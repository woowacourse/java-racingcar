public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int location;
    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("잘못된 이름입니다.");
        }
        this.name = name;
        this.numberGenerator = numberGenerator;
        location = 0;
    }

    public void tryMove() {
        int number = numberGenerator.generate();
        if (number >= MOVE_THRESHOLD) {
            location += 1;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}