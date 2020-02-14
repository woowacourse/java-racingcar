package racinggame.race.car.engine;

public class FixedEngine implements Engine {
    private static FixedEngine instance = new FixedEngine();

    private FixedEngine() {
    }

    public static FixedEngine getInstance() {
        return instance;
    }

    public boolean enoughPower() {
        return true;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass();
    }
}
