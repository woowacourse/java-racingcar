package utils;

public class ImmovableEngine implements Engine {
    @Override
    public boolean isMovable() {
        return false;
    }
}
