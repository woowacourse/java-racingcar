package racing.view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    /*
    @Test
    void requestNameTest() {
        System.out.println(Arrays.asList(", , ,,,,,ddd,,,".split(",")));
    }
    */

    @Test
    void validateNamesStringTest() {
        assertThat(InputView.validateNamesString("pobi,crong,honux")).isEqualTo(true);
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateNamesString(",,pobi");
        });
    }

    @Test
    void validateNamesListTest() {
        String[] namesString = {"pobi", "crong", ""};
        List<String> namesList = Arrays.asList(namesString);
        assertThrows(IllegalArgumentException.class, () -> {
            InputView.validateNamesList(namesList);
        });
        namesList.set(namesList.size() - 1, "honux");
        assertThat(InputView.validateNamesList(namesList)).isEqualTo(true);
    }
}
