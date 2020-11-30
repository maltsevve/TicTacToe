package main.java.com.maltsevve.tictactoe;

import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameLogic {
    public final static int[][] WINNING_CONDITIONS = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
            {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    Scanner sc = new Scanner(new InputStreamReader(System.in));

    int gamerTurn() {
        Pattern pt = Pattern.compile("[1-9]"); // Вероятно регулярка не лучшее решение, подумать потом.
        Matcher mh;
        String temp;

        do {
            temp = sc.nextLine();
            mh = pt.matcher(temp);
        } while (!mh.matches());

        return Integer.parseInt(temp);
    }

    int machineTurn() {
        return new Random().nextInt(9) + 1;
    }

    boolean winnerCheck(char[] arr, char ch) {
        int k = 0;
        for (int i = 0; i < 8; i++) { // Восемь итераций, т.к. восемь вариантов победы
            for (int j = 0; j < 3; j++) {
                if (arr[WINNING_CONDITIONS[i][j]] == ch) {
                    k++;
                } else {
                    k = 0;  // Почему условие выполняется всегда (а всегда ли?) не понимаю, но это
                    // определенно благодаря условию if ниже: (if (k == 3 && j == 2) return true;)
                    continue;
                }
                if (k == 3 && j == 2) return true;
            }
        }
        return false;
    }
}
