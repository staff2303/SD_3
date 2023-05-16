var btn = document.getElementById("btn");
var img = document.getElementById("img");

function pop() {
    if (img.style.display == "inline") {
        img.style.display = "none";
        btn.value = "숨었다!!"
    } else {
        img.style.display = "inline";
        btn.value = "나타났다!!"
    }
}

btn.addEventListener("click",pop);