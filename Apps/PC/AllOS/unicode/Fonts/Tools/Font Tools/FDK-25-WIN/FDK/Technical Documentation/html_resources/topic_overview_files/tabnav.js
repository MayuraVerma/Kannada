/*	TABBED NAVIGATOR $Revision: 1.36 $
	work in progress
*/
adobe.Loader.requireAsset("_/module/tabnav/tabnav.css", { media: "screen" });

TabNav = (function() {
	var TITLE_STYLE = "tabtitle",
	CONTENT_STYLE = "tabcontent",
	ROOT_CSS_PATTERN = "dyn-tabsection",
	ROOT_READY_CSS_PATTERN = "tabsection",
	TAB_ON_CSS = "on",
	TAB_OFF_CSS = "off",
	TAB_ON_CSS_EXP = createSpaceDelimitedPattern(TAB_ON_CSS),
	TAB_OFF_CSS_EXP = createSpaceDelimitedPattern(TAB_OFF_CSS),
	CONTENT_SHOW_CSS = "show",
	CONTENT_HIDE_CSS = "hide",
	CONTENT_SHOW_CSS_EXP = createSpaceDelimitedPattern(CONTENT_SHOW_CSS),
	CONTENT_HIDE_CSS_EXP = createSpaceDelimitedPattern(CONTENT_HIDE_CSS),
	guiSave = new adobe.StateManager("adobe.gui.save.tabs", 0),
	defaultSkins = ["tabZen","tabNav"];

	function createSpaceDelimitedPattern(s) { return new RegExp("(?:^| )" + s + "(?: |$)"); }
	
	function ViewObserver(node, viewId) {
		this.node = node;
		this.viewId = viewId;
		return this;
	}
	ViewObserver.prototype = {
		node:	null,
		viewId:	"",
		viewState: -1, //zero is hidden, one is shown
		showMethod: function(node) {},
		hideMethod: function(node) {},
		show: function(){
			if (this.viewState == 1) { return; }
			this.viewState = 1;
			this.showMethod(this.node);
			return true; //using this to record an updates total in the view manager
		},
		hide: function() {
			if (this.viewState === 0) { return; }
			this.viewState = 0;
			this.hideMethod(this.node);
			return false; //using this to record an updates total in the view manager
		},
		update: function(id) {
			return (id == this.viewId) ? this.show() : this.hide();
		}
	};
	
	function hideMethod (node, hideName, showName) {
		adobe.Element.setAttributes(node, {"class": node.className.replace( showName, hideName ) });
	}
	function showMethod (node, hideName, showName) {
		node.removeClassName(hideName);
		node.addClassName(showName);
	}
	
	
	
	function TabControllerView (node, viewId) {

		var o = new ViewObserver(node, viewId);
		
		o.hideMethod = function(n) {
			adobe.Element.setAttributes(n, {"class": n.className.replace( TAB_ON_CSS_EXP, "" ) + " " + TAB_OFF_CSS });
		};
		
		o.showMethod = function(n) {
			adobe.Element.setAttributes(n, {"class": n.className.replace( TAB_OFF_CSS_EXP, "" ) + " " + TAB_ON_CSS });
		};
		
		return o;
	};
	
	function TabContentView (node, viewId) {
		
		var o = new ViewObserver(node, viewId);
		
		o.hideMethod = function(n) {
			adobe.Element.setAttributes(n, {"class": n.className.replace( CONTENT_SHOW_CSS_EXP, "" ) + " " + CONTENT_HIDE_CSS });
		};
		
		o.showMethod = function(n) {
			adobe.Element.setAttributes(n, {"class": n.className.replace( CONTENT_HIDE_CSS_EXP, "" ) + " " + CONTENT_SHOW_CSS });
		};
		
		return o;
	};

	
	var OptionsChain = (function() {
		var Construct0r = function(exec, bind) {
			this.chain = [];
			this.exec = exec;
			this.bind = bind;
		};
		Construct0r.prototype = {
			execIf: function() {
				var method = this.chain[0];
				if (!method) { return; }
				var test = method.call(this.bind);
				if(test) {
					this.exec.call(this.bind, test);
					return this.clear();
				} else {
					return this.chain.shift();
				}
			},
			addIf: function(method) {
				this.chain.push(method);
			},
			clear: function() {
				this.chain = [];
				return;
			}
		};
		
		return Construct0r;
	})();

/*	Class: TabNav
	
	
	Parameters:
	root - Element reference
	options - hash object
	
	Properties:
	root - element reference
	id - string
	menu - element reference
	menuElements - array
	skins - array
	controllers - hash
	observers - array
	observerTotal - number
	currentView - array
	currentViewId - string
*/

	var Construct0r = function(root, options) {
		
		this.pageURL = window.location.toString();
		
		//DOM
		this.root = root;
		this.id = Element.identify(root);
		this.menu = null;
		this.menuElements = [];
		this.skins = defaultSkins.copy();
		if(options.skin) { this.skins.splice(0, 1, options.skin); }
		
		//CONTROLS
		this.controllers = {};
		
		//VIEWS
		this.observers = [];
		this.observerTotal = 0;
		this.currentView = [];
		this.currentViewId = "";
		
		//OPTIONS
		this.updateChain = new OptionsChain(this.render, this);
		
		if(options.remember) { //always prefer remember
			this.enableSave();
			this.updateChain.addIf(this.handleLoadSaved);
		}
		
		if(options.readQuery) {
			this.updateChain.addIf(this.handleLoadUri);
		}
		
		this.updateChain.addIf(this.handleLoadEvent);
		
		return this;
	};

	
	Construct0r.prototype = {
		
		//Controls
		createController: function( elem, savable ) { //0ms
			var id = elem.id;
			
			var control = {
				"link":		elem.getElementsByTagName("A")[0] || elem,
				"block":	elem,
				"recall":	savable || false
			};
			
			this.controllers[id] = control;
			
			Event.observe(control.link, "click", this.updateView.bindAsEventListener(this));
			return;
		},
		updateView: function(event) {

			var elem = event.target;
			
			var id = elem.id;
			if(!id) { //probably a link
				event.stop();
				if (!(id = (elem = elem.parentNode).id)) { return; } //give up
			}
			
			var control = this.controllers[id];
			if (!control) { return; }//is this a registered controller
									
			this.setCurrentView(id, control.recall);
			
			// FOR DEVNET: send accordion id if opened to omniture but not if the teaser is opening
			var isDevnet = (this.pageURL.indexOf('/devnet') > -1);
			if (isDevnet) {
				CLICKED_TAB = control.link.innerHTML;
				PAGE_URL = this.pageURL; // bug 80748 : have to reset to a local/private var, setTimeout doesn't get "this"
				// causes delay in expanding if this is done right away so do it a little while after
				setTimeout("sendLinkEvent('','DevCon Tab : ' + PAGE_URL +  ' : ' + CLICKED_TAB,'o');",300);
			}
		},
		
		//Views
		setCurrentView: function(id, recall) {
			if (this.currentView[0] == id) { return; } //nothing new, stop here

			var updateTotal = this.updateObservers(id);

			if(updateTotal) {
				this.currentView[0] = id;
				this.currentView[1] = recall;
				return updateTotal;
			} else {
				return;
			}
		},
		setToFirstView: function() {
			return this.setCurrentView(this.getFirstViewId(), false); //only controllers will enable savable
		},
		getCurrentViewId: function() {
			return this.currentView[0] || "";
		},
		isViewSavable: function() {
			return this.currentView[1];
		},
		getFirstViewId: function() {
			if (!this.observers[0]) { return; }
			return this.observers[0].viewId;
		},
		createViewObserver: function(viewOb) { //just testing here, this is generic right now and calls the generic ViewObserver. This ultimately will be createTabContent and create TabControl
			this.observers.push(viewOb);
			this.observerTotal++;
			return;
		},
		removeViewObserver: function() {
			
			this.observerTotal--;
			return;
		},
		updateObservers: function(id) { 

			var i = this.observerTotal, u = 0; //update total
			do {
				if(this.observers[i-1].update(id)) { u++; }
			} while (--i); //this VERY FAST loop is safe because there must be at least 1 observer triggering this method

			return u;
		},
		
		//Store
		
		_loadId: function(id) {
			return this.setCurrentView(id, true);
		},
		handleLoadEvent: function() {
			return this.setToFirstView(); //return bool to update chain
		},
		handleLoadUri: function() {
			return this._loadId(guiSave.getQueryParam(this.id)); //return bool to update chain
		},
		handleLoadSaved: function() { 
			return this._loadId(guiSave.getCookieParam(this.id)); //returns bool to update chain
		},
		enableSave: function() {
			Event.observe(window, "unload", save.bindAsEventListener(this));
			
			function save() {
				var vid = this.getCurrentViewId();
				if(!this.isViewSavable()) {
					return guiSave.removeCookieParam(this.id);
				} 
				if (!vid) { return; } //no activity, move along
				return guiSave.setCookieParam(this.id, vid); //something happened
			}
		},
		update: function() {
			while(this.updateChain.execIf()) {}
			//this.render();
		},
		
		//Wrappers
		createTab: function( label, viewKey, savable) {						
			var tab = this.createTabElement(label, viewKey);
			//control
			this.createController( tab.block, savable );
			//view
			this.createViewObserver(new TabControllerView(tab.block, viewKey));
		},
		createContent: function( node, viewKey ) {
			this.createViewObserver(new TabContentView(node, viewKey));
		},
		
		//DOM
		createTabElement: function(text, id, attachOpt) {
			
			var bk = adobe.Element.create("li", {"id": id}),
				lk = adobe.Element.create("a", {"href":"#"}),
				tx = document.createTextNode(text);
				bk.appendChild(lk).appendChild(tx);
			
			var tab = {
				"link":	lk,
				"block": bk
			};
			
			//handle attach options here and pass any arguments
			
			this.attachTab(bk);
			
			return tab;
		},
		getTabMenu: function() {
			return this.menu || adobe.Element.create("ul", {"class": this.skins.join(" ")});
		},
		attachTab: function(tabBlock) {
			if(!this.menu) { return this.menuElements.push(tabBlock); }
			this.menu.appendChild(tabBlock);
		},
		render: function() {
			var mu = this.getTabMenu(),
				em = this.menuElements,
				l = em.length;
			
			for(var i=0; i < l; i++) {
				mu.appendChild(em[i]);
			}
			
			em.clear(); //clear rendered items;
			
			adobe.Element.setAttributes(this.root, {"class": ROOT_READY_CSS_PATTERN });
			
			this.menu = adobe.Element.insertAbove(this.root, mu);
		}
	};
		
					
	Construct0r.FromDom = function(root, options) {
		
		var inst = new Construct0r(root, options);
							
		for(var i = 0, n, savable, viewId; (n = root.childNodes[i]); i++) {
			
			if(Object.isElement(n)) { //is tag
			
				n = $(n);
				
				if(n.hasClassName(TITLE_STYLE)) {
				
					id = n.id;
						
					if(!id) {
						savable = 0;
						viewId = n.identify();
					} else {
						savable = 1;
						viewId = id;
					}
					
					n.addClassName("hide");
					adobe.Element.setAttributes(n, {"id": ""});
													
					title = n.firstChild.nodeValue;
					
					inst.createTab(title, viewId, savable);
					
				} else if(n.hasClassName(CONTENT_STYLE)) {
				
					inst.createContent(n, viewId);
													
				}
			}		
		}
		
		return inst;
	};
	
	return Construct0r;
})();

adobe.tabs = (function() {
	var domSubscribers = [];
	
	function doSubUpdate(s) {
		return s.update();	
	}
	
	function updateDom() {
		domSubscribers.each(doSubUpdate);
	}
	
	var single = {
		renderDomSubscribers: function() {
			subscribers = adobe.Element.getElementsByClassName(document, "div", "dyn-tabsection");
			
			for(var i=0; i < subscribers.length; i++) {				
				subscriber = subscribers[i];
				
				options = {
					//remember: true,
					readQuery: true
				};
				
				if(adobe.Element.hasAttribute(subscriber, "class", "microtab")) {
					options.skin = "tabMini";
				}
				
				domSubscribers.push( new TabNav.FromDom(subscriber, options));
			}
			updateDom();
		},
		updateDom: updateDom
	};
	
	return single;
	
})();
