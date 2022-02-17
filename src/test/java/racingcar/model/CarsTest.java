package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("자동차 이름에 중복이 존재하는 경우 예외처리")
    void duplicateCarNamesException() {
        List<Name> names = Stream.of("aaa", "bbb", "aaa")
                .map(Name::new)
                .collect(Collectors.toList());

        assertThatThrownBy(() ->
                new Cars(names.stream()
                        .map(Car::new)
                        .collect(Collectors.toList())))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }
}
