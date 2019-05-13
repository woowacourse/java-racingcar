package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsNameTest {

    @Test
    void 공백_제거_확인() {
        String inputText = "   pobi,     crong";
        String[] result = CarsName.makeCarsName(inputText);
        String[] expectedResult = {"pobi", "crong"};
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 중복된_콤마_제거_확인() {
        String inputText = "pobi,,,,crong";
        String[] result = CarsName.makeCarsName(inputText);
        String[] expectedResult = {"pobi", "crong"};
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void 자동차_이름_배열_생성_확인() {
        String inputText = " pobi, crong, honux";
        String[] result = CarsName.makeCarsName(inputText);
        String[] expectedResult = {"pobi", "crong", "honux"};
        assertThat(result).isEqualTo(expectedResult);
    }
}
