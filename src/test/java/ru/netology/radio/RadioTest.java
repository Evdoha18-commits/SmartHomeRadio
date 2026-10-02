import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void testDefaultConstructor() {
        Radio radio = new Radio();
        assertEquals(10, radio.getStationsCount());
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testCustomConstructor() {
        Radio radio = new Radio(5);
        assertEquals(5, radio.getStationsCount());
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testNextStationWrapAround() {
        Radio radio = new Radio(3);
        radio.setCurrentStation(2);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testPrevStationWrapAround() {
        Radio radio = new Radio(3);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(2, radio.getCurrentStation());
    }

    @Test
    void testSetCurrentStationOutOfBounds() {
        Radio radio = new Radio(5);
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testVolumeDownLimit() {
        Radio radio = new Radio();
        radio.volumeDown();
        assertEquals(0, radio.getCurrentVolume()); // <-- ИСПРАВЛЕНО ЗДЕСЬ
    }

    @Test
    void testVolumeUpLimit() {
        Radio radio = new Radio();
        for (int i = 0; i < 110; i++) {
            radio.volumeUp();
        }
        assertEquals(100, radio.getCurrentVolume()); // <-- ИСПРАВЛЕНО ЗДЕСЬ
    }

    @Test
    void testInvalidStationsCount() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Radio(0);
        });
    }
}