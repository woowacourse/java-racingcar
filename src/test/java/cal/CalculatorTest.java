package cal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    Calculator cal;
    //테스트 코드도 중복을 제거하자.

    @BeforeEach
    void setUp(){
        cal = new Calculator();
        System.out.println("setUp");
    }

    @Test
    void 덧셈() { //테스트 코드는 예외상황 설명을 해야해서 한글을 사용하는 것이 좋지 않을까.
        assertThat(cal.plus(2,5)).isEqualTo(7); // result가 5랑 동일해야 통과할 수 있다.
        System.out.println("plus");
    }

    @Test
    void 뺄셈() {
        assertThat(cal.substract(3, 1)).isEqualTo(2);
        System.out.println("minus");
    }

    @Test
    void 곱셈() {
        assertThat(cal.multiply(3,4)).isEqualTo(12);
    }

    @Test
    void 나눗셈(){
        assertThat(cal.divide(4,2)).isEqualTo(2);
    }

    @AfterEach
    void 끝(){
        System.out.println("end");
    }
}
