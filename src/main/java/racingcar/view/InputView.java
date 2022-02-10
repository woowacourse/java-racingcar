package racingcar.view;

import racingcar.domain.Count;
import racingcar.utils.Console;

public class InputView {

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = Console.readLine();
        return input.split(",");
    }

    public static Count getCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return new Count(Console.readLine());
    }
}
