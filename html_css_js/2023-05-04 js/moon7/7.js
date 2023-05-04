var ran;
ran = Math.floor(Math.random() * 100);
for (var i = 1; i <= ran; i++) {
    if ( i == 7 ) {
        document.write("<img id='gold' src='7img.png' width='100px' height='150px'>");
        document.write(i + "번째 등장!", '<br>');
        var gold_img = document.getElementById("gold");
        gold_img.style.borderColor = "yellow";
        gold_img.style.borderStyle = "solid";
        gold_img.style.borderWidth = "10px";
    } else {
        document.write("<img src='7img.png' width='100px' height='150px'>");
        document.write(i + "번째 등장!", '<br>');
    }   
}
document.write('<br>' + ran + "개 등장!");
