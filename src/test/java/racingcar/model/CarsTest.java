package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.FixedNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("자동차 이름에 중복이 존재하는 경우 예외처리")
    void duplicateCarNamesException() {
        final List<Name> names = Stream.of("aaa", "bbb", "aaa")
                .map(Name::new)
                .collect(Collectors.toList());

        assertThatThrownBy(() ->
                new Cars(names.stream()
                        .map(Car::new)
                        .collect(Collectors.toList())))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("자동차 전체 비전진")
    void moveCarsNonforward(int number) {
        final List<Name> names = Stream.of("aaa", "bbb", "ccc")
                .map(Name::new)
                .collect(Collectors.toList());

        final Cars cars = new Cars(names.stream()
                .map(Car::new)
                .collect(Collectors.toList()));

        final FixedNumberGenerator fixedNumber = new FixedNumberGenerator(number);

        cars.moveAll(fixedNumber);

        assertThat(cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .sum()).isZero();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("자동차 전체 전진")
    void moveCarsForward(int number) {
        final List<Name> names = Stream.of("aaa", "bbb", "ccc")
                .map(Name::new)
                .collect(Collectors.toList());

        final Cars cars = new Cars(names.stream()
                .map(Car::new)
                .collect(Collectors.toList()));

        final FixedNumberGenerator fixedNumber = new FixedNumberGenerator(number);
        final int expected = cars.getCars().size();

        cars.moveAll(fixedNumber);

        assertThat(cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .sum()).isEqualTo((expected));
    }
}
