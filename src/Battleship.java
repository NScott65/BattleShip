import java.util.Scanner;
public class Battleship {

    static Board gameBoard = new Board();

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String choice = " ";
        boolean done = false;
        int addRow = 0;
        int addCol = 0;
        int addLen = 0;
        String hV = " ";
        boolean hVC = false;
        do{
            choice = Helper.getNonZeroLengString(scan, "Would you like to \"a\" add a ship, \"b\" see the board, \"p\" to play, or \"q\" to quit.");
            if(choice.equalsIgnoreCase("a")){
                addRow = Helper.getRangedInt(scan, "Enter a Row(0-9): ",0,9);
                addCol = Helper.getRangedInt(scan, "Enter a Column(0-9): ",0,9);
                addLen = Helper.getRangedInt(scan, "Enter a ship Length(2-5): ",2,5);
                hV = Helper.getYNConfirm(scan, "Would you like to place this horizontal(\"Y\") or vertical(\"N\")?");
                if(hV.equals("true")){
                    hVC = true;
                }else if(hV.equals("false")){
                    hVC = false;
                }
                if(addRow + addLen <= 9 && addCol + addLen <= 9){
                    gameBoard.addShip(addRow,addCol,addLen,hVC);
                    System.out.println("New Ship Added!");
                }else{
                    System.out.println("Ship placement was invalid.");
                }
            }else if(choice.equalsIgnoreCase("b")){
                System.out.println(gameBoard.toString());
            }else if(choice.equalsIgnoreCase("p")){
                boolean len3 = gameBoard.foundShip(3);
                boolean len4 = gameBoard.foundShip(4);

                if(len3 && len4){
                    System.out.println("Ok, Let's Play!");
                    done = true;
                }else{
                    System.out.println("You need ships of length 3 and 4 before you play.");
                }
            }else if(choice.equalsIgnoreCase("q")){
                System.exit(0);
            }
        }while(!done);

        boolean done2 = false;
        int hitRow = 0;
        int hitCol = 0;
        int hit = 0;

        do {
            choice = Helper.getNonZeroLengString(scan, "Press \"s\" to shoot at a square, \"b\" to see the board, and \"q\" to quit.");
            if(choice.equalsIgnoreCase("s")){
                hitRow = Helper.getRangedInt(scan, "Enter a Row(0-9): ",0,9);
                hitCol = Helper.getRangedInt(scan, "Enter a Column(0-9): ",0,9);
                hit = gameBoard.shoot(hitRow,hitCol);
                if(hit == 0){
                    System.out.println("Your shot missed.");
                }else if(hit == 1){
                    System.out.println("Your shot hit.");
                }else if(hit == 2){
                    System.out.println("Your have already hit this spot.");
                }else if(hit == -1){
                    System.out.println("Your shot was invalid.");
                }
            }else if(choice.equalsIgnoreCase("b")){
                System.out.println(gameBoard.toString());
            }else if(choice.equalsIgnoreCase("q")){
                done2 = true;
            }
        }while(!done2);
    }
}
