package play;

class Player {
    private String name;
    private int gamesPlayed;
    private int highScore;

    public Player(String name) {
        this.name = name;
        this.gamesPlayed = 0;
        this.highScore = 0;
    }

    public String getName() {
        return name;
    }
    public int getGamesPlayed() {
        return gamesPlayed;
    }
    public int getHighScore() {
        return highScore;
    }
    public void incrementGamesPlayed() {
        gamesPlayed++;
    }
    public void updateHighScore(int score) {
        if (score < highScore || highScore == 0) {
            highScore = score;
        }
    }
}
