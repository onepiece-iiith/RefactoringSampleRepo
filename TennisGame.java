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
        return new ScoreCalculator(m_score1, m_score2).calculateScore();
    }

    private class ScoreCalculator {
        private int m_score1;
        private int m_score2;

        public ScoreCalculator(int m_score1, int m_score2) {
            this.m_score1 = m_score1;
            this.m_score2 = m_score2;
        }

        public String calculateScore() {
            String score = "";
            if (m_score1 == m_score2) {
                score = getEqualScore(m_score1);
            } else if (m_score1 >= 4 || m_score2 >= 4) {
                score = calculateAdvantageOrWin();
            } else {
                score = getScores(m_score1, m_score2);
            }
            return score;
        }

        private String calculateAdvantageOrWin() {
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

        private String getScores(int score1, int score2) {
            String score = "";
            String[] scores = {"Love", "Fifteen", "Thirty", "Forty"};
            score = scores[score1] + "-" + scores[score2];
            return score;
        }
    }
}