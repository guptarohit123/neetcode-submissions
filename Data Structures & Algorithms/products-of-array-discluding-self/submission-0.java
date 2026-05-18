class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];

        int prefixProduct = 1;
        int suffixProduct = 1;
        for(int i = 0; i < res.length; i++) {
            res[i] = prefixProduct;
            prefixProduct *= nums[i];
        }
        for(int i = res.length - 1; i >= 0 ; i--)  {
            res[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return res;
    }
}