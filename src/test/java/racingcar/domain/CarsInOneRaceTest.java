package racingcar.domain;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("경주 객체 테스트")
public class CarsInOneRaceTest {
    @ParameterizedTest
    @MethodSource("getTooLongCarNames")
    @DisplayName("5자를 넘는 이름이 하나라도 있는 경우")
    void tooLongCarNamesTest(String name1, String name2, String name3) {
        String[] names = {name1, name2, name3};
        List<String> nameList = Arrays.asList(names);

        assertThatThrownBy(() -> new CarsInOneRace(nameList))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("자동차 이름은 5자 이하여야 합니다.");
    }

    private static Stream<Arguments> getTooLongCarNames() {
        return Stream.of(
            Arguments.of("우아한형제들", "asdf", "asdf"),
            Arguments.of("yiim", "fa asdf", "adsfasdf"),
            Arguments.of("....", "a    s", "fdas")
        );
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("이름 문자열이 null 인게 하나라도 있는 경우")
    void nullNamesTest(String name) {
        String[] names = {name};
        List<String> nameList = Arrays.asList(names);

        assertThatThrownBy(() -> new CarsInOneRace(nameList))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 문자열인 이름 문자열이 하나라도 있을 때")
    void emptyNamesTest() {
        String[] names = {"", "d"};
        List<String> nameList = Arrays.asList(names);

        assertThatThrownBy(() -> new CarsInOneRace(nameList))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름들에 대한 문자열 리스트가 null 인 경우")
    void nullCarNamesListTest() {
        assertThatThrownBy(() -> new CarsInOneRace(null))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
