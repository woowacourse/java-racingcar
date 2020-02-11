package calculator.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DelimiterUtilTest {
    @Test
    void 올바른_입력() {
        String[] value = DelimiterUtil.parseString("1,2:3");
        assertArrayEquals(value,new String[]{"1","2","3"});

        value = DelimiterUtil.parseString("//;\n1;2;3");
        System.out.println(value);
        assertArrayEquals(value,new String[]{"1","2","3"});
    }

    @Test
    void 올바르지_않은_입력() {
        assertThatThrownBy(() -> {
            DelimiterUtil.parseString("//;1;2;3");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("입력이 잘못 되었습니다.");

        assertThatThrownBy(() -> {
            DelimiterUtil.parseString("//;asdf1;2;3");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("입력이 잘못 되었습니다.");
    }
}