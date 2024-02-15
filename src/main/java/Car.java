public class Car {
    private final String name;
    private int location;
    private NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("잘못된 이름입니다.");
        }
        this.name = name;
        this.numberGenerator = numberGenerator;
        location = 0;
    }

    public void tryMove() {
        int number = numberGenerator.generate();
        if (number >= 4) {
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
