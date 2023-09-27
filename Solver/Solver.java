package Solver;

public class Solver {
    public char [][] board = new char[9][9];
    public Solver (char[][] b) {
        board = b;
    }
    public boolean isSafe(char[][]board,int row,int col,int num) 
    { 
        for(int i=0;i<board.length;i++){
            if(board[i][col]==(char)(num+'0')){return false;}
            if(board[row][i]==(char)(num+'0')){return false;}
        }
        int startingRow=(row/3)*3;
        int startingCol=(col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i+startingRow][j+startingCol]==(char)(num+'0')){
                    return false;
                }
            }
        }

        return true;
    }
    public boolean helper(char [][] board,int row,int col)
    {
        if(row==board.length){
            return true;
        }
        int nrow=0;
        int ncol=0;
        if(col!=board.length-1){
            nrow = row;
            ncol = col+1;
        }else{
            nrow=row+1;
            ncol=0;
        }
        if(board[row][col]!='0'){
            if(helper(board,nrow,ncol)){
                return true;
            }
        }else{
            for(int i=1;i<=9;i++){
                if(isSafe(board,row,col,i)){
                    board[row][col] = (char)(i+'0');
                    if(helper(board,nrow,ncol)){
                        return true;
                    }else{
                        board[row][col]='0';
                    }
                }
            }
        }
        return false;
    }
    public void solveSudoku(char [][] board)
    {
        helper(board,0,0);
    }
}
