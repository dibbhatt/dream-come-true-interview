package algorithm.array;

import java.util.List;

public class RotatedMatrix {
	private List<List<Integer>> wrappedSquareMatrix;
	
	public RotatedMatrix(List<List<Integer>> wrappedSquareMatrix) {
		this.wrappedSquareMatrix = wrappedSquareMatrix;
	}
	
	public int readEntry(int x, int y) {
		return wrappedSquareMatrix.get(wrappedSquareMatrix.size() - 1 -y).get(x);
	}
	
	public void writeEntry(int x, int y, int value) {
		wrappedSquareMatrix.get(wrappedSquareMatrix.size() - 1 - y).set(x, value);
	}
	
}
