package com.algorithms.string;
import java.util.Scanner;

/**
 * Created by tom lazar on 9/26/2016.
 */
public class LongestCommonSubstring {

    // Fields
    final static boolean DEBUG = true;

    // LCS Parameters
    private int MatchBonus;
    private int MisMatchPenalty;
    private int InsertionPenalty;
    private int DeletionPenalty;
    private boolean GlobalAlignment;

    //Constructors

    /**
     * Creates a LCS object with default score values, this can be used
     * to find different types of string alligments including.
     * - Global alligment
     * - Semi-Global alligment
     * - Local alligment
     *
     * @return default object.
     */
    public LongestCommonSubstring() {
        MatchBonus = 2;
        MisMatchPenalty = -1;
        InsertionPenalty = -1;
        DeletionPenalty = -1;
        GlobalAlignment = true;
    }

    /**
     * Creates a LCS object with non-default Parameters
     *
     * @return Object
     * @matchBonus Score for a match between two chars
     * @misMatchPenalty Penalty for a mismatch between two chars
     * @insertionPenalty Penalty for inserting a char into the sequence
     * @deletionPenalty Penalty for deleteing a char from the sequence
     * @globalAllignment If the value is true, then the worst score possible is zero
     */
    public LongestCommonSubstring(int matchBonus, int misMatchPenalty,
                                  int insertionPenalty, int deletionPenalty,
                                  boolean globalAlignment) {
        MatchBonus = matchBonus;
        MisMatchPenalty = misMatchPenalty;
        InsertionPenalty = insertionPenalty;
        DeletionPenalty = deletionPenalty;
        GlobalAlignment = globalAlignment;
    }

    /**
     * Runs the program in an interactive terminal.
     */
    public static void InteractiveRunner() {
        char cont; //user input for weather or not the program will continue through multiple runs.
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        do {
            // Vars for input strings
            String S, T;

            // Get Input
            Scanner s = new Scanner(System.in);

            System.out.print("Enter the first sequence: ");
            S = s.nextLine();
            System.out.print("Enter the second sequence: ");
            T = s.nextLine();

            if (DEBUG) {
                System.out.println("FIRST SEQUENCE: " + S);
                System.out.println("SECOND SEQUENCE: " + T);
            }

            // ** PROCESS TABLE **
            String res = lcs.lcs(S, T);
            System.out.println(res);

            // Decide next Program
            System.out.print("Do you want to try again (y/n) ");
            cont = s.nextLine().charAt(0);
        }
        while (cont != 'n');
        System.out.println("Bye!");
    }

    /**
     * Returns the Largest common substring for this sequence
     *
     * @param S the first input string
     * @param T the second input string
     * @return the longest common subsequence of these two.
     */
    public String lcs(String S, String T) {
        int[][] table = new int[S.length() + 1][T.length() + 1];

        // row 0 and column 0 are initialized to 0 already
        for (int i = 0; i < S.length(); i++)
            for (int j = 0; j < T.length(); j++) {
                char a = S.charAt(i),
                        b = T.charAt(j);

                if (S.charAt(i) == T.charAt(j)) // MATCHING
                    table[i + 1][j + 1] = table[i][j] + MatchBonus;
                else if (a != b)                 // mismatch
                    table[i + 1][j + 1] = table[i][j] + MisMatchPenalty;
                else {                           // INSERTION/DELETION
                    int score = Math.max(table[i + 1][j] - InsertionPenalty
                            , table[i][j + 1] - DeletionPenalty);
                    if (GlobalAlignment) {
                        score = Math.max(score, 0);
                    }
                    table[i + 1][j + 1] = score;
                }
            }

        // read the substring out from the matrix
        StringBuffer out = new StringBuffer();
        for (int x = S.length(), y = T.length(), score = 0;
             x != 0 && y != 0; ) {
            if (table[x][y] == table[x - 1][y])
                x--;
            else if (table[x][y] == table[x][y - 1])
                y--;
            else {
                assert S.charAt(x - 1) == T.charAt(y - 1);
                out.append(S.charAt(x - 1));
                x--;
                y--;
            }
        }
        return out.reverse().toString();
    }
}
