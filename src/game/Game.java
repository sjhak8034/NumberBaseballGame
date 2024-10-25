package game;

import game.log.GameLog;

import java.util.List;

public interface Game<T> {




    void displayResult(GameLog gameLog);

    GameLog createGameLog(int level,List<Integer> answer, List<Integer> userTrial);

    T playGame();
}
