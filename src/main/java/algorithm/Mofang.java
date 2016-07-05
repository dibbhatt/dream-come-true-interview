package algorithm;
/** 
 * Description :
 * Source : 
 * Created_By : zhaoxm (xmpy) 
 * Date : Aug 23, 2015 
 * Time : 10:54:37 AM
 */

enum Color {
	W, Y, R, O, G, B;
}

class Surface {
	public Color[][] colors = new Color[3][3];
	public Surface(Color color) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				colors[i][j] = color;
			}
		}
			
	}
}

public class Mofang {
    // up,down,front,back,left,right;
	// w-up, r-front, y-right
	private Surface up,down,front,back,left,right;
	
	public Mofang() {
		up = new Surface(Color.W); //up
		down = new Surface(Color.O); //down
		front = new Surface(Color.R); //front
		back = new Surface(Color.B); //back
		left = new Surface(Color.G); //left
		right = new Surface(Color.Y); //right
	}
	
	public void U() {
		Color[] temp = new Color[3];
		temp[0] = front.colors[0][0];
		temp[1] = front.colors[0][1];
		temp[2] = front.colors[0][2];
		
		for (int i = 0; i < 3; i++) {
			front.colors[0][i] =  right.colors[0][i]; 		
		}
		for (int i = 0; i < 3; i++) {
			right.colors[0][i] =  back.colors[0][i]; 		
		}
		for (int i = 0; i < 3; i++) {
			back.colors[0][i] =  left.colors[0][i]; 		
		}
		for (int i = 0; i < 3; i++) {
			left.colors[0][i] =  temp[i]; 		
		}
	}
	
	public void D() {
		Color[] temp = new Color[3];
		temp[0] = down.colors[0][0];
		temp[1] = down.colors[1][0];
		temp[2] = down.colors[2][0];
		for (int i = 0; i < 3; i++) {
			down.colors[i][0] =  back.colors[i][0]; 		
		}
		for (int i = 0; i < 3; i++) {
			back.colors[i][0] =  up.colors[2-i][2]; 		
		}
		for (int i = 0; i < 3; i++) {
			up.colors[i][2] =  front.colors[i][2]; 		
		}
		for (int i = 0; i < 3; i++) {
			front.colors[i][2] =  temp[i]; 		
		}
	}
	public void F() {
		Color[] temp = new Color[3];
		temp[0] = up.colors[2][0];
		temp[1] = up.colors[2][1];
		temp[2] = up.colors[2][2];
		for (int i = 0; i < 3; i++) {
			up.colors[2][i] =  left.colors[2 -i][2]; 		
		}
		for (int i = 0; i < 3; i++) {
			left.colors[i][2] =  down.colors[0][2 - i]; 		
		}
		for (int i = 0; i < 3; i++) {
			down.colors[0][i] =  right.colors[i][0]; 		
		}
		for (int i = 0; i < 3; i++) {
			right.colors[2 -i][0] =  temp[i]; 		
		}
	}
	
	public void B() {
		Color[] temp = new Color[3];
		temp[0] = front.colors[2][0];
		temp[1] = front.colors[2][1];
		temp[2] = front.colors[2][2];
		for (int i = 0; i < 3; i++) {
			front.colors[2][i] =  left.colors[2][i]; 		
		}
		for (int i = 0; i < 3; i++) {
			left.colors[2][i] =  back.colors[2][i]; 		
		}
		for (int i = 0; i < 3; i++) {
			back.colors[2][i] =  right.colors[2][i]; 		
		}
		for (int i = 0; i < 3; i++) {
			right.colors[2][i] =  temp[i]; 		
		}
	}
	
	public void L() {
		Color[] temp = new Color[3];
		temp[0] = front.colors[0][0];
		temp[1] = front.colors[1][0];
		temp[2] = front.colors[2][0];
		for (int i = 0; i < 3; i++) {
			front.colors[i][0] =  up.colors[i][0]; 		
		}
		for (int i = 0; i < 3; i++) {
			up.colors[i][0] =  back.colors[2 -i][2]; 		
		}
		for (int i = 0; i < 3; i++) {
			back.colors[i][2] =  down.colors[2 -i][2]; 		
		}
		for (int i = 0; i < 3; i++) {
			down.colors[2][i] =  temp[i]; 		
		}
	}
	
	public void R() {
		Color[] temp = new Color[3];
		temp[0] = front.colors[0][0];
		temp[1] = front.colors[0][1];
		temp[2] = front.colors[0][2];
		
		for (int i = 0; i < 3; i++) {
			front.colors[0][i] =  right.colors[0][i]; 		
		}
		for (int i = 0; i < 3; i++) {
			right.colors[0][i] =  back.colors[0][i]; 		
		}
		for (int i = 0; i < 3; i++) {
			back.colors[0][i] =  left.colors[0][i]; 		
		}
		for (int i = 0; i < 3; i++) {
			left.colors[0][i] =  temp[i]; 		
		}
	}
	public void play(char command) {
		if (command == 'U') {
			U();
		} else if (command == 'D') {
			D();
		} else if (command == 'F') {
			F();
		} else if (command == 'B') {
			B();
		} else if (command == 'L') {
			L();
		} else if (command == 'R') {
			R();
		}
	}
	
	public void printSurface(Surface s) {
		System.out.print(s.colors[1][1]);
		for (int i = 0; i < 3; i++) {
			System.out.print(s.colors[2][i]);
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(s.colors[2 -i][2]);
		}		
		for (int i = 0; i < 3; i++) {
			System.out.print(s.colors[0][ 2 - i]);
		}		
		for (int i = 0; i < 3; i++) {
			System.out.print(s.colors[i][0]);
		}
		System.out.print('\n');

	}
	public void show() {
		//WYROGB
		//print result;
		//		up = new Surface(Color.W); //up

		printSurface(up);
		printSurface(right);
		printSurface(front);
		printSurface(down);
		printSurface(left);
		printSurface(back);

	}
	

	public static void main(String[] args) {
		Mofang mf = new Mofang();
		String command = args[0];
		for (int i = 0; i < command.length(); i++) {
			mf.play(command.charAt(i));
		}
		mf.show();
	}

}
