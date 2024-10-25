package game;

import game.log.GameLog;

import java.util.List;

public interface Game<T> {
    void saveLog(GameLog gameLog, List<Integer> answer, List<Integer> userTry);

    void displayResult(GameLog gameLog);

    GameLog createGameLog(List<Integer> answer, List<Integer> userTrial);

    T playGame();
}
