import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Write
            FileWriter fw = new FileWriter("demo.txt");
            System.out.println("Enter text:");
            String text = sc.nextLine();
            fw.write(text);
            fw.close();

            System.out.println("File written successfully!");

            // Read
            BufferedReader br = new BufferedReader(new FileReader("demo.txt"));
            String line;

            System.out.println("\nFile Content:");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

            // Append
            FileWriter fw2 = new FileWriter("demo.txt", true);
            System.out.println("\nEnter more text:");
            String moreText = sc.nextLine();
            fw2.write("\n" + moreText);
            fw2.close();

            System.out.println("File updated successfully!");

        } catch (IOException e) {
            System.out.println("Error occurred!");
        }
    }
}