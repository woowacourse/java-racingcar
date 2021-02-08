package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class CarsTest {
    @DisplayName("쉼표도 구분된 문자열이 생성자의 인자로 들어오면 정상 실행된다")
    @Test
    void Cars_쉼표로_구분된_문자열_받으면_객체가_생성된다() {
        String carNames = "pobi,brown";
        assertThatCode(() -> Cars.generate(carNames))
                .doesNotThrowAnyException();
    }

    @DisplayName("유효하지 않은 문자열이 들어오면 에러가 발생한다")
    @Test
    void Cars_잘못된_이름이_포함된_문자열_받으면_예외가_발생한다() {
        String carNames = "pobi,bro.wn,";
        assertThatCode(() -> {
            Cars.generate(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Cars의 변수로 할당될 Car객체가 하나인경우 에러가 발생한다")
    @Test
    void Cars_1명인_경우_예외가_발생한다() {
        String carNames = "pobi";
        assertThatCode(() -> {
            Cars.generate(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}