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
        if ("player1".equals(playerName)) {
            m_score1 += 1;
        } else {
            m_score2 += 1;
        }
    }

    public String getScore() {
        return scoreCalculator.calculateScore(m_score1, m_score2);
    }
}

class ScoreCalculator {
    public String calculateScore(int m_score1, int m_score2) {
        String score = "";
        if (m_score1 == m_score2) {
            score = getEqualScore(m_score1);
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            score = getAdvantageOrWinScore(m_score1, m_score2);
        } else {
            score = getStandardScore(m_score1, m_score2);
        }
        return score;
    }

    private String getEqualScore(int score) {
        switch (score) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private String getAdvantageOrWinScore(int m_score1, int m_score2) {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) {
            return "Advantage player1";
        } else if (minusResult == -1) {
            return "Advantage player2";
        } else if (minusResult >= 2) {
            return "Win for player1";
        } else {
            return "Win for player2";
        }
    }

    private String getStandardScore(int m_score1, int m_score2) {
        String score = "";
        String[] scores = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

        score = scores[m_score1];
        score += "-";
        score += scores[m_score2];
        return score;
    }
}