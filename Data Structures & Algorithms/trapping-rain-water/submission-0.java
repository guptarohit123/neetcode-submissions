class Solution {
    public int trap(int[] height) {

        if(height == null || height.length < 3) {
            return 0;
        }
        int[] prefixSum = new int[height.length];
        int[] suffixSum = new int[height.length];

        //prefix sum
        int maxLeft = 0;
        for(int i = 1 ; i < height.length; i++) {
            maxLeft = Math.max(maxLeft,height[i-1]);
            prefixSum[i] = maxLeft;
        }
        //suffix sum
        int maxRight = 0;
        for(int i = height.length-2; i >= 0; i-- ) {
            maxRight = Math.max(height[i+1],maxRight);
            suffixSum[i] = maxRight;
        }
        // actual water trapped at index
        int res = 0;
        for(int i = 0 ; i < height.length; i++) {
            int trapped = Math.min(prefixSum[i], suffixSum[i]) - height[i];
            if(trapped > 0) {
                res += trapped;
            }
        }
        return res;
    }
}
