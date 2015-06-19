
var oldContent;

var infoDiv ;

var cursorX;
var cursorY;

var  entitiesMap = {};
var  titles = [];

var inputArea;  
var highlighter;  
var copyDiv;  
 
var spans ;
var rects ;

var curSpan;

var observe;
if (window.attachEvent) {
    observe = function (element, event, handler) {
        element.attachEvent('on'+event, handler);
    };
} else {
    observe = function (element, event, handler) {
        element.addEventListener(event, handler, false);
    };
}

initEntites();

function initInputArea() {
    var text = document.getElementById('inputArea');
    function resize () {
        text.style.height = 'auto';
        text.style.height = text.scrollHeight+'px';
    }
    /* 0-timeout to get the already changed text */
    function delayedResize () {
        window.setTimeout(resize, 0);
    }
  //  observe(text, 'change',  resize);
    observe(text, 'cut',     delayedResize);
    observe(text, 'paste',   delayedResize);
    observe(text, 'drop',    delayedResize);
    observe(text, 'keydown', delayedResize);
    
    observe(text, 'input',  resize);
   /*
    text.focus();
    text.select();
    resize();
    
    */
}

function adjustHighlighter(){   
    console.log(inputArea.offsetLeft);
    highlighter.style.left = inputArea.offsetLeft+"px";
    highlighter.style.top = inputArea.offsetTop+"px";
    highlighter.style.height = inputArea.offsetHeight+"px";
    highlighter.style.width = inputArea.offsetWidth+"px";
}

function initEntites(){
     for (  var i=0; i<entitydb.length; i++ ) {
         var obj = entitydb[i];
         entitiesMap[obj.title.toLowerCase()] = i;
         titles.push(obj.title.toLowerCase());
       //  console.log(obj.title);
     }
     
     titles.sort( function (a , b) {
         if ( a.length > b.length ) {
             return -1;
         } else if ( a.length < b.length ) {
             return 1;
         } else {
             return a - b;
         } 
     }); 
     /* 
     for (var i=0; i< titles.length; i++){
         console.log(titles[i]);
     }  
     * */  
}
    

function pageInit(){
    initEntites();
    inputArea= document.getElementById("inputArea");
    highlighter = document.getElementById("highlighter");
    copyDiv = document.getElementById("copy");
    infoDiv = document.getElementById("info");
            
    initInputArea();   
    adjustHighlighter();     
            
    txtChange();
    oldContent = inputArea.value;
    /*
    setInterval( function() { 
                    console.log("uuuuuuu ");
                    }
                   , 5000);
                   * 
                   * */
}

 function txtClick(evt){
      //  console.log(evt);
     //   forwardEvent(evt, highlighter) ;
        
       // inputArea.style.visibility = "hidden";
        var x = evt.clientX, y = evt.clientY;
        highlighter.style.pointerEvents = "auto";
        ele = document.elementFromPoint(x, y);
        highlighter.style.pointerEvents = "none";
      //  inputArea.style.visibility = "visible";
        console.log(ele); 
        if ( ele.tagName == "SPAN") {
             var eid = ele.getAttribute("data-entity-id");
             clickHighlight(eid);
        }
}         
           

function txtChange(){
    var content = inputArea.value;
 //   console.log(content);
    
    showInOthers(content);
    scanHigh();
}

function scanHigh(){
  //  console.log(highlighter.children); 
    spans = [];
    
    for (var i =0 ; i< highlighter.children.length ;i++) {
        var ele = highlighter.children[i];
        var name = ele.tagName;
     //    console.log(name);
        if ( name == "SPAN") {
            spans.push(ele);          
        }
    }
  //  console.log(spans);    
    rects = []; 
}

function txtMouseover(evt){
    
    var offX = evt.offsetX;
    var offY = evt.offsetY;
    
  //  console.log(offX, offY);
    var foundSpan = false;
    var span ;
    for (var i =0 ; i< spans.length ;i++) {
        span = spans[i];
        // var rect = spans[i].getBoundingClientRect();
        if ( (offX >= span.offsetLeft) && ( offX <= span.offsetLeft+span.offsetWidth) 
            && (offY >= span.offsetTop) && ( offY <= span.offsetTop + span.offsetHeight ) ) {
            //  console.log( offX,offY );   
            //  console.log(spans[i]);               
                foundSpan = true;
                break;            
        }
    } // for
    
    if( foundSpan ) {
        if ( !(curSpan === span) ) {
            showInfo(span);
        }
    } else {
        hideInfo();
    }
}

