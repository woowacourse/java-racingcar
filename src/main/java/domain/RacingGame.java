package domain;

import view.Input;
import view.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private CarGenerator carGenerator;
    private Input input;
    private Winner winner;
    private List<Car> cars;
    private int tryCount;

    public RacingGame() {
        carGenerator = new CarGenerator();
        input = new Input();
        winner = new Winner();
        cars = new ArrayList<>();
    }

    public void initGame() {
        Output.printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = input.getCarNames(input.getInput());
        cars = carGenerator.generateCars(carNames);
        Output.printMessage("시도할 회수는 몇회인가요?");
        this.tryCount = input.getTryCount(input.getInput());
    }

    public void start() {
        Output.printMessage("실행 결과");
        while (isValidTry()) {
            cars.forEach(car -> car.move());
            Output.printEachCarDistance(cars);
        }
    }

    public void printResult() {
        winner.makeWinnerNames(cars);
        Output.printWinner(winner);
    }

    private boolean isValidTry() {
        return this.tryCount-- > 0;
    }
}
