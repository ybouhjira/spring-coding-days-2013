package am;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Processor {
    private int e, t;

    public Processor(int e, int t) {
        this.e = e;
        this.t = t;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }
    
    public int calculate(int input, String pattern) {
        int result = input;
        for (int i = 0; i < pattern.length(); i++) {
            if(pattern.charAt(i) == 'A') {
                result += e;
            } else { // M
                result *= t;
            }
        }

        return result;
    }
    
}

class RegExp {
    public static final String AM_SPLITTER = "(?<=[AM])|(?=[AM])";
}


public class AM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scn = new Scanner(new File("am.in"));
        
        // Lirte la promiere ligne
        int e = scn.nextInt();
        int t = scn.nextInt();
        int input = scn.nextInt();
        scn.nextLine();
        
        Processor cpu = new Processor(e, t);
        
        FileWriter writer = new FileWriter("am.out");
        while(true) {
            String line = scn.nextLine();
            if(line.charAt(0) == '0')
                break;
            int result =  cpu.calculate(input, line);
            writer.write(String.valueOf(result) + "\n");
        }
        writer.close();
    }
}
