package racing.view;

import java.util.List;
import racing.dto.GameResultDto;

public class OutputView {

    public void printRacing(GameResultDto resultDto) {
        for (String name : resultDto.getNames()) {
            int position = resultDto.getPosition(name);
            System.out.println(name + " : " + "-".repeat(position));
        }
        System.out.println();
    }

    public void printWinners(List<String> names) {
        String winners = String.join(", ", names);
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
