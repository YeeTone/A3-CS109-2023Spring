import java.util.Scanner;

public class TetrisGame {

    /**
     * This is about using 2-D array to simulate Tetris game.
     * The types are as followed:
     *  I, O, T, J, L, S, Z
     *
     *  You will be given multiple lines of number:
     *  first line will be
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int W = in.nextInt();
        int H = in.nextInt();
        int N = in.nextInt();

        /**
         * Build the buffer of the upper bound
         */
        int virtualHeight = H + 3;
        int[][] field = new int[virtualHeight][W];

        /**
         * When a tetromino come, we should first check its type and leftmost index, then find its bottom point.
         *
         * Then, we check the field from bottom to top and find where we can place the tetromino.
         *
         * After placed, we check the field and eliminate the filled lines.
         *
         * In the end, we check the upper bound of the field to see if it is being exceeded.
         */
        for (int i = 0; i < N; i++) {
            String type = in.next();
            int leftmostIndex = in.nextInt();
            /**
             * Check the type and place the tetromino
             */
            switch (type){
                case "I":
                    for (int j = virtualHeight - 1; j >= 2; j--) {
                        int checkFilledCnt = field[j][leftmostIndex] + field[j][leftmostIndex + 1] + field[j][leftmostIndex + 2] + field[j][leftmostIndex + 3];
                        if (checkFilledCnt == 0) {
                            field[j][leftmostIndex] = 1;
                            field[j][leftmostIndex + 1] = 1;
                            field[j][leftmostIndex + 2] = 1;
                            field[j][leftmostIndex + 3] = 1;
                            break;
                        }
                    }
                    break;
                case "O":
                    for (int j = virtualHeight - 1; j >= 2; j--) {
                        int checkFilledCnt = field[j][leftmostIndex] + field[j][leftmostIndex + 1] + field[j - 1][leftmostIndex] + field[j - 1][leftmostIndex + 1];
                        if (checkFilledCnt == 0) {
                            field[j][leftmostIndex] = 1;
                            field[j][leftmostIndex + 1] = 1;
                            field[j - 1][leftmostIndex] = 1;
                            field[j - 1][leftmostIndex + 1] = 1;
                            break;
                        }
                    }
                    break;
                case "L":
                    for (int j = virtualHeight - 1; j >= 2; j--) {
                        int checkFilledCnt = field[j][leftmostIndex] + field[j][leftmostIndex + 1] + field[j - 1][leftmostIndex] + field[j - 2][leftmostIndex];
                        if (checkFilledCnt == 0) {
                            field[j][leftmostIndex] = 1;
                            field[j][leftmostIndex + 1] = 1;
                            field[j - 1][leftmostIndex] = 1;
                            field[j - 2][leftmostIndex] = 1;
                            break;
                        }
                    }
                    break;
                case "J":
                    for (int j = virtualHeight - 1; j >= 2; j--) {
                        int checkFilledCnt = field[j][leftmostIndex] + field[j][leftmostIndex + 1] + field[j - 1][leftmostIndex + 1] + field[j - 2][leftmostIndex + 1];
                        if (checkFilledCnt == 0) {
                            field[j][leftmostIndex] = 1;
                            field[j][leftmostIndex + 1] = 1;
                            field[j - 1][leftmostIndex + 1] = 1;
                            field[j - 2][leftmostIndex + 1] = 1;
                            break;
                        }
                    }
                    break;
                case "T":
                    for (int j = virtualHeight - 1; j >= 2; j--) {
                        int checkFilledCnt = field[j][leftmostIndex + 1] + field[j - 1][leftmostIndex] + field[j - 1][leftmostIndex + 1] + field[j - 1][leftmostIndex + 2];
                        if (checkFilledCnt == 0) {
                            field[j][leftmostIndex + 1] = 1;
                            field[j - 1][leftmostIndex] = 1;
                            field[j - 1][leftmostIndex + 1] = 1;
                            field[j - 1][leftmostIndex + 2] = 1;
                            break;
                        }
                    }
                    break;
                case "S":
                    for (int j = virtualHeight - 1; j >= 2; j--) {
                        int checkFilledCnt = field[j][leftmostIndex] + field[j][leftmostIndex + 1] + field[j - 1][leftmostIndex + 1] + field[j - 1][leftmostIndex + 2];
                        if (checkFilledCnt == 0) {
                            field[j][leftmostIndex] = 1;
                            field[j][leftmostIndex + 1] = 1;
                            field[j - 1][leftmostIndex + 1] = 1;
                            field[j - 1][leftmostIndex + 2] = 1;
                            break;
                        }
                    }
                    break;
                case "Z":
                    for (int j = virtualHeight - 1; j >= 2; j--) {
                        int checkFilledCnt = field[j - 1][leftmostIndex] + field[j - 1][leftmostIndex + 1] + field[j][leftmostIndex + 1] + field[j][leftmostIndex + 2];
                        if (checkFilledCnt == 0) {
                            field[j - 1][leftmostIndex] = 1;
                            field[j - 1][leftmostIndex + 1] = 1;
                            field[j][leftmostIndex + 1] = 1;
                            field[j][leftmostIndex + 2] = 1;
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("invalid type");
                    break;
            }

            /**
             * Eliminate the filled lines
             */
            for (int j = virtualHeight - 1; j >= 2; j--) {
                boolean filled = true;
                for (int k = 0; k < W; k++) {
                    filled = filled && (field[j][k] == 1);
                }

                if (filled) {
                    for (int k = j; k >= 0; k--) {
                        for (int l = 0; l < W; l++) {
                            field[k][l] = k == 0? 0: field[k - 1][l];
                        }
                    }
                    j += 1;
                }
            }

            /**
             * Check the upper bound
             */
            boolean isExceeded = false;
            out: for (int j = 0; j < 3; j++) {
                for (int k = 0; k < W; k++) {
                    if (field[j][k] != 0) {
                        isExceeded = true;
                        break out;
                    }
                }
            }

            if (isExceeded) {
                break;
            }
        }

        /**
         * print the result
         */
        for (int i = 3; i < virtualHeight; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(field[i][j]);
            }
            System.out.print("\n");
        }
    }
}
