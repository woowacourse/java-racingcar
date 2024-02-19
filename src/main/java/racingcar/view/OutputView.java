package racingcar.view;

import java.util.List;
import java.util.Map;

public interface OutputView {
    void printRaceResultHeaderMessage();

    void printRaceResult(final Map<String, Integer> raceResult);

    void printRaceWinners(final List<String> raceResult);
}
