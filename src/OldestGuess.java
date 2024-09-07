public class OldestGuess extends Guess {
    String hotncold;
    public OldestGuess() {

    }
    public OldestGuess(int num, String temp){
        super(num);
        hotncold = temp;
    }
    public OldestGuess (LastGuess lastGuess) {
        num = lastGuess.getNum();
        hotncold = lastGuess.getHotncold();
    }
    public String getHotncold(){
        return hotncold;
    }
}
