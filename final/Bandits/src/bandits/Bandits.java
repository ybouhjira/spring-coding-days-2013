package bandits;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Bandit {

    private boolean dead;
    private int number;

    public Bandit(int number) {
        this.number = number;
        this.dead = false;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Bandit{" + "dead=" + dead + ", number=" + number + "}\n";
    }
}

class BanditCircle implements Iterable<Object> {

    public ArrayList<Bandit> circle;
    private int index = 0;

    public BanditCircle(int count) {
        circle = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            circle.add(new Bandit(i));
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            @Override
            public boolean hasNext() {
                int foundCount = 0;
                for (int i = 0; i < circle.size(); i++) {
                    if (circle.get(i).isDead() == false) {
                        foundCount++;
                    }
                    if (foundCount >= 2) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Bandit next() {

                if (index == circle.size() - 1) {
                    index = 0;
                } else {
                    index++;
                }

                return circle.get(index);
            }

            @Override
            public void remove() {
                circle.remove(index);
            }
        };
    } //< END OF OVERRIDEN iterator()
}

public class Bandits {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new File("bandits.in"));
        FileWriter writer = new FileWriter("bandits.out");
        
        int tests = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < tests; i++) {
            int nbr = Integer.parseInt(sc.nextLine());

            BanditCircle bandits = new BanditCircle(nbr);
            boolean skip = true;
            for (Iterator it = bandits.iterator(); it.hasNext();) {
                Bandit bandit = (Bandit) it.next();
                if (bandit.isDead() == false && !skip) {
                    bandit.setDead(true);
                    skip = true;
                } else if (bandit.isDead() == false) {
                    skip = false;
                }
            }
            for (int j = 0; j < bandits.circle.size(); j++) {
                if (bandits.circle.get(j).isDead() == false) {
                    writer.write(bandits.circle.get(j).getNumber() + "\n");
                }

            }
        }
        writer.close();

    }
}
