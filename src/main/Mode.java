package main;

public enum Mode {
    STARTGAME, PRINTRECORD, PLAYREPLAY, EXITGAME;

    public static Mode fromInt(int modeNumber) {
        return Mode.values()[modeNumber - 1];
    }
}


