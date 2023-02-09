package controller;

import domain.Car;
import domain.Cars;
import dto.CarDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import utils.RandomNumberGenerator;
import utils.StringParser;
import view.InputView;
import view.OutputView;

public class RacingCarController {
    private InputView inputView;
    private OutputView outputView;

    public RacingCarController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() throws IOException {
        String carNames = inputView.readCarName();
        List<String> parse = StringParser.parse(carNames);
        List<Car> carList = new ArrayList<>();
        for (String carName : parse) {
            Car car = new Car(carName);
            carList.add(car);
        }

        Cars cars = new Cars(carList);

        int attemptNumber = inputView.readAttemptNumber();

        outputView.printResult();

        while (attemptNumber > 0) {
            for (Car car : cars.getCars()) {
                int randomNumber = RandomNumberGenerator.generate();
                car.move(randomNumber);
            }
            List<CarDto> carDtos = new ArrayList<>();
            for (Car car : cars.getCars()) {
                carDtos.add(CarDto.from(car));
            }
            outputView.printStatus(carDtos);
            attemptNumber--;
        }

        outputView.printWinner(cars.judgeWinner());
    }
}
