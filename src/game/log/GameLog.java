package game.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GameLog {
    private final int LEVEL;
    private final String DATE_TIME;
    private final int STRIKE;
    private final int BALL;
    private final boolean out;
    private final boolean WIN;
    private List<Integer> userTrial = new ArrayList<>();
    private final List<Integer> answer;

    public GameLog(int LEVEL, List<Integer> userTrial, List<Integer> answer, int STRIKE,
                   int ball, boolean out, boolean WIN) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DATE_TIME = now.format(formatter);
        this.LEVEL = LEVEL;
        this.userTrial = userTrial;
        this.answer = answer;
        this.STRIKE = STRIKE;
        this.BALL = ball;
        this.out = out;
        this.WIN = WIN;
    }

    public boolean isCorrect() {
        return WIN;
    }

    public boolean isOut() {
        return out;
    }

    public void printStrikeBall() {
        System.out.println(BALL + " 볼 " + STRIKE + " 스트라이크");
    }

    public void printLevel() {
        System.out.printf("[%d 레벨]", LEVEL);
    }

    public void printTime(){
        System.out.printf("[ "+ DATE_TIME +" ]");
    }

    public void printAnswer(){
        System.out.print(" 정답: ");
        System.out.println(this.answer.toString());

    }

    // 리플레이 재생할때 출력
    public void printAll() {
        printTime();
        System.out.printf(" [");
        System.out.printf(BALL + " 볼 " + STRIKE + " 스트라이크 " + out + " 아웃");
        System.out.printf("] ");
        System.out.println(this.userTrial.toString());

    }


}
