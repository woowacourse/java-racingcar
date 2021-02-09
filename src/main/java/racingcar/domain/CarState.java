package racingcar.domain;

public class CarState {
    private final String name;
    private final int position;

    private CarState(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static CarState of(String name, int position) {
        return new CarState(name, position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
