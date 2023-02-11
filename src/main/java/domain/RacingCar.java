package domain;

public class RacingCar{
    private static final int MIN_THROTTLE_THRESHOLD = 4;
    private final Name name;
    private final ThrottleGenerator throttleGenerator;
    private int position;

    public RacingCar(final Name name) {
        this.name = name;
        this.throttleGenerator = new RandomThrottleGenerator();
    }

    public RacingCar(final Name name, final ThrottleGenerator throttleGenerator){
        this.name = name;
        this.throttleGenerator = throttleGenerator;
    }

    public void move() {
        if (isMovable(throttleGenerator.generate())) {
            position++;
        }
    }

    private boolean isMovable(final int throttle) {
        return throttle >= MIN_THROTTLE_THRESHOLD;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name.getName();
    }
}
