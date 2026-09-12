import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board.length; c++){
                board[r][c] = ' ';
            }
        }
        char player = 'X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while(!gameOver){
            printBoard(board);
            System.out.println(" Player " + player + " enter: ");
            int r = scanner.nextInt();
            int c = scanner.nextInt();

            if(board[r][c]==' '){
                board[r][c] = player;
                gameOver = haveWon(board,player);
                if(gameOver){
                    System.out.println(" Player " + player + " has won ");
                }else{
                    if(player == 'X'){
                        player = '0';
                    }else{
                        player = 'X';
                    }
                }

            }else{
                System.out.println("Invalid move. Try again!");
            }
        } 
        printBoard(board);  
    }
    public static boolean haveWon(char[][] board, char player){
        //check the row
        for(int r = 0; r < board.length; r++){
            if(board[r][0]== player && board[r][1]== player && board[r][2]== player ){
                return true;
            }
        }

        //check for column
        for(int c = 0; c < board[0].length; c++){
            if(board[0][c]== player && board[1][c]== player && board[2][c]== player ){
                return true;
            }
        }
        
        //diagonal 
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player ){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player ){
            return true;
        }
        return false;

    }


    public static void printBoard(char[][] board){
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board.length; c++){
                System.out.print(board[r][c] + " | ");
            }
            System.out.println();
        }

    }
}