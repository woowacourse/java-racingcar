package racing.game;

import java.util.List;

public class Car {
    private static final int NAME_LENGTH_MIN_LIMIT = 1;
    private static final int NAME_LENGTH_MAX_LIMIT = 6;
    private static final int BOUNDARY = 4;
    private static final String POSITION_MARK = "-";

    private final String name;
    private int position = 0;

    public Car(final String name) throws Exception {
        this.name = name.trim();
        if (checkNull(this.name) || checkInvalidNameLength(this.name))
            throw new Exception();
    }

    public Car(final String name, int position) throws Exception {
        this.name = name.trim();
        this.position = position;
        if (checkNull(this.name) || checkInvalidNameLength(this.name))
            throw new Exception();
    }

    static boolean checkNull(Object name) {
        return name == null;
    }

    static boolean checkInvalidNameLength(String name) {
        return name.length() < NAME_LENGTH_MIN_LIMIT || name.length() >= NAME_LENGTH_MAX_LIMIT;
    }

    boolean matchCarName(String name) {
        return this.name.equals(name);
    }

    boolean move(int randomValue) {
        if (randomValue >= BOUNDARY) {
            position++;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(name);
        stringBuffer.append(" : ");
        for (int i = 0; i < position; i++) {
            stringBuffer.append(POSITION_MARK);
        }
        return stringBuffer.toString();
    }

    public String getName() {
        return name;
    }

    public boolean matchPosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

    public int compareTo(Car o2) {
        return Integer.compare(this.position, o2.position);
    }
}
