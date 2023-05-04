function br(){
    document.write("<br>");
}

for (var i = 1; i <= 10; i++) {
    document.write(i + " 는 ");
    if (i % 2 == 0) {
        document.write("짝수입니다.");
    } else {
        document.write("홀수입니다.");
    }
    br();
}
