import java.io.IOException;
import java.util.Scanner;

public class MainAja
{
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.print("Enter a character: ");
        // Read the char
        String password = null;
            String pass = keyboard.next().replaceAll("\\*", "[A-Za-z0-9]*");


    }
}
