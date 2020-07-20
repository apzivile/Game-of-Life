package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Random random;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int seed = scanner.nextInt();

        random = new Random(seed);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isAlive()) {
                    System.out.print("O");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static boolean isAlive() {
        return random.nextBoolean();
    }
}
