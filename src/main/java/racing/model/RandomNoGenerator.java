package racing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNoGenerator implements NumberGenerator {

    private static final int MIN = 1;
    private static final int MAX = 9;
    private static final int FIRST_INDEX = 0;
    private static final List<Integer> randomNumber = new ArrayList<>();

    static {
        for (int no = MIN; no <= MAX; no++) {
            randomNumber.add(no);
        }
    }

    @Override
    public int getNumber() {
        Collections.shuffle(randomNumber);
        return randomNumber.get(FIRST_INDEX);
    }
}
