class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character,Integer> collector = new HashMap<>();
        int L = 0, res = 0;

        for(int R = 0; R < s.length(); R++) {
            if(collector.containsKey(s.charAt(R))) {
                L = Math.max(L,collector.get(s.charAt(R)) + 1);                
            } 
            collector.put(s.charAt(R) , R);
            res = Math.max(res , R-L+1);            
        }
        return res;
    }
}
