package domain;

public class RacingCar {
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
}
