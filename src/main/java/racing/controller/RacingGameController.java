package racing.controller;

import racing.domain.Car;
import racing.domain.RandomNumberGenerator;
import racing.dto.GameResultDto;
import racing.service.RacingGameService;
import racing.view.InputView;
import racing.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {

    public void run() {
        List<String> names = InputView.inputNames();
        List<Car> cars = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        int tryCount = InputView.inputTryCount();

        RacingGameService gameService = new RacingGameService(new RandomNumberGenerator(), tryCount, cars);
        while (!gameService.isEnd()) {
            GameResultDto resultDto = gameService.play();
            OutputView.printRacing(resultDto);
        }
        List<String> winnerNames = gameService.getWinners();
        OutputView.printWinners(winnerNames);
    }
}
