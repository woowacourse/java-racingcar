package racingcar.view;

import racingcar.model.car.Name;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printInputNamesUi() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printInputTryCountUi() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printRaceResultUi() {
        System.out.println("\n실행 결과");
    }

    public static void printRaceResultUi(List<Name> names) {
        System.out.printf("%s가 최종 우승했습니다.", names.stream()
                .map(Name::toString)
                .collect(Collectors.joining(", ")));
    }

    public static void printErrorUi(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
