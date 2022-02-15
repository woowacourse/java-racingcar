package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.car.CarGroup;
import racingcar.domain.car.CarStatusDto;
import racingcar.exception.RacingCarException;
import racingcar.exception.car.CarNameDuplicatedException;
import racingcar.exception.car.CarNameEmptyException;
import racingcar.exception.car.CarNameNullException;
import racingcar.exception.car.CarNameTooLongException;
import racingcar.service.picker.CustomNumberPicker;

class CarGroupTest {

    private static final String providerPath = "racingcar.domain.provider.CarGroupTestProvider#";

    private void exceptionTest(Class<? extends RacingCarException> exceptionClass, List<String> carNames) {
        assertThrows(exceptionClass, () -> new CarGroup(carNames));
    }

    @DisplayName("자동차 이름은 NULL이 될 수 없다")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForNullExceptionTest")
    void carNameNullExceptionTest(List<String> names) {
        exceptionTest(CarNameNullException.class, names);
    }

    @DisplayName("자동차 이름은 공백이 될 수 없다")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForEmptyExceptionTest")
    void carNameEmptyExceptionTest(List<String> names) {
        exceptionTest(CarNameEmptyException.class, names);
    }

    @DisplayName("자동차 이름은 5자를 넘길 수 없다")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForLengthExceptionTest")
    void carNameTooLongExceptionTest(List<String> names) {
        exceptionTest(CarNameTooLongException.class, names);
    }

    @DisplayName("자동차 이름은 중복될 수 없다")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForDuplicateExceptionTest")
    void carNamesDuplicatedExceptionTest(List<String> names) {
        exceptionTest(CarNameDuplicatedException.class, names);
    }

    @DisplayName("생성자 기능 테스트")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForConstructorTest")
    void constructorTest(List<String> names) {
        assertDoesNotThrow(() -> new CarGroup(names));
    }

    @DisplayName("라운드실행 기능 테스트")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForPlayRoundTest")
    void playRoundTest(List<String> carNames, int repeatTime, List<Integer> numbers, List<String> expected) {
        CarGroup carGroup = new CarGroup(carNames);

        List<CarStatusDto> statuses = repeatPlay(carGroup, repeatTime, numbers);

        List<String> actual = statuses.stream()
                .map(CarStatusDto::toString)
                .collect(Collectors.toUnmodifiableList());
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("우승자 선정 기능 테스트")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForGetWinnerNamesTest")
    void selectWinnersTest(List<String> carNames, int repeatTime, List<Integer> numbers, List<String> expected) {
        CarGroup carGroup = new CarGroup(carNames);

        repeatPlay(carGroup, repeatTime, numbers);

        List<String> winnerNames = carGroup.getWinnerNames();
        assertThat(winnerNames).isEqualTo(expected);
    }

    private List<CarStatusDto> repeatPlay(CarGroup carGroup, int repeatTime, List<Integer> numbers) {
        CustomNumberPicker numberPicker = new CustomNumberPicker(numbers);

        List<CarStatusDto> statuses = new ArrayList<>();
        for (int i = 0; i < repeatTime; i++) {
            carGroup.goForwardOrStop(numberPicker);
            statuses.addAll(carGroup.getStatuses());
        }
        return statuses;
    }

}
