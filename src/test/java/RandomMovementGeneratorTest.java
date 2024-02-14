import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomMovementGeneratorTest {
    @Test
    @DisplayName("랜덤 이동 생성")
    void create() {
        assertThatCode(() -> new RandomMovementGenerator(new RandomNumberGenerator())).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("4이상의 숫자면 이동이 참임을 반환한다.")
    void generate() {
//        RandomMovementGenerator randomMovementGenerator = new RandomMovementGenerator();
//        assertThat(randomMovementGenerator.generate()).isTrue();
    }
}
