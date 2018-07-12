import java.io.*;

class GameCharacter implements Serializable {

	int power;
	String type;
	String[] weapons;
	
	static final long serialVersionUID = 12345L;

	public GameCharacter(int power, String type, String[] weapons) {
		this.power = power;
		this.type = type;
		this.weapons = weapons;
	}

	public int getPower() {
		return power;
	}
	public String getType() {
		return type;
	}

	public String getWeapons() {
		String weaponList = "";

		for(int i = 0 ; i < weapons.length ; i++) {
			weaponList += weapons[i] + " ";
		}
		return weaponList;
	}
}

public class SerializableTest {
	public static void main(String[] args) {

		GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "dust"});
		GameCharacter two = new GameCharacter(300, "Troll", new String[] {"bare hands", "big axe"});
		GameCharacter three = new GameCharacter(120, "Magician", new String[] {"spells", "invisiblity"});

		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
			os.writeObject(one);
			os.writeObject(two);
			os.writeObject(three);
			os.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

		one = null;
		two = null;
		three = null;

		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
			GameCharacter oneRestore = (GameCharacter) is.readObject();
			GameCharacter twoRestore = (GameCharacter) is.readObject();
			GameCharacter threeRestore = (GameCharacter) is.readObject();
			is.close();

			System.out.println(oneRestore.getType());
			System.out.println(twoRestore.getType());
			System.out.println(threeRestore.getType());
		
		} catch(Exception e) {
			e.printStackTrace();
		}


	}
}
