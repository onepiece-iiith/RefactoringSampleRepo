public class TennisGame1 implements TennisGame {
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;
    private ScoreCalculator scoreCalculator;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        this.scoreCalculator = new ScoreCalculator();
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        return scoreCalculator.calculateScore(m_score1, m_score2);
    }
}

class ScoreCalculator {
    public String calculateScore(int m_score1, int m_score2) {
        if (m_score1 == m_score2) {
            return getEqualScore(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getAdvantageOrWin(m_score1, m_score2);
        } else {
            return getNormalScore(m_score1, m_score2);
        }
    }

    private String getEqualScore(int score) {
        String[] scores = {"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};
        return scores[Math.min(score, 3)];
    }

    private String getAdvantageOrWin(int m_score1, int m_score2) {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private String getNormalScore(int m_score1, int m_score2) {
        String score = "";
        String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
        score += scores[Math.min(m_score1, 3)];
        score += "-" + scores[Math.min(m_score2, 3)];
        return score;
    }
}