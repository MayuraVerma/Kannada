/*	TREE NAVIGATOR
	$Revision: 1.3 $
	@btapley
	Notes: Key events not behaving correctly yet.
*/
adobe.Loader.requireAsset("_/module/Tree/tree.css", { media: "screen" });
adobe.Loader.requireAsset("_/module/Tree/tree.print.css", { media: "print" });

adobe.Tree = (function() {
	var _guiSave = new adobe.StateManager("adobe.gui.save");//adds setCookieParam and getCookieParam methods -- wiki link here
	
	function _openedBranchRender(element) { $(element).removeClassName("hide").addClassName("show"); }
	function _closedBranchRender(element) { $(element).removeClassName("show").addClassName("hide"); }
	
	var C0nstruct0r = function(elem, save) {

		this.treeElement = $(elem);
		this.id = this.treeElement.id;
		this.openBranchCount;
		
		Element.cleanWhitespace(elem);
		
		this.controls = {};
		
		this.setControlObserver(this.handleControlEvent.bindAsEventListener(this));

		this.collectDomControls().each(this.createBranchControl, this);
		
		var savedOpenBranches = this.getOpenBranches(); // in case someone uses the 'on' class to pre-open a tree
		
		this.closeAllBranches();
		
		if(save) { this.enableSave(); }
		
		savedOpenBranches.each(this.openBranch, this);
		
		elem.className = elem.className.replace("dyn-treelist", "treelist");
		
	};
	C0nstruct0r.prototype = {
		enableSave: function() {
			this.restoreFromSave();			
			Event.observe(window, "unload", this.save.bindAsEventListener(this));
		},
		save: function() {
			var controls = $H(this.controls).values().findAll(_savable).pluck("id");
			
			_guiSave.setCookieParam(this.id, controls);
			
			function _savable(control) {
				return control.recall && control.state;
			}			
		},
		restoreFromSave: function() {
			var lastSaved = _guiSave.getCookieParam(this.id);
					
			if(!lastSaved) { return false; }
				
			lastSaved.split(",").each(function(id_string) {
				var control = this.controls[id_string];
				if(control) { this.openBranch(control); }
			}.bind(this));
			
			return;
		},
		getOpenBranches: function() {
			return $H(this.controls).values().findAll(function(control) {
				return (control.state == 1);
			});
		},
		setControlObserver: function(func) {
			this.controlObserver = func;
		},
		collectDomControls:function() {
			
			return this.treeElement.childElements().findAll(_each);
			
			function _each(element) {
				var child = element,
				foundDD = false;
				
				if(child.nodeName != "DT") { return; }
				
				while((child = child.nextSibling) && (child.nodeName != "DT")) {
					if(child.nodeType==1) {
						foundDD = true;
						break;
					}
				}
				
				if(!foundDD) { return; }
				
				return $(element);
			}
		},
		createBranchControl:function(element) {
			var _id = element.id,
			element = $(element),
			_on = element.hasClassName("on");
			
			element.addClassName("icon");
			
			var _link = element.getElementsByTagName("a")[0] || element;
			
			if(typeof _link.href != "undefined") {
				_link.href = "#";	
			}
			
			var _storable = (_id) ? 1 : 0;
			
			if(!_storable) {
				_id = element.identify(); //can't store it, but we can make it function at least
			}
			
			var control = {
				"id":		_id,
				"block":	element,
				"link":		_link,
				"recall":	_storable,
				"state": 	(_on) ? 1 : 0 //store control state to default "off" state
			};
			
			Event.observe(_link, "click", this.controlObserver);
			
			this.controls[_id] = control;
			
			return;
		},
		disableBranchControl:function(control) {
			adobe.Element.setAttributes(control.link, {href:""});
			Event.stopObserving(control.link, "click", this.controlObserver);
		},
		handleControlEvent:function(event) {
			
			var node = event.element();
			
			var id = node.id;
						
			if(!id) { //probably a child intercepted us
				event.stop(); //stop any links
				if(!(id = (node = node.parentNode).id)) { return; }//try to find an id from parent
			}
			
			var control = this.controls[id];
			
			switch(control.state) {
				case 0: 
					this.openBranch(control);
					break;
				case 1: 
					this.closeBranch(control);
					break;
			}
		},
		getBranchNodes:function(node) {//while next sibling is not DT apply method
			var result = [];
			while((node = node.nextSibling)) {
				if(node.nodeName == "DT") { return result; }
				if(node.nodeName == "DD") { result.push(node); }
			}
			return result;
		},
		openBranch:function(control) {
			control.state = 1;
			$(control.block).removeClassName("expand").addClassName("collapse");
			this.getBranchNodes(control.block).each(_openedBranchRender);
			this.openBranchCount++;
			this.treeElement.fire("adobe.event.tree.branchopen", { control: control });
		},
		closeBranch:function(control) {
			control.state = 0;
			$(control.block).removeClassName("collapse").addClassName("expand");
			
			this.getBranchNodes(control.block).each(_closedBranchRender);
			
			this.openBranchCount--;
		},
		openOnlyBranch:function(control) { 
			this.closeAllBranches();
			this.openBranch(control);
		},
		closeAllBranches:function() {
			for(var control in this.controls) {
				this.closeBranch(this.controls[control]);
			}
			this.openBranchCount = 0; //in case closeAllBranches is called before branch state is set 
		},
		openAllBranches:function() {
			$H(this.controls).values().each(this.openBranch,this);
		}
	};
	return C0nstruct0r;
})();

