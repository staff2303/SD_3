window.onload = function(){ 
// window.onload = function() html 의 body가 다 그려지고 나서 실행되게하는 코드

    var t = document.getElementById("hi"); // id가 ()인 태그를 가져옴
    var s ="";
    
    while(true){
        s = prompt("값을 입력하세요 :");
        if(s==100){
            break;
        }else{
            t.innerHTML = "마지막 입력값 : "+s+"<br>";
        }
    }

}
