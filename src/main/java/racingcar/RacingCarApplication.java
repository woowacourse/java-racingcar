package racingcar;

import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

/**
 * Application.java
 * 자동차 경주 게임
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class RacingCarApplication {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        InputView.setScanner(scanner);

        Cars cars = createCarsFromUser();
        // TODO 회차 입력 및 Round 객체 생성
        // TODO RacingCarGame 객체 생성 및 실행
    }

    private static Cars createCarsFromUser() {
        try{
            return Cars.of(InputView.getCarNames());
        }catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return createCarsFromUser();
        }
    }
}
