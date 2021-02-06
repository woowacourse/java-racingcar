package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnersTest {

    @Test
    void Winners_1명_이상의_우승자_정상_생성된다() {
        Car pobi = new Car("pobi");
        assertThatCode(() ->
                new Winners(new ArrayList<>(Arrays.asList(pobi))))
                .doesNotThrowAnyException();
    }

    @Test
    void Winners_우승자가_한명도_없으면_에러가_발생한다() {
        assertThatThrownBy(() -> new Winners(new ArrayList<>()))
                .isInstanceOf(IllegalStateException.class);
    }
}