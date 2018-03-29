package pl.training.tictactoe;

import org.junit.Test;
import pl.training.tictatctoe.TicTacToe;

import java.util.ArrayList;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class GameTest {

    private TicTacToe ticTacToe = new TicTacToe(new ArrayList<>(), new ArrayList<>());

    @Test
    public void shouldEndGameWhenAllFieldsAreTaken() {
        ticTacToe = new TicTacToe(asList(1, 3, 5, 8), asList(2, 4, 6, 7, 9));
        assertTrue(ticTacToe.isGameOver());
    }

    @Test
    public void shouldTakeOnlyFreeFields() {
        ticTacToe.takeField(1);
        assertFalse(ticTacToe.takeField(1));
    }

    @Test
    public void shouldChangePlayerAfterEachMove() {
        int player = ticTacToe.getCurrentPlayer();
        ticTacToe.takeField(1);
        assertNotEquals(ticTacToe.getCurrentPlayer(), player);
    }

    @Test
    public void shouldChangePlayerOnlyIfFieldIsTaken() {
        ticTacToe.takeField(1);
        int player = ticTacToe.getCurrentPlayer();
        ticTacToe.takeField(1);
        assertEquals(ticTacToe.getCurrentPlayer(), player);
    }

    @Test
    public void shouldEndGameWhenWinningSequenceIsTakenByOnePlayer() {
        ticTacToe = new TicTacToe(asList(1, 2, 3), asList(4, 8, 9));
        assertTrue(ticTacToe.isGameOver());
    }

}
