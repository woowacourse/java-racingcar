package racingcar.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarNameParserTest {

    private CarNameParser parser;

    @BeforeEach
    void setUp() {
        parser = new CarNameParser();
    }

    @Test
    public void 컴마로_자동차_이름_분리() {
        List<String> expect = parser.parse("pobi,crong,honux");
        assertThat(expect).containsExactly("pobi", "crong", "honux");
    }

    @Test
    public void 이름이_6글자_이상인_경우_예외_발생() {
        assertThatThrownBy(() -> parser.parse("pobi,crong,honuxx"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(CarNameParser.INVALID_LENGTH_ERROR_MESSAGE);
    }

    @Test
    public void 이름이_공백일_경우_예외_발생() {
        assertThatThrownBy(() -> parser.parse("pobi,,honux"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(CarNameParser.EMPTY_NAME_ERROR_MESSAGE);
    }

    @Test
    public void 이름이_중복일_경우_예외_발생() {
        assertThatThrownBy(() -> parser.parse("pobi,pobi,honux"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(CarNameParser.DUPLICATE_NAME_ERROR_MESSAGE);
    }
}