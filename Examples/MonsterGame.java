import java.util.Arrays;
//import org.apache.commons.lang3.ArrayUtils;

public class MonsterGame {
	static char[][] board = new char[10][10];

	public static void buildBattleBoard() {

		for(char [] row : board) {

			Arrays.fill(row, '*');

		}
	}

	public static void redrawBoard() {
		
		for(int i = 0 ; i < 30 ; i++) {
			System.out.print('-');
		}

		System.out.println();

		for(char [] row : board) {
			for(char item : row) {
				System.out.print("|" + item + "|");
			}

			System.out.println();
		}

		for(int i = 0 ; i < 30 ; i++) {
			System.out.print('-');
		}

		 System.out.println();
	}

	public final String TOMBSTONR = "Here Lies a Dead Monster!";

	private int health = 500;
	private int attack = 20;
	private int movement = 2;
	private boolean alive = true;

	public String name = "Big Monster";
	public char nameChar = 'B';
	public int XPosition = 0;
	public int YPosition = 0;
	public static int numOfMonsters = 0;

	public int getAttack() {
		return attack;
	}

	public int getMovement(){ 
		return movement;
	}

	public int getHealth() {
		return health;
	}

	public boolean getAlive() {
		return alive;
	}

	public void setHealth(int decreaseHealth) {
		health -= decreaseHealth;
		if(health < 0) {
			alive = false;
			numOfMonsters--;
		}
	}

	public MonsterGame(String name, int health, int attack, int movement) {
		this.name = name;
		this.health = health;
		this.attack = attack;
		this.movement = movement;
		
		int maxXBoardSpace = board.length - 1;
		int maxYBoardSpace = board[0].length - 1;

		int randX, randY;

		do {

			randX = (int) (Math.random() * maxXBoardSpace);
			randY = (int) (Math.random() * maxYBoardSpace);
		} while (board[randX][randY] != '*');

		this.XPosition = randX;
		this.YPosition = randY;

		this.nameChar = this.name.charAt(0);

		board[this.XPosition][this.YPosition] = this.nameChar;

		numOfMonsters++;
	}

	public void moveMonster(MonsterGame[] Monsters, int arrayItemIndex) {
		boolean isSpaceOpen = true;
		int maxXBoardSpace = board.length - 1;
		int maxYBoardSpace = board[0].length - 1;

		while(isSpaceOpen) {
			int randMoveDirection = (int) (Math.random() * 4);
			int randMoveDistance  = (int) (Math.random() * this.getMovement() + 1);
			System.out.println("Name : " + this.nameChar + " Direction : " + randMoveDirection + " Distance : " + randMoveDistance);
			board[this.XPosition][this.YPosition] = '*';

			if(randMoveDirection == 0) {

				if((this.YPosition - randMoveDistance) < 0) {
					this.YPosition = 0;
				} else {
					this.YPosition -= randMoveDistance;

				} 
			
			} else if(randMoveDirection == 2) {

				if((this.YPosition + randMoveDistance) > maxYBoardSpace) {
					this.YPosition = maxYBoardSpace;
				} else {
					this.YPosition += randMoveDistance;
				}

			} else if(randMoveDirection == 1) {

				if((this.XPosition + randMoveDistance) > maxXBoardSpace) {
					this.XPosition = maxXBoardSpace;
				} else {
					this.XPosition += randMoveDistance;
				}

			} else {

				if((this.XPosition - randMoveDistance) < 0) {
					this.XPosition = 0;
				} else {
					this.XPosition -= randMoveDistance;
				}
			}

			for(int i = 0 ; i < Monsters.length ; i++) {

				if(i == arrayItemIndex) {
					continue;
				}

				if(onMySpace(Monsters, i, arrayItemIndex)) {
					isSpaceOpen = true;
					break;
				} else {
					isSpaceOpen = false;
				}
			}
			
		}

		board[this.XPosition][this.YPosition] = this.nameChar;
	}

	public boolean onMySpace(MonsterGame[] Monsters, int i, int arrayItemIndex) {

		if((Monsters[i].XPosition == Monsters[arrayItemIndex].XPosition) && (Monsters[i].YPosition == Monsters[arrayItemIndex].YPosition)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String args[]) {
		MonsterGame.buildBattleBoard();
		MonsterGame.redrawBoard();

		MonsterGame[] Monsters = new MonsterGame[4];

		Monsters[0] = new MonsterGame("Frank", 1000, 50, 1);
		Monsters[1] = new MonsterGame("Drack", 500, 70, 2);
		Monsters[2] = new MonsterGame("Crack", 300, 90, 3);
		Monsters[3] = new MonsterGame("Lowie", 1500, 30, 1);

		MonsterGame.redrawBoard();

		for(int i = 0 ; i < Monsters.length ; i++) {

			if(Monsters[i].getAlive()) {
				Monsters[i].moveMonster(Monsters, i);
			}
		}

		MonsterGame.redrawBoard();

	}
}
