package domain;

public class RacingCar implements Comparable<RacingCar>{
    private static final int MOVE_CONDITION = 4;
    private final String name;
    private int moveNumber = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveNumber(){
        return moveNumber;
    }

    public void race(int number) {
        if (number >= MOVE_CONDITION) {
            this.moveNumber++;
        }
    }

    public boolean isSameDistance(RacingCar racingCar) {
        return racingCar.moveNumber == this.moveNumber;
    }

    @Override
    public int compareTo(RacingCar o) {
        return o.moveNumber - this.moveNumber;
    }
}
