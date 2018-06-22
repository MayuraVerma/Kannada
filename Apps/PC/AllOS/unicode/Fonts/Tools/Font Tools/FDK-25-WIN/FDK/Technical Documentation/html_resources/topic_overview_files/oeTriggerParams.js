// Customer: Adobe
// Version : OnExit 7.2
// Copyright 2001-2008 ForeseeResults, Inc

var triggerParms= new Array();
var watchList = new Array();
var flashTagList= new Array();
var excludeList = new Array();

/**MAIN PARAMETERS**/
triggerParms["displayMode"] = 3; //0=disable, 1=popup then dhtml, 2=popup only, 3=default dhtml only
//triggerParms["mid"] = "TEST/KeZ9BETuq9v3R6aqP9U4g=="; // must have model instance id or commented if adhoc survey (use sid)
triggerParms["cid"] = "s5ccpQJxpV8s81t5gshQdw=="; // must have customer id
triggerParms["dLF"] = 0; //domain loyalty factor
triggerParms["spL"] = 1.0; //  launch sample percentage
//triggerParms["spL"] = 100.0; //  stage and testing sample percentage
triggerParms["npc"] = 0; // no persistent cookies if 1
triggerParms["rw"] = 129600; // resample wait (value in minutes)
triggerParms["compliant508"] = 0; //508-JAWS compliant if 1
//triggerParms["omb"] = "1505-0186"; //uncomment if required
triggerParms["width"] = 450;
triggerParms["height"] = 600;
triggerParms["domain"] = ".adobe.com"; // domain name
triggerParms["dhtmlURL"] ="/js/fsrscripts/html/oeFSRInvite.html";
triggerParms["oecpp_ABXTesting"]="Foresee_ABXTesting";

/**ONEXIT PARAMETERS**/
triggerParms["oeMode"]  = 1;	//default onExit mode: 0=triggers survey on subdomain or protocol change, 1=triggers survey on domain change only or in absence of code
triggerParms["sMode"] = 0; 	//default survey mode: 1=preload survey, 0=load at exit
triggerParms["trackerURL"] ="/js/fsrscripts/html/surveyTracker.html";

/**MISC PARAMETERS**/
triggerParms["sid"] = "ADOBE";		// e.g.: BROWSE|CHECKOUT|POS  - foresee defined survey identifier, default commented
triggerParms["patternType"] = "URL";	//use either URL|CK=<paste_your_cookie_name>|VALUE as a lookup pattern, default commented
triggerParms["lfcookie"] = "ForeseeLoyalty"		//default loyalty cookie name
triggerParms["ascookie"] = "ForeseeSurveyShown"		//default already shown cookie name
//triggerParms["nLF"] = 9; //navigation loyalty factor
triggerParms["spE"] = 100.0; // execute sample percentage
triggerParms["pu"] = 0;
triggerParms["olpu"] = 1;
triggerParms["userURL"] = 1; 	// value set to 1, if the client wants user url
triggerParms["capturePageView"] = 1;
//triggerParms["cmetrics"] = "90010257"; // coremetrics client id
triggerParms["visualScienceId"] = 0;	// enable visual science code if 1
triggerParms["omnitureId"] = 0;		// enable omniture code if 1
//Double Cookie/1 settings
//triggerParms["dcUniqueId"] = "TEST04JloZZN0k9cI1Ep5d"; //  (22 chars unique Id for double cookie I/II)
//triggerParms["midexp"] = 129600; // for double cookie (value in minutes)
//Scout Tracker settings
triggerParms["scout_retry"] = 2; 	// default=2, check multiple times if OE condition is true.
triggerParms["scout_delay"] = 1000;	// default=1 sec, scout delay in millseconds.
triggerParms["scout_chk"]= "ScoutRunningCheck";
triggerParms["path"] = "/";
triggerParms["trackerWidth"]  = 500;
triggerParms["trackerHeight"] = 350;

