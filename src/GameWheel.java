import java.util.ArrayList;
import java.util.Collections;

public class GameWheel {
    // Main list of slices making up the wheel
    private ArrayList<Slice> slices;
    // Position of currently selected slice on wheel
    private int currentPos;
    private ArrayList<Slice> red = new ArrayList<Slice>();
    private ArrayList<Slice> blue = new ArrayList<Slice>();
    private ArrayList<Slice> black = new ArrayList<Slice>();

    //constructor
    public GameWheel(){
        this.slices = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i == 0 || i  == 5 || i == 10 || i == 15) {
                Slice s1 = new Slice("Black", (1000 * i));
                black.add(s1);

            } else if (i%2 == 0) {
                Slice s2 = new Slice("Blue", (100 * i));
                blue.add(s2);

            } else {
                Slice s3 = new Slice("Red", (200 * i));
                red.add(s3);
            }
        }
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < 20; i++) {
            s = s + "\n" + (i + " - " + this.slices.get(i).toString());
        }
        return s;
    }
    public void split() {
        for (Slice s : this.slices) {
            if (s.getColor() == "Blue") {
                this.blue.add(s);
            } else if (s.getColor() == "Black") {
                this.black.add(s);
            } else if (s.getColor() == "Red") {
                this.red.add(s);
            }
        }
    }
    public void scramble() {
        split();
        shuffleListPos();
        this.slices.clear();

        for (int i = 0; i < 20; i++) {
            if (i%5 == 0) {
                slices.add(black.get(0));
                black.remove(0);
            } else if (i%2 == 0) {
                slices.add(blue.get(0));
                blue.remove(0);
            } else {
                slices.add(red.get(0));
                red.remove(0);
            }
        }
    }
    public void sort() {
        split();
        sortListPos();
        this.slices.clear();

        for (int i = 0; i < 20; i++) {
            if (i%5 == 0) {
                slices.add(black.get(0));
                black.remove(0);
            } else if (i%2 == 0) {
                slices.add(blue.get(0));
                blue.remove(0);
            } else {
                slices.add(red.get(0));
                red.remove(0);
            }
        }
    }

    public Slice spinWheel() {
        this.currentPos = (int)(Math.random() * ((19) + 1));
        return getSlice(this.currentPos);
    }

    public Slice getSlice(int i) {
        if (i > 19 || i < 0) {
            return this.slices.get(0);
        } else {
            return this.slices.get(i);
        }
    }

    private void shuffleListPos() {
        Collections.shuffle(red);
        Collections.shuffle(blue);
        Collections.shuffle(black);
    }

    private void sortListPos() {
        // Sorting black
        for (int i = 0; i < black.size(); i++) {

            for (int j = i+1; j < black.size(); j++) {
                if (black.get(j).getPrizeAmount() < black.get(i).getPrizeAmount()) {
                    Collections.swap(black,j,i);
                }
            }
        }

        // Sorting blue
        for (int i = 0; i < blue.size(); i++) {

            for (int j = i+1; j < blue.size(); j++) {
                if (blue.get(j).getPrizeAmount() < blue.get(i).getPrizeAmount()) {
                    Collections.swap(blue,j,i);
                }
            }
        }

        // Sorting red
        for (int i = 0; i < red.size(); i++) {

            for (int j = i+1; j < red.size(); j++) {
                if (red.get(j).getPrizeAmount() < red.get(i).getPrizeAmount()) {
                    Collections.swap(red,j,i);
                }
            }
        }
    }
}
