package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @DisplayName("우승자를 구한다.")
    @Test
    public void test(){
        NumberGenerator numberGenerator = new NumberGenerator() {
            @Override
            public int generateNumber() {
                return 5;
            }
        };

        new RacingCar("pobi", numberGenerator);
    }

}