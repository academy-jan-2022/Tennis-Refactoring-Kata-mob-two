public class TennisGame1 implements TennisGame {
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;
    private String[] scoreNames = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

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
        boolean gameIsTied = playerOneScore == playerTwoScore;
        boolean playerCouldWin = playerOneScore >=4 || playerTwoScore >=4;

        if (gameIsTied) {
            return getTiedScore(playerOneScore);
        }

        if (playerCouldWin) {
            return advantageOrWinScore();
        }

        return scoreNames[playerOneScore] + "-" + scoreNames[playerTwoScore];
    }

    private String advantageOrWinScore() {
        var advantagedPlayer = (playerOneScore > playerTwoScore) ? playerOneName : playerTwoName;
        return playerAdvantageOrWinScore(advantagedPlayer);
    }

    private String playerAdvantageOrWinScore(String playerName) {
        var scoreDifference = getScoreDifference(playerOneScore, playerTwoScore);
        return (scoreDifference == 1 ? "Advantage "  : "Win for ") + playerName;
    }

    private String getTiedScore(int score) {
        return score > 2 ? "Deuce" : scoreNames[score] + "-All";
    }

    private int getScoreDifference(int playerOneScore, int playerTwoScore){
        return Math.abs(playerOneScore - playerTwoScore);
    }
}
