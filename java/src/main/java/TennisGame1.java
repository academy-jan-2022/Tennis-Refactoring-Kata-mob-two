
public class TennisGame1 implements TennisGame {
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame1(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(playerOneName))
            playerOneScore += 1;

        if (playerName.equals(playerTwoName))
            playerTwoScore += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;

        if (playerOneScore == playerTwoScore)
        {
            return getTiedScore(playerOneScore);
        }

        if (playerOneScore >=4 || playerTwoScore >=4)
        {
            int scoreDifference = getScoreDifference(playerOneScore, playerTwoScore);
            if (playerOneScore > playerTwoScore) {
                score = generateAdvantageOrWinScore(playerOneName, scoreDifference);
            }
            if (playerOneScore < playerTwoScore) {
                score = generateAdvantageOrWinScore(playerTwoName, scoreDifference);
            }
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = playerOneScore;
                else { score+="-"; tempScore = playerTwoScore;}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
        }
        return score;
    }

    private String generateAdvantageOrWinScore(String playerName, int scoreDifference) {
        if (scoreDifference == 1) {
            return "Advantage " + playerName;
        }
        return  "Win for " + playerName;
    }

    private String getTiedScore(int score) {
        switch (score)
        {
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

    private int getScoreDifference(int playerOneScore, int playerTwoScore){
        return Math.abs(playerOneScore - playerTwoScore);
    }
}
