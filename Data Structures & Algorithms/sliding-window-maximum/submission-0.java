class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> q = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int resIdx = 0;
        int l = 0, r = 0;

        while( r < n) {
            
            int incoming = nums[r];
            while(!q.isEmpty() && nums[q.peekLast()] < incoming) {
                q.pollLast();
            }
            q.addLast(r);

            if(l > q.peekFirst()) {
                q.pollFirst();
            }

            if(r + 1 >= k) {
                res[l] = nums[q.peekFirst()];
                l++; 
            } 
            
            r++;
            
        }

        return res;    



        
                    
    }
}
