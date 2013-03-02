package cellule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Converter {

    static public int convertColumn(String code) {
        int column = 0;
        for (int i = 0; i < code.length(); i++) {
            column += ((int) code.charAt(i) - (int) 'A' + 1) * (Math.pow(26, code.length() - 1 - i));
        }

        return column;
    }
}

public class Cellule {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scn = new Scanner(new File("cellule.in"));
        FileWriter writer = new FileWriter("cellule.out");
        
        while (true) {
            String line = scn.nextLine();

            try {
                if (Integer.parseInt(line) == -1) {
                    break;
                }
            } catch (NumberFormatException exc) {
            }

            // Match column
            Pattern pattern = Pattern.compile("[A-Z]+(?=\\d*)");
            Matcher matcher = pattern.matcher(line);
            
            matcher.find();
            int column = Converter.convertColumn(matcher.group());
            
            // Match line
            Pattern pattern2 = Pattern.compile("\\d+");
            Matcher matcher2 = pattern2.matcher(line);

            matcher2.find();
            int lineNumber = Integer.parseInt(matcher2.group());
           
            writer.write(lineNumber + " " + column + "\n");

        }
        writer.close();

    }
}
