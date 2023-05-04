var player;
var computer;
var result;

function playerinput(){
     while(true){
        var str = prompt("가위 ~ 바위 ~ 보");
        if (str == "가위" || str == "바위" || str == "보") {
            break;
        } else {
            alert("정확히 입력해주세요");
        }
    }
    return str;
}
function computerinput(){
    var num = Math.floor(Math.random() * 3) + 1;
    switch(num){
        case 1:
            return "가위";
        case 2:
            return "바위";
        case 3:
            return "보";
    }
}
function gameresult(){
    if (player == computer) {
        return "비김";
    } else if (((player == "가위") && (computer == "보")) ||
               ((player == "바위") && (computer == "가위")) ||
               ((player == "보") && (computer == "바위"))) {
        return "이김";
    } else {
        return "짐";
    }
}

player = playerinput();
computer = computerinput();
result = gameresult();
document.write("플레이어 : " + player);
br();
document.write("컴 퓨 터 : " + computer);
br();
document.write("결과 : " + result);
