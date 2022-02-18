package racingcargame.model;

public class CarVO {
    private final String name;
    private final int position;

    public CarVO(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
