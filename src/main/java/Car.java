public class Car {
    private final String name;
    private int location;

    public Car(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("잘못된 이름입니다.");
        }
        this.name = name;
        location = 0;
    }

    public void tryMove() {
        if ((int) (Math.random() * 9) >= 4) {
            location++;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
