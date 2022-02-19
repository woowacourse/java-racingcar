package racingcar.model.car;

/**
 * Car 클래스의 Dto 클래스
 */
public class CarNameAndPosition {
    private final String name;
    private final int position;

    public CarNameAndPosition(Car car) {
        this.name = car.getName().toString();
        this.position = car.getPosition().toInt();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
