package racingTest;

import org.junit.jupiter.api.Test;
import racing.model.RandomNo;

import static org.assertj.core.api.Assertions.assertThat;


public class RandomNoTest {

    @Test
    void 랜덤_넘버_숫자_확인(){
        RandomNo randomNo = new RandomNo(4);
        int result = randomNo.getNumber();
        assertThat(result).isEqualTo(4);
    }
}
