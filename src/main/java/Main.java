import controller.CarController;
import utils.RacingRandomNumberGenerator;

public class Main {

    public static void main(String[] args) {
        CarController carController = new CarController();

        carController.run(new RacingRandomNumberGenerator());
    }
}