/**DHTML PARAMETERS**/
triggerParms["dhtmlIndex"]= 100;	// z-index s/b greater then client’s dhtml z-index (if exist) - default 100
triggerParms["dhtmlWidth"] = 450;	// invite page width
triggerParms["dhtmlHeight"] = 300;	// invite page height
triggerParms["dhtmlWinRep"] = 0;	// drops ScoutRunning cookie if 0
triggerParms["dhtmlDelay"]= 1000;	// default=1s, invite timeout in millisecs
//DHTML Positioning
//center		bottom-center		bottom-right		bottom-left        upper-right          upper-left
//x,y = (2,150)		x,y = (2,350)		x,y = (1.02,350)	x,y = (60,350)    x,y = (1.02,50)   x,y = (60,50)
//replace (x,y) below with any one of the above, default = center
var x=2;
var y=150;
triggerParms["dhtmlLeft"] = (self.screen.width - triggerParms["dhtmlWidth"])/x;			//invite page left position**DO NOT MODIFY**
triggerParms["dhtmlTop"] = Math.min((self.screen.height - triggerParms["dhtmlHeight"])/2,y);	//invite page top position**DO NOT MODIFY**

/**FLASH PARAMETERS - not to be used with other embedded objects e.g. (.dcr/.mov/.mpeg/.avi/.wma/.wmv/.aam/.rm/.ram)**/
triggerParms["flashDetect"]= 0;		// check if page has flash embedded with a valid browser & player ver before showing  dhtml - disable if 0
flashTagList[0]= "swf";			// flash src check for IE/NE complaint browsers
flashTagList[1]= "spl";			// splash src check for IE/NE complaint browsers
flashTagList[2]= "clsid:d27cdb6e-ae6d-11cf-96b8-444553540000";	//activeX ID check for IE browsers only

/**MULTIPLE SURVEY VENDORS - uncomment variables below & add corresponding SP and URL **/
//var multiVendorSP= new Array();
//var multiVendorURL= new Array();
//multiVendorSP[0] = 0;		// sampling percentage for third-party vendor - disable if commented
//multiVendorURL[0]= "";	// absolute path to third-party script - disable if commented

/**FORESEE SYSTEM PARAMETERS**/
triggerParms["captureTriggerVersion"] = "OE7.2";	// track latest trigger version
//triggerParms["showCookie"]= 1; 	// commented by default - remove comments to put Retry cookie value
//triggerParms["showException"]= 1; 	// commented by default - remove comments to show JS onError exception alert

/**CLIENT CPPS**/
//triggerParms["oecpp_cppName"]="Foresee_cppName";	//uncomment & replace cppName for OE

/**Exclude List**/	
excludeList[0] = "adobe.com/cfusion/communityengine/";
excludeList[1] = "adobe.com/cfusion/exchange/";
excludeList[2] = "labs.adobe.com/";
excludeList[3] = "adobe.com/newsletters/edge/";
excludeList[4] = "adobe.com/cfusion/";
excludeList[5] = "adobe.com/products/acrobat/readstep2_servefile.html";
excludeList[6] = "adobe.com/products/acrobat/readstep2_thankyou.html";
excludeList[7] = "adobe.com/products/acrobat/readstep3_thankyou.html";
excludeList[8] = "macromedia.com/support/";
excludeList[9] = "adobe.com/help/";
excludeList[10] = "adobe.com/ion/";
/**Start JP excludes**/	
excludeList[11] = "adobe.com/jp/devnet/";
excludeList[12] = "adobe.com/jp/cfusion/communityengine/";
excludeList[13] = "adobe.com/jp/cfusion/exchange/";
excludeList[14] = "adobe.com/jp/newsletters/edge/";
excludeList[15] = "adobe.com/jp/cfusion/";
excludeList[16] = "adobe.com/jp/products/acrobat/readstep2_servefile.html";
excludeList[17] = "adobe.com/jp/products/acrobat/readstep2_thankyou.html";
excludeList[18] = "adobe.com/jp/products/acrobat/readstep3_thankyou.html";