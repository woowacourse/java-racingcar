package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameRepositoryTest {

    @DisplayName("이름 1개 또는 중복 값 처리")
    @ParameterizedTest
    @MethodSource("generateData")
    void addCarNames(List<String> carNamesInput) {
        assertThatThrownBy(() -> {
            CarNameRepository.addCarNames(carNamesInput);
        }).isInstanceOf(RuntimeException.class);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
            Arguments.of(Arrays.asList("one")),
            Arguments.of(Arrays.asList("one", "one"))
        );
    }
}
