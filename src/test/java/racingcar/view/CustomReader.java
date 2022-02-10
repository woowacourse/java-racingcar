package racingcar.view;

import racingcar.view.input.reader.Reader;

public class CustomReader implements Reader {

	private String text = "";

	@Override
	public String readLine() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
