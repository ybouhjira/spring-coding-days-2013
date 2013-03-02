
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Drawer {

    public static String drawSegment(int pieces, int containerLength, char character) {
        int beginPos = 0;
        if (pieces != 0) {
            beginPos = containerLength / pieces;
        }
        StringBuilder builder = new StringBuilder("");
        for (int i = 1; i <= containerLength; i++) {
            if (i % 2 == beginPos % 2) {
                builder.append(character);
            } else {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}

public class Pyramide {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("pyramide.in"));
        int count = Integer.parseInt(scn.nextLine());

        for (int p = 0; p < count; p++) {
            // read
            String[] tokens = scn.nextLine().split("\\s");
            int n = Integer.parseInt(tokens[0]);
            char symbol = tokens[1].charAt(0);


        }


    }

    public static void generate2(char sym, int nbr) {
        int h1 = nbr;
        String triangles = "";
        int count = 1;
        for (int j = 0; j < nbr * 3; j++) {
            System.out.print("x");
        }
        System.out.print(sym + "\n");

        int tmp = nbr - 1;
        int tmp2 = tmp * 2;
        int k = 1;

        for (int j = 0; j < nbr - 1; j++) {
            for (int c0 = 0; c0 < tmp; c0++) {
                System.out.print("x");
            }

            for (int c1 = 0; c1 < k; c1++) {
                if (c1 != k - 1) {
                    System.out.print(sym + "_");
                } else {
                    System.out.print(sym);
                }
            }

            for (int c0 = 0; c0 < tmp2 + 1; c0++) {
                System.out.print("X");
            }
            for (int c3 = 0; c3 < k + 1; c3++) {

                if (c3 != k) {
                    System.out.print(sym + "_");
                } else {
                    System.out.print(sym);
                }
            }

            for (int c0 = 0; c0 < tmp2 + 1; c0++) {
                System.out.print("X");
            }

            for (int c4 = 0; c4 < k; c4++) {
                System.out.print(sym + " ");
            }
            k++;
            System.out.print("\n");
            tmp--;
            tmp2 = tmp2 - 2;
        }
    }
}
