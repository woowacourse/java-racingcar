package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnersTest {

    @DisplayName("1명 이상의 우승자가 있을 시 정생 생성된다.")
    @Test
    void Winners_1명_이상의_우승자_정상_생성된다() {
        Car pobi = new Car("pobi");
        assertThatCode(() ->
                new Winners(Collections.singletonList(pobi)))
                .doesNotThrowAnyException();
    }

    @DisplayName("우승자가 한명도 없으면 에러가 발생한다. ")
    @Test
    void Winners_우승자가_한명도_없으면_에러가_발생한다() {
        assertThatThrownBy(() -> new Winners(new ArrayList<>()))
                .isInstanceOf(IllegalStateException.class);
    }
}