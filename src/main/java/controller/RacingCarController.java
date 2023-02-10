package controller;

import domain.Car;
import domain.Cars;
import dto.CarDto;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    public void run() throws IOException {
        List<String> carNames = InputView.readCarNames();
        int attemptNumber = InputView.readAttemptNumber();

        Cars cars = getCars(carNames);

        OutputView.printResult();

        while ((attemptNumber--) > 0) {
            moveAll(cars);
            List<CarDto> carDtos = getCarDtos(cars);
            OutputView.printStatus(carDtos);
        }

        OutputView.printWinner(cars.judgeWinners());
    }

    private List<CarDto> getCarDtos(Cars cars) {
        return cars.getCars().stream()
                .map(CarDto::from)
                .collect(Collectors.toList());
    }

    private void moveAll(Cars cars) {
        for (Car car : cars.getCars()) {
            int randomNumber = RandomNumberGenerator.generate();
            car.move(randomNumber);
        }
    }

    private Cars getCars(List<String> carNames) {
        List<Car> carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new Cars(carList);
    }
}
