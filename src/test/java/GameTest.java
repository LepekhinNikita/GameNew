import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void testRoundFirstWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Paladin", 100);
        Player player2 = new Player(2, "Warrior", 30);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Paladin", "Warrior");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testRoundSecondWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Paladin", 10);
        Player player2 = new Player(2, "Warrior", 100);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Paladin", "Warrior");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void testRoundNoOneWin() {
        Game game = new Game();
        Player player1 = new Player(1, "Paladin", 300);
        Player player2 = new Player(2, "Warrior", 300);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Paladin", "Warrior");
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testRoundNoFirstPlayer() {
        Game game = new Game();
        Player player2 = new Player(2, "Warrior", 300);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Paladin", "Warrior");
        });

    }
    @Test
    public void testRoundNoSecondPlayer() {
        Game game = new Game();
        Player player1 = new Player(1, "Paladin", 700);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Paladin", "Warrior");
        });

    }
}
