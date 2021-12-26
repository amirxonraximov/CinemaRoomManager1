import java.util.Arrays;
import java.util.Scanner;

class Task {
    public static void main(String[] args) {

        var cubSides = 3;

        Scanner scanner = new Scanner(System.in);
        int[] first = new int[cubSides];
        int[] second = new int[cubSides];
        for (int i = 0; i < cubSides * 2; i++) {
            if (i < cubSides)
                first[i] = scanner.nextInt();
            else
                second[i - cubSides] = scanner.nextInt();
        }
        Arrays.sort(first);
        Arrays.sort(second);

        if (first[0] < second[0] && first[1] < second[1] && first[2] < second[2]) {
            System.out.println("Box 1 < Box 2");
        } else if (first[0] > second[0] && first[1] > second[1] && first[2] > second[2]) {
            System.out.println("Box 1 > Box 2");
        } else {
            System.out.println("Incompatible");
        }
    }
}
