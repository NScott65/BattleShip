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
        boolean val = false;

        if(row <= 10 && col <= 10 && row >= 1 && col >= 1 && len >= 2 && len <= 5 ){

        }else{
            
        }

        return val;
    }
}
