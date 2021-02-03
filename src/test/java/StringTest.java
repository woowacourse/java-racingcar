import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringTest {
    @Test
    void split() {
        String value = "1,2";
        String separator = ",";

        int testIndexOne = 0;
        int testIndexTwo = 1;

        String expectResultOne = "1";
        String expectResultTwo = "2";

        assertThat(value.split(separator)[testIndexOne]).contains(expectResultOne);
        assertThat(value.split(separator)[testIndexTwo]).contains(expectResultTwo);

        assertThat(value.split(separator)).containsExactly(expectResultOne, expectResultTwo);
    }
}
