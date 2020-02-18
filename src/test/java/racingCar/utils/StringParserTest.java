package racingCar.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingCar.domain.Name;
import racingCar.utils.StringParser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class StringParserTest {

    @Test
    void parseToNameList_ShouldReturnTrue() {
        // given
        String[] given = {"kueni", "pobi", "jason"};
        String input = String.join(",", given);

        // when
        List<Name> result = StringParser.parseToNameList(input);

        // then
        boolean containsAll = result.stream()
                .map(Name::toString)
                .collect(Collectors.toUnmodifiableList())
                .containsAll(Arrays.asList(given));
        Assertions.assertThat(containsAll)
                .isTrue();
        Assertions.assertThat(result.size() == given.length)
                .isTrue();
    }
}