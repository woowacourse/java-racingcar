import java.util.List;

public class Controller {

    private final View view = new View();

    void start() {
        List<Car> cars = view.readCars();
        int count = view.readCount();

        for (Car car : cars) {
            int random = (int) (Math.random() * 10) + 1;
            if (random > 4) {
                car.go();
            }
        }


    }

}
