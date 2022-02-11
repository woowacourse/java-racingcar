package racingcar.service;

import java.util.List;

public interface GameService {

	void initCarNames(List<String> carNames);

	void initRound(int count);

	boolean isContinuable();

	List<String> playRound();

	List<String> getWinnerNames();

}
