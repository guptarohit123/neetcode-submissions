class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> counts = new HashMap();
        List<Integer>[] freq = new List[nums.length + 1];

        for(int i = 0; i < nums.length + 1; i++) {
            freq[i] = new ArrayList();
        }

        for (int n : nums) {
            counts.put(n, counts.getOrDefault(n , 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : counts.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        List<Integer> result = new ArrayList();
        int addedCount = 0;
        for(int i = freq.length -1 ; i > 0 && addedCount<k ; i--) {
            if(!freq[i].isEmpty()) {
                result.addAll(freq[i]);
                addedCount+=freq[i].size();
            }
        }

        return result.stream().mapToInt(i -> i).toArray();        

    }
}
