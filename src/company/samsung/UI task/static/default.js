
var oldContent;
var editorDiv ;
var infoDiv ;

var cursorX;
var cursorY;

var  entitiesMap = {};
var  titles = [];

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
 //   console.log(oldContent);
    editorDiv = document.getElementById("editor");
    infoDiv = document.getElementById("info");
    
    render();
    oldContent = editorDiv.innerHTML;
    

    document.onmousemove = function(e){
        cursorX = e.pageX;
        cursorY = e.pageY;
      //  console.log("X="+cursorX + " ,Y="+cursorY );
    }
}

function editorPaste(){
    console.log("paste 111");
    render();
}

function catchCursor(){
     var char = 7; // character at which to place caret  content.focus();
     var sel = window.getSelection();
     console.log( editorDiv.innerHTML );
     sel.collapse(editorDiv.firstChild, char);
}

function render(){
    var editorDiv = document.getElementById("editor");
//    console.log(editorDiv);     
    var content = editorDiv.innerHTML;
    if ( oldContent == content )
        return;
        
  //  console.log(content);
   // content =  content.replace(/<(?:.|\n)*?>/gm, '');
    content =  content.replace(/<\/?span[^>]*>/g,"");
    if ( content == oldContent)
        return;
    
    console.log(content);
    var lowContent = content.toLowerCase();
    var ranges = [];
    var found = [];

    for ( var i=0; i<titles.length; i++){       
        findEntity(lowContent, titles[i], ranges, found );
    }
   // console.log(ranges);
    var newContent = replaceEntity(content, found );
  //  console.log(newContent);
    editorDiv.innerHTML = newContent;
    oldContent = editorDiv.innerHTML;
}

function replaceEntity(content, found ){
    found.sort( function compare(a , b) {
        return a.range[0] - b.range[0];
    });
    console.log(found);
     
    var newContent ='';
    var p = 0;
    for ( var i=0; i<found.length; i++){
        var title = found[i].title;
        var range = found[i].range;
        var str1 = content.substring(p,range[0] );
        newContent +=str1;
        var oriTitle = content.substring( range[0],range[1] );
        var eid = entitiesMap[title];
        var event = 'onmouseout="outHighlight()" onclick="clickHighlight('+eid+')"  onmouseover="overHighlight('+eid+')"';
        var span = '<span class="entity" ' + event + ' data-entity-id="' + eid + '" >' + oriTitle + '</span>';
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
