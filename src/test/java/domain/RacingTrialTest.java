package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;

class RacingTrialTest {

    // 받은 차들에 대해서 moveStrategy 가 적용된 차들을 움직여주는 역할
    @Test
    void runTrial_움직여야할차들만움직이는지확인() {
        final int MAX_CARS = 10;

        ArrayList<Car> mockedCars = new ArrayList();
        for (int i = 0; i < MAX_CARS; i++) {
            Car mockedCar = mock(Car.class);
            mockedCars.add(mockedCar);
        }
        ArrayList<Integer> movedIdxs = new ArrayList(Arrays.asList(0, 4, 9));
        List<Car> movedCars = movedIdxs.stream().map((Integer i) -> mockedCars.get(i)).collect(Collectors.toList());

        CarMoveFilter mockedCarMoveFilter = mock(CarMoveFilter.class);
        when(mockedCarMoveFilter.adjust(mockedCars)).thenReturn(movedCars);

        RacingTrial racingTrial = new RacingTrial(mockedCarMoveFilter);


        // Act
        racingTrial.runTrial(mockedCars);


        // Assert
        for (int i = 0; i < MAX_CARS; i++) {
            Car car = mockedCars.get(i);
            if (movedIdxs.contains(i)) {
                // 불려야함
                verify(car).move();
                continue;
            }
            // 불리면 안됨
            verify(car, never()).move();
        }
    }
}