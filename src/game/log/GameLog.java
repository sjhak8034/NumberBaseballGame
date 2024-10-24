package game.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameLog {
    private final int LEVEL;
    private final String DATE_TIME;
    private int strike = 0;
    private int ball = 0;
    private int out;
    private int win = 0;


    public GameLog(int LEVEL) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DATE_TIME = now.format(formatter);
        this.LEVEL = LEVEL;
    }

    public void incrementStrike() {
        strike++;
    }

    public void incrementBall() {
        ball++;
    }

    public boolean isCorrect() {
        if(strike == LEVEL){
            this.win++;
            return true;
        }
        return false;
    }

    public boolean isOut() {
        if(strike ==0 && ball == 0){
            this.out++;
            return true;
        }
        return false;
    }

    public void printStrikeBall() {
        System.out.println(ball + " 볼 " + strike + " 스트라이크");
    }

    public void printLevel() {
        System.out.printf("[%d 레벨]", LEVEL);
    }

    public void printTime(){

        System.out.printf("[ "+ DATE_TIME +" ]");
    }


}
