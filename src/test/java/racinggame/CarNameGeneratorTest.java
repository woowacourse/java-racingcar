package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarNameGeneratorTest {

    CarNameGenerator cng;

    @BeforeEach
    void setUp() {
        cng = new CarNameGenerator();
    }

    @Test
    void 자동차_이름_생성_확인() {
        String[] result = {"pobi", "crong", "honux"};
        assertThat(cng.createCarsName("pobi,  , , crong, honux")).isEqualTo(result);
    }
}
