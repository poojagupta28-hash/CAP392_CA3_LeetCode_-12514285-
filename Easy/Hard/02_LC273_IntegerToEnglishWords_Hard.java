class Solution {

    private static final String[] ones = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] units = {
        "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder ans = new StringBuilder();
        int group = 0;

        while (num > 0) {
            int part = num % 1000;

            if (part != 0) {
                String word = convert(part);
                String current = word + (units[group].isEmpty() ? "" : " " + units[group]);

                if (ans.length() == 0)
                    ans.insert(0, current);
                else
                    ans.insert(0, current + " ");
            }

            num /= 1000;
            group++;
        }

        return ans.toString();
    }

    private String convert(int num) {
        StringBuilder sb = new StringBuilder();

        if (num >= 100) {
            sb.append(ones[num / 100]).append(" Hundred");
            num %= 100;
            if (num > 0) sb.append(" ");
        }

        if (num >= 20) {
            sb.append(tens[num / 10]);
            num %= 10;
            if (num > 0) sb.append(" ");
        }

        if (num > 0 && num < 20) {
            sb.append(ones[num]);
        }

        return sb.toString();
    }
}
