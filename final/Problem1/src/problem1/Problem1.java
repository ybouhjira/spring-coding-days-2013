package problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("Fibonacci.in"));
        int ordre = scn.nextInt();

        int[] prev = new int[ordre];
        int[] current = new int[ordre];

        current[0] = 1;
        for (int i = 1; i < ordre; i++) {
            current[i] = 0;
        }

        for (int line = 0; line < ordre; line++) {

            for (int j = 0; j < line + 1; j++) {
                if (j == 0) {
                    current[j] = 1;
                } else {
                    current[j] = prev[j] + prev[j - 1];
                }
            }

            for (int i = 0; i < ordre - line - 1; i++) {
                System.out.print("  ");
            }
            // display current
            writeRow(current);

            // previous = current
            System.arraycopy(current, 0, prev, 0, ordre);
        }
    }

    public static void writeRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            String spaces = " ";

            if (i < row.length - 2) {
                int spaceCount = String.valueOf(row[i] + row[i + 1]).length();
                spaces = "";
                for (int j = 0; j < spaceCount; j++) {
                    spaces += " ";
                }
            }

            if (row[i] != 0) {
                System.out.print(row[i]);
                System.out.print(spaces);
            }
        }
        System.out.println();
    }
}
