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
        if (m_score1 == m_score2) {
            score = getEqualScoreString();
        } else if (isNormalPlay()) {
            score = getNormalPlayScore();
        } else {
            score = getAdvantageOrWinScore();
        }
        return score;
    }

    private String getEqualScoreString() {
        String[] equalScores = {"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};
        int minScore = Math.min(m_score1, 3);
        return equalScores[minScore];
    }

    private boolean isNormalPlay() {
        return m_score1 < 4 && m_score2 < 4;
    }

    private String getAdvantageOrWinScore() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) return "Advantage player1";
        if (minusResult == -1) return "Advantage player2";
        if (minusResult >= 2) return "Win for player1";
        return "Win for player2";
    }

    private String getNormalPlayScore() {
        String[] scoreValues = {"Love", "Fifteen", "Thirty", "Forty"};
        return scoreValues[m_score1] + "-" + scoreValues[m_score2];
    }
}   
