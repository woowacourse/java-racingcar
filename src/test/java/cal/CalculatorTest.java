package cal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
// 위와 같이 class 내부의 method를 바로 쓰기위해서 static import를 사용할 수 있다.

/*
\* Test Class는 테스트할 Production Code의 `클래스명 + Test`
 * 또한, Test Class는 패키지 또한 Production Code와 맥락을 같이 해야한다.
 * 이런 컨벤션을 지킨다면 class import 없이도 테스트를 진행할 수 있다.
 * 이런 jUnit 테스트가 main 메서드와 다른점은 자동화 및 각 기능별로 테스트를 분리할 수 있다는 점
 */
public class CalculatorTest {
    Calculator cal;

    // junit에서는 각각의 테스트 메서드가 시작, 끝날때마다 setup / tearDown을 실행하여 해당 테스트의 진행 상태값을 없앤다.
    // 모든 테스트케이스는 독립적이여야하므로 실행순서는 랜덤
    @BeforeEach
    void setUp() {
        // 각 테스트들의 초기 설정, 모든 테스트들에서 사용하는 것을 정리
        cal = new Calculator();
        System.out.println("setup");
    }

    @Test
    void 덧셈() {
        // test method는 이름을 한글로 만들어도 무방,
        // System.out.println(result); test 코드에서 콘솔에 값을 출력하는 것은 지양
        assertThat(cal.plus(2, 3)).isEqualTo(5);
        // 프로그램을 통해 콘솔로 테스팅했던 부분을 자동화
    }

    @Test
    void 뺄셈() {
        assertThat(cal.sub(5, 3)).isEqualTo(2);
    }

    @Test
    void 곱셈() {
        assertThat(cal.mul(2, 3)).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        assertThat(cal.div(6, 3)).isEqualTo(2);
    }

    @AfterEach
    void tearDown() {
        // 테스트 후처리
    }
}
