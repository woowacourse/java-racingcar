package racingcar.view;

import java.util.List;
import java.util.Map;

public interface OutputView {
    void printRaceResultHeaderMessage();

    void printRaceHistory(final List<Map<String, Integer>> raceHistory);

    void printRaceWinners(final List<String> raceResult);
}
