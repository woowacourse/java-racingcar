package racingcar;

import java.util.Scanner;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.utils.InputUtils;
import racingcar.utils.PrintUtils;

public class GameRunner {

    final Scanner scanner;

    private Cars cars;
    private Round round;

    public GameRunner(final Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        PrintUtils.printInfo("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        cars = Cars.createByNames(InputUtils.getNames(scanner));

        PrintUtils.printInfo("시도할 회수는 몇회인가요?");
        round = Round.create(InputUtils.getInteger(scanner));

        PrintUtils.printInfo("실행 결과");
        while (!round.isEnd()) {
            cars.tryMoveCars();
            PrintUtils.printResult(cars.getAllCarsPosition());
            round.next();
        }
        PrintUtils.printWinner(cars.getWinners());
    }
}
