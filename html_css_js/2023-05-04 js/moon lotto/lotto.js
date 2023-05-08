// 로또번호생성
var lotto = [];

while (lotto.length < 6) {
    var num = parseInt(Math.random() * 45 + 1);
    if (lotto.indexOf(num) == -1) {
        lotto.push(num);
    }
}
// 로또번호정렬
lotto.sort((a, b) => a - b);

// 로또번호출력
for (let i = 0; i < lotto.length; i++) {
    document.write("<div class='ball ball'>" + lotto[i] + "</div>");
}
