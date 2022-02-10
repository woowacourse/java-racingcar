package racingcar.view;

import racingcar.view.reader.DataReader;

public class CustomReader implements DataReader {

	private String text = "";

	@Override
	public String readLine() {
		return text + " ";
	}

	public void setText(String text) {
		this.text = text;
	}
}
