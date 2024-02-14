package racingcar.view.console;

import racingcar.dto.request.RaceCountRequest;
import racingcar.dto.request.RaceParticipantsRequest;
import racingcar.view.InputView;

import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public RaceParticipantsRequest readRaceParticipants() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        return new RaceParticipantsRequest(input);
    }

    @Override
    public RaceCountRequest readRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = scanner.nextLine();
        return new RaceCountRequest(input);
    }
}
