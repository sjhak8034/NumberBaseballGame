package data;

import game.log.GameLogger;

import java.util.ArrayList;

public class NumberBaseBallData<T extends GameLogger> implements Data<T> {

    private final ArrayList<T> logData = new ArrayList<>(){};
    @Override
    public void save(T record) {
        logData.add(record);
    }
    @Override
    public void printData() {
        System.out.println("< 게임 기록 보기 >");
        for (int i = 0; i < logData.size(); i++) {
            logData.get(i).printTime();
            System.out.print(" " + (i + 1) + "번째 게임 : ");
            logData.get(i).printLevel();
            System.out.print(" 시도 횟수 -");
            logData.get(i).printScore();
            System.out.println("");
        }

    }



}
