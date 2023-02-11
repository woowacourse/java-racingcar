package domain;

import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final CarGenerator carGenerator;
    private final Winner winner;
    private List<Car> cars;
    private int tryCount;

    public RacingGame() {
        carGenerator = new CarGenerator();
        winner = new Winner();
        cars = new ArrayList<>();
    }

    public void initGame() {
        Output.printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = Input.getCarNames(Input.getInput());
        cars = carGenerator.generateCars(carNames);
        Output.printMessage("시도할 회수는 몇회인가요?");
        this.tryCount = Input.getTryCount(Input.getInput());
    }

    public void start() {
        Output.printMessage("실행 결과");
        while (isGameContinue()) {
            cars.forEach(car -> car.move());
            Output.printEachCarDistance(cars);
        }
    }

    public void printResult() {
        winner.makeWinnerNames(cars);
        Output.printWinner(winner);
    }

    private boolean isGameContinue() {
        return this.tryCount-- > 0;
    }
}
