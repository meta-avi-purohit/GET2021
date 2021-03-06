import java.util.*;

public class Recursion {

	public static boolean isPossible(int board[][], int row, int col, int N) {
		int i, j;
		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;
		for (i = row, j = col; i > 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;
		for (i = row, j = col; j >= 0 && i < N; i++, j--)
			if (board[i][j] == 1)
				return false;
		return true;
	}

	public boolean nQueen(int board[][], int start, int dimensionOfMatrix) {
		if (start >= dimensionOfMatrix)
			return true;

		for (int i = 0; i < dimensionOfMatrix; i++) {
			if (isPossible(board, i, start, dimensionOfMatrix)) {
				board[i][start] = 1;

				if (nQueen(board, start + 1, dimensionOfMatrix) == true) {
					return true;
				}
				board[i][start] = 0;
			}
		}
		return false;
	}

	public void printBoard(int board[][], int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Dimension of Chess Board : ");
		int n = scan.nextInt();
		int board[][] = new int[n][n];
		Recursion Q = new Recursion();
		Q.nQueen(board, 0, n);
		Q.printBoard(board, n);
		scan.close();
	}
}
