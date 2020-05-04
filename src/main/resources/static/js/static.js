var query = window.location.href.split('?')[1];
var value = query.split("%22");

window.onload = function() {
     document.getElementsByClassName("hello-title")[0].innerHTML = "You have been hacked, " +  value[1] + "!"
 }