package racing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNo {
    private static final int UPPER_BOUND = 9;
    private static final int LOWER_BOUND = 1;
    private static final int FIRST_INDEX = 0;
    private static final List<Integer> randomNumbers = new ArrayList<>();

    static {
        for (int no = LOWER_BOUND; no <= UPPER_BOUND; no++){
            randomNumbers.add(no);
        }
    }

    public static int getNumber() {
        Collections.shuffle(randomNumbers);
        return randomNumbers.get(FIRST_INDEX);
    }
}
