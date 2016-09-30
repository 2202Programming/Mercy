
import java.util.Scanner;

/**
 * Created by tom lazar on 9/26/2016.
 */
public class LongestCommonSubstring
{

    // Fields
    final static boolean DEBUG = true;

    // LCS Parameters
    private int MatchBonus;
    private int MisMatchPenalty;
    private int InsertionPenalty;
    private int DeletionPenalty;

    //Constructors


    public LongestCommonSubstring()
    {
      MatchBonus = 2;
      MisMatchPenalty = -1;
      InsertionPenalty = -1;
      DeletionPenalty = -1;
    }

    public LongestCommonSubstring(int matchBonus, int misMatchPenalty,
                                  int insertionPenalty, int deletionPenalty)
    {
      MatchBonus = matchBonus;
      MisMatchPenalty = misMatchPenalty;
      InsertionPenalty = insertionPenalty;
      DeletionPenalty = deletionPenalty;
    }

    public static void InteractiveRunner(String[] args)
    {
        char cont; //user input for weather or not the program will continue through multiple runs.
        do
        {
            // Vars for input strings
            String S, T;

            // Get Input
            Scanner s = new Scanner(System.in);

            System.out.print("Enter the first sequence: ");
            S = s.nextLine();
            System.out.print("Enter the second sequence: ");
            T = s.nextLine();

            if (DEBUG)
            {
                System.out.println("FIRST SEQUENCE: " + S);
                System.out.println("SECOND SEQUENCE: " + T);
            }

            // ** PROCESS TABLE **
            String res = lcs(S, T);
            System.out.println(res);

            // Decide next Program
            System.out.print("Do you want to try again (y/n) ");
            cont = s.nextLine().charAt(0);
        }
        while (cont != 'n');
        System.out.println("Bye!");
    }

    /** Returns the Largest common substring for this sequence
     * @param S the first input string
     * @param T the second input string
     * @return the longest common subsequence of these two.
     */
    public static String lcs(String S, String T)
    {
        int[][] table = new int[S.length() + 1][T.length() + 1];

        // row 0 and column 0 are initialized to 0 already
        for (int i = 0; i < S.length(); i++)
            for (int j = 0; j < T.length(); j++)
                if (S.charAt(i) == T.charAt(j)) // MATCHING
                    table[i + 1][j + 1] = table[i][j] + 2;
                else
                    table[i + 1][j + 1] = // INSERTION/DELETION
                            Math.max(Math.max(table[i + 1][j] - 1, table[i][j + 1] - 1), 0);

        // read the substring out from the matrix
        StringBuffer out = new StringBuffer();
        for (int x = S.length(), y = T.length(), score = 0;
             x != 0 && y != 0; )
        {
            if (table[x][y] == table[x - 1][y])
                x--;
            else if (table[x][y] == table[x][y - 1])
                y--;
            else
            {
                assert S.charAt(x - 1) == T.charAt(y - 1);
                out.append(S.charAt(x - 1));
                x--;
                y--;
            }
        }
        return out.reverse().toString();
    }
}
