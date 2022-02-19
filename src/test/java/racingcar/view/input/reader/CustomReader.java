package racingcar.view.input.reader;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CustomReader implements Reader {

    private Iterator<String> values;

    public void initText(final List<String> values) {
        this.values = values.iterator();
    }

    public void initText(final String value) {
        this.values = Arrays.asList(value).iterator();
    }

    @Override
    public String readLine() {
        return values.next();
    }

}
