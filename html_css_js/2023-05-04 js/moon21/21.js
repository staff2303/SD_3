for (var y = 0; y < 10; y++) {
    for (var x = 10; x > y + 1; x--) {
        document.write('　');
    }
    for (var s = 0; s < y + 1; s++) {
        document.write("☆");
    }
    document.write('<br>');
}

/* for(var i=1; i<=10; i=i+1){

    for(k=9; k>=i; k=k-1){
        document.write("&nbsp;");
    }

    for(var j=1; j<=i; j=j+1){
        document.write("*");
    }
    document.write("<br>");
} */