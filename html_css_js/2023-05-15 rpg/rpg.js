class Cter {
    constructor(name, job, level, hp, Oexp, attack) {
        this.name = name;
        this.job = job;
        this.level = level;
        this.hp = hp;
        this.Maxhp = hp;
        this.Oexp = Oexp;
        this.Nexp = 0;
        this.attack = attack;
    }
}
class Mter {
    constructor(name, job, Ohp, attack) {
        this.name = name;
        this.job = job;
        this.Ohp = Ohp;
        this.Nhp = Ohp;
        this.attack = attack;
    }
}

var battlebtn = document.querySelector(".battlebtn");
var logtext = document.getElementById("log");
//캐릭터생성
var player = new Cter("캐릭터당", "모험가당", 1, 100, 100, 10);

//프로필 업데이트
// profilename.children[0].innerHTML 플레이어이름
// profilename.children[1].innerHTML 직업
// profilename.children[3].innerHTML 래벨
// profilename.children[4].children[1].children[0].children[0].style.width hp%
// profilename.children[5].children[1].children[0].children[0].style.width exp%
// profilename.children[6].children[1].innerHTML 공격력
function profileUpdate(str, cls) {
    let profilename = document.querySelector("." + str);
    let hpPercent = Math.floor((cls.hp * 100) / cls.Maxhp);
    console.log(cls.hp);
    console.log(cls.Maxhp)
    console.log(hpPercent);
    profilename.children[0].innerHTML = cls.name;
    profilename.children[1].innerHTML = cls.job;
    profilename.children[3].innerHTML = cls.level;
    profilename.children[4].children[1].children[0].children[0].style.width = hpPercent + "%";
    profilename.children[5].children[1].children[0].children[0].style.width = cls.exp;
    profilename.children[6].children[1].innerHTML = cls.attack;
}
// 로그 출력
var log = function (msg) {
    var p = document.createElement("p");
    p.innerHTML = msg;
    logtext.prepend(p);
}

profileUpdate("player", player);
