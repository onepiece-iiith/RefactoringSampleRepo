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
            int minusResult = m_score1-m_score2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            score = getScoreForDifferentScore(m_score1,m_score2);
        }
        return score;
    }

    private String getScoreForSameScore(int score) {
        String scoreStr = "";
        switch (score) {
            case 0:
                scoreStr = "Love-All";
                break;
            case 1:
                scoreStr = "Fifteen-All";
                break;
            case 2:
                scoreStr = "Thirty-All";
                break;
            default:
                scoreStr = "Deuce";
                break;
        }
        return scoreStr;
    }

    private String getScoreForDifferentScore(int score1, int score2) {
        String score = "";
        String[] scoreStrings = {"Love", "Fifteen", "Thirty", "Forty"};
        for (int i = 1; i < 3; i++) {
            int tempScore = (i == 1) ? score1 : score2;
            score += scoreStrings[tempScore];
            if (i < 2) {
                score += "-";
            }
        }
        return score;
    }
}    