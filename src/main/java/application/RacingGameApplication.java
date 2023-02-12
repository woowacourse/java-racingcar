package application;

import domain.Car;
import domain.Cars;
import domain.Name;
import domain.TryCount;
import dto.response.CarStatusDto;
import dto.response.WinnersNameDto;
import utils.NumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameApplication {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public RacingGameApplication(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        List<Name> names = inputView.sendCarsName();
        TryCount tryCount = inputView.sendTryCount();

        Cars cars = getCars(names);

        playGame(tryCount, cars);
        printResult(cars);
    }

    private Cars getCars(List<Name> names) {
        return names.stream()
                .map(Car::new)
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
