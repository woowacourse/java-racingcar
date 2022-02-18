package racingcar.view.input.reader;

import java.util.Iterator;
import java.util.List;

public class CustomReader implements Reader {

    private Iterator<String> values;

    public void initText(final List<String> values) {
        this.values = values.iterator();
    }

    public void initText(String value) {
        this.values = List.of(value).iterator();
    }

    @Override
    public String readLine() {
        return values.next();
    }

}
