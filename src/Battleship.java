import java.util.Scanner;
public class Battleship {

    static Board gameBoard = new Board();

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String choice = "";
        boolean done = false;
        int addRow = 0;
        int addCol = 0;
        int addLen = 0;

        do{
            choice = Helper.getNonZeroLengString(scan, "Would you like to \"a\" add a ship, \"b\" see the board, \"p\" to play, or \"q\" to quit.")
            if(choice.equalsIgnoreCase("a")){
                addRow = Helper.getRangedInt(scan, "Enter a Row(0-9): ",0,9);
                addCol = Helper.getRangedInt(scan, "Enter a Column(0-9): ",0,9);
                addLen = Helper.getRangedInt(scan, "Enter a ship Length(2-9): ",2,9);
            }
        }while(!done);
    }
}
