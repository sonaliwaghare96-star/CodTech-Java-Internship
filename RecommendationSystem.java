import java.util.Scanner;

public class RecommendationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Books");
        System.out.println("2. Movies");
        System.out.println("3. Music");

        System.out.print("Enter Choice: ");
        int ch = sc.nextInt();

        if (ch == 1)
            System.out.println("Recommended: Java, Python, Data Structures");

        else if (ch == 2)
            System.out.println("Recommended: 3 Idiots, Interstellar");

        else if (ch == 3)
            System.out.println("Recommended: Arijit Songs, Lo-fi");

        else
            System.out.println("Invalid Choice");

        sc.close();
    }
}