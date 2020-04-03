import java.util.Arrays;
import java.util.*;

public class Tile {
    private String type; // { Nonaccessable [X], Market, Common Tile [Safe Zone OR Monster] }
    private boolean onloc;

    public Tile() {
        double prob = Math.random();
        if (prob < 0.2) { // 0.2
            type = "Nonaccessible";
        }
        else if (prob < 0.5) { // 0.5
            type = "Market";
        }
        else {
            type = "Common";
        }
        onloc = false;
    }

    public boolean onLocation() {
        return onloc;
    }

    public void setLocTile() {;
        onloc = true;
    }
    public void leaveTile() {
        onloc = false;
    }

    public String getType() {
        return type;
    }
    public void setCommon() {
        this.type = "Common";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        Tile other = (Tile) o;
        return (!(this.onloc) && !(other.onloc)) && (this.type.equals(other.type));
    }

    @Override
    public String toString() {
        if (onloc) return " X ";
        if (this.type.equals("Nonaccessible")) {
            // return " ψ ";
            return " D ";
        }
        else if (this.type.equals("Market")) {
            return " M ";
        }
        else return "   ";
    }


    public static void main(String[] args) {
        Tile hello = new Tile();
        // hello.setTile("yo");
        System.out.println(hello);
    }
}