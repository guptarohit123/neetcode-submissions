class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character,Integer> counts = new HashMap<>();

        for(char ch : s.toCharArray()) {
            counts.put(ch, counts.getOrDefault(ch , 0) + 1);
        }

        for(char ch : t.toCharArray()) {
            int count = counts.getOrDefault(ch , 0);
            if(count == 0) {
                return false;
            }
            counts.put(ch , count - 1);
        }

        return true;
    }
}
