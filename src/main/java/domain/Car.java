package domain;

public class Car {

    private final String name;

    private int position;

    public Car(String name, int position) {
        validateNameLength(name.length());
        this.name = name;
        this.position = position;
    }

    public void move(int number) {
        if (isAllowedToMove(number)) {
            this.position += 1;
        }
    }

    private void validateNameLength(int nameSize) {
        if (!isValidNameLength(nameSize)) {
            throw new IllegalArgumentException("[ERROR] 1에서 5사이의 이름 길이만 입력 가능합니다.");
        }
    }

    private static boolean isValidNameLength(int nameSize) {
        return nameSize >= 1 && nameSize <= 5;
    }

    private boolean isAllowedToMove(int number) {
        return number >= 4;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;

    }
}
