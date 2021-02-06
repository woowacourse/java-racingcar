package car.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {
    
    @Test
    @DisplayName("음수일 경우 예외 발생")
    void init_NegativeNumber_ExceptionThrown() {
        
        // given
        final int position = -1;
        
        // when
        ThrowableAssert.ThrowingCallable callable = () -> Position.from(position);
        
        // then
        assertThatIllegalArgumentException().isThrownBy(callable);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    @DisplayName("음수가 아닐 경우 정상 생성")
    void init_NotNegativeNumber_ExceptionNotThrown(final int position) {
        
        // when
        ThrowableAssert.ThrowingCallable callable = () -> Position.from(position);
        
        // then
        assertThatCode(callable).doesNotThrowAnyException();
    }
}