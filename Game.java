
import java.util.Scanner;

public class Game {
    private static players player1;
    private static players player2;
    private static Board board;

    public static void main(String[] args) {
        Game g = new Game();
        
        g.startGame(g);
    }
    public static void startGame(Game g){

        Scanner s = new Scanner(System.in);
        String name1, name2;
        char symbol1, symbol2;

        System.out.println("Enter Player-1 Name :");
        name1 = s.next();
        System.out.println("Enter Player-1 Symbol :");
        symbol1 = s.next().charAt(0);
        System.out.println("Enter Player-2 Name :");
        name2 = s.next();
        while(name1.equals(name2)){
            System.out.println("Already Player-1 choose same Name, so choose different Name:");
         name2 = s.next();

        }
        System.out.println("Enter Player-2 Symbol :");
        symbol2 = s.next().charAt(0);
        while(symbol1 == symbol2){
            System.out.println("Already Player-1 choose same Symbol, so choose different Symbol:");
        symbol2 = s.next().charAt(0);

        }

        player1 = new players(name1, symbol1);
        player2 = new players(name2, symbol2);
        board = new Board(symbol1, symbol2);
        Game.play(1);

    }
    public static void play(int turn){
        if(board.getCount() == 9){
            System.out.println("\nThe Game is Draw");
            return ;
        }

        Scanner s = new Scanner(System.in);
        

        if(turn == 1){
            System.out.println("Player 1 - "+player1.getName()+" Turn");
            System.out.println("Enter X:");
            int row = s.nextInt();
            System.out.println("Enter Y:");
            int col = s.nextInt();
            if(board.insert(player1.getSymbol(), row, col)){
                Game.play(1);
            }
            if(board.check(row, col, player1.getSymbol())){
                System.out.println("\nPlayer 1 - "+player1.getName()+"WON!"); 
                return ;
            }
            Game.play(2);

        }
        else{
            System.out.println("Player2 - "+player2.getName()+" Turn");
            System.out.println("Enter X:");
            int row = s.nextInt();
            System.out.println("Enter Y:");
            int col = s.nextInt();
            if(board.insert(player2.getSymbol(), row, col)){
                Game.play(2);
            }
            if(board.check(row, col, player2.getSymbol())){
                System.out.println("\nPlayer2 - "+player2.getName()+" WON! The Game"); 
                return ;
            }
            Game.play(1);

        }
    }
    
}
