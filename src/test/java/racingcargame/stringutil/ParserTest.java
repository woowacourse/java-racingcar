package racingcargame.stringutil;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcargame.domain.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserTest {
    @Test
    void 이름을_입력하면_구분자로_구분하여_CarList_생성() {
        List<Car> actual = Parser.parseCars("a, b, c");
        List<Car> expected = Arrays.asList(new Car("a"),
                new Car("b"),
                new Car("c"));
        Assertions.assertThat(actual).isEqualTo(actual);
    }
}
