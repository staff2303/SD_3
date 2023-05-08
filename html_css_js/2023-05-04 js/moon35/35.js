var array = new Array();
array = ["개","고양이","너굴맨"];

var str = array[1] + array[0];

alert("합계: " + str);
for (var i = 0; i < 3; i++){
    document.write("array["+ i +"] : " + array[i]);
    document.write("<br>");
}