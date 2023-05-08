var array = new Array();
array = [1, 2, 3, 4];

var n1 = array[0];
var n2 = array[1];
var n3 = array[2];
var n4 = array[3];
var sum = n1 + n2 + n3 + n4;

alert("합계: " + sum);
for (var i = 0; i < 4; i++){
    document.write("array["+ i +"] : " + array[i]);
    document.write("<br>");
}