package algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-18 
 * Time : 下午11:27:17
 */

class Pos {
    public int x = 0;
    public int y = 0;
    public Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class SurroundedRegions {
    public void dfs(char[][] board, Pos start) {
        if (start.x >= board.length || start.y >= board[0].length || start.x < 0 || start.y < 0){
            return;
        }
        if (board[start.x][start.y] == 'X' || board[start.x][start.y] == 'D'){
            return;
        }
        
        board[start.x][start.y] = 'D';
        
        dfs(board, new Pos(start.x + 1, start.y));
        dfs(board, new Pos(start.x, start.y + 1));
        dfs(board, new Pos(start.x - 1, start.y));
        dfs(board, new Pos(start.x, start.y - 1));
    }
    
    
    public boolean isValid(char[][] board, Pos start){
        if (start.x >= board.length || start.y >= board[0].length || start.x < 0 || start.y < 0){
            return false;
        }
        if (board[start.x][start.y] == 'X' || board[start.x][start.y] == 'D'){
            return false;
        }
        return true;
    }
    
    public void bfs(char[][] board, int x, int y){
    	if (board[x][y] != 'O'){
    		return; 
    	}
        
        Queue<Pos> queue = new LinkedList<Pos>();
        
        queue.add(new Pos(x, y));
        
        while (queue.size() != 0){
        	Pos p = queue.poll();
        	board[p.x][p.y] = 'D';
        	if (p.x > 0 && board[p.x - 1][p.y] == 'O'){
        		queue.add(new Pos(p.x - 1, p.y));
        	}
        	if (p.x < board.length - 1 && board[p.x + 1][p.y] == 'O'){
        		queue.add(new Pos(p.x + 1, p.y));
        	}
        	if (p.y > 0 && board[p.x][p.y - 1] == 'O'){
        		queue.add(new Pos(p.x, p.y - 1));
        	}
        	if (p.y < board[0].length - 1 && board[p.x][p.y + 1] == 'O'){
        		queue.add(new Pos(p.x, p.y + 1));
        	}
        	
        }
        
    }
    
    
    public void solve(char[][] board) {
    	if(board == null){
    		return;
    	}
    	if (board.length == 0){
    		return;
    	}
        
        for (int i = 0; i < board.length; i++){
            bfs(board, i, 0);
            bfs(board, i,board[0].length - 1);
        }
        
        for (int i = 1; i < board[0].length - 1; i++){
            bfs(board, 0, i);
            bfs(board, board.length - 1, i);
        }
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'D'){
                    board[i][j] = 'O'; 
                }
            }
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
