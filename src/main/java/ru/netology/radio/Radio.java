public class Radio {
    private int currentStation;
    private int currentVolume;
    private int stationsCount;

    // Конструктор по умолчанию (10 станций)
    public Radio() {
        this(10);
    }

    // Конструктор с указанием количества станций
    public Radio(int stationsCount) {
        if (stationsCount <= 0) {
            throw new IllegalArgumentException("Количество станций должно быть больше нуля!");
        }
        this.stationsCount = stationsCount;
        this.currentStation = 0;
        this.currentVolume = 0;
    }

    public void next() {
        if (currentStation == stationsCount - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationsCount - 1;
        } else {
            currentStation--;
        }
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation >= 0 && currentStation < stationsCount) {
            this.currentStation = currentStation;
        }
    }

    public void volumeUp() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void volumeDown() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    // Геттеры (обрати внимание: getCurrentVolume)
    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getStationsCount() {
        return stationsCount;
    }
}