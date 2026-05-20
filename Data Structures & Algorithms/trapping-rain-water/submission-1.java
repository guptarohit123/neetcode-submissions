class Solution {
    public int trap(int[] height) {

        if(height == null || height.length < 3) {
            return 0;
        }
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];

        //prefix sum
        int leftMax = 0;
        for(int i = 1 ; i < height.length; i++) {
            leftMax = Math.max(leftMax,height[i-1]);
            maxLeft[i] = leftMax;
        }
        //suffix sum
        int rightMax = 0;
        for(int i = height.length-2; i >= 0; i-- ) {
            rightMax = Math.max(height[i+1],rightMax);
            maxRight[i] = rightMax;
        }
        // actual water trapped at index
        int res = 0;
        for(int i = 0 ; i < height.length; i++) {
            int waterAtIndex = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if(waterAtIndex > 0) {
                res += waterAtIndex;
            }
        }
        return res;
    }
}
