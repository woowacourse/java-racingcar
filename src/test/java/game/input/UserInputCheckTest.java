package game.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputCheckTest {

    @Test
    void 문자열_공백_중복_제거() {
        String[] result = UserInputCheck.checkCarNames("  crong, pobi  ");
        String[] answer = {"crong", "pobi"};
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 문자열_콤마_기준으로_분할() {
        String[] result = UserInputCheck.checkCarNames("pobi,crong,honux");
        String[] answer = {"pobi", "crong", "honux"};
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 자동차_이름_길이_5이하_확인() {
        String[] result = UserInputCheck.checkCarNames("pobi,crong");
        String[] answer = {"pobi", "crong"};
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void 자동차_이름_공백_확인_1() {
        String[] result = UserInputCheck.checkCarNames("pobi,,,crong");
        assertThat(result).isNull();
    }

    @Test
    void 자동차_이름_공백_확인_2() {
        String[] result = UserInputCheck.checkCarNames(",,,");
        assertThat(result).isNull();
    }

    @Test
    void 자동차_이름_길이_5초과_확인() {
        String[] result = UserInputCheck.checkCarNames("pobico,crong");
        assertThat(result).isNull();
    }
}
