
public class Problem208 {
	
	Problem208() {
		Trie mTrie = new Trie();
		mTrie.insert("abd");
		boolean ans = mTrie.search("abdb");
		if(ans == true){
			System.out.println("find this word");
		}
		else
			System.out.println("not find this word");
	}
	
	public static void main(String[] args) {
		Problem208 m = new Problem208();
	}
	class TrieNode {
		boolean have;
		TrieNode[] children = null;
		
	    // Initialize your data structure here.
	    public TrieNode() {
	    	have = false;
	    	children = new TrieNode[26];
	    }
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	        TrieNode cur = root;
	        int len = word.length();
	        
	        for(int i = 0; i < len; i ++) {
	        	int index = word.charAt(i) - 'a';
	        	if(cur.children[index] == null) {
	        		cur.children[index] = new TrieNode();
	        	}
	        	cur = cur.children[index];
	        }
	        cur.have = true;
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        int len = word.length();
	        TrieNode cur = root;
	        boolean ans = false;
	        
	        int i;
	        for(i = 0; i < len; i ++) {
	        	int index = word.charAt(i) - 'a';
	        	cur = cur.children[index];
	        	if(cur == null) {
	        		ans = false;
	        		break;
	        	}
	        }
	        if(i == len && cur.have == true) 
	        	ans = true;
	        return ans;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        boolean ans = true;
	        int len = prefix.length();
	        TrieNode cur = root;
	        
	        for(int i = 0; i < len; i ++) {
	        	int index = prefix.charAt(i) - 'a';
	        	cur = cur.children[index];
	        	if(cur == null) {
	        		ans = false;
	        		break;
	        	}
	        }
	        return ans;
	    }
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
