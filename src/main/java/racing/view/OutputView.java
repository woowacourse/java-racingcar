package racing.view;

import racing.dto.GameResultDto;

import java.util.List;

public class OutputView {

    public static void printRacing(GameResultDto resultDto) {
        for (String name : resultDto.getNames()) {
            int position = resultDto.getPosition(name);
            String positionView = "-".repeat(position);
            System.out.printf("%s : %s\n", name, positionView);
        }
        System.out.println();
    }

    public static void printWinners(List<String> names) {
        String winners = String.join(", ", names);
        System.out.printf("%s가 최종 우승했습니다.\n", winners);
    }
}
