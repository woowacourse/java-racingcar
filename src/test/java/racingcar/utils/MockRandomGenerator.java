package racingcar.utils;

import org.mockito.MockedStatic;
import org.mockito.Mockito;

public abstract class MockRandomGenerator {

    MockedStatic<RandomGenerator> mockRandom = Mockito.mockStatic(RandomGenerator.class);

    public void randomNumberOverFour() {
        mockRandom.when(() -> RandomGenerator.getRandomNumberInRange(9)).thenReturn(4);

    }

    public void randomNumberBelowFour() {
        mockRandom.when(() -> RandomGenerator.getRandomNumberInRange(9)).thenReturn(3);
    }

    public void closeMockRandom() {
        mockRandom.close();
    }
}
