package racingcar.service.picker;

import java.util.Iterator;
import java.util.List;

public class CustomNumberPicker implements NumberPicker {

    private final Iterator<Integer> numbers;

    public CustomNumberPicker(final List<Integer> numbers) {
        this.numbers = numbers.iterator();
    }

    @Override
    public int pickNumber() {
        return numbers.next();
    }

}
