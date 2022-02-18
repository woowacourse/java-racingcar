package racingcar.domain.game;

import java.util.List;

public interface RacingGameBuilder {

    RacingGameBuilder randomNumberGenerator(RandomNumberGenerator randomNumberGenerator);

    RacingGameBuilder tryCount(Integer tryCount);

    RacingGameBuilder carNames(List<String> carNames);

    RacingGame build();
}
