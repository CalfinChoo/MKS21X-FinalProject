<<<<<<< HEAD
=======

>>>>>>> d6e4fe3218831d6bc4be8e4bdffc23c3a2777ac5
import java.lang.Math;
import java.util.Random;
public class Room{
	/*private Terminal.Color[][] SpawnRoomCM = new Terminal.Color[15][15];
	private Terminal.Color[][] ShopRoomCM = new Terminal.Color[35][35];
	private Terminal.Color[][] SmallBattleRoomCM = new Terminal.Color[75][75];
	private Terminal.Color[][] BigBattleRoomCM = new Terminal.Color[95][95];
	private Terminal.Color[][] TreasureRoomCM = new Terminal.Color[25][25];
	private Terminal.Color[][] BossRoomCM = new Terminal.Color[115][115]; */
	private String[][] SpawnRoom = new String[15][30];
	private String[][] ShopRoom = new String[35][75];
	private String[][] SmallBattleRoom = new String[75][150];
	private String[][] BigBattleRoom = new String[95][190];
	private String[][] TreasureRoom = new String[25][50];
	private String[][] BossRoom = new String[115][230];
	private int randRow, randCol;
	private Random rand;
	private int randRC[][];
	/*
 * Contains all the different rooms used in the game.
 * Rooms are saved as 2-Dimensional String Arrays containing the layouts of the rooms.
 * Some rooms include randomized placement of objects while others are always the same.
 */

//  Constructs rooms
	public Room(){
		rand = new Random();
		fillRoom(SpawnRoom);fillRoom(ShopRoom);fillRoom(SmallBattleRoom);
		fillRoom(TreasureRoom);fillRoom(BossRoom);fillRoom(BigBattleRoom);
	}
//  Room getters
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
//  Helper functions for Lava placement for BattleRooms in fillroom command:
//  initiateLava creates number of pits of lava to be placed
	public void initiateLava(String[][] room, int count, int major, int minor) {
		randRC = new int[count][2];
		for (int i = 0; i < count; i++) {
			randRow = rand.nextInt(room.length);
			while (randRow + minor >= room.length - 6 || randRow - minor <= 5) randRow = rand.nextInt(room.length);
			randCol = rand.nextInt(room[randRow].length);
			while (randCol + major >= room[randRow].length - 6 || randCol - major <= 5) randCol = rand.nextInt(room[randRow].length);
			randRC[i][1] = randRow;
			randRC[i][0] = randCol;
		}
	}
//  lavaIsPlaceable checks to see if current position in room filling is part of a designated lava pit
	public boolean lavaIsPlaceable(String[][] room, int row, int col, int randRow, int randCol, int major, int minor) {
			if (Math.pow((row - randRow), 2) / (minor * minor) + Math.pow((col - randCol), 2) / (major * major) <= 1) {
				return true;
			}
		return false;
	}
//  Fills rooms with room-specific objects (e.g. Treasure in TreasureRoom), as well as shared objects (i.e. walls, doors, floor)
	public String[][] fillRoom(String[][] room) {
		if (room.equals(SmallBattleRoom)) initiateLava(SmallBattleRoom, 4, 9, 5);  // initiateLava(room, # of pits, major axis length, minor axis length)
		if (room.equals(BigBattleRoom)) initiateLava(BigBattleRoom, 5, 9, 5);
		for (int row = 0; row < room.length; row++) {
			for (int col = 0; col < room[row].length; col++) {
				//  Room-specific objects
				if (room.equals(SmallBattleRoom) || room.equals(BigBattleRoom)) {
					for (int i = 0; i < randRC.length; i++) {
						if (lavaIsPlaceable(room, row, col, randRC[i][1], randRC[i][0], 9, 5)) {
							room[row][col] = "l";
						}
					}
				}
				if (room.equals(BossRoom)) {
				  if ((row < 10 && row > 0) || (row > room.length - 11 && row < room.length - 1) || (col < 10 && col > 0) || (col > room[row].length - 11 && col < room[row].length - 1)) {
						room[row][col] = "l";
					}
					if ((row > 0 && row < room.length - 1 && col >= room[row].length / 2 - 3 && col <= room[row].length / 2 + 3) || (col > 0 && col < room[row].length - 1 && row >= room.length / 2 - 3 && row <= room.length / 2 + 3)) room[row][col] = null;
				}
				if (room.equals(TreasureRoom)) {
					room[12][12] = "t";
				}
				if (room.equals(ShopRoom) && (((row == 14 || row == 20) && (col >= 14 && col <= 20)) || (col == 14 || col == 20) && (row >= 14 && row <= 20))) {
					room[row][col] = "m";
				}
				//  Objects shared by all rooms
				if ((row == 0 || row == room.length - 1 || col == 0 || col == 1 || col == room[row].length - 1 || col == room[row].length - 2)) {
					room[row][col] = "w";
				}
				// if ((col == 0 || col == room[row].length -1) && row == room.length / 2) {
				// 	for (int count = row - 3; count < row + 4; count++) {
				// 		room[count][col] = "d";
				// 	}
				// }
				// if ((row == 0 || row == room.length - 1) && col == room[row].length / 2) {
				// 	for (int count = col - 3; count < col + 4; count++) {
				// 		room[row][count] = "d";
				// 	}
				// }
			}
		}
		return room;
	}

	private static void printView(String[][] view){
		String out = "";
		for (int y = 0; y < view.length; y++){
			for (int x = 0; x < view[0].length;x++){
				if (view[y][x] == null) out += " ";
				else out+=view[y][x];
			}
			out += "\n";
		}
		System.out.println(out);
	}
	public static void main(String[] args){
		Room rooms = new Room();
		printView(rooms.getSmallBattleRoom());
	}
}
