package racingcar.view.inputview.reader;

import racingcar.view.input.reader.Reader;

public class CustomReader implements Reader {

    private String text;

    public void initText(String text) {
        this.text = text;
    }

    @Override
    public String readLine() {
        return text;
    }

}
