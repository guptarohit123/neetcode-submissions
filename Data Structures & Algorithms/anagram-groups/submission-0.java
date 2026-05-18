class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<List<Integer> , List<Integer>> groupedAnagrams = new HashMap<>();
        for(int i = 0; i < strs.length; i ++ ) {
            List<Integer> freqCounter = new ArrayList(Collections.nCopies(26, 0));
            
            for(int j = 0; j < strs[i].length() ; j ++) {
                int counterPos = strs[i].charAt(j) - 'a';
                freqCounter.set(counterPos, freqCounter.get(counterPos) + 1);
            }
            if (!groupedAnagrams.containsKey(freqCounter)) {
                groupedAnagrams.put(freqCounter, new ArrayList());
            }
            groupedAnagrams.get(freqCounter).add(i);
        }

        List<List<String>> result = new ArrayList<>();
        groupedAnagrams.values().forEach(indexList -> {
            List<String> subList = new ArrayList();
            for(Integer strIdx : indexList) {
                subList.add(strs[strIdx]);
            }
            result.add(subList);
        });

        return result;
    }
}
