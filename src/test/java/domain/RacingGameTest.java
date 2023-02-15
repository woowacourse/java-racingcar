package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.util.Converter;

import java.util.List;

class RacingGameTest {

    @DisplayName("입력받은 문자열이 잘 쪼개지는지")
    @Test
    void 문자열_분리_확인() {
        String inputNames = "pobi,crong,honux";
        List<String> names = Converter.splitInput(inputNames);
        assertAll(() -> assertThat(names.get(0)).isEqualTo("pobi"),
                () -> assertThat(names.get(1)).isEqualTo("crong"),
                () -> assertThat(names.get(2)).isEqualTo("honux"));
    }
}
