import java.util.Random;

public class Guess {
    Random rand = new Random();
    int num;
    public Guess() {
        num = rand.nextInt(100) + 1;
    }
    public Guess(int num) {
        this.num = num;
    }
    public int getNum() {
        return num;
    }
}
