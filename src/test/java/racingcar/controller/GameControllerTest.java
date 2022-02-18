package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.AppConfig;
import racingcar.domain.car.strategy.CustomMoveStrategy;
import racingcar.dto.CarStatusDto;
import racingcar.dto.RoundDto;
import racingcar.service.GameService;
import racingcar.view.input.reader.CustomReader;

class GameControllerTest {

    private static final String PROVIDER_PATH = "racingcar.controller.provider.GameControllerTestProvider#";
    private static final AppConfig APP_CONFIG = AppConfig.getInstance();

    private final CustomReader customReader = APP_CONFIG.reader;
    private final CustomMoveStrategy customMoveStrategy = APP_CONFIG.moveStrategy;
    private final GameService gameService = APP_CONFIG.gameService;
    private final GameController gameController = APP_CONFIG.gameController;

    private void initGame(final List<String> readerDatas) {
        customReader.initText(readerDatas);
        gameController.initGame();
    }

    @DisplayName("자동차 이름 설정 기능 테스트")
    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideForInitGameTest")
    void initParticipantsTest(final List<String> readerDatas,
                              final List<String> expectedCarNames,
                              final int expectedRoundCount) {
        this.initGame(readerDatas);

        final List<CarStatusDto> carStatusDtos = gameService.getCurrentStatuses();
        final List<String> carNames = carStatusDtos.stream()
                .map(CarStatusDto::getName)
                .collect(Collectors.toUnmodifiableList());
        assertThat(carNames).isEqualTo(expectedCarNames);
    }

    @DisplayName("실행 횟수 설정 기능 테스트")
    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideForInitGameTest")
    void initRoundTest(final List<String> readerDatas,
                       final List<String> expectedCarNames,
                       final int expectedRoundCount) {
        this.initGame(readerDatas);

        final RoundDto roundDto = gameService.getCurrentRound();
        final int roundCount = roundDto.getCount();
        assertThat(roundCount).isEqualTo(expectedRoundCount);
    }

    @DisplayName("게임 라운드 실행, 자동차 이동거리 확인 테스트")
    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideForGetCarStatusesTest")
    void getCarStatusesTest(final List<String> readerDatas,
                            final List<Boolean> moveConditions,
                            final List<Integer> expected) {
        this.initGame(readerDatas);
        customMoveStrategy.initMoveConditions(moveConditions);
        gameController.playGame();

        final List<CarStatusDto> carStatusDtos = gameService.getCurrentStatuses();
        final List<Integer> carLocations = carStatusDtos.stream()
                .map(CarStatusDto::getLocation)
                .collect(Collectors.toUnmodifiableList());
        assertThat(carLocations).isEqualTo(expected);
    }

    @DisplayName("게임 라운드 실행, 우승자 확인 테스트")
    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideForGetWinnerNamesTest")
    void getWinnerNamesTest(final List<String> readerDatas,
                            final List<Boolean> moveConditions,
                            final List<String> expected) {
        this.initGame(readerDatas);
        customMoveStrategy.initMoveConditions(moveConditions);
        gameController.playGame();

        final List<String> winnerNames = gameService.getWinnerNames();
        assertThat(winnerNames).isEqualTo(expected);
    }

}
