package GameV1;

import java.util.ArrayList;

public class Record {
    private ArrayList<Integer> records = new ArrayList<>();

    public void record(int record) {
        records.add(record);
    }

    public void printRecord() {
        System.out.println("< 게임 기록 보기 >");
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i + 1) + "번째 게임 : 시도 횟수 -" + records.get(i));
            System.out.println("");
        }

    }

    public void clearRecord() {
        records.clear();
    }

}
