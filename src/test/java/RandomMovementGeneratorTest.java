import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import domain.RandomMovementGenerator;
import domain.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomMovementGeneratorTest {
    @Test
    @DisplayName("랜덤 이동 생성")
    void create() {
        //given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        RandomMovementGenerator randomMovementGenerator = new RandomMovementGenerator(randomNumberGenerator);
        //when
        //then
//        assertThat( >= 4).isEqualTo(randomMovementGenerator.generate());
    }
}