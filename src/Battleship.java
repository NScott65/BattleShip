public class Battleship {
    static Board gameBoard = new Board();
    public static void main(String[] args) {

        gameBoard.addShip(3,4,2,true);
        System.out.println(gameBoard.toString());
    }
}
