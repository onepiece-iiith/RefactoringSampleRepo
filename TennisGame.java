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
        if (m_score1 == m_score2) {
            return getEvenScore();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getAdvantageOrWin();
        } else {
            return getStandardScore();
        }
    }

    private String getEvenScore() {
        switch (m_score1) {
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

    private String getAdvantageOrWin() {
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private String getStandardScore() {
        String score = "";
        int[] scores = {m_score1, m_score2};
        String[] scoreStrings = {"Love", "Fifteen", "Thirty", "Forty"};

        for (int i = 0; i < 2; i++) {
            score += scoreStrings[scores[i]];
            if (i == 0) score += "-";
        }
        return score;
    }
} 
