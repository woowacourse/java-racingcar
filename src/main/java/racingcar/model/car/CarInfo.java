package racingcar.model.car;

/**
 * Car 클래스의 Dto 클래스
 */
public class CarInfo {
    private final String name;
    private final int position;

    public CarInfo(Car car) {
        this.name = car.getName();
        this.position = car.getPosition();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
