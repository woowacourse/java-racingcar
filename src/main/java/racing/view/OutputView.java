package racing.view;

import java.util.List;
import racing.dto.GameResultDto;

public class OutputView {
    public static final String GAME_RESULT_FORMAT = "%s : %s\n";
    public static final String WINNER_FORMAT = "%s가 최종 우승했습니다.\n";

    public void printRacing(GameResultDto resultDto) {
        for (String name : resultDto.getNames()) {
            int position = resultDto.getPosition(name);
            String positionView = "-".repeat(position);
            System.out.printf(GAME_RESULT_FORMAT, name, positionView);
        }
        System.out.println();
    }

    public void printWinners(List<String> names) {
        String winners = String.join(", ", names);
        System.out.printf(WINNER_FORMAT, winners);
    }
}
