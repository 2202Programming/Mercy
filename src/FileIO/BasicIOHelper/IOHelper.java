package FileIO.BasicIOHelper;

import java.io.*;
import java.util.Arrays;

/**
 * Created by lazar on 9/8/2016.
 * Basic helper for simple File IO operations.
 * v1.0.1
 * @author Tom Lazar
 *         (262) 408-0490
 *         thomas.lazar@marquette.edu
 */
public class IOHelper {

    private final File inputFile;
    private final File outputFile;

    /**
     * Constructs a new helper with the input and output linked to the same file
     * @param nFile file to write and read
     */
    public IOHelper(String nFile) {
        inputFile = new File(nFile);
        outputFile = inputFile;
    }

    /**
     * Constructs a new helper with seperate input and output files
     * @param inputPath file to read input from
     * @param outputPath file to write output to
     */
    public IOHelper(String inputPath, String outputPath) {
        inputFile = new File(inputPath);
        outputFile = new File(outputPath);
    }

    /**
     * Reads all text from the input file.
     * @return string representation of the file's contents
     */
    public String readAll() {
        StringBuilder sb = new StringBuilder();
        try {
            Reader r = new InputStreamReader(new FileInputStream(inputFile));
            int c;
            while ((c = r.read()) != -1)
                sb.append((char) c);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Reads all text input from the input file, and then splits it into
     * seperate strings based on lines.
     * @return Array of N strings from a file where each string is line from the
     * input file.
     */
    public String[] readAllAsArray() {
      return this.readAll().split("\n");
    }

    /**
     * writes the input to the file, this operation is destructive to the previous contents of the file.
     * @param out string to write
     */
    public void writeAll(String out) {
        try {
            PrintWriter writer = new PrintWriter(outputFile);
            writer.print(out);
            writer.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File " + outputFile.getName() + " not found\nStackTrance:\n" + Arrays.toString(e.getStackTrace()));
        }
    }
}
