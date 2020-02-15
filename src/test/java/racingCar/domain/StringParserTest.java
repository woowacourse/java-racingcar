package racingCar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {

    @Test
    void parseToNameList_ShouldReturnTrue() {
        List<Name> names = StringParser.parseToNameList("kueni,pobi,jason");
        List<Name> expected = new ArrayList<>();
        expected.add(new Name("kueni"));
        expected.add(new Name("pobi"));
        expected.add(new Name("jason"));
        for (int i = 0; i < names.size(); i++) {
            boolean result = names.get(i).equals(expected.get(i));
            Assertions.assertThat(result).isTrue();
        }
    }

    @Test
    void parseToNameList_ShouldReturnFalse() {
        List<Name> names = StringParser.parseToNameList("kueni,pobi,jason");
        List<Name> notExpected = new ArrayList<>();
        notExpected.add(new Name("a"));
        notExpected.add(new Name("pobi2"));
        notExpected.add(new Name("jaso"));
        for (int i = 0; i < names.size(); i++) {
            boolean result = names.get(i).equals(notExpected.get(i));
            Assertions.assertThat(result).isFalse();
        }
    }
}