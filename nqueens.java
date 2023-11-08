public class nqueens {

    public static boolean isSafe(char board[][], int row, int col){
        //vertical up
        for(int i=row-1; i>=0; i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }

        //upper left diagonal
        for(int i=row-1, j=col-1;  i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        //upper right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        

        return true;
  }

    public static void printBoard(char board[][]){
        System.out.println("------------------------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void nQueen(char board[][], int row){

        if(row==board.length){
            printBoard(board);
            //count++;
            return;
        }

        for(int j=0; j<board.length; j++){
            if((isSafe(board, row, j) )){
                board[row][j]='Q';
                nQueen(board, row+1);
                board[row][j]='.';
            }
            
        }
    }
    
    
    static int count=0;
    

    public static void main(String args[]) {
        int n = 8;
        int firstQueenRow = 0;
        int firstQueenCol = 1; // For example, placing the first queen in the first row and second column

        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Place the first queen
        board[firstQueenRow][firstQueenCol] = 'Q';

        // Solve for the remaining queens using backtracking
        nQueen(board, 1); // Start with the second row (row index 1)

        
    }

    
}

