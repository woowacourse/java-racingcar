package cal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StrCalculatorTest {
    StrCalculator strCalculator;

    @BeforeEach
    void setUp() {
        strCalculator = new StrCalculator();
    }

    @Test
    void 사칙연산확인() {
        String[] input = {"1", "+", "1", "*", "100", "/", "50", "-", "4"};
        strCalculator.values = input;

        assertThat(strCalculator.calculate()).isEqualTo(0);
    }

    @Test
    void 연산자와피연산자의총합이홀수인예외확인() {
        String[] input = {"-1", "+"};
        strCalculator.values = input;

        assertThat(strCalculator.expressionIsOdd()).isEqualTo(true);
    }

    @Test
    void 짝수인덱스확인() {
        String[] input = {"-1", "+", "2", "-", "4", "*", "2", "/", "1"};
        assertThat(strCalculator.isEvenPositionMatch(input)).isEqualTo(true);
    }

    @Test
    void 짝수인덱스연산자예외확인() {
        String[] arr = {"-1", "+", "-"};
        assertThat(strCalculator.isEvenPositionMatch(arr)).isEqualTo(false);
    }

    @Test
    void 짝수인덱스없는값예외확인() {
        String[] arr = {""};
        assertThat(strCalculator.isEvenPositionMatch(arr)).isEqualTo(false);
    }

    @Test
    void 짝수인덱스널예외확인() {
        String[] arr = {"-1", "+", "2", "-", null};
        assertThat(strCalculator.isEvenPositionMatch(arr)).isEqualTo(false);
    }

    @Test
    void 홀수인덱스확인() {
        String[] input = {"-1", "+", "2", "-", "4", "*", "2", "/", "1"};
        assertThat(strCalculator.isOddPositionMatch(input)).isEqualTo(true);
    }


    @Test
    void 홀수인덱스없는값예외확인() {
        String[] input = {"-1", "+", "2", "-", ""};
        assertThat(strCalculator.isOddPositionMatch(input)).isEqualTo(false);
    }

    @Test
    void 홀수인덱스에연산자가아닌숫자예외확인() {
        String[] input = {"-1", "1", "2"};
        assertThat(strCalculator.isOddPositionMatch(input)).isEqualTo(false);
    }

    @Test
    void 홀수인덱스널예외확인() {
        String[] input = {"-1", "+", "2", "-", null};
        assertThat(strCalculator.isOddPositionMatch(input)).isEqualTo(false);
    }

    @Test
    void 출력문자열확인() {
        String[] input = {"-1", "+", "2"};
        strCalculator.values = input;

        assertThat(strCalculator.makeResultSentence(1)).isEqualTo("-1 + 2 의 결과는 1");
    }
}