class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int left = 0 , right = nums.length - 1;

        while (left < right) {            
            int current = nums[left] + nums[right];
            if(current > target) {
                right-- ;
                continue;
            }
            if(current < target) {
                left ++;
                continue;
            }
            return new int[] {++left,++right};   
        }

        throw new IllegalArgumentException("no valid solution found for given arguments");
    }
}
