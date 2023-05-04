var cat_age;
var cat_wht;
var cat_name;

function scanf() {
    cat_age = prompt("고양이 나이는?");
    cat_wht = prompt("고양이 종류는?");
    cat_name = prompt("고양이 이름는?");
}
function sumver(a, b, c) {
    var sum = a + b + c;
    return sum;
}

scanf();
alert(sumver(cat_age, cat_wht, cat_name));

