package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.AppConfig;
import racingcar.domain.car.strategy.CustomMoveStrategy;
import racingcar.dto.CarStatusDto;
import racingcar.dto.RoundDto;

class GameServiceTest {

    private static final String PROVIDER_PATH = "racingcar.service.provider.GameServiceTestProvider#";
    private static final List<String> CAR_NAMES = Arrays.asList("hello", "poby", "ifif", "hanul");
    private static final int ROUND_INITIALIZING_COUNT = 3;
    private static final int ROUND_DECREASING_COUNT = 1;
    private static final AppConfig APP_CONFIG = AppConfig.getInstance();

    private final CustomMoveStrategy customMoveStrategy = APP_CONFIG.moveStrategy;
    private final GameService gameService = APP_CONFIG.gameService;

    @BeforeEach
    void initialize() {
        gameService.initCarNames(CAR_NAMES);
        gameService.initRound(ROUND_INITIALIZING_COUNT);
    }

    @DisplayName("게임 라운드 실행 횟수는 하나씩 감소된다.")
    @Test
    void decreaseRoundTest() {
        customMoveStrategy.initMoveConditions(Arrays.asList(true, true, true, true));
        gameService.playRound();
        final RoundDto roundDto = gameService.getCurrentRound();

        final int actual = roundDto.getCount();
        final int expected = ROUND_INITIALIZING_COUNT - ROUND_DECREASING_COUNT;
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("게임 라운드 실행 가능 여부 확인 기능 테스트")
    @Test
    void isContinuableTest() {
        customMoveStrategy.initMoveConditions(Arrays.asList(
                true, true, true, true,
                true, true, true, true,
                true, true, true, true
        ));

        for (int i = 0; i < ROUND_INITIALIZING_COUNT; i++) {
            assertThat(gameService.isContinuable()).isTrue();
            gameService.playRound();
        }
        assertThat(gameService.isContinuable()).isFalse();
    }

    @DisplayName("게임 라운드 실행 시, 조건에 따라 자동차가 전진한다.")
    @ParameterizedTest(name = "[{index}] 실행횟수 : {1}, 이동거리 : {2}")
    @MethodSource(PROVIDER_PATH + "provideForPlayRoundTest")
    void playRoundTest(final List<Boolean> moveConditions, final int repeatTime, final List<Integer> expected) {
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

    @DisplayName("게임 라운드 우승자 반환 기능 테스트")
    @ParameterizedTest(name = "[{index}] 실행횟수 : {1}, 우승자 : {2}")
    @MethodSource(PROVIDER_PATH + "provideForGetWinnerNamesTest")
    void getWinnerNamesTest(final List<Boolean> moveConditions, final int repeatTime, final List<String> expected) {
        customMoveStrategy.initMoveConditions(moveConditions);
        for (int i = 0; i < repeatTime; i++) {
            gameService.playRound();
        }

        final List<String> winnerNames = gameService.getWinnerNames();
        assertThat(winnerNames).isEqualTo(expected);
    }

}
