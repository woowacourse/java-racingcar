package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.car.strategy.CustomMoveStrategy;
import racingcar.dto.CarStatusDto;
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

    @DisplayName("게임 라운드 실행 시, 조건에 따라 자동차가 전진한다.")
    @ParameterizedTest
    @MethodSource("provideForPlayRoundTest")
    void playRoundTest(final List<Boolean> moveConditions, final List<Integer> expected, final int repeatTime) {
        customMoveStrategy.initMoveConditions(moveConditions);
        for (int i = 0; i < repeatTime; i++) {
            gameService.playRound();
        }

        final List<CarStatusDto> carStatusDtos = gameService.getCurrentStatuses();
        final List<Integer> carLocations = carStatusDtos.stream()
                .map(CarStatusDto::getLocation)
                .collect(Collectors.toUnmodifiableList());
        assertThat(carLocations).isEqualTo(expected);
    }

    public static Stream<Arguments> provideForPlayRoundTest() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(true, true, false, false),
                        Arrays.asList(1, 1, 0, 0), 1
                ),
                Arguments.of(
                        Arrays.asList(
                                false, true, true, false,
                                false, true, false, true
                        ),
                        Arrays.asList(0, 2, 1, 1), 2
                )
        );
    }

}
