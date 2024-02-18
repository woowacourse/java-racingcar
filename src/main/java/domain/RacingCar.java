package domain;

public class RacingCar implements Comparable<RacingCar>{
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

    public void race(int randomNumber) {
        if (randomNumber >= 4) {
            this.moveNumber++;
        }
    }

    public boolean hasSameDistance(RacingCar racingCar) {
        return racingCar.moveNumber == this.moveNumber;
    }

    @Override
    public int compareTo(RacingCar o) {
        return this.moveNumber - o.moveNumber;
    }
}
