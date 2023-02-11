package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RacingCarApplicationTest {

    @Test
    @DisplayName("게임이 정상적으로 실행되는지 테스트한다")
    void runGame() {
        final RacingCarApplication racingCarApplication = mock(RacingCarApplication.class);

        InputStream nameInput = new ByteArrayInputStream("gavi,jude".getBytes());
        InputStream repeatsInput = new ByteArrayInputStream("5".getBytes());
        System.setIn(nameInput);
        System.setIn(repeatsInput);
        racingCarApplication.startRacing();

        verify(racingCarApplication).endRacing();
    }

}