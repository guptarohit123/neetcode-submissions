class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0)  {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }

       final Set<Character> collector = new HashSet(s.length());
       int maxLength = 0;
       int L = 0;
       int R = 0;

        while(R < s.length()) {
            if(collector.contains(s.charAt(R))) {
               collector.remove(s.charAt(L));
               L++;             
            } else {
                collector.add(s.charAt(R));
                maxLength = Math.max(maxLength, R-L+1);
                R++;
            }
        }
        return maxLength;
    }
}
