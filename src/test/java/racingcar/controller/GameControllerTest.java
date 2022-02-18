package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.AppConfig;
import racingcar.dto.CarStatusDto;
import racingcar.dto.RoundDto;
import racingcar.service.GameService;
import racingcar.view.input.reader.CustomReader;

class GameControllerTest {

    private static final String PROVIDER_PATH = "racingcar.controller.provider.GameControllerTestProvider#";
    private static final AppConfig APP_CONFIG = AppConfig.getInstance();

    private final CustomReader customReader = APP_CONFIG.reader;
    private final GameService gameService = APP_CONFIG.gameService;
    private final GameController gameController = APP_CONFIG.gameController;

    @DisplayName("자동차 이름을 설정할 수 있다.")
    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideForInitGameTest")
    void initParticipantsTest(final List<String> readerData,
                              final List<String> expectedCarNames,
                              final int expectedRoundCount) {
        customReader.initText(readerData);
        gameController.initGame();

        final List<CarStatusDto> carStatusDtos = gameService.getCurrentStatuses();
        final List<String> carNames = carStatusDtos.stream()
                .map(CarStatusDto::getName)
                .collect(Collectors.toUnmodifiableList());
        assertThat(carNames).isEqualTo(expectedCarNames);
    }

    @DisplayName("실행 횟수를 설정할 수 있다.")
    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideForInitGameTest")
    void initRoundTest(final List<String> readerData,
                       final List<String> expectedCarNames,
                       final int expectedRoundCount) {
        customReader.initText(readerData);
        gameController.initGame();

        final RoundDto roundDto = gameService.getCurrentRound();
        final int roundCount = roundDto.getCount();
        assertThat(roundCount).isEqualTo(expectedRoundCount);
    }

}
