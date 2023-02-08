import java.util.List;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void addPosition() {
        position = position + 1;
    }

    public boolean amIWinner(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            max = Math.max(car.position, this.position);
        }

        return max == position;
    }
}
