package algorithm.highfrequency;
/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Aug 9, 2015 
 * Time : 10:40:25 PM
 */
public class NumberOfDigitOne {
    public static int countDigitOne(int n) {
        long count = 0;
        long tens = 1;
        long tempN = n;
        while (( tempN / tens ) != 0) {
            
            int digit = (int) (n / tens % 10);
            
            if (digit > 1) {
                count += (n / (tens * 10) + 1)* tens;
            } else if (digit == 1) {
                count += (n / (tens * 10))* tens + n % tens + 1;
            } else {
                count += (n / (tens* 10)) * tens;
            }
            
            tens = tens * 10;  // 考虑这个溢出的情况
        }
        return (int)count;
    }
    
    public static void main(String[] args) {
    	System.out.print(countDigitOne(1410065408));
    }
}
/* Better Solution
int countDigitOne(int n) {
    long long int res(0);
    int highn(n), lowc(1), lown(0);
    while(highn > 0){
        int curn = highn % 10;
        highn = highn / 10;
        if (1 == curn) {
            //higher: 0~(highn-1);  lower:  0 ~ (lowc-1)
            res += highn * lowc;
            //higher: highn ~ highn;     lower:0~lown
            res += lown + 1;
        } else if (0 == curn) {  
            //curn < 1
            //higher: 0~(highn-1);  lower:  0 ~ (lowc-1)
            res += highn * lowc;
        } else {              
            //curn > 1
            res += (highn + 1) * lowc;
        }
        //update lown and lowc
        lown = curn * lowc + lown;
        lowc = lowc * 10;
    }
    return res;
}

*/