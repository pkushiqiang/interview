
var oldContent;
var editorDiv ;
var infoDiv ;

var cursorX;
var cursorY;

function pageInit(){
    
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
    content =  content.replace(/<span*?>/gm, '');
    if ( content == oldContent)
        return;
    
  //  console.log(content);

    for ( var i=0; i<titles.length; i++){
        var title = titles[i];
        var p = content.indexOf(title);
        if ( p != -1 ) {
            var eid = entitiesMap[title];
            var event = 'onmouseout="outHighlight()" onclick="clickHighlight('+eid+')"  onmouseover="overHighlight('+eid+')"';
            var span = '<span class="entity" ' + event + ' data-entity-id="' + eid + '" >' + title + '</span>';
            var reg = new RegExp(title,"g");
      //      console.log(reg);
            content = content.replace( reg , span);              
        }
    }
    
    editorDiv.innerHTML =  content;
    oldContent = editorDiv.innerHTML;
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
    pic.src = entity.image;
   
    adjustInfoPos();    
    infoDiv.style.visibility = "visible";
}

function adjustInfoPos(){
    var x = cursorX - 80;
    if (x<=0)
        x = 10;
    if ( x + 500 > window.innerWidth )
        x = window.innerWidth - 500 - 60;
        
    infoDiv.style.left = x+"px";
    infoDiv.style.top = cursorY+15+"px";
    
}

