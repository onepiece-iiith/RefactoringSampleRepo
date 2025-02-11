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
        String score = "";
        if (m_score1==m_score2)
        {
            score = getScoreForEqualScores(m_score1);
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            score = getScoreForAdvantageOrWin(m_score1, m_score2);
        }
        else
        {
            score = getScoreForStandardScores(m_score1, m_score2);
        }
        return score;
    }

    private String getScoreForEqualScores(int score) {
        String scoreText = "";
        switch (score) {
            case 0: scoreText = "Love-All"; break;
            case 1: scoreText = "Fifteen-All"; break;
            case 2: scoreText = "Thirty-All"; break;
            default: scoreText = "Deuce"; break;
        }
        return scoreText;
    }

    private String getScoreForAdvantageOrWin(int score1, int score2) {
        String scoreText = "";
        int minusResult = score1-score2;
        if (minusResult==1) scoreText ="Advantage player1";
        else if (minusResult ==-1) scoreText ="Advantage player2";
        else if (minusResult>=2) scoreText = "Win for player1";
        else scoreText ="Win for player2";
        return scoreText;
    }

    private String getScoreForStandardScores(int score1, int score2){
        String scoreText = "";
        for (int i=1; i<3; i++) {
            if (i == 1) {
                scoreText += getScoreText(score1);
            } else {
                scoreText += "-" + getScoreText(score2);
            }
        }
        return scoreText;
    }

    private String getScoreText(int score) {
        String scoreText = "";
        switch(score) {
            case 0: scoreText = "Love"; break;
            case 1: scoreText = "Fifteen"; break;
            case 2: scoreText = "Thirty"; break;
            case 3: scoreText = "Forty"; break;
        }
        return scoreText;
    }
}