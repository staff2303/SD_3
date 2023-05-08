var player;
var computer;
var result;
var imgArray = new Array();
imgArray[0] = "gawe.png";
imgArray[1] = "bawe.png";
imgArray[2] = "bo.png";
var i = 0;
var img;
var game_result;

window.onload = function seting() {
    img = document.getElementById("computer_img");
    plyer_input = document.getElementById("plyer_input");
    com_input = document.getElementById("com_input");
    game_result = document.getElementById("result");
}
const intervalId = setInterval(showimg, 50);

function showimg() {
    i = Math.floor(Math.random() * 3)
    img.src = imgArray[i];
}



function input_gawe() {
    clearInterval(intervalId);
    player = "가위";
    computerinput();
}
function input_bawe() {
    clearInterval(intervalId);
    player = "바위";
    computerinput()
}
function input_bo() {
    clearInterval(intervalId);
    player = "보";
    computerinput()
}

function computerinput(){
    switch(i){
        case 0:
            computer = "가위";
            break;
        case 1:
            computer = "바위";
            break;
        case 2:
            computer = "보";
            break;
    }
    game_result.innerText = gameresult();
}

function gameresult(){
    if (player == computer) {
        return "비겼다!";
    } else if (((player == "가위") && (computer == "보")) ||
               ((player == "바위") && (computer == "가위")) ||
               ((player == "보") && (computer == "바위"))) {
        return "이겼다!";
    } else {
        return "졌다!";
    }
}
