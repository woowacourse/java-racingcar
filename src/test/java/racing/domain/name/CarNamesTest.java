package racing.domain.name;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class CarNamesTest {
    @DisplayName("쉼표도 구분된 문자열이 생성자의 인자로 들어오면 정상 실행된다")
    @Test
    void CarNames_쉼표로_구분된_문자열_받으면_객체가_생성된다() {
        String carNames = "pobi,brown";
        assertThatCode(() -> CarNames.of(carNames))
                .doesNotThrowAnyException();
    }

    @DisplayName("유효하지 않은 문자열이 들어오면 에러가 발생한다")
    @Test
    void CarNames_잘못된_이름이_포함된_문자열_받으면_예외가_발생한다() {
        String carNames = "pobi,bro.wn,";
        assertThatCode(() -> {
            CarNames.of(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("빈 문자열이 들어오면 에러가 발생한다")
    @Test
    void CarNames_빈_문자열_에러가_발생한다() {
        String carNames = "";
        assertThatCode(() -> {
            CarNames.of(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 문자열이 들어오면 에러가 발생한다")
    @Test
    void CarNames_중복된_문자열_에러가_발생한다() {
        String carNames = "pobi,pobi,brown";
        assertThatCode(() -> {
            CarNames.of(carNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복될 수 없습니다.");
    }
}