package model.powergenerator;

@FunctionalInterface
public interface PowerGenerator {
    int determinePower(int maxPower);
}
