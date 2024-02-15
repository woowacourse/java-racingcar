package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class InputView {

    public Cars askCarNames(){
        System.out.println("\n경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = readLine();
        String[] splittedInput = carNames.split(",");
        List<Car> cars = Arrays.stream(splittedInput).map(Car::new).toList();
        return new Cars(cars);
    }

    public int askMoveCount() {
        System.out.println("\n시도할 회수는 몇회인가요?");
        return Integer.parseInt(readLine());
    }

    private String readLine() {
        return Console.readLine().replaceAll(" ", "");
    }
}
