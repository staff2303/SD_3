function one(){
    return 100;
}

function two(){
    return 200;
}

function add(a,b){

    var sum = a + b;

    return sum;
}

// 함수 실행
var addsum = add( one(), two() );

document.write(addsum);