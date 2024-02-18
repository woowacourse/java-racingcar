package domain;

public class Car implements Comparable<Car> {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int score;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void move() {
        this.score++;
    }

    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(this.score, otherCar.score);
    }

    @Override
    public boolean equals(Object otherCar) {
        if (!(otherCar instanceof Car)) {
            throw new RuntimeException("알 수 없는 예외가 발생했습니다.");
        }

        return this.score == ((Car) otherCar).score;
    }

    private void validate(String name) {
        if (!name.matches("^[a-zA-Z]{" + MIN_NAME_LENGTH + "," + MAX_NAME_LENGTH + "}$")) {
            throw new IllegalArgumentException(
                MIN_NAME_LENGTH + "~" + MAX_NAME_LENGTH + "자의 알파벳만 입력 가능합니다.");
        }
    }
}
