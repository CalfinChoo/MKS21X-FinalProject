import java.lang.Math;
import java.util.Random;

/*
* Contains all the different rooms used in the game.
* Rooms are saved as 2-Dimensional String Arrays containing the layouts of the rooms.
* Some rooms include randomized placement of objects while others are always the same.
*/

public class Room{
	private static String[][] SpawnRoom;
	private static String[][] ShopRoom;
	private static String[][] SmallBattleRoom;
	private static String[][] BigBattleRoom;
	private static String[][] TreasureRoom;
	private static String[][] BossRoom;
	private int randRow, randCol;
	private Random rand;
	private int randRC[][];

//  Constructs rooms
	public Room(){
		rand = new Random();
		SpawnRoom = new String[15][30];
		ShopRoom = new String[35][75];
		SmallBattleRoom = new String[75][150];
		BigBattleRoom = new String[95][190];
		TreasureRoom = new String[25][50];
		BossRoom = new String[115][230];
		fillRoom(SpawnRoom);fillRoom(ShopRoom);fillRoom(SmallBattleRoom);
		fillRoom(TreasureRoom);fillRoom(BossRoom);fillRoom(BigBattleRoom);
	}
//  Room getters
	public static String[][] getSpawnRoom() {
		return SpawnRoom;
	}
	public static String[][] getShopRoom() {
		return ShopRoom;
	}
	public static String[][] getSmallBattleRoom() {
		return SmallBattleRoom;
	}
	public static String[][] getBigBattleRoom() {
		return BigBattleRoom;
	}
	public static String[][] getTreasureRoom() {
		return TreasureRoom;
	}
	public static String[][] getBossRoom() {
		return BossRoom;
	}
// Helper function to place enemy spawnpoints in fillroom command
  private void placeEnemies(String[][] room, int count){
		while (count > 0) {
			randRow = rand.nextInt(room.length);
			while (randRow + (Graphics.LargeEnemy[1].length / 2) >= room.length - 2 || randRow - (Graphics.LargeEnemy[1].length / 2) <= 1) randRow = rand.nextInt(room.length);
			randCol = rand.nextInt(room[randRow].length);
			while (randCol + (Graphics.LargeEnemy[1][0].length / 2) >= room[randRow].length - 3 || randCol - (Graphics.LargeEnemy[1][0].length / 2) <= 2) randCol = rand.nextInt(room[randRow].length);
			if (room[randRow][randCol] != "l") {
				room[randRow][randCol] = "e";
				count--;
			}
		}
	}
	private void placeBoss(String[][] room){
		room[room.length / 2][room[0].length / 2] = "b";
	}
//  Helper functions for Lava placement for BattleRooms in fillroom command:
//  initiateLava creates number of pits of lava to be placed
	private void initiateLava(String[][] room, int count, int major, int minor) {
		randRC = new int[count][2];
		for (int i = 0; i < count; i++) {
			randRow = rand.nextInt(room.length);
			while (randRow + minor >= room.length - 6 || randRow - minor <= 5) randRow = rand.nextInt(room.length);
			randCol = rand.nextInt(room[randRow].length);
			while (randCol + major >= room[randRow].length - 7 || randCol - major <= 6) randCol = rand.nextInt(room[randRow].length);
			randRC[i][1] = randRow;
			randRC[i][0] = randCol;
		}
	}
//  lavaIsPlaceable checks to see if current position in room filling is part of a designated lava pit
	private boolean lavaIsPlaceable(String[][] room, int row, int col, int randRow, int randCol, int major, int minor) {
			if (Math.pow((row - randRow), 2) / (minor * minor) + Math.pow((col - randCol), 2) / (major * major) <= 1) {
				return true;
			}
		return false;
	}
//  Fills rooms with room-specific objects (e.g. Treasure in TreasureRoom), as well as shared objects (i.e. walls, doors, floor)
	private String[][] fillRoom(String[][] room) {
		if (room.equals(SmallBattleRoom)) initiateLava(SmallBattleRoom, 4, 9, 5);  // initiateLava(room, # of pits, major axis length, minor axis length)
		if (room.equals(BigBattleRoom)) initiateLava(BigBattleRoom, 5, 9, 5);
		if (room.equals(BossRoom)) initiateLava(BossRoom, 7, 9, 5);
		for (int row = 0; row < room.length; row++) {
			for (int col = 0; col < room[row].length; col++) {
				//  Room-specific objects
				if (room.equals(SmallBattleRoom) || room.equals(BigBattleRoom) || room.equals(BossRoom)) {
					for (int i = 0; i < randRC.length; i++) {
						if (lavaIsPlaceable(room, row, col, randRC[i][1], randRC[i][0], 9, 5)) {
							room[row][col] = "l";
						}
					}
				}
				else if (room.equals(TreasureRoom)) {
					room[12][12] = "t";
				}
				else if (room.equals(ShopRoom) && (((row == 14 || row == 20) && (col >= 14 && col <= 20)) || (col == 14 || col == 20) && (row >= 14 && row <= 20))) {
					room[row][col] = "m";
				}
				//  Objects shared by all rooms
				if ((row == 0 || row == room.length - 1 || col == 0 || col == 1 || col == room[row].length - 1 || col == room[row].length - 2)) {
					room[row][col] = "w";
				}
				if (room[row][col] == null) room[row][col] = "f";
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
		if (room.equals(SmallBattleRoom)) placeEnemies(room, 7); // placeEnemies(room, # of spawnpoints)
		if (room.equals(BigBattleRoom))	placeEnemies(room, 10);
		if (room.equals(BossRoom)) placeBoss(room, 1);
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
		printView(rooms.getBossRoom());
	}
}
