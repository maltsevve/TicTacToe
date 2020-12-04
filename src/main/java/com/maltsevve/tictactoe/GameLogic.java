package main.java.com.maltsevve.tictactoe;

import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameLogic {
    private final static int[][] WINNING_CONDITIONS = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
            {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
    private static int index = 0;
    Scanner sc = new Scanner(new InputStreamReader(System.in));
    Field fi = new Field();

    void start() {
        fi.drawField();
        gameplay();
        index = 0;
        System.out.println("GAME OVER");
    }

    private void gameplay() {
        turn(gamerTurn(), 'X');

        if (winnerCheck(fi.getField(), 'X')) {
            fi.drawField();
            System.out.println("YOU ARE WIN!");
            return;
        }

        if (tieCheck(fi)) return;

        turn(machineTurn(), 'O');

        if (winnerCheck(fi.getField(), 'O')) {
            fi.drawField();
            System.out.println("YOU ARE LOSE!");
            return;
        }

        fi.drawField();
        gameplay();
    }

    private void turn(int i, char ch) {
        if (validateInput(i)) {
            fi.setCell(i, ch);
            return;
        } else if (ch == 'X' && fi.getField()[i - 1] == 'X') System.out.println("Occupied! Try another cell.");

        switch (ch) {
            case 'X' -> turn(gamerTurn(), ch);
            case 'O' -> turn(machineTurn(), ch);
        }
    }

    private boolean validateInput(int i){
        return fi.getField()[i - 1] == i + 48;
    }

    private int gamerTurn() {
        Pattern pt = Pattern.compile("[1-9]");
        Matcher mh;
        String temp;

        do {
            temp = sc.nextLine();
            mh = pt.matcher(temp);
            if (!mh.matches()) System.out.println("Wrong number, please enter a number from 1 to 9");
        } while (!mh.matches());

        return Integer.parseInt(temp);
    }

    private int machineTurn() {
        return new Random().nextInt(9) + 1;
    }

    private boolean winnerCheck(char[] arr, char ch) {
        int k = 0;
        for (int i = 0; i < 8; i++) { // Восемь итераций, т.к. восемь вариантов победы
            for (int j = 0; j < 3; j++) {
                if (arr[WINNING_CONDITIONS[i][j]] == ch) {
                    k++;
                } else {
                    k = 0;
                    continue;
                }
                if (k >= 3 && j == 2) return true;
            }
        }
        return false;
    }

    private boolean tieCheck(Field fi) {
        index++;
        if (index == 5) {
            fi.drawField();
            System.out.println("TIE");
            return true;
        }
        return false;
    }
}
