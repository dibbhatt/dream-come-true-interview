package algorithm.bitwise;

public class ReverseBits {
	
	private static int WORD_SIZE = 16;
	// 2^16 = 65536
	private static int CACHE_SIZE = (int)(Math.pow(2, WORD_SIZE));
	private static int BIT_MASK = 0xFFFF;

    private static int[] preComputedReverse = new int[CACHE_SIZE];
	
    static {
    	for(int i = 0; i < CACHE_SIZE; i++) {
    		preComputedReverse[i] = reverse16Bits(i);    		
    	} 
    }
    
    // Answer 1
	public int reverseBitsBruteForce(int n) {
        int width = Integer.SIZE;
        int i = 0;
        int j = width - 1;
        while (i < j) {
            if (((n >>> i) & 1) != ((n >>> j) & 1)) {
                n ^= ( 1 << i ) | (1 << j);
            }
            i++;
            j--;
        }
        return n;
    }
	
    public static int reverse16Bits(int n) {
        int i = 0;
        int j = WORD_SIZE - 1;
        while (i < j) {
            if (((n >>> i) & 1) != ((n >>> j) & 1)) {
                n ^= ( 1 << i ) | (1 << j);
            }
            i++;
            j--;
        }
        return n;
    }

	
    public int reverseBits(int n) {
    	// Since int is 32 bits.
    	return (preComputedReverse[( n >>> WORD_SIZE) & BIT_MASK] | (preComputedReverse[n & BIT_MASK] << WORD_SIZE ));
    }
}
