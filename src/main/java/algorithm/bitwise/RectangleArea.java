package algorithm.bitwise;

public class RectangleArea {
    public int computeIntersectionArea(int A, int B, int C, int D, int E, int F, int G, int H) {
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
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	
        return Math.abs((C-A) * ( D - B)) + Math.abs((G - E) * ( H - F)) - computeIntersectionArea(A, B, C, D, E, F, G, H );

    }
	
}
