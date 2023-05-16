var str_id = "";
var str_pw = "";

var input_id;
var input_pw;

window.onload = function(){
    input_id = document.getElementById("id");
    input_pw = document.getElementById("pw");
}

function login(){
    alert("ID:"+input_id.value+" PW:"+input_pw.value);
}