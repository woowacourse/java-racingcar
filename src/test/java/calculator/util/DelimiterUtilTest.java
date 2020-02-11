package calculator.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DelimiterUtilTest {
    @Test
    void 올바른_입력() {
        String[] value = StringUtil.parseString("1,2:3");
        assertArrayEquals(value,new String[]{"1","2","3"});

        value = StringUtil.parseString("//;\n1;2;3");
        System.out.println(value);
        assertArrayEquals(value,new String[]{"1","2","3"});
    }

    @Test
    void 올바르지_않은_입력() {
        assertThatThrownBy(() -> {
            StringUtil.parseString("//;1;2;3");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("입력이 잘못 되었습니다.");

        assertThatThrownBy(() -> {
            StringUtil.parseString("//;asdf1;2;3");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("입력이 잘못 되었습니다.");
    }
}