package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.car.CarCollection;
import racingcar.domain.car.CarStatusDto;
import racingcar.exception.car.CarNameDuplicatedException;
import racingcar.exception.car.CarNameEmptyException;
import racingcar.exception.car.CarNameNullException;
import racingcar.exception.car.CarNameTooLongException;
import racingcar.service.picker.CustomNumberPicker;


@SuppressWarnings("NonAsciiCharacters")
public class CarCollectionTest {

    private void exceptionTest(Class throwableClass, List<String> carNames) {
        assertThrows(throwableClass, () -> new CarCollection(carNames)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValuesForLengthException")
    void 자동차이름_길이_예외처리(List<String> names) {
        exceptionTest(CarNameTooLongException.class, names);
    }

    public static Stream<Arguments> provideValuesForLengthException() {
        return Stream.of(
            Arguments.of(Arrays.asList("slow", "if", "hanull")),
            Arguments.of(Arrays.asList("sinb57", "slow", "if")),
            Arguments.of(Arrays.asList("sinb57", "slow", "if", "hanull"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideValuesForNullException")
    void 자동차이름_null_예외처리(List<String> names) {
        exceptionTest(CarNameNullException.class, names);
    }

    public static Stream<Arguments> provideValuesForNullException() {
        return Stream.of(
                Arguments.of(Arrays.asList("if", null, "hanul")),
                Arguments.of(Arrays.asList("if", "hanul", null))
        );
    }

    @ParameterizedTest
    @MethodSource("provideValuesForEmptyException")
    void 자동차이름_공백_예외처리(List<String> names) {
        exceptionTest(CarNameEmptyException.class, names);
    }

    public static Stream<Arguments> provideValuesForEmptyException() {
        return Stream.of(
                Arguments.of(Arrays.asList("")),
                Arguments.of(Arrays.asList("if", "hanul", ""))
        );
    }

    @ParameterizedTest
    @MethodSource("provideValuesForDuplicateException")
    void 자동차이름_중복_예외처리(List<String> names) {
        exceptionTest(CarNameDuplicatedException.class, names);
    }

    public static Stream<Arguments> provideValuesForDuplicateException() {
        return Stream.of(
            Arguments.of(Arrays.asList("slow", "if", "slow")),
            Arguments.of(Arrays.asList("slow", "if", "test", "test")));
    }

    @ParameterizedTest
    @MethodSource("provideValuesForPlayRoundTest")
    void 라운드실행_정상작동테스트(List<String> carNames, int time, List<Integer> numbers, List<String> expected) {
        CarCollection carCollection = new CarCollection(carNames);
        CustomNumberPicker customNumberPicker = new CustomNumberPicker(numbers);

        List<CarStatusDto> statuses = new ArrayList<>();
        for (int i = 0; i < time; i++) {
            carCollection.goForwardOrStop(customNumberPicker);
            statuses.addAll(carCollection.getStatuses());
        }

        List<String> actual = statuses.stream()
                .map(CarStatusDto::toString)
                .collect(Collectors.toList());
        assertThat(actual).isEqualTo(expected);
    }

    public static Stream<Arguments> provideValuesForPlayRoundTest() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("slow", "if", "poby"),
                        1,
                        Arrays.asList(0,5,8),
                        Arrays.asList("slow : ", "if : -", "poby : -")),
                Arguments.of(
                        Arrays.asList("slow", "if", "poby"),
                        2,
                        Arrays.asList(0,5,8, 7,3,4),
                        Arrays.asList(
                                "slow : ", "if : -", "poby : -",
                                "slow : -", "if : -", "poby : --"))
        );
    }

    @ParameterizedTest
    @MethodSource("provideValuesForGetWinnerNamesTest")
    void 우승자선정_정상작동테스트(List<String> carNames, int time, List<Integer> numbers, List<String> expected) {
        CarCollection carCollection = new CarCollection(carNames);
        CustomNumberPicker customNumberPicker = new CustomNumberPicker(numbers);

        for (int i = 0; i < time; i++) {
            carCollection.goForwardOrStop(customNumberPicker);
        }
        List<String> winnerNames = carCollection.getWinnerNames();
        assertThat(winnerNames).isEqualTo(expected);
    }

    public static Stream<Arguments> provideValuesForGetWinnerNamesTest() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("slow", "if", "poby"),
                        1,
                        Arrays.asList(0,5,8),
                        Arrays.asList("if", "poby")),
                Arguments.of(
                        Arrays.asList("slow", "if", "poby"),
                        2,
                        Arrays.asList(0,5,8, 7,3,4),
                        Arrays.asList("poby"))
        );
    }

}
