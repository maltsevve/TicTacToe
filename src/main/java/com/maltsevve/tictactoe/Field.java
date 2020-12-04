package main.java.com.maltsevve.tictactoe;

public class Field {
    private final char[] field = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    void setCell(int i, char ch) {
        field[i - 1] = ch;
    }

    char[] getField() {
        return field;
    }

    void drawField() {
        for (int i = 0; i < field.length; i++) {
            System.out.print(field[i] + " ");
            if ((i + 1) % 3 == 0) System.out.println();
        }
    }
}
