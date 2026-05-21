class Solution {
    public int trap(int[] height) {

        if(height == null || height.length < 3){
            return 0;
        }
        
        int l = 0;
        int r = height.length - 1;

        int maxLeft = 0;
        int maxRight = 0;
        int totalTrapped = 0;
        
        while(l < r) {
            maxLeft = Math.max(height[l] , maxLeft);
            maxRight = Math.max(height[r], maxRight);
            if(maxLeft < maxRight) {
                int waterAtLeftIndex = Math.min(maxLeft,maxRight) - height[l];
                if(waterAtLeftIndex > 0) {
                    totalTrapped += waterAtLeftIndex;
                }
                l++;
            } else {
                int waterAtRightIndex = Math.min(maxLeft,maxRight) - height[r];
                if(waterAtRightIndex > 0) {
                    totalTrapped += waterAtRightIndex;
                }
                r--;
            }
        }
        return totalTrapped;
    }
}
