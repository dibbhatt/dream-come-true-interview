package algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-10-8 
 * Time : 下午7:24:25
 */
public class SurroundedRegions2 {
    private static Queue<Integer> queue = null;
    private static char[][] board;
    private static int rows = 0;
    private static int cols = 0;

    public void solve(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (board.length == 0 || board[0].length == 0) return;
        queue = new LinkedList<Integer>();
        this.board = board;
        rows = board.length;
        cols = board[0].length;

        for (int i = 0; i < rows; i++) { // **important**
            enqueue(i, 0);
            enqueue(i, cols - 1);
        }

        for (int j = 1; j < cols - 1; j++) { // **important**
            enqueue(0, j);
            enqueue(rows - 1, j);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / cols,
                y = cur % cols;

            if (board[x][y] == 'O') {
                board[x][y] = 'D';
            }

            enqueue(x - 1, y);
            enqueue(x + 1, y);
            enqueue(x, y - 1);
            enqueue(x, y + 1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'D') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        queue = null;
        board = null;
        rows = 0;
        cols = 0;
    }

    public static void enqueue(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols && board[x][y] == 'O'){  
            queue.offer(x * cols + y);
        }
    }
    
    @Test
    public void test(){
    	char[][] board = new char[4][4];
    	board[0][0] = 'X';
    	board[0][1] = 'X';
    	board[0][2] = 'X';
    	board[0][3] = 'X';
    	
    	board[1][0] = 'X';
    	board[1][1] = 'O';
    	board[1][2] = 'O';
    	board[1][3] = 'X';
    	
    	board[2][0] = 'X';
    	board[2][1] = 'X';
    	board[2][2] = 'O';
    	board[2][3] = 'X';
    	
    	board[3][0] = 'X';
    	board[3][1] = 'O';
    	board[3][2] = 'X';
    	board[3][3] = 'X';
    	
    
    	
    	solve(board);
    }
}
