public class TennisGame1 implements TennisGame {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        return new ScoreDisplay(m_score1, m_score2).getScore();
    }
}

class ScoreDisplay{
    private int m_score1;
    private int m_score2;

    public ScoreDisplay(int score1, int score2){
        this.m_score1 = score1;
        this.m_score2 = score2;
    }

    public String getScore(){
        String score = "";
        if (m_score1 == m_score2) {
            score = getScoreForEqualScores(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = getScoreForAdvantageOrWin(m_score1, m_score2);
        } else {
            score = getScoreForNormalPlay(m_score1, m_score2);
        }
        return score;
    }

    private String getScoreForEqualScores(int score) {
        String result = "";
        switch (score) {
            case 0:
                result = "Love-All";
                break;
            case 1:
                result = "Fifteen-All";
                break;
            case 2:
                result = "Thirty-All";
                break;
            default:
                result = "Deuce";
                break;
        }
        return result;
    }

    private String getScoreForAdvantageOrWin(int score1, int score2) {
        int minusResult = score1 - score2;
        String result = "";
        if (minusResult == 1) {
            result = "Advantage player1";
        } else if (minusResult == -1) {
            result = "Advantage player2";
        } else if (minusResult >= 2) {
            result = "Win for player1";
        } else {
            result = "Win for player2";
        }
        return result;
    }

    private String getScoreForNormalPlay(int score1, int score2) {
        return getScoreForSinglePlayer(score1) + "-" + getScoreForSinglePlayer(score2);
    }

    private String getScoreForSinglePlayer(int score) {
        String result = "";
        switch (score) {
            case 0:
                result = "Love";
                break;
            case 1:
                result = "Fifteen";
                break;
            case 2:
                result = "Thirty";
                break;
            case 3:
                result = "Forty";
                break;
            default:
                result = "";
                break;
        }
        return result;
    }
}