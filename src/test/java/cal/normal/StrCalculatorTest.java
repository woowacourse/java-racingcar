package cal.normal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StrCalculatorTest {
    StrCalculator strCalculator;
    @BeforeEach
    public void setUp(){
        strCalculator = new StrCalculator();
    }

    @Test
    void 계산1더하기1() {
        String[] arr = {"1", "+", "1"};
        strCalculator.values = arr;

        assertThat(strCalculator.calculate()).isEqualTo(2);
    }

    @Test
    void 사칙연산한번씩다해보기() {
        String[] arr = {"1", "+", "1", "*", "100", "/", "50", "-"};
        strCalculator.values = arr;

        assertThat(strCalculator.calculate()).isEqualTo(0);
    }

    @Test
    void 짝수숫자확인1() {
        String[] arr = {"-1", "+", "2", "1", "-"};
        assertThat(strCalculator.isEvenPositionMatch(arr)).isEqualTo(false);
    }

    @Test
    void 짝수숫자확인2() {
        String[] arr = {"-1", "+", "2", "1", "5"};
        assertThat(strCalculator.isEvenPositionMatch(arr)).isEqualTo(true);
    }

    @Test
    void 홀수위치연산자확인1() {
        String[] arr = {"1", "+", "2", "-", "3", "*", "4", "/"};
        assertThat(strCalculator.isOddPositionMatch(arr)).isEqualTo(true);
    }

    @Test
    void 홀수위치연산자확인2() {
        String[] arr = {"1", "+", "2", "-", "3", "*", "4", "a"};
        assertThat(strCalculator.isOddPositionMatch(arr)).isEqualTo(false);
    }
}