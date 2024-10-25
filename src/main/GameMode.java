package main;

public enum GameMode {
    START_GAME, PRINT_RECORD, PLAY_REPLAY, EXIT_GAME;

    public static GameMode fromInt(int modeNumber) {
        return GameMode.values()[modeNumber - 1];
    }
}


