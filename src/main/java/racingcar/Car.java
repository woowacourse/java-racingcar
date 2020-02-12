
package racingcar;

import java.util.Arrays;
import java.util.List;

public class Car {
    public static final String DELIMITER = ",";

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
}
