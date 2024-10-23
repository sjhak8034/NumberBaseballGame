package Games.NumberBaseballGame;

public class CurrentResult {
    private int strike = 0;
    private int ball = 0;
    private int out = 0;

    private int level;
    private int win = 0;

    public CurrentResult(int level) {
        this.level= level;
    }

    public void incrementStrike() {
        strike++;
    }
    public void incrementBall() {
        ball++;
    }

    public boolean isCorrect() {
        if(strike ==level ){
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



}
