package racinggame.domain.car.generatenumber;

import java.util.Random;

public class GenerateRandomNumber implements GenerateNumberService {
    public int generateNumber(int bound) {
        return new Random(System.currentTimeMillis()).nextInt(bound);
    }
}
