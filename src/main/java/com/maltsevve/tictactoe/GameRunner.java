package main.java.com.maltsevve.tictactoe;

public class GameRunner {
    public static int index = 0;

    public static void main(String[] args) {
        Field fi = new Field();
        GameLogic gl = new GameLogic();

        fi.drawField();
        gameplay(fi, gl);
        System.out.println("GAME OVER");
    }

    static void gameplay(Field fi, GameLogic gl) {
        while (!Field.FLAG) {
            fi.setCell(gl.gamerTurn(), true); // Где-то здесь нужно уведомлять пользователя если он повторно
            // вводит ту же цифру что уже использованна им или компьютером.
        }
        Field.FLAG = false;
        if (gl.winnerCheck(fi.field, 'X')) {
            fi.drawField();
            System.out.println("YOU ARE WIN!");
            return;
        }

        // блок ниже это проверка на ничью, сделать потом метод в GameLogic, распологаться должна именно тут
        // так как игрок делает 5 ходов, а компьютер 4. Проверка нужна после того как все 9 ходов будут сделаны,
        // т.е. метод gameplay отработает 4,5 раза условно.
        index++;
        if (index == 5){
            fi.drawField();
            System.out.println("TIE");
            return;
        }

        while (!Field.FLAG) {
            fi.setCell(gl.machineTurn(), false);
        }
        Field.FLAG = false;
        if (gl.winnerCheck(fi.field, 'O')) {
            fi.drawField();
            System.out.println("YOU ARE LOSE!");
            return;
        }

        fi.drawField();
        gameplay(fi, gl);
    }
}
