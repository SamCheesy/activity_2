import java.util.Scanner;

public class Main {

    // Failure function
    public static int[] failureFunction(char[] pattern) {
        int n = pattern.length;
        int[] f = new int[n];
        f[0] = 0;
        int t = 0;

        for (int s = 1; s < n; s++) {
            while (t > 0 && pattern[s] != pattern[t]) {
                t = f[t - 1];
            }
            if (pattern[s] == pattern[t]) {
                t++;
            }
            f[s] = t;
        }
        return f;
    }

    // KMP algorithm
    public static boolean kmpSearch(String text, String keyword) {
        char[] a = text.toCharArray();
        char[] b = keyword.toCharArray();
        int m = a.length;
        int n = b.length;
        int[] f = failureFunction(b);
        int s = 0;

        for (int i = 0; i < m; i++) {
            while (s > 0 && a[i] != b[s]) {
                s = f[s - 1];
            }
            if (a[i] == b[s]) {
                s++;
            }
            if (s == n) {
                return true;
            }
        }
        return false;
    }

    public static void runTest(String text, String keyword, String label) {
        boolean found = kmpSearch(text, keyword);
        System.out.println(label);
        System.out.println("Text:    " + text);
        System.out.println("Keyword: " + keyword);
        System.out.println("Result:  " + (found ? "yes" : "no"));
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyword = "ababaa";

        System.out.println("KMP Algorithm - Exercise 3.4.6");
        System.out.println("Keyword used: " + keyword);
        System.out.println();
        System.out.println("Choose an option:");
        System.out.println("1 -> a) text = abababaab");
        System.out.println("2 -> b) text = abababbaa");
        System.out.println("3 -> Both");
        System.out.println("4 -> Enter your own text");
        System.out.print("Enter option: ");

        int option = scanner.nextInt();
        System.out.println();

        switch (option) {
            case 1:
                runTest("abababaab", keyword, "Case a)");
                break;
            case 2:
                runTest("abababbaa", keyword, "Case b)");
                break;
            case 3:
                runTest("abababaab", keyword, "Case a)");
                runTest("abababbaa", keyword, "Case b)");
                break;
            case 4:
                System.out.print("Enter your text: ");
                String userText = scanner.next();
                System.out.println();
                runTest(userText, keyword, "Custom case");
                break;
            default:
                System.out.println("Invalid option.");
        }

        System.out.println("To try again, run the program again.");
        scanner.close();
    }
}
