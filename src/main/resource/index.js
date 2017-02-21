var obj = new ActiveXObject("WScript.Shell");

var btns = new Array();
btns[0] = document.getElementById("RadEHtmlButtonctl00_cphContect_t4Header");
btns[1] = document.getElementById("RadEHtmlButtonctl00_cphContect_RbWriterC");
btns[2] = document.getElementById("RadEHtmlButtonctl00_cphContect_RbUnitC");
btns[3] = document.getElementById("RadEHtmlButtonctl00_cphContect_t4KeywordsC");
btns[4] = document.getElementById("RadEHtmlButtonctl00_cphContect_radBody4c");

btns[5] = document.getElementById("RadEHtmlButtonctl00_cphContect_t4HeaderE");
btns[6] = document.getElementById("RadEHtmlButtonctl00_cphContect_RdWriterE");
btns[7] = document.getElementById("RadEHtmlButtonctl00_cphContect_RbUnitE");
btns[9] = document.getElementById("RadEHtmlButtonctl00_cphContect_T4KeywordsE");
btns[10] = document.getElementById("RadEHtmlButtonctl00_cphContect_radBody4e");
for(var b in btns){
    btns[b].onclick();
}

var arr = new Array(2);
arr[0] = document.getElementById("ctl00_cphContect_T4ScriptID");
arr[1] = document.getElementById("RadEContentTextareactl00_cphContect_t4Header");
arr[2] = document.getElementById("RadEContentTextareactl00_cphContect_RbWriterC");
arr[3] = document.getElementById("RadEContentTextareactl00_cphContect_RbUnitC");
arr[4] = document.getElementById("RadEContentTextareactl00_cphContect_t4KeywordsC");
arr[5] = document.getElementById("RadEContentTextareactl00_cphContect_radBody4c");

arr[6] = document.getElementById("RadEContentTextareactl00_cphContect_t4HeaderE");
arr[7] = document.getElementById("RadEContentTextareactl00_cphContect_RdWriterE");
arr[8] = document.getElementById("RadEContentTextareactl00_cphContect_RbUnitE");
arr[9] = document.getElementById("RadEContentTextareactl00_cphContect_T4KeywordsE");
arr[10] = document.getElementById("RadEContentTextareactl00_cphContect_radBody4e");

var delay = 0;
var jx = 200;

setTimeout(function(){
    obj.sendKeys("^b");//更换
},delay+=jx);

setTimeout(function(){
    arr[0].value = window.clipboardData.getData("Text");
},delay+=jx);


setTimeout(function(){
    obj.sendKeys("^b");//更换
},delay+=jx);

setTimeout(function(){
    arr[1].value = window.clipboardData.getData("Text");
},delay+=jx);

setTimeout(function(){
    obj.sendKeys("^b");//更换
},delay+=jx);

setTimeout(function(){
    arr[2].value = window.clipboardData.getData("Text");
},delay+=jx);

setTimeout(function(){
    obj.sendKeys("^b");//更换
},delay+=jx);

setTimeout(function(){
    arr[3].value = window.clipboardData.getData("Text");
},delay+=jx);

setTimeout(function(){
    obj.sendKeys("^b");//更换
},delay+=jx);

setTimeout(function(){
    arr[4].value = window.clipboardData.getData("Text");
},delay+=jx);

setTimeout(function(){
    obj.sendKeys("^b");//更换
},delay+=jx);

setTimeout(function(){
    arr[5].value = window.clipboardData.getData("Text");
},delay+=jx);

setTimeout(function(){
    obj.sendKeys("^b");//更换
},delay+=jx);

setTimeout(function(){
    arr[6].value = window.clipboardData.getData("Text");
},delay+=jx);

setTimeout(function(){
    obj.sendKeys("^b");//更换
},delay+=jx);

setTimeout(function(){
    arr[7].value = window.clipboardData.getData("Text");
},delay+=jx);

setTimeout(function(){
    obj.sendKeys("^b");//更换
},delay+=jx);

setTimeout(function(){
    arr[8].value = window.clipboardData.getData("Text");
},delay+=jx);

setTimeout(function(){
    obj.sendKeys("^b");//更换
},delay+=jx);

setTimeout(function(){
    arr[9].value = window.clipboardData.getData("Text");
},delay+=jx);

setTimeout(function(){
    obj.sendKeys("^b");//更换
},delay+=jx);

setTimeout(function(){
    arr[10].value = window.clipboardData.getData("Text");
},delay+=jx);

setTimeout(function(){
    obj.sendKeys("^b");//更换
},delay+=jx);

setTimeout(function(){
    obj.sendKeys("^b");//更换
},delay+=jx);
