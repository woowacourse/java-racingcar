package racingcar.domain;

public class RacingCar implements Comparable<RacingCar> {

    private static int CAR_NAME_MAX_LENGTH = 5;
    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position = DEFAULT_POSITION;

    public RacingCar(final String name) {
        validateRacingCarName(name);
        this.name = name;
    }

    private void validateRacingCarName(final String name) {
        isEmpty(name);
        checkNameLength(name);
    }

    private void isEmpty(final String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없다.");
        }
    }

    private void checkNameLength(final String name) {
        if(name.length() > CAR_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다.");
        }
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
    public int compareTo(final RacingCar anotherCar) {
        return this.position - anotherCar.position;
    }
}
