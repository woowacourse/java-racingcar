package game.input;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputTest {
    UserInputCheck userInputCheck;

    @BeforeEach
    void setUp() {
        userInputCheck = new UserInputCheck();
    }

    @Test
    void 문자열_공백_중복쉼표_제거() {
        String result = userInputCheck.removeBlankAndDoubleComma("  crong, ,pobi  ");
        assertThat(result).isEqualTo("crong,pobi");
    }

    @Test
    void 문자열_콤마_기준으로_분할() {
        String[] result = userInputCheck.splitWithComma("pobi,crong,honux");
        String[] answer = {"pobi", "crong", "honux"};
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 자동차_이름_길이_5이하_확인() {
        String[] carNames = {"pobi", "crong"};
        boolean result = userInputCheck.checkCarNamesLength(carNames);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 자동차_이름_길이_5초과_확인() {
        String[] carNames = {"pobico", "crong"};
        boolean result = userInputCheck.checkCarNamesLength(carNames);
        assertThat(result).isEqualTo(false);
    }
}