function showInfo(span){
  //  console.log(span);
    curSpan = span;
    var eid = span.getAttribute("data-entity-id");
    console.log(eid);
    overHighlight(eid);    
}

function hideInfo(){
    curSpan = null;
    infoDiv.style.visibility = "hidden";
}
            
function showInOthers(content){
    if ( oldContent == content )
        return;    
    
    var newContent =  content;
    newContent = getShowText(content);   
    oldContent = newContent;
    
    highlighter.innerHTML =   newContent;
    copy.innerHTML =   newContent;
};
 

function getShowText(content){
    
  //  console.log(content);
    var lowContent = content.toLowerCase();
    var ranges = [];
    var found = [];

    for ( var i=0; i<titles.length; i++){       
        findEntity(lowContent, titles[i], ranges, found );
    }
   // console.log(ranges);
    var newContent = replaceEntity(content, found );
  //  console.log(newContent);
    return newContent;
}

function replaceEntity(content, found ){
    found.sort( function compare(a , b) {
        return a.range[0] - b.range[0];
    });
  //  console.log(found);
     
    var newContent ='';
    var p = 0;
    for ( var i=0; i<found.length; i++){
        var title = found[i].title;
        var range = found[i].range;
        var str1 = content.substring(p,range[0] );
        newContent +=str1;
        var oriTitle = content.substring( range[0],range[1] );
        var eid = entitiesMap[title];
      //  var event = 'onmouseout="outHighlight()" onclick="clickHighlight('+eid+')"  onmouseover="overHighlight('+eid+')"';
        var span = '<span class="entity" '  + ' data-entity-id="' + eid + '" >' + oriTitle + '</span>';
        newContent += span;
        p = range[1];
    }
    newContent += content.substring(p,content.length );
    return newContent;   
}

function findEntity(lowContent, title, ranges, found ){
     var start = 0;
     var i = lowContent.indexOf( title, start); 
     while( i != -1 ) {
         if ( isValidPos(lowContent, title, i,  ranges) ) {
             var range = [i,i+title.length];
             ranges.push(range);
             found.push( {"title": title, "range":range});
         }
         start = i+title.length;
         i = lowContent.indexOf( title, start); 
     } // while 
} 

function isValidPos( lowContent, title, i,  ranges ) {
    var charSet = { ' ': true, '.': true, '(': true,  ')': true, 
                    ',': true, '?': true, '!': true,  '\"':true, 
                    '\'':true, '\<':true, '\>':true,  '\&':true,
                    ';': true, '\r':true, '\n':true }; 
    if ( i != 0  ) {
       var preC =  lowContent.charAt(i-1);
       if (  !(preC in charSet)  )
          return false;
    }
    
    if (  i+title.length != lowContent.length  ) {
       var postC =  lowContent.charAt( i+title.length);
       if (  !(postC in charSet)  )
          return false;
    }
    
    for (var j =0; j<ranges.length; j++){
        var range = ranges[j];
        if ( i>= range[0] && i<= range[1])
            return false;
    }    
    return true;
}

function clickHighlight(eid) {
    var entity = entitydb[eid];
    var url = entity.url;
    console.log(url);
    var win = window.open(url, '_blank');
    win.focus();
}

function outHighlight(){
    infoDiv.style.visibility = "hidden";
}

function overHighlight(eid) {
    var entity = entitydb[eid];
    var url = entity.url;
    console.log("mouse over >>" + entity.title);
    
    var titleDiv = document.getElementById("title");
    var pic = document.getElementById("pic");        
    var descDiv = document.getElementById("desc");
    
    titleDiv.innerHTML = '<h3>' + entity.title +'</h3>';
    descDiv.innerHTML =  entity.description ;
    
    pic.style.display = "none";
    pic.src = entity.image;
   
  //  adjustInfoPos();    
    infoDiv.style.visibility = "visible";
}

function adjustInfoPos(){   
   // infoDiv.style.top = cursorY - 80+"px";    
}

function imageLoad(){
    var pic = document.getElementById("pic"); 
    pic.style.display = "inline";
}
