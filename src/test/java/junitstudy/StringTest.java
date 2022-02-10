package junitstudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.StringTokenizer;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void splitTest() {
        String testString1 = "1,2";
        String testString2 = "1";

        String[] result1 = testString1.split(",");
        String[] result2 = testString2.split(",");

        assertThat(result1).containsExactly("1", "2");
        assertThat(result2).containsExactly("1");
    }
}
