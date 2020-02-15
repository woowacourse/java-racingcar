package racingcar.view;

import racingcar.domain.Name;
import racingcar.domain.RacingRound;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMA = ",";

    public static List<Name> getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> stringNames = Arrays.asList(SCANNER.nextLine().trim().split(COMMA));
        return stringNames.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public static RacingRound getMoveNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        return new RacingRound(Integer.parseInt(SCANNER.nextLine()));
    }
}
