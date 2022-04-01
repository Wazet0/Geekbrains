//5x5 TicTacToe | 4 to win
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
        private static final char DOT_X = 'X';
        private static final char DOT_O = 'O';
        private static final char DOT_EMPTY = '*';

        private static final Scanner scanner = new Scanner(System.in);
        private static final Random random = new Random();

        private static char[][] field;
        private static char dotHuman;
        private static char dotAi;
        private static int fieldSizeX;
        private static int fieldSizeY;
        private static int scoreHuman;
        private static int scoreAi;
        private static int roundCounter;

        public static void main(String[] args) {
            runGame();
        }

        private static void runGame() {
            while (true) {
                chooseDot();
                playRound();

                System.out.printf("SCORE:    HUMAN     AI\n" +
                        "            %d       %d\n", scoreHuman, scoreAi);

                System.out.print("Want to play again ? (Y or N): ");

                if (!scanner.next().toLowerCase(Locale.ROOT).equals("y")) {
                    System.out.println("BYE");
                    break;
                }
            }
        }

        private static void playRound() {
            System.out.printf("Round %d start\n", ++roundCounter);
            initField(5, 5);
            printField();
            if (dotHuman == DOT_X) {
                humanFirst();
            } else {
                aiFirst();
            }
        }

        private static void humanFirst() {
            while (true) {
                humanTurn();
                printField();
                if (gameCheck(dotHuman)) {
                    break;
                }
                aiTurn();
                printField();
                if (gameCheck(dotAi)) {
                    break;
                }
            }
        }

        private static void aiFirst() {
            while (true) {
                aiTurn();
                printField();
                if (gameCheck(dotAi)) {
                    break;
                }
                humanTurn();
                printField();
                if (gameCheck(dotHuman)) {
                    break;
                }
            }
        }

        private static boolean gameCheck(char dot) {
            if (checkWin(dot) && dot == dotHuman) {
                System.out.println("Human win!");
                scoreHuman++;
                return true;
            } else if (checkWin(dot) && dot == dotAi) {
                System.out.println("AI win!");
                scoreAi++;
                return true;
            }
            return checkDraw();
        }

        private static void chooseDot() {
            System.out.print("Type 'X' to play with X and for 0 type anything: ");

            if (scanner.next().toLowerCase(Locale.ROOT).equals("x")) {
                dotHuman = DOT_X;
                dotAi = DOT_O;
            } else {
                dotHuman = DOT_O;
                dotAi = DOT_X;
            }
        }

        private static void aiTurn() { //изменено! Перекрытие выигрышной  человека.
            int x = 0;
            int y = 0;
            do {
                boolean hasTurn = false;
                loop:for (int i = 0; i < fieldSizeX; i++) {
                    for (int j = 0; j < fieldSizeY; j++) {
                        if (isCellValid(i, j)) {
                            field[i][j] = dotHuman;
                            if (checkWin(dotHuman)) {
                                x = j;
                                y = i;
                                hasTurn = true;
                                field[i][j] = DOT_EMPTY;
                                break loop;
                            }
                            field[i][j] = DOT_EMPTY;
                        }
                    }
                }
                if (!hasTurn) {
                    x = random.nextInt(fieldSizeX);
                    y = random.nextInt(fieldSizeY);
                }
            } while (!isCellValid(y, x));

            field[y][x] = dotAi;
        }

        private static void humanTurn() {
            int x;
            int y;

            do {
                System.out.print("Please enter coordinates x and y: ");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } while (!isCellValid(y, x));

            field[y][x] = dotHuman;
        }

        private static boolean checkWin(char dot) { //изменено! Алгоритм - сдвиг массива 4х4 по всему массиву field(5x5) и проверка.
            //hor
            for(int i = 0; i < fieldSizeX - 1; i++){
                if(field[i][0] == dot && field[i][1] == dot && field[i][2] == dot && field[i][3] == dot) return true;
                if(field[i][1] == dot && field[i][2] == dot && field[i][3] == dot && field[i][4] == dot) return true;
                if(field[i+1][1] == dot && field[i+1][2] == dot && field[i+1][3] == dot && field[i+1][4] == dot) return true;
                if(field[i+1][0] == dot && field[i+1][1] == dot && field[i+1][2] == dot && field[i+1][3] == dot) return true;
            }
            //ver
            for(int i = 0; i < fieldSizeY - 1; i++){
                if(field[0][i] == dot && field[1][i] == dot && field[2][i] == dot && field[3][i] == dot) return true;
                if(field[0][i+1] == dot && field[1][i+1] == dot && field[2][i+1] == dot && field[3][i+1] == dot) return true;
                if(field[1][i+1] == dot && field[2][i+1] == dot && field[3][i+1] == dot && field[4][i+1] == dot) return true;
                if(field[1][i] == dot && field[2][i] == dot && field[3][i] == dot && field[4][i] == dot) return true;
            }
            //diag
            //Несократимо, извените за ваши глаза))
            //Для наглядности сделал +1 к числу. Не считайте пожалуйста за недочет.
            if (field[0][0] == dot && field[1][1] == dot && field[2][2] == dot && field[3][3] == dot) return true;
            if (field[0][3] == dot && field[1][2] == dot && field[2][1] == dot && field[3][0] == dot) return true;

            if (field[0][0+1] == dot && field[1][1+1] == dot && field[2][2+1] == dot && field[3][3+1] == dot) return true;
            if (field[0][3+1] == dot && field[1][2+1] == dot && field[2][1+1] == dot && field[3][0+1] == dot) return true;

            if (field[0+1][0+1] == dot && field[1+1][1+1] == dot && field[2+1][2+1] == dot && field[3+1][3+1] == dot) return true;
            if (field[0+1][3+1] == dot && field[1+1][2+1] == dot && field[2+1][1+1] == dot && field[3+1][0+1] == dot) return true;

            if (field[0+1][0] == dot && field[1+1][1] == dot && field[2+1][2] == dot && field[3+1][3] == dot) return true;
            if (field[0+1][3] == dot && field[1+1][2] == dot && field[2+1][1] == dot && field[3+1][0] == dot) return true;
            return false;
        }

        private static boolean checkDraw() { //изменено! Сократил код
            for(char[] arr : field){
                for(char el : arr){
                    if(el == '*') return false;
                }
            }
            System.out.println("DRAW!");
            return true;
        }

        private static boolean isCellValid(int y, int x) {
            return x >= 0 && y >= 0 && x < fieldSizeX && y < fieldSizeY && field[y][x] == DOT_EMPTY;
        }

        private static void initField(int sizeX, int sizeY) {
            fieldSizeY = sizeY;
            fieldSizeX = sizeX;
            field = new char[fieldSizeY][fieldSizeX];

            for (int y = 0; y < fieldSizeY; y++) {
                for (int x = 0; x < fieldSizeX; x++) {
                    field[y][x] = DOT_EMPTY;
                }
            }
        }

        private static void printField() { //изменено! Свой формат вывода поля.
            System.out.print("  ");
            for(int i = 0; i < fieldSizeY * 2 + 1; i++){
                System.out.print(i % 2 == 0 ? " " : i / 2 + 1);
            }

            System.out.println();
            for(int i = 0; i < fieldSizeX; i++){
                System.out.print((i + 1) + " |");
                for(int j = 0; j < fieldSizeY; j++){
                    System.out.print(field[i][j] + "|");
                }
                System.out.println();
            }
        }
}
