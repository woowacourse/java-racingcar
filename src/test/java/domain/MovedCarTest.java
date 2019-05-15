package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MovedCarTest {
    @Test
    void positionComparator_위치동일할때() {
        int[] positions = new int[]{
                0, 1, 10, 100, 1000
        };

        for (int position : positions) {
            MovedCar movedCar1 = new MovedCar("car1", position);
            MovedCar movedCar2 = new MovedCar("car2", position);

            assertThat(MovedCar.positionComparator.compare(movedCar1, movedCar2)).isEqualTo(0);
        }
    }

    @Test
    void positionComparator_앞이적은위치() {
        int[] positions = new int[]{
                0, 1, 10, 100, 1000
        };

        for (int position : positions) {
            MovedCar movedCar1 = new MovedCar("car1", position);
            MovedCar movedCar2 = new MovedCar("car2", position+1);

            assertThat(MovedCar.positionComparator.compare(movedCar1, movedCar2)).isNegative();
        }
    }

    @Test
    void positionComparator_앞이큰위치() {
        int[] positions = new int[]{
                0, 1, 10, 100, 1000
        };

        for (int position : positions) {
            MovedCar movedCar1 = new MovedCar("car1", position+1);
            MovedCar movedCar2 = new MovedCar("car2", position);

            assertThat(MovedCar.positionComparator.compare(movedCar1, movedCar2)).isPositive();
        }
    }
}