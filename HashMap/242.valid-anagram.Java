/**
* Given two strings s and t, write a function to determine if t is an anagram of s.
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null || s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Integer> characterMap=new HashMap<>();
        //add all characters to map which are present in String s
        for(char c:s.toCharArray()){
           characterMap.put(c,characterMap.getOrDefault(c,0)+1);
        }
        //remove characters from map which are present in String t
        for(char c:t.toCharArray()){
             if(characterMap.containsKey(c)){
                if(characterMap.get(c)==1){
                    characterMap.remove(c);
                }else{
                    characterMap.put(c,characterMap.get(c)-1);
                }
             }else{
                 return false;
             }
        }
        return characterMap.size()==0;
    }
}
