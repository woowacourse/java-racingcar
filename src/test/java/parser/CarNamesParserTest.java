package parser;

import domain.CarName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarNameParserTest {
    @Test
    void parseCarNames_() {
        String input = "a,b,c";

        assertThat(CarNameParser.parseCarNames(input)).isEqualTo(
                generateCarNames(Arrays.asList("a", "b", "c")));
    }

    @Test
    void parseCarNames_쉼표사이에_공백존재() {
        String input = "a ,b, c";

        assertThat(CarNameParser.parseCarNames(input)).isEqualTo(
                generateCarNames(Arrays.asList("a", "b", "c")));
    }

    private List<CarName> generateCarNames(List<String> names) {
        return names.stream()
                .map(CarName::from)
                .collect(Collectors.toList());
    }
}