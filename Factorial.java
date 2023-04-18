import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program uses recursion to reverse,
 * a set of strings.
 *
 * @author  Sarah Andrew
 * @version 1.0
 *
 * @since 2023-13-04.
 */

public final class Factorial {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Factorial() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        // Usage of try catch to detect error.
        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                final String line = sc.nextLine();
                try {
                    // Parse the input as double.
                    final double newLine = Double.parseDouble(line);

                    // Declare variable.
                    final double aStr = newLine;

                    // Call function.
                    final double factorialNum = recFactorial(aStr);

                    // Display results.
                    System.out.print("The factorial of " + aStr);
                    System.out.print(" is " + factorialNum + "\n");

                    // Write to console.
                    write.print("The factorial of " + aStr);
                    write.println(" is " + factorialNum);
                } catch (NumberFormatException e) {
                    // Displays error to user if input is not a valid double.
                    System.out.println("Invalid, \""
                            + line + "\" is not a valid number.");
                    write.print("Error: Invalid, \""
                            + line + "\" is not a valid number.");
                }
            }
            // Closes scanner & writer.
            write.close();
            sc.close();
        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
    * This function uses recursion to
    * reverse a string.
    *
    * @param aNum passed
    * @return recFactorial.
    */

    public static double recFactorial(double aNum) {
        // Checking to see if line is empty.
        if (aNum <= 1) {
            return 1;
        } else {
            return recFactorial(aNum - 1) * aNum;
        }
    }
}
