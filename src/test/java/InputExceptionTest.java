import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputExceptionTest {
    InputException inputException;

    @BeforeEach
    void setUp() {
        inputException = new InputException();
    }

    @Test
    void checkCarNameLength() {
        assertThatThrownBy(() -> {
            inputException.checkCarNameLength("우아한테크코스");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkInputCountLength() {
        assertThatThrownBy(() -> {
            inputException.checkInputCountLength(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}