package rpg;

public class Character {
	String nameString;
	int hp;
	int attack;
	public Character(String nameString, int hp, int attack) {
		super();
		this.nameString = nameString;
		this.hp = hp;
		this.attack = attack;
		System.out.println("=====캐릭터생성=====");
		System.out.println("이름 : " + this.nameString);
		System.out.println("HP : " + this.hp);
		System.out.println("Attack : " + this.attack);
		
	}
}
