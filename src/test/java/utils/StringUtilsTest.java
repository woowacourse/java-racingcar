package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

    @Test
    @DisplayName("구분자로 분리되는지 확인")
    void splitBySeparator() {
        String target = "a,b,c";

        Assertions.assertThat(StringUtils.splitBySeparator(target))
                .isEqualTo(new String[]{"a", "b", "c"});
    }
}