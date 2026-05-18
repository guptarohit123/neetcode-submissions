class Solution {
    public int maxArea(int[] heights) {
        
        int left = 0;
        int right = heights.length - 1;
        int currentMax = 0;
        while(left < right) {
            int volume = Math.min(heights[left], heights[right]) * (right - left);
            currentMax = Math.max(volume,currentMax);
            if(heights[left] < heights[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return currentMax;
    }
}
