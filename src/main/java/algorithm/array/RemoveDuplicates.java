package algorithm.array;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : Jun 12, 2014 
 * Time : 10:29:31 PM
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] A) {
        if(A.length <= 1)
            return A.length;
            
        boolean done = false;
        int fill = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i] == A[fill]){
                if(!done){
                    done = true;
                    fill++;
                    A[fill] = A[i];
                }
            }else{
                done = false;
                fill++;
                A[fill] = A[i];
            }
        }
        return fill;
    }
}
