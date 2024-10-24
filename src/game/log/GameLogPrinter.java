package game.log;

import java.util.ArrayList;
import java.util.List;

public class GameLogPrinter implements LogPrinter<GameLog> {
    private final List<GameLog> gameLogs = new ArrayList<>();
    // 한 판에 대한 전체 로그를 저장

    @Override
    public void append(GameLog gameLog) {
        gameLogs.add(gameLog);
    }
    @Override
    public void printScore() {
        System.out.println(gameLogs.size());
    }
    @Override
    public void printLevel() {
        if (!gameLogs.isEmpty()) {
            gameLogs.get(0).printLevel();
        } else {
            System.out.println("No game logs available.");
        }
    }
    @Override
    public void printTime(){
        if (!gameLogs.isEmpty()) {
            gameLogs.get(gameLogs.size() - 1).printTime();
        } else {
            System.out.println("No game logs available.");
        }
    }
    @Override
    public void printAnswer() {
        if (!gameLogs.isEmpty()) {
            gameLogs.get(0).printAnswer();
        } else {
            System.out.println("No game logs available.");
        }
    }
    @Override
    public void printSuccessLog(int NumberOfGame){
        if (!gameLogs.isEmpty()) {
            printTime();
            System.out.print(" " + (NumberOfGame + 1) + "번째 게임 : ");
            printLevel();
            System.out.print(" 시도 횟수 -");
            printScore();
            System.out.println();
        } else {
            System.out.println("No game logs available.");
        }

    }
    @Override
    public void printReplay(int NumberOfGame){
        printGameHeader(NumberOfGame);
        printLevel();
        printAnswer();
        for (GameLog gameLog : gameLogs) {
            gameLog.printAll();
        }
        System.out.println();
    }
    @Override
    public void printGameHeader(int numberOfGame) {
        System.out.println(" " + (numberOfGame + 1) + "번째 게임 : ");
    }

}
