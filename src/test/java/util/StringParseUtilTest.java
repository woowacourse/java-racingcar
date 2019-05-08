package util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringParseUtilTest {
    @Test
    void 문자열나누기() {
        List<String> testList = Arrays.asList("스폰지밥,징징이,뚱이");
        assertThat(StringParseUtil.parseStringByComma("스폰지밥,징징이,뚱이")).isEqualTo(testList);
    }
}
