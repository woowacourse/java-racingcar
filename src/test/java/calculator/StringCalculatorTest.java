package calculator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    
    @ParameterizedTest
    @DisplayName("null 또는 빈 문자열일 경우 0 반환")
    @NullAndEmptySource
    void splitAndSum_nullOrEmpty_returnZero(String input) {
        
        // when
        int result = StringCalculator.splitAndSum(input);
        
        // then
        assertThat(result).isEqualTo(0);
    }
    
    @Test
    @DisplayName("숫자 하나 입력 시 그 숫자 반환")
    void splitAndSum_OnlyOneNumber_Number() {
        
        // given
        final String input = "1";
        
        // when
        int result = StringCalculator.splitAndSum(input);
        
        // then
        assertThat(result).isEqualTo(1);
    }
    
    @Test
    @DisplayName("기본 구분자 하나 입력 시 덧셈 계산")
    void splitAndSum_DefaultDelimiter_SummedNumber() {
        
        // given
        final String input = "1,2";
        
        // when
        int result = StringCalculator.splitAndSum(input);
        
        // then
        assertThat(result).isEqualTo(3);
    }
    
    @Test
    @DisplayName("여러 구분자 입력 시 덧셈 계산")
    void splitAndSum_DefaultDelimiters_SummedNumber() {
        
        // given
        final String input = "1,2:3";
        
        // when
        int result = StringCalculator.splitAndSum(input);
        
        // then
        assertThat(result).isEqualTo(6);
    }
    
    @Test
    @DisplayName("커스텀 구분자 입력 시 덧셈 계산")
    void splitAndSum_CustomDelimiter_SummedNumber() {
        
        // given
        final String input = "//;\n1;2;3";
        
        // when
        int result = StringCalculator.splitAndSum(input);
        
        // then
        assertThat(result).isEqualTo(6);
    }
    
    @Test
    @DisplayName("음수 존재 시 예외를 던짐")
    void splitAndSum_Negative_ExceptionThrown() {
        
        // given
        final String input = "-1,2,3";
        
        
        // when
        final ThrowableAssert.ThrowingCallable callable = () -> StringCalculator.splitAndSum(input);
        
        // then
        assertThatThrownBy(callable).isInstanceOf(RuntimeException.class);
    }
    
    @Test
    @DisplayName("두 자리 숫자들 덧셈 계산")
    void splitAndSum_TwoDigitNumber_SummedNumber() {
        
        // given
        final String input = "15,16";
        
        // when
        int result = StringCalculator.splitAndSum(input);
        
        // then
        assertThat(result).isEqualTo(31);
    }
    
    @Test
    @DisplayName("마이너스 커스텀 구분자 입력 시 덧셈 계산")
    void splitAndSum_MinusCustomDelimiter_SummedNumber() {
        
        // given
        final String input = "//-\n1:2,3";
        
        // when
        int result = StringCalculator.splitAndSum(input);
        
        // then
        assertThat(result).isEqualTo(6);
    }
    
    @Test
    @DisplayName("숫자없이 커스텀 구분자만 존재 시 0 반환")
    void splitAndSum_OnlyCustomDelimiter_Zero() {
        
        // given
        final String input = "//;\n";
        
        // when
        int result = StringCalculator.splitAndSum(input);
        
        // then
        assertThat(result).isEqualTo(0);
    }
}
