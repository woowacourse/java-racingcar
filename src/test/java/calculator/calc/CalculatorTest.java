package calculator.calc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("setUp");            // 테스트 코드가 실행되는 순서를 확인하기 위한 출력 코드
    }

    @Test
    void 덧셈() {
        assertThat(calculator.plus(2, 3)).isEqualTo(5);
        System.out.println("plus");             // 테스트 코드가 실행되는 순서를 확인하기 위한 출력 코드
    }

    @Test
    void 뺄셈() {
        assertThat(calculator.minus(3, 2)).isEqualTo(1);
        System.out.println("minus");            // 테스트 코드가 실행되는 순서를 확인하기 위한 출력 코드
    }

    @AfterEach
    void testDown() {
        System.out.println("testDown");         // 테스트 코드가 실행되는 순서를 확인하기 위한 출력 코드
    }
}