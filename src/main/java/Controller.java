import java.util.List;

public class Controller {

    private final View view = new View();

    public void start() {
        List<Car> cars = view.readCars();
        int count = view.readCount();

        Race race = new Race(count, cars);
    }

}
