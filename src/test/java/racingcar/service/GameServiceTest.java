package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.dto.CarStatusDto;

class GameServiceTest {

    private static final String PROVIDER_PATH = "racingcar.service.provider.GameServiceTestProvider#";
    private static final int CAR_INITIALIZED_LOCATION = 0;

    private final GameService gameService = new GameService();

    @DisplayName("자동차 이름 초기화 기능 테스트")
    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideForInitCarNamesTest")
    void initCarNamesTest(final List<String> carNames) {
        gameService.initCarNames(carNames);
        final List<CarStatusDto> carStatusDtos = gameService.getCurrentStatuses();

        compareCarNames(carStatusDtos, carNames);
        checkCarLocationsInitialized(carStatusDtos);
    }

    private void compareCarNames(final List<CarStatusDto> carStatusDtos, final List<String> expected) {
        final List<String> actualCarNames = carStatusDtos.stream()
                .map(CarStatusDto::getName)
                .collect(Collectors.toUnmodifiableList());

        assertThat(actualCarNames).isEqualTo(expected);
    }

    private void checkCarLocationsInitialized(final List<CarStatusDto> carStatusDtos) {
        final List<Integer> carLocations = carStatusDtos.stream()
                .map(CarStatusDto::getLocation)
                .collect(Collectors.toUnmodifiableList());

        carLocations.forEach(location -> assertThat(location).isEqualTo(CAR_INITIALIZED_LOCATION));
    }

}
