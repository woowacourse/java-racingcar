package domain;

public class RaceResult {
    private final String name;
    private int moveNumber;

    public RaceResult(String name, int moveNumber) {
        this.name = name;
        this.moveNumber = moveNumber;
    }

    public String getName() {
        return name;
    }

    public int getMoveNumber(){
        return moveNumber;
    }
}
