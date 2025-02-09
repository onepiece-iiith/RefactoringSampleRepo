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
        int tempScore=0;
        if (m_score1==m_score2)
        {
            score = getScoreForSameScore(m_score1);
        }
        else if (m_score1>=4 || m_score2>=4)
        {
            score = getScoreForAdvantage(m_score1, m_score2);
        }
        else
        {
            score = getScoreForDifferentScores(m_score1, m_score2);
        }
        return score;
    }

    private String getScoreForSameScore(int score) {
        switch (score) {
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }

    private String getScoreForAdvantage(int m_score1, int m_score2) {
        int minusResult = m_score1-m_score2;
        if (minusResult==1) return "Advantage player1";
        else if (minusResult ==-1) return "Advantage player2";
        else if (minusResult>=2) return "Win for player1";
        else return "Win for player2";
    }

    private String getScoreForDifferentScores(int m_score1, int m_score2) {
        String score = "";
        for (int i=1; i<3; i++) {
            if (i==1) {
                score += getScoreForSinglePlayer(m_score1);
            } else {
                score += "-" + getScoreForSinglePlayer(m_score2);
            }
        }
        return score;
    }

    private String getScoreForSinglePlayer(int score) {
        switch (score) {
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            case 3: return "Forty";
            default: return ""; //Should not happen
        }
    }
}
