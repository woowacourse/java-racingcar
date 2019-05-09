package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
    private final CarFactory factory = new CarFactory();

    @Test
    void newCars_순서에따라_올바른_이름으로_생성했는지_검사() {
        // Arrange
        String[] names = {"포비", "제이슨", "씨유"};

        // Act
        ArrayList<Car> actuals = factory.newCars(names);

        // Assert
        for (int i = 0; i < names.length && i < actuals.size(); i++) {
            String expected = names[i];
            String actual = actuals.get(i).getName();

            assertEquals(expected,
                    actual,
                    String.format("[%d] expected: %s, actual: %s", i, expected, actual));
        }
    }

    @Test
    void newCars_N개의올바른이름_N개차생성() {
        // Arrange
        String[] names = {"포비", "제이슨", "씨유"};

        // Act
        ArrayList<Car> actuals = factory.newCars(names);

        // Assert
        assertEquals(names.length, actuals.size());
    }
}