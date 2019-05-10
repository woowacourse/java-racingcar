package racing.view;

import racing.model.Car;
import racing.model.CarNamesInput;
import racing.model.RoundNumberInput;

import java.util.List;
import java.util.Scanner;

public class InputView {
    static final Scanner SCANNER = new Scanner(System.in);
    static final String CARNAMES_ERROR = "입력형식이 틀렸습니다. 쉼표로 구분된 6자 미만의 이름들을 입력해 주세요.";
    static final String ROUND_NUMBER_ERROR = "1 이상의 정수를 입력해 주세요.";
    static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요)이름은 쉼표(,)를 기준으로 구분).";
    static final String ASK_ROUND_NUMBERS = "시도할 횟수는 몇회인가요?";

    public static List<Car> getCars() {
        System.out.println(ASK_CAR_NAMES);
        try {
            return CarNamesInput.getCars(SCANNER.nextLine());
            //차 이름을 차 객체들로 변환
        } catch (Exception e) {
            System.out.println(CARNAMES_ERROR + "\n");
            return getCars();
        }
    }

    public static int getRoundNumber() {
        System.out.println(ASK_ROUND_NUMBERS);
        try {
            return RoundNumberInput.getRoundNumber(SCANNER.nextLine());
        } catch (Exception e) {
            System.out.println(ROUND_NUMBER_ERROR + "\n");
            return getRoundNumber();
        }
    }

}
