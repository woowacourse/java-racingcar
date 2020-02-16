package racingTest;

import org.junit.jupiter.api.Test;
import racing.model.RandomNo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RandomNoTest {

    @Test
    void 랜덤넘버_4이상일_경우_true_반환(){
        RandomNo randomNo = mock(RandomNo.class);

        when(randomNo.isMovable()).thenReturn(true);
        assertThat(randomNo.isMovable()).isTrue();
    }
}
