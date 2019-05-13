package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxFinderTest {

    @Test
    void findAllMax_여러가지입력에대한검증() {
        ArrayList<ArrayList<Integer>> testCases = new ArrayList<>();
        testCases.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        testCases.add(new ArrayList<>(Arrays.asList(1, 2, 3, 5, 5)));
        testCases.add(new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1)));
        testCases.add(new ArrayList<>(Arrays.asList(-1, -1, -1, -1, -4)));
        testCases.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0)));

        List<Integer> expectedes = new ArrayList<>(Arrays.asList(
                1,
                2,
                1,
                4,
                7
        ));


        for (int i = 0; i < testCases.size(); i++) {
            // Arrange
            ArrayList<Integer> testCase = testCases.get(i);

            // Act
            List<Integer> actual = MaxFinder.findAllMax(testCase, Integer::compareTo);

            // Assert
            assertEquals(expectedes.get(i), actual.size(), String.format("i: %d", i));
        }
    }
}