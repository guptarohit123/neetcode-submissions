class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int i = -1;
        int j;
        while(i < nums.length - 1) {
            i ++;
            j = i + 1;    
            while(j < nums.length ) {
                if(nums[i] + nums[j] == target ) {
                    return new int[]{i , j};
                }
                j ++;
            }
        }
        throw new IllegalArgumentException("no valid answer found for given arguments");
    }
}
