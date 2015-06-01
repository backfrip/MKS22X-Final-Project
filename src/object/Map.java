package object;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.badlogic.gdx.math.Vector2;

public class Map {
    private char[][] map;
    private Vector2 spawn = new Vector2(1, 1);
    private Vector2 size = new Vector2(0, 0);

    public Map(String filename) {
	try {
	    BufferedReader in = new BufferedReader(new FileReader(
		    "resource/map/" + filename + ".omap"));
	    in.mark(10000);
	    String line = in.readLine();
	    size.x = line.length();
	    for (; line != null && !line.equals(""); size.y++)
		line = in.readLine();
	    map = new char[(int) size.y][(int) size.x];
	    in.reset();
	    for (int i = 0; i < size.y; i++) {
		line = in.readLine();
		for (int j = 0; j < size.x; j++) {
		    if (line.charAt(j) == 's')
			spawn = new Vector2(j, i);
		    map[i][j] = line.charAt(j);
		}
	    }
	    in.close();// @formatter:off
	}catch(FileNotFoundException e){System.err.println("File \""+filename+"\" not found!\nStopping...");System.exit(1);
	}catch(IOException e){System.err.println("Error reading file \""+filename+"\"\nStopping...");System.err.println(e.getMessage());
	}catch(NullPointerException e){System.err.println("File \""+filename+"\" is empty!\nStopping...");System.exit(1);
	}catch(StringIndexOutOfBoundsException e){System.err.println("Syntax error in first line of file \""+filename+"\"\nStopping...");System.exit(1);}
    }// @formatter:on

    public String toString() {
	String out = "";
	for (char[] row : map) {
	    for (char space : row)
		out += space;
	    out += "\n";
	}
	return out;
    }

    public float length() {
	return size.x;
    }

    public float depth() {
	return size.y;
    }

    public Vector2 getSpawn() {
	return new Vector2(spawn.x, size.y - spawn.x - 1);
    }

    public char getTile(float x, float y) {
	return map[(int) (size.y - y - 1)][(int) x];
    }
}
