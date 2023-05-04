
var random; //변수생성
random = Math.floor(Math.random() * 6) + 1; // 랜덤수 생성후 변수에저장
var random2;
random2 = Math.floor(Math.random() * 6) + 1;
var s = "주사위를 굴려 ( " + random + " ) 와 ( " + random2 + " ) 가 나왔습니다."; // 
document.write(s);



