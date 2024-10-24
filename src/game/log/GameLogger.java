package game.log;

import java.util.ArrayList;
import java.util.List;

public class GameLogger implements Log<GameLog> {
    List<GameLog> gameLogs = new ArrayList<GameLog>();
    @Override
    public void append(GameLog gameLog) {
        gameLogs.add(gameLog);
    }

    @Override
    public void printScore() {
        System.out.println(gameLogs.size());
    }

    public void printLevel() {
        gameLogs.get(0).printLevel();
    }

    public void printTime(){
        gameLogs.get(gameLogs.size()-1).printTime();
    }





}
