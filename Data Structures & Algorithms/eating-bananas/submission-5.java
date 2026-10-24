class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int maxBananas = 0;
        for(int pile : piles) {
            maxBananas = Math.max(maxBananas,pile);
        }

        int left = 1;
        int right = maxBananas;        
        int res = right;

        while(left <= right) {
            int mid = left + (right-left)/2;
            long hours = 0;
            for(int pile : piles) {
                hours += Math.ceil((double)pile/mid);
            }
            if(hours <= h) {
                res = mid;
                right = mid - 1;
            } else if(hours > h){
                left = mid + 1;
            } 
        }

        return res;

    }
}
