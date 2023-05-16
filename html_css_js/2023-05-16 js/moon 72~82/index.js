var str_id = "";
var str_pw = "";

var input_id = input_id = document.getElementById("id");
var input_pw = input_pw = document.getElementById("pw");

const labels = document.querySelectorAll(".form-control label");

labels.forEach((label) => {
  label.innerHTML = label.innerText
    .split("")
    .map(
      (letter, idx) =>
        `<span style="transition-delay:${idx * 50}ms">${letter}</span>`
    )
    .join("");
});

function login(){
    alert("ID:"+input_id.value+" PW:"+input_pw.value);

    if(input_id.value == "staff" && input_pw.value == "2303"){
        alert("로그인 성공");
    }else{
        alert("로그인 실패");
        return;
    }
}