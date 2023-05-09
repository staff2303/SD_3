var user_box;
var chkboxcount;
var com_child;
var user_child;

window.onload = function seting() {
    user_box = document.getElementById('user_chkbox');
    chkboxcount = 'input[class="user_num"]:checked';
    com_child = document.getElementsByClassName('ball com');
    user_child = document.getElementsByClassName('ball user');
}
// 체크박스 값 가져오기
function num_check() {
    let lotto = [];
    let user = [];
    const element = document.querySelectorAll(chkboxcount);
    const chkcount = element.length;
    let chknum = document.getElementsByClassName('user_num');
    if (chkcount == 7) {
        for (let i = 0; i < chknum.length; i++) {
            if (chknum[i].checked == true) {
                user.push(Number(chknum[i].value));
            }
        }
        lottonum(lotto);
        //showlotto 초기화
        while (com_child.length > 0) {
            let childelement = document.querySelector("#ball");
            childelement.remove();
        }
        while (user_child.length > 0) {
            let childelement = document.querySelector("#ball");
            childelement.remove();
        }
        showlotto(lotto);
        showuser(user);
        showresult(user, lotto);
    } else {
        alert("숫자 7개를 선택해주세요.");
    }
}
// 체크박스체크갯수제한
function count_check() {
    const element = document.querySelectorAll(chkboxcount);
    const chkcount = element.length;
    if (chkcount > 7) {
        alert("7개까지 체크할 수 있습니다.");
        document.querySelectorAll(".user_num").forEach(function (v) { v.checked = false; });
    }
}
// 로또번호생성
function lottonum(lotto) {
    while (lotto.length < 7) {
        var num = parseInt(Math.random() * 45 + 1);
        if (lotto.indexOf(num) == -1) {
            lotto.push(num);
        }
    }
    // 로또번호정렬
    lotto.sort((a, b) => a - b);
}
// 로또번호출력
function showlotto(lotto) {
    for (let i = 0; i < lotto.length; i++) {
        //div 요소 생성
        let newDiv = document.createElement("div");
        //class 지정
        newDiv.setAttribute("id", "ball");
        newDiv.setAttribute("class", "ball com");
        if (i == 6) newDiv.setAttribute("class", "ball com luck");
        //텍스트 입력
        let newtext = document.createTextNode(lotto[i]);
        newDiv.appendChild(newtext);
        //추가
        document.querySelector("#computer_box").append(newDiv);
    }
}
// 고른번호출력
function showuser(user) {
    for (let i = 0; i < user.length; i++) {
        //div 요소 생성
        let newDiv = document.createElement("div");
        //class 지정
        newDiv.setAttribute("id", "ball");
        newDiv.setAttribute("class", "ball user");
        if (i == 6) newDiv.setAttribute("class", "ball user luck");
        //텍스트 입력
        let newtext = document.createTextNode(user[i]);
        newDiv.appendChild(newtext);
        //추가
        document.querySelector("#user_box").append(newDiv);
    }
}
// 결과!!
function showresult(user, lotto) {
    console.log(user.filter(x => lotto.includes(x)));
    switch (user.filter(x => lotto.includes(x)).length) {
        case 6:
            alert("1등!!");
            break;
        case 5:
            alert("3등!!");
            break;
        case 4:
            alert("4등!!");
            break;
        case 3:
            alert("5등!!");
            break;
        default:
            alert("꽝!!");
            break;
    }
}