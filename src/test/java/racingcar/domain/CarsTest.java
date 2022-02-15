package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.car.CarStatusDto;
import racingcar.domain.car.Cars;
import racingcar.exception.WrongArgumentException;
import racingcar.service.picker.CustomNumberPicker;

class CarsTest {

    private static final String providerPath = "racingcar.domain.provider.CarsTestProvider#";

    private void exceptionTest(List<String> carNames) {
        assertThrows(WrongArgumentException.class, () -> new Cars(carNames));
    }

    @DisplayName("자동차 이름은 NULL이 될 수 없다")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForNullExceptionTest")
    void carNameNullExceptionTest(List<String> names) {
        exceptionTest(names);
    }

    @DisplayName("자동차 이름은 공백이 될 수 없다")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForEmptyExceptionTest")
    void carNameEmptyExceptionTest(List<String> names) {
        exceptionTest(names);
    }

    @DisplayName("자동차 이름은 5자를 넘길 수 없다")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForLengthExceptionTest")
    void carNameTooLongExceptionTest(List<String> names) {
        exceptionTest(names);
    }

    @DisplayName("자동차 이름은 중복될 수 없다")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForDuplicateExceptionTest")
    void carNamesDuplicatedExceptionTest(List<String> names) {
        exceptionTest(names);
    }

    @DisplayName("생성자 기능 테스트")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForConstructorTest")
    void constructorTest(List<String> names) {
        assertDoesNotThrow(() -> new Cars(names));
    }

    @DisplayName("라운드실행 기능 테스트")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForPlayRoundTest")
    void playRoundTest(List<String> carNames, int repeatTime, List<Integer> numbers, List<String> expected) {
        Cars cars = new Cars(carNames);

        List<CarStatusDto> statuses = repeatPlay(cars, repeatTime, numbers);

        List<String> actual = statuses.stream()
                .map(CarStatusDto::toString)
                .collect(Collectors.toUnmodifiableList());
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("우승자 선정 기능 테스트")
    @ParameterizedTest
    @MethodSource(providerPath + "provideForGetWinnerNamesTest")
    void selectWinnersTest(List<String> carNames, int repeatTime, List<Integer> numbers, List<String> expected) {
        Cars cars = new Cars(carNames);

        repeatPlay(cars, repeatTime, numbers);

        List<String> winnerNames = cars.getWinnerNames();
        assertThat(winnerNames).isEqualTo(expected);
    }

    private List<CarStatusDto> repeatPlay(Cars cars, int repeatTime, List<Integer> numbers) {
        CustomNumberPicker numberPicker = new CustomNumberPicker(numbers);

        List<CarStatusDto> statuses = new ArrayList<>();
        for (int i = 0; i < repeatTime; i++) {
            cars.goForwardOrStop(numberPicker);
            statuses.addAll(cars.getStatuses());
        }
        return statuses;
    }

}
