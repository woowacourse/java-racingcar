package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.car.strategy.CustomMoveStrategy;
import racingcar.domain.car.strategy.MoveStrategy;
import racingcar.domain.car.strategy.TrueMoveStrategy;
import racingcar.dto.CarStatusDto;
import racingcar.exception.car.CarNameExceptionStatus;
import racingcar.exception.car.WrongCarNameException;

class CarsTest {

    private static final String PROVIDER_PATH = "racingcar.domain.car.provider.CarsTestProvider#";
    private static final MoveStrategy TRUE_MOVE_STRATEGY = TrueMoveStrategy.getInstance();

    @DisplayName("자동차 이름은 중복될 수 없다")
    @ParameterizedTest(name = "[{index}] 자동차 이름 목록 : {0}")
    @MethodSource(PROVIDER_PATH + "provideForDuplicateExceptionTest")
    void carNamesDuplicatedExceptionTest(final List<String> names) {
        assertThatThrownBy(() -> new Cars(names, TRUE_MOVE_STRATEGY))
                .isInstanceOf(WrongCarNameException.class)
                .hasMessageContaining(CarNameExceptionStatus.NAME_IS_DUPLICATED.getMessage());
    }

    @DisplayName("생성자 기능 테스트")
    @ParameterizedTest(name = "[{index}] 자동차 이름 목록 : {0}")
    @MethodSource(PROVIDER_PATH + "provideForConstructorTest")
    void constructorTest(final List<String> names) {
        assertDoesNotThrow(() -> new Cars(names, TRUE_MOVE_STRATEGY));
    }

    @DisplayName("라운드실행 기능 테스트")
    @ParameterizedTest(name = "[{index}] 실행 횟수 : {1}")
    @MethodSource(PROVIDER_PATH + "provideForPlayRoundTest")
    void playRoundTest(final List<String> carNames,
                       final int repeatTime,
                       final List<Boolean> conditions,
                       final List<String> expected) {
        CustomMoveStrategy customMoveStrategy = new CustomMoveStrategy(conditions);
        final Cars cars = new Cars(carNames, customMoveStrategy);
        final List<CarStatusDto> statuses = repeatPlay(cars, repeatTime);

        final List<String> actual = statuses.stream()
                .map(CarStatusDto::toString)
                .collect(Collectors.toUnmodifiableList());
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("우승자 선정 기능 테스트")
    @ParameterizedTest(name = "[{index}] 실행 횟수 : {1}")
    @MethodSource(PROVIDER_PATH + "provideForGetWinnerNamesTest")
    void selectWinnersTest(final List<String> carNames,
                           final int repeatTime,
                           final List<Boolean> conditions,
                           final List<String> expected) {
        CustomMoveStrategy customMoveStrategy = new CustomMoveStrategy(conditions);
        final Cars cars = new Cars(carNames, customMoveStrategy);
        repeatPlay(cars, repeatTime);

        final List<String> winnerNames = cars.getWinnerNames();
        assertThat(winnerNames).isEqualTo(expected);
    }

    private List<CarStatusDto> repeatPlay(final Cars cars, final int repeatTime) {
        final List<CarStatusDto> statuses = new ArrayList<>();
        for (int i = 0; i < repeatTime; i++) {
            cars.goForwardOrStop();
            statuses.addAll(cars.getStatuses());
        }
        return statuses;
    }

}
