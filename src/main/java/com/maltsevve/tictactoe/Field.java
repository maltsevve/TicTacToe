package main.java.com.maltsevve.tictactoe;

public class Field {
    public static boolean FLAG = false;
    char[] field = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    void setCell(int i, boolean player) {
        if (field[i - 1] == i + 48) {
            if (player) field[i - 1] = 'X'; /* Сюда могут попасть только значения 1 - 9, код 9 в ASCII = 57
            в то время как код Х = 88, следовательно значения никак пересечься не могут */
            else field[i - 1] = 'O'; // Использовал O, а не 0, ASCII = 79, так же совпадений не предвидется.
            FLAG = true;
        }
    }

    void drawField() {
        for (int i = 0; i < field.length; i++) {
            System.out.print(field[i] + " ");
            if ((i + 1) % 3 == 0) System.out.println();
        }
    }
}
