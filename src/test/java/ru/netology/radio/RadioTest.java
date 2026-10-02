package ru.netology.radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void shouldNextFrom5() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.next();

        Assertions.assertEquals(6, radio.getCurrentStation());
    }

    @Test
    public void shouldNextFrom9() {
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.next();

        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevFrom5() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.prev();

        Assertions.assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldPrevFrom0() {
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        radio.prev();

        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void shouldSetValidStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(7);

        Assertions.assertEquals(7, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetNegativeStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.setCurrentStation(-1);

        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetTooHighStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.setCurrentStation(10);

        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);

        radio.increaseVolume();

        Assertions.assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeAbove100() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);

        radio.increaseVolume();

        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);

        radio.decreaseVolume();

        Assertions.assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeBelow0() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);

        radio.decreaseVolume();

        Assertions.assertEquals(0, radio.getCurrentVolume());
    }
}
