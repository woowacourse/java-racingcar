package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class StringTest {

    @Test
    @DisplayName("스플릿 테스트")
    public void verificationSplit() {
        String testElement = "1,2";
        String[] result = testElement.split(",");
        assertThat(result).contains("1");
        assertThat(result).contains("");
    }

}
