
package racingcar;

import java.util.Arrays;
import java.util.List;

public class Car {
    public static final String DELIMITER = ",";
    public static final int CRITERIA = 4;

    private int position;

    public List<String> splitNames(String inputNames) {
        return Arrays.asList(inputNames.split(DELIMITER));
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position++;
    }

    public void moveCarAccordingToCondition(int randomValue) {
        if (randomValue >= CRITERIA) {
            moveForward();
        }
    }
}
