package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarMoveFilterTest {

    // 전략이 적용되는 애들만 모아서 리턴되는지
    @Test
    void adjust_전략이적용된차들만잘걸러내는지() {
        final int MAX_CARS = 10;

        ArrayList<Boolean> expectedIsMoveds = initExpectedIsMoveds(MAX_CARS);

        MoveStrategy mockedMoveStrategy = mock(MoveStrategy.class);
        when(mockedMoveStrategy.isMove()).thenReturn(expectedIsMoveds.get(0),
                expectedIsMoveds.subList(1, expectedIsMoveds.size()).toArray(new Boolean[]{}));

        List<Car> cars = new ArrayList(Stream.generate(() -> new Car("a")).limit(MAX_CARS).collect(Collectors.toList()));
        CarMoveFilter carMoveFilter = new CarMoveFilter(mockedMoveStrategy);


        // Act
        List<Car> returnedCars = carMoveFilter.adjust(cars);

        // Assert
        for (int i = 0; i < expectedIsMoveds.size(); i++) {
            boolean isMoved = expectedIsMoveds.get(i);
            Car car = cars.get(i);
            if (isMoved) {
                assertTrue(returnedCars.contains(car));
                continue;
            }
            assertFalse(returnedCars.contains(car));
        }
    }

    private ArrayList<Boolean> initExpectedIsMoveds(int size) {
        ArrayList<Boolean> expectedIsMoveds = new ArrayList(Stream.generate(() -> Boolean.FALSE).limit(size).collect(Collectors.toList()));

        int[] trueIdxs = {0, 4, 9};
        for (int trueIdx : trueIdxs) {
            expectedIsMoveds.set(trueIdx, true);
        }

        return expectedIsMoveds;
    }
}