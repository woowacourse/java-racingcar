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
        int max = position;
        for (Car car : cars) {
            max = Math.max(car.position, max);
        }

        return max == position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
