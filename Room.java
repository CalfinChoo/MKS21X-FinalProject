public class Room{
	private String[][] SpawnRoom = new String[15][15];
	private String[][] ShopRoom = new String[35][35];
	private String[][] BattleRoom = new String[45][45];
	private String[][] TreasureRoom = new String[15][15];
	private String[][] BossRoom = new String[75][75];
	public String[][] getSpawnRoom() {
		if (isEmpty(SpawnRoom)) fillRoom(SpawnRoom);
		return SpawnRoom;
	}
	public String[][] getShopRoom() {
		if (isEmpty(ShopRoom)) fillRoom(ShopRoom);
		return ShopRoom;
	}
	public String[][] getBattleRoom() {
		if (isEmpty(BattleRoom)) fillRoom(BattleRoom);
		return BattleRoom;
	}
	public String[][] getTreasureRoom() {
		if (isEmpty(TreasureRoom)) fillRoom(TreasureRoom);
		return TreasureRoom;
	}
	public String[][] getBossRoom() {
		if (isEmpty(BossRoom)) fillRoom(BossRoom);
		return BossRoom;
	}
	private boolean isEmpty(String[][] room) {
		boolean empty = true;
		for (int row = 0; row < room.length; row++) {
			for (int col = 0; col < room[row].length; col++) {
				if (room[row][col] != null) {
					empty = false;
					break;
				}
			}
		}
		return empty;
	}
	public String[][] fillRoom(String[][] room) {
		for (int row = 0; row < room.length; row++) {
			for (int col = 0; col < room[row].length; col++) {
				if (row == 0 || row == room.length - 1 || col == 0 || col == room[row].length - 1) {
					room[row][col] = "w";
				}
				if (row == room.length / 2) {
					room[row][col] = "d";
					room[row - 1][col] = "d";
					room[row - 2][col] = "d";
					room[row + 1][col] = "d";
					room[row + 2][col] = "d";
				}
				if (col == room[row].length / 2) {
					room[row][col] = "d";
					room[row][col - 1] = "d";
					room[row][col - 2] = "d";
					room[row][col + 1] = "d";
					room[row][col + 2] = "d";
				}
				if (room.equals(ShopRoom) && (row == 14 || row == 20 || col == 14 || col == 20)) {
					room[row][col] = "m";
				}
			}
		}
		return room;
	}
}
