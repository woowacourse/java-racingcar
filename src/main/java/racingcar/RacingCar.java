package racingcar;

public class RacingCar {

    private static final int MOVE_STANDARD = 4;
    private final String name;
    private int position;


    private RacingCar(String name) {
        this.position = 0;
        this.name = name;
    }

    public static RacingCar generateRacingCar(String name) {
        return new RacingCar(name);
    }

    public int getPosition() {
        return position;
    }

    public void goOrStay(int randomNumber) {
        if (randomNumber >= MOVE_STANDARD) {
            position++;
        }

    }


}
