package carracing;

public class Car {
	private String name;
	private int position;

	public Car(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("자동차 이름의 길이는 5를 초과할 수 없습니다.");
		}
		if (name.length() < 1) {
			throw new IllegalArgumentException("자동차 이름의 길이는 최소 한글자 이상이어야 합니다.");
		}
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void move() {
		position++;
	}

	public int getPosition() {
		return this.position;
	}
}
