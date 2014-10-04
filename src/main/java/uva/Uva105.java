package uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * UVa 105 - The Skyline Problem
 * Created by Darren on 14-3-8.
 */

class Uva105 {
    public final static int MAX_COORDINATE = 10000;
    private static int[] skyline = new int[MAX_COORDINATE];

    public static void main(String[] args) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int leftMost = -1, rightMost = 0;
        String line;
        StringTokenizer stringTokenizer;
        try {
            while ((line = in.readLine()) != null) {
                stringTokenizer = new StringTokenizer(line);
                int left = Integer.parseInt(stringTokenizer.nextToken());
                int height = Integer.parseInt(stringTokenizer.nextToken());
                int right = Integer.parseInt(stringTokenizer.nextToken());
                if (leftMost < 0)
                    leftMost = left;    // Buildings are sorted in ascending order of their left coordinates

                // Update the heights within range [left, right); note that
                // the height at right is not included.
                for (int i = left; i < right; i++) {
                    skyline[i] = Math.max(skyline[i], height);
                }

                rightMost = Math.max(rightMost, right);
            }
            // Output the skyline according to the heights between adjacent coordinates
            String out = "" + leftMost + " " + skyline[leftMost];
            for (int i = leftMost + 1; i <= rightMost; i++) {
                if (skyline[i] != skyline[i-1])
                    out += " " + i + " " + skyline[i];

            }
            System.out.println(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}