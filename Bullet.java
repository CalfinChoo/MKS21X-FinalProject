import com.googlecode.lanterna.*;
public class Bullet{
  private Coordinate coord;
  private int damage;
  private boolean good;
  private Coordinate target;
  private String graphic;
  public long lastMove;
  private int direction;
  private char type;
  public Coordinate getCoord(){
    return coord;
  }
  public Bullet(Coordinate startCoord, int d, int direction, boolean g, char t){
    coord = new Coordinate(startCoord); good = g;
    damage = d;
    this.direction = direction;
    type = t;
    //System.out.println(startCoord);
  }
  public TextColor getColor(){
    switch (type){
      case 'd':
      return new TextColor.RGB(255,165,0);
      case 'i':
      return new TextColor.RGB(200,0,0);
      case 's':
      return new TextColor.RGB(255,255,255);
      case 'c':
      return new TextColor.RGB(255, 221, 153);
    }
    return new TextColor.RGB(255, 221, 153);
  }
  public boolean speedAway(MapGen map, long time){
    if (map.getSymMap()[coord.getY()][coord.getX()] == "w" || coord.getX() >= map.getWidth() || coord.getY() >= map.getHeight() ){
      return false;
    }
    if (time - lastMove > 10) {move(direction); lastMove = time;}
    return true;
  }
  /*
  private int getNext(){
    int x = coord.getX(); int y = coord.getY();
    Coordinate[] surrounding = {new Coordinate(x,y-1),new Coordinate(x+1,y),new Coordinate(x,y+1),new Coordinate(x-1,y), 
      new Coordinate(x+1,y-1),new Coordinate(x+1,y+1),new Coordinate(x-1,y+1),new Coordinate(x-1,y-1)
    };
    int direction = -1; 
    double smallestDist = Math.sqrt(Math.pow(target.getX() - x,2) + Math.pow(target.getY() - y,2));
    for (int c = 0; c < 8; c++){
      double dist = Math.sqrt(Math.pow(target.getX() - surrounding[c].getX(),2) + Math.pow(target.getY() - surrounding[c].getY(),2));
      if (dist < smallestDist){
        direction = c;
        smallestDist = dist;
      }
    }
    //System.out.println(direction);
    return direction;
  }
  */
  //********************************************************************************
  //*let it be noted that I tried to make shooting along sloped lines but it failed*
  //********************************************************************************
  private void move(int direction){
    //7,0,4
    //3,~,1
    //6,2,5
    switch (direction){
      case 0:
      coord.minusY();
      break;
      case 1:
      coord.plusX();
      break;
      case 2:
      coord.plusY();
      break;
      case 3:
      coord.minusX();
      break;
      case 4:
      coord.minusY();
      coord.plusX();
      break;
      case 5:
      coord.plusX();
      coord.plusY();
      break;
      case 6:
      coord.minusX();
      coord.plusY();
      break;
      case 7:
      coord.minusY();
      coord.minusX();
      break;
    }
    return;
  }
}
