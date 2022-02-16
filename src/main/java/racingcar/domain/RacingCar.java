package racingcar.domain;

public class RacingCar {

    private static final int MOVE_STANDARD = 4;
    private static final int BASE_POSITION = 0;
    private final String name;
    private int position;

    private RacingCar(String name) {
        this.position = BASE_POSITION;
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

    public void goOrStay(int number) {
        if (number >= MOVE_STANDARD) {
            position++;
        }
    }

    public boolean isSamePosition(RacingCar racingCar) {
        return this.position == racingCar.getPosition();
    }

}
