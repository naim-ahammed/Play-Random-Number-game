package play;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class RandomNumberGame {
    private List<Player> players;
    private Random random;
    private Scanner scanner;

    public RandomNumberGame() {
        players = new ArrayList<>();
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void play() {
        boolean exit = false;

        System.out.println("Welcome to the Random Number Game!");

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Play a Round");
            System.out.println("2. View Player Statistics");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    playRound();
                    break;
                case 2:
                    viewPlayerStatistics();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you for playing!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    private void playRound() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        Player currentPlayer = getPlayer(name);

        if (currentPlayer == null) {
            currentPlayer = new Player(name);
            players.add(currentPlayer);
        }

        currentPlayer.incrementGamesPlayed();

        int targetNumber = random.nextInt(10) + 1;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("\nNew Round, " + currentPlayer.getName() + "! Guess a number between 1 and 10.");

        while (!guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int guessNum = scanner.nextInt();
            scanner.nextLine();
            attempts++;

            if (guessNum < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (guessNum > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations,"+currentPlayer.getName()+"! You guessed the correct number in " + attempts + " attempts.");
                currentPlayer.updateHighScore(attempts);
                guessedCorrectly = true;
            }
        }
    }

    private void viewPlayerStatistics() {
        if (players.isEmpty()) {
            System.out.println("No player statistics available.");
        } else {
            System.out.println("Player Statistics:");

            for (Player player : players) {
                System.out.println("Player: " + player.getName());
                System.out.println("Games Played: " + player.getGamesPlayed());
                System.out.println("High Score: " + (player.getHighScore() > 0 ? player.getHighScore() : "N/A"));
                System.out.println();
            }
        }
    }

    private Player getPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null;
    }
}
