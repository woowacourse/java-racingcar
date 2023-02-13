package controller.application;

import model.domain.Car;
import model.domain.Cars;
import controller.utils.NumberGenerator;
import model.domain.TryCount;
import model.dto.request.CarNameDto;
import model.dto.response.CarStatusDto;
import model.dto.response.WinnersNameDto;
import view.InputViewForRetry;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameApplication {

    private final InputViewForRetry inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RacingGameApplication(InputViewForRetry inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        List<CarNameDto> carNameDtos = inputView.inputCarsName();
        TryCount tryCount = inputView.inputTryCount();

        Cars cars = getCars(carNameDtos);

        playGame(tryCount, cars);
        printResult(cars);
    }

    private Cars getCars(List<CarNameDto> carNameDtos) {
        return carNameDtos.stream()
                .map(carNameDto -> new Car(carNameDto.getName()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Cars::new));
    }

    private void playGame(TryCount tryCount, Cars cars) {
        for (int i = 0; i < tryCount.getTryCount(); i++) {
            cars.move(numberGenerator);
            List<CarStatusDto> carStatusDtos = cars.getCars()
                    .stream()
                    .map(CarStatusDto::of)
                    .collect(Collectors.toList());
            outputView.printEachRound(carStatusDtos);
        }
    }

    private void printResult(Cars cars) {
        List<Car> winners = cars.findWinners();
        outputView.printWinners(WinnersNameDto.of(winners));
    }
}
