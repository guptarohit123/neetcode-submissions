class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) {
            return false;
        }

        int[] targetFreqMap = new int[26];
        int[] windowFreqMap = new int[26];

        for(int i = 0; i < s1.length() ; i++) {
            targetFreqMap[s1.charAt(i) - 'a']++;
            windowFreqMap[s2.charAt(i) - 'a']++;
        }
        int matches = 0;
        for(int i = 0; i < 26; i++) {
            if(targetFreqMap[i] == windowFreqMap[i]) {
                matches++;
            }
        }

        if(matches == 26) {
            return true;
        }
        
        for(int right = s1.length() ; right < s2.length(); right++) {
            int left = right - s1.length() + 1;

            int rightIndex = s2.charAt(right) - 'a';
            windowFreqMap[rightIndex]++;

            if(windowFreqMap[rightIndex] == targetFreqMap[rightIndex]) {
                matches++;
            } else if(windowFreqMap[rightIndex] == targetFreqMap[rightIndex] + 1) {
                matches--;
            }

            int oldLeftIndex = s2.charAt(left - 1) - 'a';
            windowFreqMap[oldLeftIndex]--;

            if(windowFreqMap[oldLeftIndex] == targetFreqMap[oldLeftIndex]) {
                matches++;
            } else if(windowFreqMap[oldLeftIndex] == targetFreqMap[oldLeftIndex] - 1) {
                matches--; 
            }   

            if(matches == 26) {
                return true;
            }
        }

        return false;    
    }
}
