package racingcar.model.vo;

public class Car implements Comparable<Car> {
    private static final int ADVANCE_STANDARD = 4;
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = validateLength(trim(name));
    }

    private static String trim(String name) {
        return name.trim();
    }

    private static String validateLength(final String name) {
        if (name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 %d글자가 넘을 수 없습니다.", MAXIMUM_LENGTH));
        }

        return name;
    }

    public void advance(final int number) {
        if (number >= ADVANCE_STANDARD) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isEqualPosition(final int position) {
        return this.position == position;
    }

    @Override
    public int compareTo(final Car car) {
        return this.position - car.position;
    }
}
