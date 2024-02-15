package domain;

import java.util.Comparator;

public class RacingCar implements Comparable<RacingCar>{
    private String name;
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

    public void race() {
        if (RandomNumberUtil.getRandomNumber() >= 4) {
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
