class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> numsSet = new HashSet(nums.length);

        for(int num : nums) {
            numsSet.add(num);
        }
        
        int longestConsecutive = 0;

        for(int num : nums) {
            if(!numsSet.contains(num - 1)) {
                int next = num + 1;
                int count = 1;
                while(numsSet.contains(next)) {
                    count ++;
                    next ++;
                }
                longestConsecutive = Math.max(longestConsecutive, count);
            }
        }

        return longestConsecutive;

    }
}
