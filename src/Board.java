public class Board {
    private static String[][] squares;

    public Board() {
        squares = new String[10][10];

        for(int r = 0; r < squares.length; r++){
            //Inner for loop accesses each column in the current row
            for(int c = 0; c < squares[0].length; c++){
                squares[r][c] = "-";
            }
        }
    }

    public String toString(){
        String value = "";
        for(int r = 0; r < squares.length; r++){
            //Inner for loop accesses each column in the current row
            for(int c = 0; c < squares[0].length; c++){
                value += squares[r][c] + " ";
            }
            value += "\n";
        }
        return value;
    }

    public boolean addShip(int row, int col, int len, boolean horizontal ){
        boolean val = true;
        boolean clearPath = true;


        if(row <= 10 && col <= 10 && row >= 1 && col >= 1 && len >= 2 && len <= 5 ){

            if(horizontal){
                if(col + len <= 9) {
                    for (int c = col; c < col + len; c++) {
                        if (!squares[row][c].equalsIgnoreCase("-")) {
                            clearPath = false;
                        }
                    }
                    if (clearPath) {
                        for (int c = col; c < col + len; c++) {
                            squares[row][c] = "b";
                        }
                    } else {
                        System.out.println("That spot is taken or off the board.");
                        val = false;
                    }
                }

            }else if(!horizontal){
                if(row + len <= 9) {
                    for (int r = row; r < row + len; r++) {
                        if (!squares[r][col].equalsIgnoreCase("-")) {
                            clearPath = false;
                        }
                    }
                    if (clearPath) {
                        for (int r = row; r < row + len; r++) {
                            squares[r][col] = "b";
                        }
                    } else {
                        System.out.println("That spot is taken or off the board.");
                        val = false;
                    }
                }
            }

        }else{
            System.out.println("Your input was invalid. Can't run.");
            val = false;
        }

        return val;
    }

    public boolean foundShip(int len){
        int count = 0;
        //horizontal
        for(int r = 0; r < squares.length; r++){
            count = 0;
            for (int c = 0; c < squares[0].length; c++){
                if (squares[r][c].equals("b")){
                    count++;
                } else if(count == len){
                    return true;
                }else{
                    count = 0;
                }
            }
            if(count == len) {
                return true;
            }
        }

        count = 0;
        //vertical
        for(int c = 0; c < squares[0].length; c++){
            count = 0;
            for (int r = 0; r < squares.length; r++){
                if (squares[r][c].equals("b")){
                    count++;
                } else if(count == len){
                    return true;
                }else{
                    count = 0;
                }
            }
            if(count == len) {
                return true;
            }
        }

        return false;
    }

    public int shoot(int row, int col){
        int val = -1;

        if (squares[row][col].equals("b")) {
            squares[row][col] = "x";
            return 1;
        }else if(squares[row][col].equals("-")){
            squares[row][col] = "m";
            return 0;
        }else if(squares[row][col].equals("m") || squares[row][col].equals("x")){
            return 2;
        }

        return val;
    }

    public boolean gameOver(){
        boolean val = false;

        for(int r = 0; r < squares.length; r++){
            //Inner for loop accesses each column in the current row
            for(int c = 0; c < squares[0].length; c++){
                if(!squares[r][c].equals("b")){
                    return true;
                }
            }

        }

        return val;
    }
}
