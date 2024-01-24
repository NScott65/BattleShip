public class Board {
    private static String[][] squares;

    public static void main(String[] args) {




    }

    public Board() {
        squares = new String[10][10];
    }

    public String toString(){
        String value = " ";
        for(int r = 0; r < squares.length; r++){
            //Inner for loop accesses each column in the current row
            for(int c = 0; c < squares[0].length; c++){
                squares[r][c] = "-";
                System.out.print(squares[r][c] + " ");
            }
            System.out.println();
        }
         return value;
    }
}
