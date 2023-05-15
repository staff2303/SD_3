class human {
    constructor (name, age, city) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.sleep = function(){
            document.write("졸리다 <br>");
        }
    }
}

var shim = new human ('심훈', 25, 'Gyeonggi-do');
var kim = new human ('김철수', 24, 'seoul');

if(shim.age > kim.age) document.write(shim.name + "(이)가 형<br>");
if(shim.age < kim.age) document.write(kim.name + "(이)가 형<br>");
if(shim.age == kim.age) document.write(shim.name + " 와 " + kim.name + " 는 친구<br>");

document.write("<br>");
document.write(shim.name + "<br>");
document.write(shim.age + "<br>");
document.write(shim.city + "<br>");
shim.sleep();
document.write("<br>");
document.write(kim.name + "<br>");
document.write(kim.age + "<br>");
document.write(kim.city + "<br>");
