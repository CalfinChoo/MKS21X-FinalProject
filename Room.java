import com.googlecode.lanterna.terminal.Terminal;
import java.lang.Math;
import java.util.Random;
public class Room{
	private Terminal.Color[][] SpawnRoomCM = new Terminal.Color[15][15];
	private Terminal.Color[][] ShopRoomCM = new Terminal.Color[35][35];
	private Terminal.Color[][] SmallBattleRoomCM = new Terminal.Color[75][75];
	private Terminal.Color[][] BigBattleRoomCM = new Terminal.Color[95][95];
	private Terminal.Color[][] TreasureRoomCM = new Terminal.Color[25][25];
	private Terminal.Color[][] BossRoomCM = new Terminal.Color[115][115];
	private String[][] SpawnRoom = new String[15][15];
	private String[][] ShopRoom = new String[35][35];
	private String[][] SmallBattleRoom = new String[75][75];
	private String[][] BigBattleRoom = new String[95][95];
	private String[][] TreasureRoom = new String[25][25];
	private String[][] BossRoom = new String[115][115];
	private int randRow1, randRow2, randRow3, randCol1, randCol2, randCol3, randRow4, randCol4, randRow5, randCol5 = 0;
	private Random rand;

	public Room(){
		rand = new Random();
		fillRoom(SpawnRoom);fillRoom(ShopRoom);fillRoom(SmallBattleRoom);
		fillRoom(TreasureRoom);fillRoom(BossRoom);fillRoom(BigBattleRoom);
	}
	public String[][] getSpawnRoom() {
		return SpawnRoom;
	}
	public String[][] getShopRoom() {
		return ShopRoom;
	}
	public String[][] getSmallBattleRoom() {
		return SmallBattleRoom;
	}
	public String[][] getBigBattleRoom() {
		return BigBattleRoom;
	}
	public String[][] getTreasureRoom() {
		return TreasureRoom;
	}
	public String[][] getBossRoom() {
		return BossRoom;
	}
	public String[][] fillRoom(String[][] room) {
		if (room.equals(SmallBattleRoom) || room.equals(BigBattleRoom)) {
			randRow1 = rand.nextInt(room.length - 30) + 15;
			randCol1 = rand.nextInt(room.length - 30) + 15;
			randRow2 = rand.nextInt(room.length - 30) + 15;
			randCol2 = rand.nextInt(room.length - 30) + 15;
			randRow3 = rand.nextInt(room.length - 30) + 15;
			randCol3 = rand.nextInt(room.length - 30) + 15;
			randRow4 = rand.nextInt(room.length - 30) + 15;
			randCol4 = rand.nextInt(room.length - 30) + 15;
			randRow5 = rand.nextInt(room.length - 30) + 15;
			randCol5 = rand.nextInt(room.length - 30) + 15;
		}
		for (int row = 0; row < room.length; row++) {
			for (int col = 0; col < room[row].length; col++) {
				if (room.equals(SmallBattleRoom) || room.equals(BigBattleRoom)) {
					if (Math.pow((row - randRow1), 2) + Math.pow((col - randCol1), 2) <= 25) {
						room[row][col] = "l";
					}
					if (Math.pow((row - randRow2), 2) + Math.pow((col - randCol2), 2) <= 25) {
						room[row][col] = "l";
					}
					if (Math.pow((row - randRow3), 2) + Math.pow((col - randCol3), 2) <= 25) {
						room[row][col] = "l";
					}
					if (Math.pow((row - randRow4), 2) + Math.pow((col - randCol4), 2) <= 25) {
						room[row][col] = "l";
					}
					if (room.equals(BigBattleRoom) && Math.pow((row - randRow5), 2) + Math.pow((col - randCol5), 2) <= 25) {
						room[row][col] = "l";
					}
				}
				if (room.equals(BossRoom)) {
				  if (row < 10 || row > room.length - 11 || col < 10 || col > room[row].length - 11) {
						room[row][col] = "l";
					}
				}
				if (room.equals(TreasureRoom)) {
					room[12][12] = "t";
				}
				if (room.equals(ShopRoom) && (((row == 14 || row == 20) && (col >= 14 && col <= 20)) || (col == 14 || col == 20) && (row >= 14 && row <= 20))) {
					room[row][col] = "m";
				}
			}
		}
		for (int r = 0; r < room.length; r++) {
			for (int c = 0; c < room[r].length; c++) {
				if ((r == 0 || r == room.length - 1 || c == 0 || c == room[r].length - 1) && room[r][c] != "d") {
					room[r][c] = "w";
				}
				if ((c == 0 || c == room[r].length -1) && r == room.length / 2) {
					for (int count = r - 3; count < r + 4; count++) {
						room[count][c] = "d";
						if (room.equals(BossRoom) && c == 0) {
							for (int del = c + 1; del < c + 10; del++) {
								room[count][del] = null;
							}
						}
						if (room.equals(BossRoom) && c == room[r].length -1) {
							for (int del = c - 1; del > c - 11; del--) {
								room[count][del] = null;
							}
						}
					}
				}
				if ((r == 0 || r == room.length - 1) && c == room[r].length / 2) {
					for (int count = c - 3; count < c + 4; count++) {
						room[r][count] = "d";
						if (room.equals(BossRoom) && r == 0) {
							for (int del = r + 1; del < r + 10; del++) {
								room[del][count] = null;
							}
						}
						if (room.equals(BossRoom) && r == room.length - 1) {
							for (int del = r - 1; del > r - 11; del--) {
								room[del][count] = null;
							}
						}
					}
				}
			}
		}
		return room;
	}
	private static void printView(String[][] view){
		String out = "";
		for (int y = 0; y < view.length; y++){
			for (int x = 0; x < view[0].length;x++){
				if (view[y][x] == null) out += "  ";
				else out+=view[y][x]+" ";
			}
			out += "\n";
		}
		System.out.println(out);
	}

	public static void main(String[] args){
		Room rooms = new Room();
		printView(rooms.getTreasureRoom());
	}
}
