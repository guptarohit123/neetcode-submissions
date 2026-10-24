class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int maxBananas = 0;
        for(int pile : piles) {
            maxBananas = Math.max(maxBananas,pile);
        }

        int left = 1;
        int right = maxBananas;        

        while(left <= right) {
            int mid = left + (right-left)/2;
            long hours = 0;
            for(int pile : piles) {
                hours += (long)Math.ceil((double)pile/mid);
            }
            if(hours <= h) {
                right = mid - 1;
            } else if(hours > h){
                left = mid + 1;
            } 
        }

        return left;

    }
}
