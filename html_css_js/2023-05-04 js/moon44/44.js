function one(num){
    num = num + 1;
    return num;
}

// 함수 실행
var run = one(one(100));

document.write(run);