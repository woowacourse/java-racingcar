package car.domain;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NameTest {
    
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("Null 혹은 빈 문자열 일 경우 예외 발생")
    void init_NullAndEmpty_ExceptionThrown(String name) {
        
        // when
        ThrowableAssert.ThrowingCallable callable = () -> Name.from(name);
        
        // then
        assertThatIllegalArgumentException().isThrownBy(callable);
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"k", "k7", "sm7", "tico", "honda"})
    @DisplayName("정상적인 자동차 이름일 경우 정상 생성")
    void init_NullAndEmpty_ExceptionNotThrow(String name) {
        
        // when
        ThrowableAssert.ThrowingCallable callable = () -> Name.from(name);
        
        // then
        assertThatCode(callable).doesNotThrowAnyException();
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"sonata", "ferrari", "Lamborghini"})
    @DisplayName("문자열 길이 조건을 위배할 경우 예외 발생")
    void init_TooLongName_ExceptionThrown(String name) {
        
        // when
        ThrowableAssert.ThrowingCallable callable = () -> Name.from(name);
        
        // then
        assertThatIllegalArgumentException().isThrownBy(callable);
    }
}