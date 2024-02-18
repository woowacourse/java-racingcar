package racingcar.model;

public class CarName {
    private static final int MOVE_THRESHOLD = 4;
    private static final int INITIAL_POSITION = 0;
    private final String name;
    private int position;

    public CarName(String name) {
        validateNameCharacters(name);
        validateNameLength(name);
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_THRESHOLD) {
            position++;
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    private void validateNameCharacters(String name) {
        if (!name.matches("^[a-zA-Z]*$")) {
            throw new IllegalArgumentException("자동차의 이름은 영어로만 이루어져야 합니다.");
        }
    }
}
