import controller.CarController;
import service.CarService;
import utils.RacingRandomNumberGenerator;

public class Main {

    public static void main(String[] args) {
        CarService carService = new CarService();
        CarController carController = new CarController(carService);

        carController.run(new RacingRandomNumberGenerator());
    }
}
