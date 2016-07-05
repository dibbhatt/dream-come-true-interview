package java;
/** 
 * Description : 使用Java实现函数指针，实现Call Back功能
 * Source : Java 程序员面试笔试宝典
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-12-7 
 * Time : 下午5:51:44
 */
interface IntCompare {
	int cmp(int a, int b);
}


class Cmp1 implements IntCompare {

	@Override
	public int cmp(int a, int b) {
		if (a > b) 
			return 1;
		else if (a < b) 
			return -1;
		else 
			return 0;
		
	}
}

class Cmp2 implements IntCompare {

	@Override
	public int cmp(int a, int b) {
		if (a > b) 
			return -1;
		else if (a < b) 
			return 1;
		else 
			return 0;
		
	}
}




public class CallBackImp {
	
	public static void insertSort(int[] a, IntCompare cmp) {
		
	}
	

}
