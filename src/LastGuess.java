public class LastGuess extends Guess{
    String hotncold;
    Boolean orNot = false;
    public LastGuess() {

    }
    public LastGuess(int num) {
        super(num);
    }
    public LastGuess(int num, String temp){
        super(num);
        hotncold = temp;
        orNot = true;
    }
    public Boolean didGuess () {
        return orNot;
    }
    public String getHotncold() {
        return hotncold;
    }
}
