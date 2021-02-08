package car.domain;

import car.domain.engine.Engine;

class MockEngine implements Engine {
    
    private final int condition;
    
    public MockEngine(int condition) {
        this.condition = condition;
    }
    
    @Override
    public boolean isEnoughFuel() {
        return condition >= MOVE_CONDITION;
    }
}
