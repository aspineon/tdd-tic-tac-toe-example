package pl.training.tictatctoe;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class TicTacToe {

    public static final int BOARD_SIZE = 9;

    private static final List<List<Integer>> winningSequences = asList(
            asList(1, 2, 3), asList(4, 5, 6), asList(7, 8, 9),
            asList(1, 4, 7), asList(2, 5, 8), asList(3, 6, 9),
            asList(1, 5, 9), asList(3, 5, 7));

    private int currentPlayer;
    private List<Integer> firstPlayerFields;
    private List<Integer> secondPlayerFields;

    public TicTacToe(List<Integer> firstPlayerFields, List<Integer> secondPlayerFields) {
        this.firstPlayerFields = firstPlayerFields;
        this.secondPlayerFields = secondPlayerFields;
    }

    public boolean isGameOver() {
        return allFieldsAreTaken() || hasWinningSequence();
    }

    private List<Integer> getCurrentPlayerFields() {
        return currentPlayer == 0 ? firstPlayerFields : secondPlayerFields;
    }

    private List<Integer> getAllFields() {
        List<Integer> fields = new ArrayList<>();
        fields.addAll(firstPlayerFields);
        fields.addAll(secondPlayerFields);
        return fields;
    }

    private boolean allFieldsAreTaken() {
        return BOARD_SIZE - getAllFields().size() == 0;
    }

    private boolean hasWinningSequence() {
        for (List<Integer> sequence: winningSequences) {
            if (getCurrentPlayerFields().containsAll(sequence)) {
                return true;
            }
        }
        return false;
    }

    public boolean takeField(int field) {
        if (getAllFields().contains(field)) {
            return false;
        }
        getCurrentPlayerFields().add(field);
        currentPlayer = currentPlayer == 0 ? 1 : 0;
        return true;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

}
