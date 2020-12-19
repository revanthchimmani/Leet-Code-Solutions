/**
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

 

Example 1:

Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
 

Note:

1 <= S.length <= 20000
S consists only of English lowercase letters.
*/

class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        //Using Stack -Space O(n)
        /**
        Stack<Character> stackChar=new Stack<>();
        for (int i=0;i<S.length();i++) {
           if(!stackChar.isEmpty() && stackChar.peek() == S.charAt(i)){
               stackChar.pop();
           }else{
               stackChar.push(S.charAt(i));
           }
        }
        //converting the rest of char as String
        StringBuilder sb = new StringBuilder();
        while(!stackChar.isEmpty()){
            sb.append(stackChar.pop());
        }
        return sb.reverse().toString();
        */
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()){
            int size=sb.length();
           if(size>0 && sb.charAt(size-1) == c){
               sb.deleteCharAt(size-1);
           }else{
               sb.append(c);
           }
        }
        return sb.toString();
    }
}
