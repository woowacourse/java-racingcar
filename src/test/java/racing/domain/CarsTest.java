package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class CarsTest {
    @Test
    void Cars_쉼표로_구분된_문자열_받으면_객체가_생성된다() {
        String carNames = "pobi,brown";
        assertThatCode(() -> Cars.generate(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    void Cars_잘못된_이름이_포함된_문자열_받으면_예외가_발생한다() {
        String carNames = "pobi,bro.wn,";
        assertThatCode(() -> {
            Cars.generate(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void Cars_1명인_경우_예외가_발생한다() {
        String carNames = "pobi";
        assertThatCode(() -> {
            Cars.generate(carNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}