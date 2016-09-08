package algorithm.bitwise;

public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        int r = 0;
        int carry = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            int aa = a & (1 << i);
            int bb = b & (1 << i);
            int c = aa ^ bb ^ (carry << i);
            carry = ((aa != 0) && (bb != 0)) || (((aa != 0) || (bb != 0)) && (carry == 1)) ? 1 : 0;
            r = r | c;
        }
        return r;
    }
}
