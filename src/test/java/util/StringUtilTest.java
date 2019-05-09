package util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringUtilTest {
    @Test
    void 문자열나누기() {
        List<String> testList = Arrays.asList("스폰지밥", "징징이", "뚱이");
        assertThat(StringUtil.parseStringByComma("스폰지밥,징징이,뚱이")).isEqualTo(testList);
    }

    @Test
    void 자동차이름길이() {
        assertThat(StringUtil.isCarNameLength("aaaaa")).isTrue();
        assertThat(StringUtil.isCarNameLength("aaaaaa")).isFalse();
    }
}
