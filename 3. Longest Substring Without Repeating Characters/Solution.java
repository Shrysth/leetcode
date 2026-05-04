// class Solution {
//     public static void main(String[] args) {
//         Solution solution = new Solution();
//         String s = "abcabcbb";
//         int result = solution.lengthOfLongestSubstring(s);
//         System.out.println(result); // Should print 3
//     }

//     public int lengthOfLongestSubstring(String s) {
//         int maxLen = 0;

//         // Loop 'i' is the starting point of the substring
//         for (int i = 0; i < s.length(); i++) {
//             // Loop 'j' is the ending point of the substring
//             for (int j = i + 1; j <= s.length(); j++) {
//                 String substring = s.substring(i, j);
                
//                 // If the substring has no duplicates, check if it's the longest
//                 if (isUnique(substring)) {
//                     maxLen = Math.max(maxLen, substring.length());
//                 }
//             }
//         }
//         return maxLen;
//     }

//     // Helper method to check for repeating characters
//     public boolean isUnique(String sub) {
//         boolean[] visited = new boolean[256]; // For ASCII characters
//         for (int i = 0; i < sub.length(); i++) {
//             char c = sub.charAt(i);
//             if (visited[c]) {
//                 return false; // Found a duplicate
//             }
//             visited[c] = true;
//         }
//         return true;
//     }
// }

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        int maxLength = 0;
        // Map to store character and its last seen index
        Map<Character, Integer> map = new HashMap<>();
        
        // Sliding window pointers: left and right
        int left = 0;
        for (int right = 0; right < n; right++) {
            char current = s.charAt(right);
            
            // If character already exists in current window,
            // move left pointer to after the old position
            if (map.containsKey(current)) {
                left = Math.max(left, map.get(current) + 1);
            }
            
            // Update the last seen position of the character
            map.put(current, right);
            
            // Calculate max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
