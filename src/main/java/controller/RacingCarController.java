package controller;

import domain.Car;
import domain.Cars;
import dto.CarDto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class RacingCarController {

    public void run() throws IOException {
        List<String> carNames = InputView.readCarName();
        int attemptNumber = InputView.readAttemptNumber();

        Cars cars = makeCarsFromNames(carNames);

        OutputView.printResult();

        while ((attemptNumber--) > 0) {
            moveAll(cars);
            List<CarDto> carDtos = getCarDtos(cars);
            OutputView.printStatus(carDtos);
        }

        OutputView.printWinner(cars.judgeWinner());
    }

    private List<CarDto> getCarDtos(Cars cars) {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars.getCars()) {
            carDtos.add(CarDto.from(car));
        }
        return carDtos;
    }

    private void moveAll(Cars cars) {
        for (Car car : cars.getCars()) {
            int randomNumber = RandomNumberGenerator.generate();
            car.move(randomNumber);
        }
    }

    private Cars makeCarsFromNames(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());

        return new Cars(cars);
    }
}
