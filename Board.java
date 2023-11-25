public class Board {

    private char[][] board;
    private char p1Symbol, p2Symbol;

    int size;
    int count;
    private char Empty =' ';
    public Board(char p1Symbol, char p2Symbol){
        this.p1Symbol = p1Symbol;
        this.p2Symbol = p2Symbol;
        this.board = new char[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = Empty;
            }
        }
    }
    public boolean insert(char symbol,int row, int col){
        if( row <0 || row > 2 || col <0 || col >2 ){
            System.out.println("You have entered wrong coordinates! Please enter valid Coordinates( 0, 1, 2)");
            return true;
        }
        if(board[row][col] != Empty){
            System.out.println("It is filled already");
            return true;
        }
        board[row][col] = symbol;
        print();
        count++;
        return false;
        
    }

    public void print(){
        for(int i=0; i< board.length ; i++){
            for(int j =0; j< board[0].length; j++){
                System.out.print("| "+board[i][j]+"|");
            }
            System.out.println();
        }
    }
    public boolean check(int row, int col, char symbol){
        if(count < 5){
            return false;
        }
        boolean f= true;
        for(int i=0; i<3; i++){
            if(board[i][col] != symbol){
                f = false;
                break;
            }
        }
        if(f)return f;
        f=true;
        for(int i=0; i<3; i++){
            if(board[i][col] != symbol){
                f = false;
                break;
            }
        }
        if(f)return f;
        if(row == col){
            for(int i=0; i<3; i++){
                if(board[i][i] != symbol){
                    return false;
                }
            }
            return true;
        }
        return false;

        
    }
    public int getCount(){
        return this.count;
    }
    
}
