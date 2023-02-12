package racingcar.domain;

import racingcar.dto.CarNamesRequest;
import racingcar.dto.CarStatusResponse;
import racingcar.dto.GameResultResponse;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameManager {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;
    private Cars cars;
    private GameRound gameRound;

    public GameManager(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void playGame() {
        createCars();
        createGameRound();
        startEachGameRound();
        endGame();
    }

    private void startEachGameRound() {
        outputView.printResultMessage();
        while (!gameRound.isEnd()) {
            cars.moveCars();
            gameRound.increaseRound();
            Set<Car> currentCars = cars.getCars();
            List<CarStatusResponse> roundResultCarStatus = convertCarToCarStatus(currentCars);
            outputView.printRoundResult(roundResultCarStatus);
        }
    }

    private List<CarStatusResponse> convertCarToCarStatus(Set<Car> carsStatus) {
        List<CarStatusResponse> roundResultCarStatus = new ArrayList<>();
        for (Car car : carsStatus) {
            roundResultCarStatus.add(new CarStatusResponse(car));
        }
        return roundResultCarStatus;
    }

    /**
     * 이 부분 인덴트가 2인 것을 줄이고 싶었으나,
     * 현재 구조에서는 while 문을 없애고
     * catch문에서 재귀호출을 하는 것 밖에는 방법이 떠오르지 않아
     * 그대로 두었습니다.
     */
    private void createCars() {
        while (true) {
            try {
                cars = new Cars();
                CarNamesRequest requestCarNames = inputView.inputCarName();
                List<String> carNames = requestCarNames.getCarNames();
                cars.createCars(carNames, numberGenerator);
                return;
            } catch (Exception e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void createGameRound() {
        while (true) {
            try {
                int totalRound = inputView.inputGameRound().getRound();
                gameRound = new GameRound(totalRound);
                return;
            } catch (Exception e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void endGame() {
        GameResultResponse gameResult = new GameResultResponse(cars.findWinnerNames());
        outputView.printEndGameResult(gameResult);
    }
}
