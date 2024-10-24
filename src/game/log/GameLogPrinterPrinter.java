package game.log;

import java.util.ArrayList;
import java.util.List;

public class GameLogPrinterPrinter implements LogPrinter<GameLog> {
    List<GameLog> gameLogs = new ArrayList<GameLog>();
    // 한 판에 대한 전체 로그를 저장

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

    public void printAnswer() {
        gameLogs.get(0).printAnswer();
    }

    // 게임 기록을 출력을 위한 메소드
    public void printSuccessLog(int NumberOfGame){
        printTime();
        System.out.print(" " + (NumberOfGame + 1) + "번째 게임 : ");
        printLevel();
        System.out.print(" 시도 횟수 -");
        printScore();
        System.out.println("");
    }

    public void printReplay(int NumberOfGame){
        System.out.println(" " + (NumberOfGame + 1) + "번째 게임 : ");
        printLevel();
        System.out.printf(" 정답: ");
        printAnswer();
        System.out.println("");
        for(int i = 0; i < gameLogs.size(); i++){
            gameLogs.get(i).printAll();
        }
    }





}