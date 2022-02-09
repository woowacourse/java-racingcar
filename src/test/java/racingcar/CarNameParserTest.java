package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarNameParserTest {
    @Test
    public void parse_name_by_comma() {
        CarNameParser parser = new CarNameParser();
        List<Car> expect = parser.parse("pobi,crong,honux");
        assertThat(expect).containsExactly(Car.from("pobi"), Car.from("crong"), Car.from("honux"));
    }


}
