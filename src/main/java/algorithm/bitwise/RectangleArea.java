package algorithm.bitwise;

public class RectangleArea {
	
	public boolean isIntersect(int A, int B, int C, int D, int E, int F, int G, int H) {
		return C >= E && A <= G && D >= F && B <= H;
	}
	
	public int computeIntersectionArea2(int A, int B, int C, int D, int E, int F, int G, int H) {
		if ( isIntersect(A, B, C, D, E, F, G, H)) {
			return Math.abs(Math.max(E, A) - Math.min(C, G)) * (Math.min(D, H) - Math.max(F, B));
		}
		return 0;
	}
	
	public int computeIntersectionArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		if (A > G || C < E) {
			return 0; // Non-overlapping
		} 
		if (D < F || B > H) {
			return 0;
		}
		// overlapping
		int top = Math.min(D, H);
		int bottom = Math.max(B, F);
		int left = Math.max(A, E);
		int right = Math.min(C, G);
		return (right - left) * (top - bottom);
	}
	
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        return Math.abs((C-A) * ( D - B)) + Math.abs((G - E) * ( H - F)) - computeIntersectionArea(A, B, C, D, E, F, G, H );
    }
	
    public int computeIntersectionAreaBruteforce(int A, int B, int C, int D, int E, int F, int G, int H) {
        // Left 
        if (A <= E) {
            // Up
            if (D >= H) {
                // Not intersect
                if (E >= C || H <= B) {
                    return 0;
                }
                return Math.abs((Math.min(C, G) - E) * ( H - Math.max(B, F)));
            } else  { // Down
                if (E >= C || D <= F) {
                    return 0;
                }
                return Math.abs((E - Math.min(C, G)) * ( D- Math.max(B, F)));
            }
        } else { // Right
            if (D >= H) { // Up
                if (A >= G || B >= H) {
                  return 0;
                }
                return Math.abs((A - Math.min(C, G)) * ( H - Math.max(B, F)));
            } else  { // Down
                if (A >= G || D <= F) {
                    return 0;
                }
                return Math.abs((A - Math.min(C, G)) * ( D- Math.max(B, F)));
            } 
        }
    }
}
