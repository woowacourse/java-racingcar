package domain;

public class RacingCar implements Comparable<RacingCar>{
    private NumberGenerator numberGenerator;
    private final String name;
    private int moveNumber = 0;

    public RacingCar(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public String getName() {
        return name;
    }

    public int getMoveNumber(){
        return moveNumber;
    }

    public void race() {
        if (numberGenerator.generateNumber() >= 4) {
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
