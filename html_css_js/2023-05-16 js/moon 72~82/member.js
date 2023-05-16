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

var Id = document.getElementById("id");
var Pw = document.getElementById("pw");
var Cpw = document.getElementById("cpw");
var Name = document.getElementById("name");
var Email = document.getElementById("email");
var Cemail = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
var Birth = document.getElementById("birth");
var Sex = document.getElementById("sex");
var Phone = document.getElementById("phone");
var Cphone = /^(01[016789]{1})[0-9]{3,4}[0-9]{4}$/;

function check() {
  if (checkId() && checkPw() && checkName() && checkEmail() && checkBirth() && checkSex() && checkPhone()) {
    alert("회원가입 완료");
    console.log(Id.value);
    console.log(Pw.value);
    console.log(Name.value);
    console.log(Email.value);
    console.log(Birth.value);
    console.log(Sex.value);
    console.log(Phone.value);
  } else {
    alert("회원가입 실패");
  }
}

function checkId() {
  if (Id.value.length >= 4 && Id.value.length <= 12) {
    return true;
  } else {
    alert("아이디는 4자리 이상 12자리 미만으로 입력해주세요");
    return false;
  }
}

function checkPw() {
  if (Pw.value.length >= 4 && Pw.value.length <= 12) {
    if (Pw.value == Cpw.value) {
      return true;
    } else {
      alert("비밀번호가 일치하지 않습니다. 다시입력해주세요");
      return false;
    }
  } else {
    alert("비밀번호는 4자리 이상 12자리 미만으로 입력해주세요");
    return false;
  }
}

function checkName() {
  if (Name.value == '') {
    alert("이름을 입력하세요")
    return false;
  } else {
    return true;
  }
}

function checkEmail() {
  if (Email.value == '' || !Cemail.test(Email.value)) {
    alert("올바른 이메일 주소를 입력하세요")
    return false;
  } else {
    return true;
  }
}

function checkBirth() {
  if (Birth.value == "") {
    alert("생년월일을 정확하게 입력해주세요");
    return false;
  } else {
    return true;
  }
}

function checkSex() {
  if (Sex.value == "남" || Sex.value == "여") {
    return true;
  } else {
    alert("남 / 여 정확하게 입력해주세요");
    return false;
  }
}

function checkPhone() {
  if (Phone.value == '' || !Cphone.test(Phone.value)) {
    alert("올바른 핸드폰 번호를 입력하세요")
    return false;
  } else {
    return true;
  }
}
