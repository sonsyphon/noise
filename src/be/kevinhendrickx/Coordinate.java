package be.kevinhendrickx;

import java.lang.Object;

/**
 * Created by kevin Hendrickx on 1/27/15.
 */
public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof Coordinate))
            return false;

        Coordinate coordinate2 = (Coordinate) obj;
        if(coordinate2.x == x && coordinate2.y == y)
            return true;
        else
            return false;
    }

    public int hashCode()
    {
        int hash = 7;
        hash = 71 * hash + this.x;
        return 71 * hash + this.y;
    }
}
