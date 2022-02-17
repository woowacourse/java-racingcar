package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.dto.CarStatusDto;
import racingcar.dto.RoundDto;
import racingcar.exception.WrongArgumentException;

class GameServiceTest {

    private static final String PROVIDER_PATH = "racingcar.service.provider.GameServiceTestProvider#";
    private static final int CAR_INITIALIZED_LOCATION = 0;

    private final GameService gameService = new GameService();

    private void initCarNamesExceptionTest(final List<String> carNames) {
        assertThrows(WrongArgumentException.class, () -> gameService.initCarNames(carNames));
    }

    @DisplayName("자동차 이름은 NULL이 될 수 없습니다.")
    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideForInitCarNamesNullExceptionTest")
    void initCarNamesNullExceptionTest(final List<String> carNames) {
        initCarNamesExceptionTest(carNames);
    }

    @DisplayName("자동차 이름은 중복될 수 없습니다.")
    @ParameterizedTest
    @MethodSource(PROVIDER_PATH + "provideForInitCarNamesDuplicatedExceptionTest")
    void initCarNamesDuplicatedExceptionTest(final List<String> carNames) {
        initCarNamesExceptionTest(carNames);
    }

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

    @DisplayName("실행 횟수 초기화 기능 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void initRoundTest(final int roundCount) {
        gameService.initRound(roundCount);
        final RoundDto roundDto = gameService.getCurrentRound();
        assertThat(roundDto.getCount()).isEqualTo(roundCount);
    }

}
