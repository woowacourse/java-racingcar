package study;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ExceptionAssertionStudyTest {

    private void throwIllegalStateException() {
        throw new IllegalStateException("예외 1번");
    }

    @Test
    void exceptionTest_1() {
        assertThatThrownBy(this::throwIllegalStateException)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("예외 1번")
                .hasMessageContaining("1번")
                .hasMessageEndingWith("1번");
    }

    @Test
    void exceptionTest_2() {
        assertThatExceptionOfType(IllegalStateException.class).isThrownBy(() -> throwIllegalStateException())
                .withMessage("예외 1번")
                .withMessageContaining("예외")
                .withMessageContaining("1번")
                .withMessageStartingWith("예외")
                .withMessageEndingWith("1번");
    }

    /**
     * 아래 Exception들 미리 제공
     * assertThatNullPointerException
     * assertThatIllegalArgumentException
     * assertThatIllegalStateException
     * assertThatIOException
     */
    @Test
    void exceptionTest_3() {
        assertThatIllegalStateException().isThrownBy(this::throwIllegalStateException)
                .withMessage("예외 1번")
                .withMessageContaining("예외")
                .withMessageContaining("1번")
                .withMessageStartingWith("예외")
                .withMessageEndingWith("1번");
    }

    @Test
    void notExceptionTest() {
        assertThatNoException().isThrownBy(AssertJWithIterableStudyTest::members);
    }
}
