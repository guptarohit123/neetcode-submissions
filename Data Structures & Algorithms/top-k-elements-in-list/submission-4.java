class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> counts = new HashMap<>();
        for(int num : nums) {
            counts.put(num, counts.getOrDefault(num , 0) + 1);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        for(Map.Entry<Integer,Integer> entry : counts.entrySet()) {
            heap.offer(new int[]{entry.getValue() , entry.getKey()});
            if(heap.size() > k) {
                heap.poll();
            }
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = heap.poll()[1];
        }

        return res;
        
    }
}
