package UserRecord;

import Games.Log;

import java.util.ArrayList;

public class NumberBaseballRecord<T extends Log> implements UserRecord <T> {

    private ArrayList<T> records = new ArrayList<>(){};
    @Override
    public void record(T record) {
        records.add(record);
    }
    @Override
    public void printRecord() {
        System.out.println("< 게임 기록 보기 >");
        for (int i = 0; i < records.size(); i++) {
            System.out.printf((i + 1) + "번째 게임 : 시도 횟수 -");
            records.get(i).print();
            System.out.println("");
        }

    }



}
