package racingcar.domain;

public class RacingCar {

    private static final int START_POSITION = 0;
    private static final int MOVE_STANDARD = 4;
    private final String name;
    private int position;


    private RacingCar(String name) {
        this.position = START_POSITION;
        this.name = name;
    }

    public static RacingCar generateRacingCar(String name) {
        return new RacingCar(name);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void goOrStay(int randomNumber) {
        if (randomNumber >= MOVE_STANDARD) {
            position++;
        }
    }

    public boolean isSamePosition(RacingCar racingCar){
        return this.position == racingCar.getPosition();
    }


}
