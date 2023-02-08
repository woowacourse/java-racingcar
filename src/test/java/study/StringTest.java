package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("split 메소드 - 숫자 두 개 입력")
    void splitTestWithTwoNumbers() {
        String target = "1,2";
        assertThat(target.split(",")).containsExactly("1", "2");
    }

}
