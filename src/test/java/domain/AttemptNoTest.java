package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.*;

public class AttemptNumberTest {
    @Test
    void createAttemptNumber_적합한_횟수() {
        new AttemptNumber("1");
    }

    @Test
    void createAttemptNumber_부적합한_횟수_문자() {
        assertThatThrownBy(() -> new AttemptNumber("타미"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createAttemptNumber_부적합한_횟수_음수() {
        assertThatThrownBy(() -> new AttemptNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isEndTest_성공() {
        assertThat(new AttemptNumber("1").isEnd()).isTrue();
    }

    @Test
    void isEndTest_실패() {
        assertThat(new AttemptNumber("0").isEnd()).isFalse();
    }

}
