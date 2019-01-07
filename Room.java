import com.googlecode.lanterna.terminal.Terminal;
public class Room{
	private Terminal.Color[][] SpawnRoomCM = new Terminal.Color[15][15];
	private Terminal.Color[][] ShopRoomCM = new Terminal.Color[35][35];
	private Terminal.Color[][] SmallBattleRoomCM = new Terminal.Color[75][75];
	private Terminal.Color[][] BigBattleRoomCM = new Terminal.Color[95][95];
	private Terminal.Color[][] TreasureRoomCM = new Terminal.Color[15][15];
	private Terminal.Color[][] BossRoomCM = new Terminal.Color[115][115];
	private String[][] SpawnRoom = new String[15][15];
	private String[][] ShopRoom = new String[35][35];
	private String[][] SmallBattleRoom = new String[75][75];
	private String[][] BigBattleRoom = new String[95][95];
	private String[][] TreasureRoom = new String[15][15];
	private String[][] BossRoom = new String[115][115];

	Room(){
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
	/* private boolean isEmpty(String[][] room) {
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
	} */
	public String[][] fillRoom(String[][] room) {
		for (int row = 0; row < room.length; row++) {
			for (int col = 0; col < room[row].length; col++) {
				if ((col == 0 || col == room[row].length -1) && row == room.length / 2) {
					room[row][col] = "d";
					room[row - 1][col] = "d";
					room[row - 2][col] = "d";
					room[row + 1][col] = "d";
					room[row + 2][col] = "d";
				}
				if ((row == 0 || row == room.length - 1) && col == room[row].length / 2) {
					room[row][col] = "d";
					room[row][col - 1] = "d";
					room[row][col - 2] = "d";
					room[row][col + 1] = "d";
					room[row][col + 2] = "d";
				}
				if ((room.equals(SmallBattleRoom) || room.equals(BigBattleRoom) || room.equals(BossRoom)) && (row == col || row == room.length - 1 - col || col == room[row].length - 1 - row)) {
					room[row][col] = "l";
					if (row == 2 || row == room.length - 3) {
						room[row][col + 1] = "l";
						room[row][col - 1] = "l";
						room[row][col + 2] = "l";
						room[row][col - 2] = "l";
					}
					if (col == 2 || col == room[row].length - 3) {
						room[row - 1][col] = "l";
						room[row + 1][col] = "l";
						room[row - 2][col] = "l";
						room[row + 2][col] = "l";
					}
					if (row > 2 && row < room.length - 3) {
						room[row][col + 1] = "l";
						room[row][col - 1] = "l";
						room[row][col + 2] = "l";
						room[row][col - 2] = "l";
						room[row][col + 3] = "l";
						room[row][col - 3] = "l";
					}
					if (col > 2 && col < room[row].length - 3) {
						room[row - 1][col] = "l";
						room[row + 1][col] = "l";
						room[row - 2][col] = "l";
						room[row + 2][col] = "l";
						room[row - 3][col] = "l";
						room[row + 3][col] = "l";
					}
				}
				if (room.equals(ShopRoom) && (((row == 14 || row == 20) && (col >= 14 && col <= 20)) || (col == 14 || col == 20) && (row >= 14 && row <= 20))) {
					room[row][col] = "m";
				}
			}
		for (int r = 0; r < room.length; r++) {
			for (int c = 0; c < room[r].length; c++) {
				if ((r == 0 || r == room.length - 1 || c == 0 || c == room[r].length - 1) && room[r][c] != "d") {
					room[r][c] = "w";
				}
				if (room.equals(SmallBattleRoom) || room.equals(BigBattleRoom)) {
					if ((r == room.length / 4 || r == room.length - 1 - room.length / 4) && (c == room[r].length / 4 || c == room[r].length - 1 - room[r].length / 4)) {
						for (int t = c - 6; t < c + 7; t++) {
							room[r][t] = null;
							room[r + 1][t] = null;
							room[r + 2][t] = null;
							room[r + 3][t] = null;
							room[r - 1][t] = null;
							room[r - 2][t] = null;
							room[r - 3][t] = null;
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
				if (view[y][x] == null) out += ". ";
				else out+=view[y][x]+" ";
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
