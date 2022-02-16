package racingcar.domain;

public class RacingCar implements Comparable<RacingCar> {

    private static final int DEFAULT_POSITION = 0;

    private final String name;
    private int position = DEFAULT_POSITION;

    public RacingCar(String name) {
        isEmpty(name);
        this.name = name;
    }

    private void isEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없다.");
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
    public int compareTo(RacingCar anotherCar) {
        return this.position - anotherCar.position;
    }
}
