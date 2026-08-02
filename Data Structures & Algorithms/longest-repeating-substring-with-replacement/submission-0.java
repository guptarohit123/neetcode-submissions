class Solution {
    public int characterReplacement(String s, int k) {
        
        Map<Character,Integer> count = new HashMap<>();

        int L = 0, R = 0;
        int res = 0;

        for( ; R < s.length(); R++) {
            char current = s.charAt(R);
            count.put(current, count.getOrDefault(current , 0) + 1);
            
            int maxCount = Collections.max(count.values());
            while(R - L + 1 - maxCount > k && L <= R) {
                count.compute(s.charAt(L), (p,v) -> --v);
                L++;
                maxCount = Collections.max(count.values());
            }

            res = Math.max(res , R-L+1);
        }
        return res;
    }
}
