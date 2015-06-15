package object;

import java.util.*;

import com.badlogic.gdx.math.Rectangle;

public class MonsterSpawn {
	Random loc, mon;
	Map map;
	public MonsterSpawn(Map m){
		map = m;
	}
	public Rectangle findLoc(){
		loc = new Random();
		int x = loc.nextInt((int)map.length() * 1000);
		int y = loc.nextInt((int)map.depth() * 1000);
		if (x < map.length() && y < map.depth() && map.getTile(x, y) != '#'){
			return new Rectangle(x, y, 1, 1);
		}
		return null;
	}
	public String monsterType(){
		mon = new Random();
		int type = mon.nextInt(5);
		if (type == 0){
			return "Slime";
		}
		if (type == 1){
			return "Minion";
		}
		if (type == 2){
			return "Brute";
		}
		if (type == 3){
			return "Banshee";
		}
		return "Wolf";
	}
}
