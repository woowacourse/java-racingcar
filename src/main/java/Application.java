import controller.GameController;
import domain.Car;
import domain.repository.CarRepository;
import service.GameService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        GameService gameService = new GameService(new CarRepository());
        List<Car> cars = new GameController(gameService).getCars();

    }
}
