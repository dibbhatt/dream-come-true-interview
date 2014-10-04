package java;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-9 
 * Time : 下午10:14:14
 */
public class StaticTest
{
     /* See below - I have marked the constructor as static. It should be wrong!!*/
     public StaticTest()
     {
         System.out.println("Static Constructor of the class");
     }
     public static void main(String args[])
     {
         /*Below: I'm trying to create an object of the class
         which would intern call the constructor*/
         StaticTest obj = new StaticTest();
     }
}
