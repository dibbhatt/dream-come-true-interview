package algorithm.graph;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-24 
 * Time : 下午2:39:00
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (dfs(i, j, 0, word, new boolean[board.length][board[0].length], board)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    
    public boolean dfs(int x, int y, int start, String word, boolean[][] visited, char[][] board){
        
        if (board[x][y] != word.charAt(start)){
            return false;
        }
        
        visited[x][y] = true;
        
        if (start == word.length() - 1){
            return true;
        }
        
        if ( x + 1 < board.length && visited[x+1][y] == false){
            if (dfs(x + 1, y, start + 1, word, visited, board)){
                 visited[x][y] = false;
                return true;
            }
        }
        
        if ( x - 1 >= 0 && visited[x-1][y] == false){
            if (dfs(x - 1, y, start + 1, word, visited, board)){
                 visited[x][y] = false;
                return true;
            }
        }
        
        if ( y + 1 < board[0].length && visited[x][y+1] == false){
            if (dfs(x, y + 1, start + 1, word, visited, board)){
                 visited[x][y] = false;
                return true;
            }
        }
        
        if ( y - 1 >= 0 && visited[x][y-1] == false){
            if (dfs(x, y - 1, start + 1, word, visited, board)){
                 visited[x][y] = false;
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
    
    @Test
    public void test(){
    	String word = "ABCCED";
    	char[][] board = new char[3][4];
    	
    	board[0][0] = 'A'; board[0][1] = 'B';board[0][2] = 'C'; board[0][3] = 'E';
    	board[1][0] = 'S'; board[1][1] = 'F';board[1][2] = 'C'; board[1][3] = 'S';
    	board[2][0] = 'A'; board[2][1] = 'D';board[2][2] = 'E'; board[2][3] = 'E';
    	
    	boolean r = exist(board,word);
    	System.out.println(r);
    }
}
