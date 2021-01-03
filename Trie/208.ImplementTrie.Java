/**
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
*/
class Trie {
    /* Initialization of TrieNode class*/ 
    class TrieNode {
        public TrieNode[] child;
        public boolean isWord;
        
        public TrieNode(){
            this.child=new TrieNode[26];
            this.isWord=false;
        }
    }
    /* declare root node*/
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur=root;
        for(Character ch : word.toCharArray()){
            
            if(cur.child[ch-'a']==null){
                cur.child[ch-'a'] = new TrieNode();
            }
            cur=cur.child[ch-'a'];
        }
        cur.isWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode resultWord=searchWord(word);
        return (resultWord!=null ? resultWord.isWord : false);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return (searchWord(prefix)!=null ? true : false);
    }
    
    private TrieNode searchWord(String word){
        TrieNode current = root;
        for(Character c:word.toCharArray()){
            if(current.child[c-'a']==null){
                return null;
            }
            current =current.child[c-'a'];
        }
        return current;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
