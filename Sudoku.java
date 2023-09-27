import java.util.Scanner;
import Solver.Solver;

public class Sudoku
{
    public static void main(String[] args)
    {
        System.out.println("Sudoku:  ");
        Scanner s = new Scanner(System.in);
        char[][] a=new char[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                a[i][j] = (char)(s.nextInt()+'0');
            }
        }
        System.out.println(" ");
        Solver sol = new Solver(a);
        sol.solveSudoku(sol.board);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char ch = (char)(sol.board[i][j]);
                System.out.print(ch+" ");
            }
            System.out.println("");
        }
        s.close();
    }
}