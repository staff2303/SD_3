var ran;
ran = Math.floor(Math.random() * 100);
for (var i = 1; i <= ran; i++) {
    document.write("<img src='5img.png' height='250' width='150'>");   
}
document.write('<br>' + ran + "개 등장!");