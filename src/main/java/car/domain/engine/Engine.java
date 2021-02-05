package car.domain.engine;

public interface Engine {
    
    int MOVE_CONDITION = 4;
    
    boolean isEnoughFuel();
    
    class Fake implements Engine {
        
        private final int condition;
        
        public Fake(int condition) {
            this.condition = condition;
        }
        
        @Override
        public boolean isEnoughFuel() {
            return condition >= MOVE_CONDITION;
        }
    }
}
