package racingcar.domain;

// TODO: 2020/02/11 UserInput, Output, Application, Game, Cars Method(getWinners, toString) Car(toString)
// TODO: 2020/02/11 테스트를 하기 위한 설계 (내 생각이 틀렸을 수 있다) , private 접근제어자에서 같은 클래스면 Getter 없이 다른 인스턴스들에 인스턴스변수에 접근가능 
// TODO: 2020/02/11 Comparator
public class Car implements Comparable<Car> {
	private final String name;
	private int position = 0;

	public Car(String name) {
		if (isTooLongName(name))
			throw new IllegalArgumentException();
		this.name = name;
	}

	private boolean isTooLongName(String name) {
		return name.length() > 5;
	}

	// TODO: 2020/02/11 int -> something wrapping ?
	public void move(int random) {
		if (isMoving(random)) {
			position++;
		}
	}

	private boolean isMoving(int random) {
		return random >= 4;
	}

	public boolean isOnSamePosition(Car anotherCar) {
		return compareTo(anotherCar) == 0;
	}

	// TODO: 2020/02/11 isSame(int, car another) -> equals 빠지고 move도 테스트되니

	@Override
	public int compareTo(Car anotherCar) {
		return anotherCar.position - position;
	}
}
