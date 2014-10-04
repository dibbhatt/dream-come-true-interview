package algorithm.array;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-9 
 * Time : 下午9:36:52
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        
        //find left top point
        int top = 0;
        int left = 0;
        int bottom = matrix.length;
        int right = matrix[0].length;
        
        boolean sign = true;
        
        for (int i = 0; i < matrix.length && sign; i++){
            for(int j = 0; j < matrix[0].length && sign; j++){
                if (matrix[i][j] == '1'){
                    sign = false;
                }
            }
            top = i;
        }
        if(sign == true){
            return 0;
        }
        sign = true;
        
        for (int i = 0; i < matrix[0].length && sign; i++){
            for (int j = 0; j < matrix.length && sign; j++){
                if (matrix[j][i] == '1'){
                    sign = false;
                }
            }
            left = i;
        }
        
        if(sign == true){
            return 0;
        }
        
        sign = true;
        
        for (int i = matrix.length - 1 ; i >= 0 && sign; i--){
            for (int j = 0; j < matrix[0].length && sign; j++){
                if (matrix[i][j] == '1' ){
                    sign = false;
                }
            }
            bottom = i;
        }
        sign = true;
        
        for (int i = matrix[0].length - 1; i >= 0 && sign ; i--){
            for (int j = 0; j < matrix.length && sign; j++){
                if (matrix[j][i] == '1'){
                    sign = false;
                }
            }
            right = i;
        }
       // System.out.println(left + " " + top + " "+ right +" "+ bottom );
        return (right - left + 1) * (bottom - top + 1);
    }
}
