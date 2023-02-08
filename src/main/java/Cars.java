import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            tryMove(car);
        }
    }

    private void tryMove(Car car) {
        int randomNumber = RandomUtil.createRandomNumber();

        if (RandomUtil.canMoveForward(randomNumber)) {
            car.move();
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : cars) {
            stringBuilder.append(car.getCurrentState() + "\n");
        }

        return stringBuilder.toString();
    }
}
