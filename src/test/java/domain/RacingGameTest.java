package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.*;

class RacingGameTest {
    private RacingGame racingGame;

    @Test
    void play_nTrials번만큼runTrial를호출했는지() {
        // Arrange
        RacingTrial mockedRacingTrial = mock(RacingTrial.class);
        racingGame = new RacingGame(mockedRacingTrial);

        int nTrials = 10;
        ArrayList<Car> cars = new ArrayList<>(Arrays.asList(new Car("a"), new Car("b"), new Car("c")));


        // Act
        racingGame.play(cars, nTrials);


        // Assert
        verify(mockedRacingTrial, times(nTrials)).runTrial(cars);

    }

//    @Test
//    void play_winners를_잘출력했는지() {
//        // maxfinder에게 부탁했는지
//        // 받은 winner를 잘 출력했는지
//    }
}