adobe.TreeExplode = Class.create(); //create priveledged access to Tree?
adobe.TreeExplode.prototype = {
	initialize: function(link_element) {
		this.link_element = link_element;
		var text = " " + (link_element.text || link_element.innerText || "");
		this.expand = "expand";
		this.collapse = "collapse";
		this.labels = [(link_element.title || "") + text, (link_element.rev || "") + text];
		
		link_element.removeAttribute("rev");
		link_element.removeAttribute("title");
		$(link_element).addClassName("no-print");
		
		link_element.style.cursor='pointer';
		
		var tree_ids = link_element.rel.split(" ");
		tree_ids.shift(); //remove dyn marker
		
		this.treeStates = {};
		
		var gui_members = adobe.gui.Tree.members;
		
		this.trees = gui_members.findAll(function(tree) {
			return tree_ids.detect(function(id, index) {
				var foundMatch = tree.id == id;
				if(foundMatch) { tree_ids.slice(index,1); } //remove id already matched
				return foundMatch;
			}); //if detect found a match, collect the object with findAll
		});
				
		this.setControlState();
		
		Event.observe(link_element, "click", this.handleControlEvent.bindAsEventListener(this));
		
		var controls = gui_members.inject({}, function(trees, tree) {
			Object.extend(trees, tree.controls);
			return trees;
		});
		
		$H(controls).values().each(this.createTreeObserver.bindAsEventListener(this)); //subscribe to Tree Control Events
		/**/
	},
	createTreeObserver: function(control) {
		Event.observe(control.link, "click", this.handleTreeEvent.bindAsEventListener(this));
		//Event.observe(control.link, "keyup", this.handleTreeEvent.bindAsEventListener(this));
	},
	handleTreeEvent:function() {
		this.setControlState();
	},
	getDomState: function() {
		return (this.getOpenBranchTotal() > 0) ? this.collapse : this.expand;
	},
	setControlState: function(requested_state) {		
		requested_state = requested_state || this.getDomState();
		
		var stateChanged = (this.state != requested_state); //set state property
		if(!stateChanged)  { return; }
		
		switch(requested_state) {
			case this.expand: 
				$(this.link_element).update(this.labels[0]);
				this.control_method = this.doExpandAll;
				break;
			case this.collapse: 
				$(this.link_element).update(this.labels[1]);
				this.control_method = this.doCollapseAll;
				break;
		}
		this.state = requested_state;
		return;
	},
	handleControlEvent: function(event) {
		//detect event types here
		this.control_method();
	},
	getOpenBranchTotal: function() {
		return this.trees.inject(0, function(n, tree) {
			return tree.openBranchCount + n;
		});
	},
	control_method: function() {},
	doCollapseAll:function() {
		this.setControlState(this.expand);
		this.trees.each(function(tree) {
			return tree.closeAllBranches();					 
		});
		
	},
	doExpandAll:function() {
		this.setControlState(this.collapse);
		this.trees.each(function(tree) {
			return tree.openAllBranches();					 
		});
	}
};

//this is obviously lame, but I haven't finish a component architecture
adobe.gui = {};
adobe.gui.Tree = (function(){
	var singl3ton = {};
	
	singl3ton.members = [];
	
	singl3ton.renderDomSubscribers = function() {
		var trees = $$("dl.dyn-treelist"),
			i = trees.length-1;
		if(i < 0) return;
		
		do{
			singl3ton.members[i] = new adobe.Tree(trees[i], true);
		} while (i--);
		
		$$("a[rel~=dyn-explodetree]").each(_createExplode);
		
		function _createExplode(element) { return new adobe.TreeExplode(element); }
		
	};
	
	return singl3ton;
})();