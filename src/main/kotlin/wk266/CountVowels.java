package wk266;

// todo: analyze this
public class CountVowels {
    public long countVowels(String word) {
        int n = word.length();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            if (i == 0)
                arr[i] = n;
            else
                arr[i] = (n - i) + arr[i - 1] - i;
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u')
                sum += arr[i];
        }

        return sum;
    }
}
