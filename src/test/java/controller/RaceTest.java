package controller;

import controller.Race;
import org.junit.jupiter.api.Test;
import util.NumberGenerator;

class RaceTest {
    private TestNumberGenerator testNumberGenerator = new TestNumberGenerator();
    private Race race = new Race(testNumberGenerator);

    @Test
    void generateRandomNumber() {
        testNumberGenerator.setNumber(3);
        assertEquals(1, race.generateRandomNumber());
    }


    class TestNumberGenerator implements NumberGenerator {
        private int number;
        @Override
        public int generateNumber() {
            return this.number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }

}