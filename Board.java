// import java.util.Arrays;
import java.util.Scanner;

public class Board {
    private Tile[][] gameBoard;
    private int n;
    private int[] p; // position

    public Board(int n) { // checks for an int >=3 PRIOR
        /** 
        hahagameBoard = new String[][] {
            { "   ", "|", "   ", "|", "   " },
            { "---", "+", "---", "+", "---" },
            { "   ", "|", "   ", "|", "   " },
            { "---", "+", "---", "+", "---" },
            { "   ", "|", "   ", "|", "   " }
        }; */
        gameBoard = new Tile[n][n];
        this.n = n;
        // open = n*n;
        // available = new boolean[open]; //default: false
        // Arrays.fill(available, Boolean.TRUE);
        // Arrays.fill(gameBoard, new Tile());
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                Tile t = new Tile();
                gameBoard[r][c] = t;
            }
        }
        for (int r = n-2; r < n; r++) {
            for (int c = 0; c < 2; c++) {
                gameBoard[r][c].setCommon();
            }
        }
        p = new int[] {n-1, 0};
        gameBoard[p[0]][p[1]].setLocTile();
    }

    public boolean valid(String dir) { // check valid move & move
        // String[] directions = new String[] {"w", "A", "S", "D"};
        int r = p[0];
        int c = p[1];
        switch (dir) {
            case "W":
                r--;
                break;
            case "A":
                c--;
                break;
            case "S":
                r++;
                break;
            case "D":
                c++;
            case "w":
                r--;
                break;
            case "a":
                c--;
                break;
            case "s":
                r++;
                break;
            case "d":
                c++;
        }
        if (r < 0 || c < 0 || r >= n || c >= n) {
            System.out.println("You cannot move in that direction! It's off the map!");
            return false;
        }
        if (gameBoard[r][c].getType().equals("Nonaccessible")) {
            System.out.println("You cannot move in that direction! It's blocked and nonaccessible!");
            return false;
        }
        else {
            // gameBoard[p[0]][p[1]].leaveTile();
            // p[0] = r;
            // p[1] = c;
            // gameBoard[r][c].setLocTile();
            return true;
        }
    }
    public Tile move(String dir) { // check valid move & move
        int r = p[0];
        int c = p[1];
        switch (dir) {
            case "W":
                r--;
                break;
            case "A":
                c--;
                break;
            case "S":
                r++;
                break;
            case "D":
                c++;
            case "w":
                r--;
                break;
            case "a":
                c--;
                break;
            case "s":
                r++;
                break;
            case "d":
                c++;
        }
        gameBoard[p[0]][p[1]].leaveTile();
        p[0] = r;
        p[1] = c;
        gameBoard[r][c].setLocTile();
        return gameBoard[r][c];
    }

    public int getn() {
        return n;
    }
    public int[] getPosition() {
        return p;
    }
    public String getTileType() {
        return gameBoard[p[0]][p[1]].getType();
    }
    public Tile[][] getMap() {
        return this.gameBoard;
    }

    public String toString() {
        String bd = "";
        String midrows = "+";
        for (int i = 0; i < n; i++) {
            midrows = midrows + "---+";
        }
        midrows = midrows + "\n";
        bd = bd + midrows;
        for (int r = 0; r < n; r++) {
            bd = bd + "|";
            for (int c = 0; c < n; c++) {
                bd = bd + this.gameBoard[r][c].toString() + "|";
                if (c == n-1) {bd = bd + "\n";}
            }
            bd = bd + midrows;
        }
        return bd;
    }

    /** public void resetBoard() {
        this.gameBoard = new Board();
    } */

    public static void main(String[] args) {
        Board hello = new Board(3);

        System.out.println(hello);

        Tile[][] map = hello.getMap();

        // for (int r = 0; r < hello.getn(); r++) {
        //     for (int c = 0; c < hello.getn(); c++) {
        //         System.out.println(map[r][c].getType());
        //     }
        // }

        Scanner m = new Scanner(System.in);
        boolean exit = false;
        do {
            System.out.println("Where would you like to move your team of Heroes? W: North, A: West, D: East, S: South, and I -> Show Team Stats");
            String dir = m.nextLine();
            if (dir.equals("I") || dir.equals("i")) {
                // PRINT TEAM INFO
            }
            if (dir.equals("W") || dir.equals("A") || dir.equals("D") || dir.equals("S") || dir.equals("w") || dir.equals("a") || dir.equals("d") || dir.equals("s")) {
                boolean valid = hello.valid(dir);
                if (valid) {
                    hello.move(dir);
                    System.out.println(hello);
                }
                // hello.move(dir);
            }
            else if (dir.equals("e")) exit = true;
            else {
                System.out.println("Invalid Input!");
            }
        }
        while (!exit);
        // m.close();
    }
}