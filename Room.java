public class Room{
	private String[][] SpawnRoom = new String[15][15];
	private String[][] ShopRoom = new String[35][35];
	private String[][] BattleRoom = new String[45][45];
	private String[][] TreasureRoom = new String[15][15];
	private String[][] BossRoom = new String[75][75];

	Room(){
		fillRoom(SpawnRoom);fillRoom(ShopRoom);fillRoom(BattleRoom);
		fillRoom(TreasureRoom);fillRoom(BossRoom);
	}
	public String[][] getSpawnRoom() {
		return SpawnRoom;
	}
	public String[][] getShopRoom() {
		return ShopRoom;
	}
	public String[][] getBattleRoom() {
		return BattleRoom;
	}
	public String[][] getTreasureRoom() {
		return TreasureRoom;
	}
	public String[][] getBossRoom() {
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
	private static void printView(String[][] view){
		String out = "";
		for (int y = 0; y < view.length; y++){
			for (int x = 0; x < view[0].length;x++){
				out+=view[y][x]+" ";
			}
			out += "\n";
		}
		System.out.println(out);
	}
	public static void main(String[] args){
		Room rooms = new Room();
		printView(rooms.getShopRoom());
	}
}
