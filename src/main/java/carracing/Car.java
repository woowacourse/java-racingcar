package carracing;

public class Car {
	private String name;
	private int position;

	public Car(String name) {
		if (name.length() < 1 || name.length() > 5) {
			throw new IllegalArgumentException("자동차 이름의 길이는 한 글자 이상, 다섯 글자 이하여야합니다.");
		}
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void move(int randomNumber) {
		if (randomNumber >= 4) {
			position++;
		}
	}

	public int getPosition() {
		return this.position;
	}
}
