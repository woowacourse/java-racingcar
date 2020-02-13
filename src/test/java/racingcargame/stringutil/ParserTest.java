package racingcargame.stringutil;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcargame.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ParserTest {
    @Test
    void 이름을_입력하면_구분자로_구분하여_CarList_생성() {
        List<Car> actual = Parser.parseCars("a, b, c");
        List<Car> expected = Arrays.asList(new Car("a"),
                new Car("b"),
                new Car("c"));
        assertThat(actual).isEqualTo(actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "4:4", "5:5", "6:6"}, delimiter = ':')
    void String을_입력받아_round횟수를_반환(String string, int expected) {
        int actual = Parser.parseRound(string);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 음수를_입력하면_예외발생() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Parser.parseRound("-3"));
    }
}
