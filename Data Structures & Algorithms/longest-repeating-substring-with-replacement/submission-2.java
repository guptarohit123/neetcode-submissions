class Solution {

    //AAABABBA:: K=2 :: res = 7


    public int characterReplacement(String s, int k) {
        
        int[] freq = new int[26];
        int maxFreq = 0;
        int left = 0;
        int res = 0;

        for(int right = 0; right < s.length(); right++) {
            int rightIndex = s.charAt(right) - 'A';
            freq[rightIndex]++;
            maxFreq = Math.max(maxFreq,freq[rightIndex]);

            int windowLength = right - left + 1;
            while(windowLength - maxFreq > k) {
                int leftIndex = s.charAt(left) - 'A';
                freq[leftIndex]--;
                left++;
                windowLength = right - left + 1;
            }
            res = Math.max(res, windowLength);
        }

        return res;

    }
}
