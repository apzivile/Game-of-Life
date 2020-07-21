package life;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Random random;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final int size = scanner.nextInt();
        final long seed = scanner.nextLong();
        int numberOfGenerations = scanner.nextInt();

        random = new Random(seed);

        String[][] previousGeneration = new String[size][size];


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isAlive()) {
                    previousGeneration[i][j] = "O";
                } else {
                    previousGeneration[i][j] = " ";
                }
            }
        }
        //System.out.println(toString(previousGeneration));
        while (numberOfGenerations > 0) {
            previousGeneration = nextGeneration(previousGeneration, size);
            numberOfGenerations--;
        }

        System.out.println(toString(previousGeneration));
    }

    public static boolean isAlive() {
        return random.nextBoolean();
    }

    public static String[][] nextGeneration(String[][] previousGeneration, int universeSize) {
        String[][] nextGeneration = new String[universeSize][universeSize];
        int count = 0;
        int north = 0;
        int east = 0;
        int south = 0;
        int west = 0;
        for (int i = 0; i < universeSize; i++) {
            for (int j = 0; j < universeSize; j++) {
                if (i == universeSize - 1 && j == universeSize - 1) {
                    north = i - 1;
                    east = 0;
                    south = 0;
                    west = j - 1;
                } else if (i > 0 && j == universeSize - 1) {
                    north = i - 1;
                    east = 0;
                    south = i + 1;
                    west = j - 1;
                } else if (i == universeSize - 1 && j > 0) {
                    north = i - 1;
                    east = j + 1;
                    south = 0;
                    west = j - 1;
                } else if (i > 0 && j > 0) {
                    north = i - 1;
                    east = j + 1;
                    south = i + 1;
                    west = j - 1;
                } else if (i == 0 && j == 0) {
                    north = universeSize - 1;
                    east = j + 1;
                    south = i + 1;
                    west = universeSize - 1;
                } else if (i == 0 && j == universeSize - 1) {
                    north = universeSize - 1;
                    east = 0;
                    south = 1;
                    west = j - 1;
                } else if (i == universeSize - 1 && j == 0) {
                    north = i - 1;
                    east = j + 1;
                    south = 0;
                    west = universeSize - 1;
                } else if (i == 0) {
                    north = universeSize - 1;
                    east = j + 1;
                    south = i + 1;
                    west = j - 1;
                } else if (j == 0) {
                    north = i - 1;
                    east = j + 1;
                    south = i + 1;
                    west = universeSize - 1;
                }

                //if (previousGeneration[i][j].equals("O")) {
                if (previousGeneration[north][j].equals("O")) {
                    count++;
                }
                if (previousGeneration[i][east].equals("O")) {
                    count++;
                }
                if (previousGeneration[south][j].equals("O")) {
                    count++;
                }
                if (previousGeneration[i][west].equals("O")) {
                    count++;
                }
                if (previousGeneration[north][east].equals("O")) {
                    count++;
                }
                if (previousGeneration[south][east].equals("O")) {
                    count++;
                }
                if (previousGeneration[south][west].equals("O")) {
                    count++;
                }
                if (previousGeneration[north][west].equals("O")) {
                    count++;
                }

                if ((count == 3 && previousGeneration[i][j].equals("O"))
                        || (count == 2 && previousGeneration[i][j].equals("O"))
                        || (count == 3 && previousGeneration[i][j].equals(" "))) {
                    nextGeneration[i][j] = "O";
                } else {
                    nextGeneration[i][j] = " ";
                }
                count = 0;
            }
        }
        return nextGeneration;

    }


    public static String toString(String[][] generation) {
        return Arrays.deepToString(generation).replace("[", "")
                .replace("]", "\n")
                .replace(", ", "")
                .trim();
    }
}
