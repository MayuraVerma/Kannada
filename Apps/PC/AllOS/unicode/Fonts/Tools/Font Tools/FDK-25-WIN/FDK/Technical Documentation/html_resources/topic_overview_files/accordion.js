/*
	ACCORDION YUI EXTENSION
	@author mok
	$Id: accordion.js,v 1.23 2008/09/24 22:20:57 mok Exp $
*/
adobe.Loader.requireAsset('_/urlParser.js');

/*--- for convenience so if class names change, set it here ---*/
var aDc_cfg = {			
	"accordion"		: { collapsed: "collapsed",	expanded: "expanded" },
	"controller"	: { collapsed: "closed",	expanded: "opened" },
	"handle"		: { collapsed: "down",		expanded: "up" }
};	

var AccordionStates = {};

YAHOO.Accordion = Class.create();


Object.extend(YAHOO.Accordion, new adobe.StateManager("adobe.accordions.save"));

YAHOO.Accordion.prototype = {
	
	initialize: function(accordionId, accordionCfg, controlText) {	
	
		this.pageURL = window.location;				
		this.openedText = "";
		this.closedText = "";	
		this.isDevnet = (this.pageURL.toString().indexOf('devnet') > -1) || (this.pageURL.toString().indexOf('cfusion'));
						
		this.updateControl = accordionCfg.updateControl || true;
		
		this.accordion = accordionId;	
		this.control = accordionCfg.control;	
		
		this.controller = $(this.control);
		this.accordionContainer = $(this.accordion);
		
		if(!this.accordionContainer) { return; }
		
		this.rememberMe = accordionCfg.rememberMe || false;
				
		this.accordionContent = YAHOO.util.Dom.getFirstChild(this.accordionContainer);
	
		this.accordionHandle = YAHOO.util.Dom.getFirstChild(this.controller);
		this.accordionHandle1 = YAHOO.util.Dom.getNextSibling(this.accordionHandle);		
		
		this.expandDuration = accordionCfg.expandDuration || 0.2;		
		this.collapseDuration = accordionCfg.collapseDuration || 0.2;
			
		this.expandedHeight =  accordionCfg.expandedHeight || this.accordionContent.offsetHeight;		
		this.collapsedHeight = accordionCfg.collapsedHeight || 0;		
		
		this.expandedWidth = accordionCfg.expandedWidth || false;
		this.collapsedWidth = accordionCfg.collapsedWidth || false;
		
		// if expanded y not set, set expanded height to offset height
		this.sizeTo = (!this.expandedWidth) ? this.expandedHeight : this.expandedWidth;		
		// if collapsed y not set, set collapsed height to offset height
		this.sizeFrom = (!this.expandedWidth) ? this.collapsedHeight : this.collapsedWidth;
		this.sizeUnit = accordionCfg.sizeUnit || 'px';	
		
		this.expandCfg = {
			to	:	this.sizeTo,
			from:	this.sizeFrom,
			unit:	this.sizeUnit
		};
		
		this.expandVertical = {	height : this.expandCfg	};		
		this.expandHorizontal = { width : this.expandCfg };
		this.expandProperties = (!this.expandedWidth) ? this.expandVertical : this.expandHorizontal;
				
		this.collapseCfg = {
			from: 	this.sizeTo,
			to: 		this.sizeFrom,
			unit:		this.sizeUnit
		};
		
		this.collapseVertical = { height :this.collapseCfg };		
		this.collapseHorizontal = { width :	this.collapseCfg };		
		this.collapseProperties = (!this.expandedWidth) ? this.collapseVertical : this.collapseHorizontal;				
		
		// name given for cookie settings
		var cookieName = "adc." + this.accordion;
		var cookieSetting = adobe.Cookie.get(cookieName);	
		
		if(this.rememberMe) {
			var cookieName = this.accordion;			
			var cookieSetting = adobe.Cookie.get(cookieName);	
			adobe.URLParser.siteSection = "";
		}

		// set default state if there is a cookie		
		// if no cookie, then just use user defined or collapsed (default)	
		this.defaultState = (cookieSetting && adobe.URLParser.siteSection == "") ? cookieSetting : (accordionCfg.defaultState || aDc_cfg.accordion.collapsed);
				
		// currently for top 2 ADC menus
		this.isTeaser = accordionCfg.isTeaser || false;
					
		this.setupAccordions();
		
		YAHOO.util.Event.addListener(this.control, 'click', this.handleToggleAnimation.bindAsEventListener(this));
		
	},	
	
	// get any url query params
	// open panel by appending query to URL -->  ?panel=accordionID
	getURIState: function() {
		return (YAHOO.Accordion.getQueryParam('panel')) ; //return bool to update chain
	},
	
	// if 'panel' is defined in URL, reset default setting and override cookie too
	handleURIState: function() {
		var teaser = this.controller.id+"-teaser";
		// check if accordion has a teaser
		if($(teaser)) {	
			this.handleURITeaserToggle(teaser);			
		}
		// update state manager and cookie manager array
		AccordionStates[this.accordion]=aDc_cfg.accordion.expanded;	
		this.updateCookieManager();
		return this.defaultState = aDc_cfg.accordion.expanded;	
	},
	
	// if accordion has a teaser, reset state and cookie
	handleURITeaserToggle : function(teaser) {
		YAHOO.util.Dom.replaceClass(teaser, aDc_cfg.accordion.expanded, aDc_cfg.accordion.collapsed);
		AccordionStates[teaser]=aDc_cfg.accordion.collapsed;	
	},
	
	// initialize accordions onLoad function
	setupAccordions : function() {
		
		// populate Accordion State Manager
		AccordionStates[this.accordion]=this.defaultState;
		
		//check if URL has panel to be opened
		if(this.getURIState() == this.accordion) {
			this.handleURIState();
		}
			
		this.setAccordionState(this.defaultState);
		this.setControllerState(this.defaultState);
		
	},	
	
	// Sets initial class of the Accordion
	setAccordionState : function (state) {	
		YAHOO.util.Dom.addClass(this.accordionContainer, state);	
		if((adobe.SCRIPT_ENGINE == "JScript" && adobe.SCRIPT_VERSION == 5.6) && state == aDc_cfg.accordion.expanded && (!this.isTeaser)) {
			this.accordionContent.style.height = this.expandedHeight  + "px";	// ie6 needs height setting
		}		
	},

	// initialize state of controller and handle
	setControllerState : function(state) {	
			
		var isCollapsed = this.isCollapsed(state);
			
		var handleClass 	= (!isCollapsed) ? aDc_cfg.handle.collapsed 	: aDc_cfg.handle.expanded;
		var controlClass 	= (!isCollapsed) ? aDc_cfg.controller.collapsed : aDc_cfg.controller.expanded;
		var text			= (!isCollapsed) ? this.closedText				: this.openedText; //currently not used
		
		if(this.isTeaser) { return;}	// if accordion is a teaser then don't change the control className
		
		// if hover behavior added in CSS, causes JS error in print preview
		// adding behavior to <controller> handle (adds "hover" class to DIV) b/c div:hover doesn't work in IE6
		if(adobe.hostEnv.ieV == 6) {
			this.controller.addBehavior("/lib/yui/extensions/accordion/control_hover.htc");
		}
		
		this.toggleController(text,handleClass,controlClass);
		
	},

	// toggles Accordion CSS class
	toggleAccordionState : function(state) {	
		var isCollapsed = this.isCollapsed(state);
		var currentClass = (!isCollapsed) ? aDc_cfg.accordion.collapsed : aDc_cfg.accordion.expanded;	// current collapsed class
		var toggledClass = (isCollapsed) ? aDc_cfg.accordion.collapsed : aDc_cfg.accordion.expanded;	// class to toggle to
		YAHOO.util.Dom.replaceClass(this.accordion, currentClass, toggledClass);
		return toggledClass;
	},

	// utility to update the class of controller and handle
	toggleController : function(text, handleClass, controlClass, toggledHandleClass, toggledControlClass) {	
		// if this is the setup
		if(!toggledControlClass) {
			YAHOO.util.Dom.addClass(this.controller, controlClass);		// set controller
			YAHOO.util.Dom.addClass(this.accordionHandle, handleClass);	// set handle
			// if there is a second handle
			if(this.accordionHandle1) { YAHOO.util.Dom.addClass(this.accordionHandle1, handleClass); }	
			return;
		}
		// if this is an update
		YAHOO.util.Dom.replaceClass(this.controller, controlClass, toggledControlClass);
		YAHOO.util.Dom.replaceClass(this.accordionHandle, handleClass, toggledHandleClass);
		if(this.accordionHandle1) { YAHOO.util.Dom.replaceClass(this.accordionHandle1, handleClass, toggledHandleClass); }
	},
	
	// toggle controller classes then update state manager
	updateAccordion : function(state) {				
		// get new state and toggle accordion class
		var toggledState = this.toggleAccordionState(state);		
		// update AccordionStates Manager
		AccordionStates[this.accordion]=toggledState;
	},
	
	// clear cookies, then repush updated AccordionStates to Cookie array	
	updateCookieManager : function(accordion) {
		
		var accordionCookie = "adc." + accordion;
		// set cookie for each accordion if in /devnet/
		var currentLoc = adobe.URLParser.url.toString();	// Depends on URLParser.js
		// had to add pathname to cookie setting or else sub pages wouldn't hold same cookie as homepage
		var locale = "/" + adobe.URLParser.locale;
		var section = "/" + adobe.URLParser.siteLevel;
		var product = "/" + adobe.URLParser.productName;
		// create path and add locale dir if 
		var path = (locale != "/en_us") ? locale + section : section;
		// hack for workarea
		if(currentLoc.indexOf("WORKAREA") > -1) {
			var directory = window.location.pathname.split("/");
			var workarea  = directory[2];
			path = "/WORKAREA/" + workarea + "/devnet";
		}
		
		if(this.rememberMe) {
			var accordionCookie = accordion;
			var path = window.location.pathname.toString();
			adobe.Cookie.set(accordionCookie,AccordionStates[accordion]);
			return;
		}
		
		adobe.Cookie.set(accordionCookie,'','/devnet/');
		
		//adobe.Cookie.set(accordionCookie,AccordionStates[accordion],'','/devnet/');	
			
	},
	
	// update controller on click (from handleAnimation())	
	updateController : function(state) {				
			
		var isCollapsed = this.isCollapsed(state);
				
		var handleClass			=	(!isCollapsed)	?	aDc_cfg.handle.collapsed : aDc_cfg.handle.expanded;
		var toggledHandleClass 	=	(isCollapsed)	?	aDc_cfg.handle.collapsed : aDc_cfg.handle.expanded;		
		var controlClass		=	(!isCollapsed)	?	aDc_cfg.controller.collapsed : aDc_cfg.controller.expanded; 
		var toggledControlClass	=	(isCollapsed)	?	aDc_cfg.controller.collapsed : aDc_cfg.controller.expanded; 		
		var newtext				=	(isCollapsed)	?	this.closedText : this.openedText; 
		
		if(this.isTeaser) { return; }
		
		this.toggleController(newtext, handleClass, controlClass, toggledHandleClass, toggledControlClass);
	},	
	
	// onclick handler that updates accordion and controller state
	handleToggleAnimation : function() {
				
		// this is the state to change
		var currentState = AccordionStates[this.accordion];	
		this.setAnimation(currentState);
		this.updateAccordion(currentState);
		this.updateController(currentState);
		this.updateCookieManager(this.accordion);
	},
	observe: function(eventname, func) {
		this.accordionContainer.observe(eventname, func);
	},	
	// based on state, switch the animation type
	setAnimation : function(state) {				
		if(!this.expandedWidth && !this.expandedHeight) { return; }
		// change animation action depending on state
		var accordion = (!this.isCollapsed(state)) ? this.expandAccordion() : this.collapseAccordion();	
		accordion.animate();
		// FOR DEVNET: send accordion id if opened to omniture but not if the teaser is opening
		var isTeaser = (this.accordion.indexOf('teaser') < 0);
		
		if (this.isCollapsed(state) && this.isDevnet && !isTeaser) {
			// causes delay in expanding if this is done right away so do it a little while after
			 // bug 80748 : have to reset to a local/private var, setTimeout doesn't get "this"
			_pageURL = this.pageURL;
			_accordion = this.accordion;
			setTimeout("sendLinkEvent('','DevCon Accordion : ' + _pageURL +  ' : ' + _accordion,'o')",300);
		}
	},
		
	// called from the onclick manager (depends if the accordion is collapsed or not)
	expandAccordion : function() {
		if(!this.isDevnet) {
			var isTeaser = (this.accordion.indexOf('teaser') < 0);
			if(!isTeaser && this.expandProperties.height.to < this.accordionContent.offsetHeight) {
				this.expandProperties.height.to = this.accordionContent.offsetHeight;
			}
		}
		var accordionAction = new YAHOO.util.Anim(this.accordion, this.expandProperties, this.expandDuration, YAHOO.util.Easing.easeNone);		
		this.controller.fire("accordion:openAnimation");
		return accordionAction; 		
	},
	
	// called from the onclick manager (depends if the accordion is collapsed or not)
	collapseAccordion : function() {
		var accordionAction = new YAHOO.util.Anim(this.accordion, this.collapseProperties,this.collapseDuration, YAHOO.util.Easing.easeOutStrong);
		this.controller.fire("accordion:closeAnimation");
		return accordionAction; 
	},
	
	// return state is not collapsed, return true/false
	isCollapsed : function(state) {		
		return state != aDc_cfg.accordion.collapsed;
	}	
};