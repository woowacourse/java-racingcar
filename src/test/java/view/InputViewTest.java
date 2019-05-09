package view;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {

    @Test
    void 문자열을받아서자동차이름리스트() {
        List<String> resultList = Arrays.asList("pobi", "crong", "honux");
        assertThat(InputView.getCarNames("pobi,crong,honux")).isEqualTo(resultList);
    }
}
