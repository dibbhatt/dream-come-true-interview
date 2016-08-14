package algorithm.array;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer>{
	List<List<Integer>> vec2d = null;
    private int currRow = 0;
    private int currCol = 0;

    public Vector2D(List<List<Integer>> vec2d) {
    	this.vec2d = vec2d;
    }
    
    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        if (vec2d.get(currRow).size() <= currCol) {
            for (; currRow < vec2d.size(); currRow++) {
                if (vec2d.get(currRow).size() > 0) {
                    break;
                }
            }
            currCol = 0;
        } else {
            currCol += 1;
        }
        return vec2d.get(currRow).get(currCol);

    }
    
    @Override
    public boolean hasNext() {
        if (currCol == vec2d.get(currRow).size()) {
            int i = currRow;
            for (; i < vec2d.size(); i++) {
                if (vec2d.get(i).size() > 0) {
                    break;
                }
            }
            
            if (i == vec2d.size()) {
                return false;
            }
        } 
        return true;
    }

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
