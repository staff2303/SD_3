var btn = document.getElementById("btn");
var popupWindow = document.getElementById("pop");

btn.onclick = function() {
    if (btn.value == "닫기") {
        popupWindow.style.transitionProperty = "width, height, background";
        popupWindow.style.transitionDuration = "2s";
        popupWindow.style.color = "blue";
        popupWindow.style.height = "10px";
        popupWindow.style.width = "10px";
        popupWindow.style.background = "gray";
        btn.value = "열기"
    } else if (btn.value == "열기"){
        popupWindow.style.transitionProperty = "width, height, background";
        popupWindow.style.transitionDuration = "2s";
        popupWindow.style.color = "blue";
        popupWindow.style.height = "300px";
        popupWindow.style.width = "300px";
        popupWindow.style.background = "purple";
        btn.value = "닫기"
    }
};