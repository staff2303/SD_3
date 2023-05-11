var user_box;
var chkboxcount;
var com_child;
var user_child;
var chknum;
var element;
var user = [];
var lotto = [];
var delindex = 0;

window.onload = function seting() {
    user_box = document.getElementById('user_chkbox');
    chkboxcount = 'input[class="user_num"]:checked';
    com_child = document.getElementsByClassName('ball com');
    user_child = document.getElementsByClassName('ball user');
    chknum = document.getElementsByClassName('user_num');
}
// reset
function reset() {
    delindex = 0;
    user = [];
    lotto = [];
    showlotto();
    showuser();
    document.querySelectorAll(".user_num").forEach(function (v) { v.checked = false; });
}
// 체크박스
function num_check() {
    element = document.querySelectorAll(chkboxcount);
    if (element.length == 7) {
        lottonum();            //로또번호 뽑고
        showlotto();           //로또번호 보여주고
        showresult();    //결과실행
    } else {
        alert("숫자 7개를 선택해주세요.");
        reset();
    }
}
function count_check(i) {
    let index = i - 1;
    if (chknum[index].checked == true) {
        if (user.lastIndexOf(Number(chknum[index].value)) == -1) {
            user.push(Number(chknum[index].value));
            if(user.length < 7) user.sort((a, b) => a - b);
            delshowuser();
            showuser();
        }
    } else {
        for (let i = 0; i < user.length; i++) {
            if (user[i] === Number(chknum[index].value)) {
                user.splice(i, 1);
            }
        }
        delshowuser();
        showuser();
    }
    element = document.querySelectorAll(chkboxcount);
    if (element.length > 7) {
        alert("7개까지 체크할 수 있습니다.");
        reset();
    }
}
//show 초기화
function delshowlotto() {
    while (com_child.length > 0) {
        let childelement = document.querySelector("#ball");
        childelement.remove();
    }
}
function delshowuser() {
    while (user_child.length > 0) {
        let childelement = document.querySelector("#userball");
        childelement.remove();
    }
}
// 로또번호생성
function lottonum() {
    lotto = [];
    while (lotto.length < 6) {
        let num = parseInt(Math.random() * 45 + 1);
        if (lotto.indexOf(num) == -1) {
            lotto.push(num);
        }
    }
    // 로또번호정렬
    lotto.sort((a, b) => a - b);
    // 행운번호
    while (true) {
        num = parseInt(Math.random() * 45 + 1);
        if (lotto.indexOf(num) == -1) {
            lotto.push(num);
            break;
        }
    }
}
// 로또번호출력
function showlotto() {
    delshowlotto();
    for (let i = 0; i < 7; i++) {
        //div 요소 생성
        let newDiv = document.createElement("div");
        //class 지정
        newDiv.setAttribute("id", "ball");
        newDiv.setAttribute("class", "ball com");
        if (i == 6) newDiv.setAttribute("class", "ball com luck");
        //텍스트 입력
        if (lotto[i] != undefined) {
            let newtext = document.createTextNode(lotto[i]);
            newDiv.appendChild(newtext)
        };
        //추가
        document.querySelector("#computer_box").append(newDiv);
    }
}
// 고른번호출력
function showuser() {
    delshowuser();
    for (let i = 0; i < 7; i++) {
        //div 요소 생성
        let newDiv = document.createElement("div");
        //class 지정
        newDiv.setAttribute("id", "userball");
        newDiv.setAttribute("class", "ball user");
        if (i == 6) newDiv.setAttribute("class", "ball user luck");
        //텍스트 입력
        let newtext = document.createTextNode(user[i]);
        if (user[i] != undefined) newDiv.appendChild(newtext);
        //추가
        document.querySelector("#user_box").append(newDiv);
    }
}
// 결과!!
function showresult() {
    let resultid = document.querySelector(".congratulations");
    let count = 0;
    let luck = false;
    for (let i = 0; i < 6; i++) {
        if (lotto.indexOf(user[i]) == 1) {console.log(user[i]); count++;}
    }
    if (user[6] == lotto[6]) luck = true;
    console.log("lotto : " + lotto);
    console.log("user : " + user);
    console.log("count : " + count);
    console.log("lucknum : " + luck)
    switch (count) {
        case 6: //1등
            resultid.innerHTML = "1등";
            break;
        case 5: //2등, 3등
            if (luck) {
                resultid.innerHTML = "2등";
                break;
            } else {
                resultid.innerHTML = "3등";
                break;
            }
        case 4: //4등
            resultid.innerHTML = "4등";
            break;
        case 3: //5등
            resultid.innerHTML = "5등";
            break;
        default: //꽝
            resultid.innerHTML = "꽝";
            break;
    }
}
