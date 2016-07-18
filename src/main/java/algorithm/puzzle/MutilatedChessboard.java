package algorithm.puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * Description :
 * Source : EPI chapter 4.2 p 37 
 * Created_By : xmpy
 * Time : Jul 13, 2016 10:20:19 AM  
 */
public class MutilatedChessboard {
	
	public List<List<Integer>> getPlacements(int n) {
	
		return getPlacements(n, n, 0, 0);
	}
	
	public List<List<Integer>> getPlacements(int originN, int n, int startSquare, int missSquare) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> placement = new ArrayList<Integer>();
 		if (n == 2) {
			int[] squares = new int[]{startSquare, startSquare + 1, startSquare + originN, startSquare + originN + 1};
			for (int square : squares) {
				if (square != missSquare) {
					placement.add(square);
				}
			}
			result.add(placement);
			return result;
		}
 		int square1 = startSquare + n / 2 - 1 + originN * ( n / 2 - 1);
		int square2 = startSquare + n / 2 + originN * ( n / 2 - 1);
		int square3 = startSquare + n / 2 - 1 + originN * ( n / 2 );
 		int square4 = startSquare + n / 2 + originN * ( n / 2 );
		
		if (missSquare == startSquare) {
			result.addAll(getPlacements(originN, n / 2, startSquare, missSquare));
		} else {
			result.addAll(getPlacements(originN, n / 2, startSquare, square1));
			placement.add(square1);
		}
		
		if (missSquare == startSquare + n - 1) {
			result.addAll(getPlacements(originN, n / 2, startSquare + n / 2, missSquare));
		} else {
			result.addAll(getPlacements(originN, n / 2, startSquare + n / 2, square2));
			placement.add(square2);
		}
		
		if (missSquare == startSquare +  originN * ( n - 1)) {
			result.addAll(getPlacements(originN, n / 2, startSquare + (n / 2) * originN, missSquare));
		} else {
			result.addAll(getPlacements(originN, n / 2, startSquare + (n / 2) * originN, square3));
			placement.add(square3);
		}
		
		if (missSquare == startSquare +  originN * ( n - 1) + n - 1) {
			result.addAll(getPlacements(originN, n / 2, startSquare + (n / 2) * originN + n / 2, missSquare));
		} else {
			result.addAll(getPlacements(originN, n / 2, startSquare + (n / 2) * originN + n / 2, square4));
			placement.add(square4);
		}
		result.add(placement);
 		return result;
	}
	
	public void printResult(int n, List<List<Integer>> result) {
		int[][] board = new int[n][n];
		for ( int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				int r = result.get(i).get(j);
				board[r / n][r % n] = i + 1;
			}
		}
		// Print this board.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String[] args) {
		MutilatedChessboard mc = new MutilatedChessboard();
		List<List<Integer>> r = mc.getPlacements(8);
		mc.printResult(8, r);
	}
}
