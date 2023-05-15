class Mter {
    constructor(name, Ohp, attack) {
        this.name = name;
        this.Ohp = Ohp;
        this.Nhp = Ohp;
        this.attack = attack;
    }
}
class Cter {
    constructor(name, Ohp, attack) {
        this.name = name;
        this.Ohp = Ohp;
        this.Nhp = Ohp;
        this.attack = attack;
    }
}

var battlebtn = document.querySelector(".battlebtn");
var logtext = document.getElementById("log");

//프로필 업데이트
function profileUpdate(str) {
    var profilename = document.querySelector("." + str);
    // profilename.children[0].innerHTML 플레이어이름
    // profilename.children[1].innerHTML 직업
    // profilename.children[3].innerHTML 래벨
    // profilename.children[4].children[1].children[0].children[0].style.width hp
    // profilename.children[5].children[1].children[0].children[0].style.width exp
    console.log(profilename.children[4].children[1].children[0].children[0].style.width);
}
// 로그 출력
var log = function (msg) {
    var p = document.createElement("p");
    p.innerHTML = msg;
    logtext.prepend(p);
}

profileUpdate("player");
