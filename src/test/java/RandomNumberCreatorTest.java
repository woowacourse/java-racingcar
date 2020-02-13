import org.junit.jupiter.api.Test;
import racingCar.domain.RandomNumberCreator;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberCreatorTest {

    @Test
    void 생성한_랜덤_숫자가_0에서_9사이이다() {
        int randomNumber = RandomNumberCreator.create();
        assertThat(randomNumber).isBetween(0,9);
    }
}
