// class Solution {

//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         String s = "cbbd";
//         String longestPalindrome = solution.longestPalindrome(s);
//         System.out.println("Longest Palindromic Substring: " + longestPalindrome);
//     }

//     public String longestPalindrome(String s) {
//     String maxStr = "";
//     for (int i = 0; i < s.length(); i++) {
//         for (int j = i + 1; j <= s.length(); j++) {
//             String sub = s.substring(i, j);
//             if (sub.length() > maxStr.length() && isPalindrome(sub)) {
//                 maxStr = sub;
//             }
//         }
//     }
//     return maxStr;
// }

// private boolean isPalindrome(String sub) {
//     return new StringBuilder(sub).reverse().toString().equals(sub);
// }
// }

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "mqizdjrfqtmcsruvvlhdgzfrmxgmmbguroxcbhalzggxhzwfznfkrdwsvzhieqvsrbyedqxwmnvovvnesphgddoikfwuujrhxwcrbttfbmlayrlmpromlzwzrkjkzdvdkpqtbzszrngczvgspzpfnvwuifzjdrmwfadophxscxtbavrhfkadhxrmvlmofbzqshqxazzwjextdpuszwgrxirmmlqitjjpijptmqfbggkwaolpbdglmsvlwdummsrdyjhmgrasrblpjsrpkkgknsucsshjuxunqiouzrdwwooxclutkrujpfebjpoodvhknayilcxjrvnykfjhvsikjabsdnvgguoiyldshbsmsrrlwmkfmyjbbsylhrusubcglaemnurpuvlyyknbqelmkkyamrcmjbncpafchacckhymtasylyfjuribqxsekbjkgzrvzjmjkquxfwopsbjudggnfbuyyfizefgxamocxjgkwxidkgursrcsjwwyeiymoafgyjlhtcdkgrikzzlenqgtdukivvdsalepyvehaklejxxmmoycrtsvzugudwirgywvsxqapxyjedbdhvkkvrxxsgifcldkspgdnjnnzfalaslwqfylmzvbxuscatomnmgarkvuccblpoktlpnazyeazhfucmfpalbujhzbykdgcirnqivdwxnnuznrwdjslwdwgpvjehqcbtjljnxsebtqujhmteknbinrloregnphwhnfidfsqdtaexencwzszlpmxjicoduejjomqzsmrgdgvlrfcrbyfutidkryspmoyzlgfltclmhaeebfbunrwqytzhuxghxkfwtjrfyxavcjwnvbaydjnarrhiyjavlmfsstewtxrcifcllnugldnfyswnsewqwnvbgtatccfeqyjgqbnufwttaokibyrldhoniwqsflvlwnjmffoirzmoxqxunkuepj";
        System.out.println("Longest Palindromic Substring: " + solution.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Case 1: Palindrome like "aba" (centered at i)
            int len1 = expandFromMiddle(s, i, i);
            // Case 2: Palindrome like "abba" (centered between i and i+1)
            int len2 = expandFromMiddle(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            
            // If we found a longer one, update our pointers
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandFromMiddle(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Returns the length of the palindrome found
        return right - left - 1;
    }
}