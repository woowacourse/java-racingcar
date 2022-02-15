package racingcar.dto;

public class CarValue {
    private final String name;
    private final int position;

    public CarValue(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
