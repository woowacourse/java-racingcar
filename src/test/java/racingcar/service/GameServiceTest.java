package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.strategy.CustomMoveStrategy;
import racingcar.dto.RoundDto;

class GameServiceTest {

    private static final List<String> CAR_NAMES = Arrays.asList("hello", "poby", "ifif", "hanul");
    private static final int ROUND_INITIALIZED_COUNT = 3;
    private static final int ROUND_DECREASING_COUNT = 1;

    private final CustomMoveStrategy customMoveStrategy = new CustomMoveStrategy();
    private final GameService gameService = new GameService(customMoveStrategy);

    @BeforeEach
    void initialize() {
        gameService.initCarNames(CAR_NAMES);
        gameService.initRound(ROUND_INITIALIZED_COUNT);
    }

    @DisplayName("게임 라운드 실행 횟수는 하나씩 감소된다.")
    @Test
    void decreaseRoundTest() {
        customMoveStrategy.initMoveConditions(Arrays.asList(true, true, true, true));
        gameService.playRound();
        final RoundDto roundDto = gameService.getCurrentRound();

        final int actual = roundDto.getCount();
        final int expected = ROUND_INITIALIZED_COUNT - ROUND_DECREASING_COUNT;
        assertThat(actual).isEqualTo(expected);
    }

}
