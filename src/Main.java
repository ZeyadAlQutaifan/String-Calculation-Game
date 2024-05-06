import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String t = scanner.nextLine();
        int maxSubstringValue = findMaxSubstringValue(t);
        System.out.println(maxSubstringValue);
        scanner.close();
    }



    public static int findMaxSubstringValue(String t) {
        int max = 0;
        int n = t.length();

        // Iterate through each character in t
        for (int i = 0; i < n; i++) {
            // Calculate f(s) for substrings starting from i
            for (int j = i; j < n; j++) {
                String substring = t.substring(i, j + 1);
                int length = substring.length();
                int count = 0;

                // Count the occurrences of substring in t
                for (int k = 0; k <= n - length; k++) {
                    if (t.substring(k, k + length).equals(substring)) {
                        count++;
                    }
                }

                // Update max if f(s) for current substring is greater
                max = Math.max(max, length * count);
            }
        }
        return max;
    }

}