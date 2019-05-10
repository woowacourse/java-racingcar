package textCalculaotr.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserInputCheckTest {

    @Test
    void 공백으로_잘라_배열_생성() {
        String[] result = UserInputCheck.splitByBlank("1 + 2 + 3");
        String[] target = {"1", "+" ,"2", "+", "3"};
        assertThat(result).isEqualTo(target);
    }
}
