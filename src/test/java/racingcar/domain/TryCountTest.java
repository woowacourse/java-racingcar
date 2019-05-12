package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TryCountTest {
    TryCount tryCount = null;

    @BeforeEach
    void setUp() {
        tryCount = new TryCount();
    }

    @Test
    void create() {
        assertThat(new TryCount("3")).isEqualTo(new TryCount("3"));
    }

    @Test
    void 자연수가아닐때_익셉션이발생하는지_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TryCount("-2");
        });
    }

    @Test
    void 문자열을입력했을때_익셉션이발생하는지_테스트(){
        assertThrows(IllegalArgumentException.class, () -> {
            new TryCount("abcsjdsa");
        });
    }
}
