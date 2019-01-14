package leetcode;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 *
 * <p>Given a string, find the length of the longest substring without repeating characters.</p>
 *
 * <p>Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.</p>
 *
 *
 * @author zhushuai
 */
public class Solution1 {


    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int result = 0;
        List<Character> temp = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            char character = s.charAt(i);
            if (temp.contains(character)) {
                result = Math.max(result, temp.size());
                temp = temp.subList(temp.indexOf(character) + 1, temp.size());
                temp.add(character);
            } else {
                temp.add(character);
                result = Math.max(result, temp.size());
            }
        }
        return result;
    }


    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String testStr = "abcdefgdab";
        System.out.println(lengthOfLongestSubstring2(testStr));
    }
}
