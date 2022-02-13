package racingcar.service;

import java.util.List;

public interface GameService {

    void initCarNames(List<String> carNames);

    void initRound(int count);

    boolean isContinuable();

    void playRound();

    List<String> getCurrentStatuses();

    List<String> getWinnerNames();

}
