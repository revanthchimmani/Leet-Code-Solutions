/*
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode"
return 2.
 

Note: You may assume the string contains only lowercase English letters.

Time: O(n)
Space: O(c) -> c=26

*/

class FirstUniqueCharacterString {
    public int firstUniqChar(String s) {
        int[] charCount=new int[26];
        for(Character c:s.toCharArray()){
            charCount[c-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(charCount[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }
}
