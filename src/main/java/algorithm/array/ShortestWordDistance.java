package algorithm.array;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int w1Index = -1;
        int w2Index = -1;
        
        int d = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (w.equals(word1)) {
                if (w2Index != -1) {
                    d = Math.min(d, i - w2Index);
                }
                w1Index = i;
            } else if (w.equals(word2))  {
                if (w1Index != -1) {
                    d = Math.min(d, i - w1Index);
                }
                w2Index = i;
            }
        }
        return d;
    }
}
