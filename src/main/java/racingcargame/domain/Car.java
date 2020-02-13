package racingcargame.domain;

public class Car {
    private static final String DISTANCE = "-";
    private final Name name;
    private int position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = 0;
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = position;
    }

    public void go(Engine engine) {
        if (engine.isHigherThanLimit()) {
            position++;
        }
    }

    public boolean isSameTo(int position) {
        return this.position == position;
    }

    public String printPosition() {
        StringBuilder sb = new StringBuilder();
        sb.append(name.getName() + " : ");
        for (int i = 0; i < position; i++) {
            sb.append(DISTANCE);
        }
        sb.append("\n");
        return sb.toString();
    }
}
