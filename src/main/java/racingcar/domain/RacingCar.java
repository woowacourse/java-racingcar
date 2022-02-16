package racingcar.domain;

public class RacingCar implements Comparable<RacingCar> {

    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position = DEFAULT_POSITION;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    @Override
    public int compareTo(RacingCar anotherCar) {
        return this.position - anotherCar.position;
    }
}
