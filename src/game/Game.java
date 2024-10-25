package game;

import game.log.GameLog;

import java.util.List;

public interface Game<T> {

    GameLog createGameLog(List<Integer> answer, List<Integer> userTrial);

    void displayResult(GameLog gameLog);

    T playGame();
}
