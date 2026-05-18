class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null 
            || s.length() == 0 || t.length() == 0 
            || s.length() != t.length())  {
            return false;
        }
        int[] counts = new int[26];
        for(char sElem : s.toCharArray() ) {
            counts[sElem - 'a']++;
        }

        for(char tElem : t.toCharArray()) {
            if(--counts[tElem - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
