class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty() || t.length() > s.length()) {
            return "";
        }

        Map<Character,Integer> countT = new HashMap();
        Map<Character,Integer> countS = new HashMap();

        for(int i = 0; i < t.length() ; i++)  {
            countT.put(t.charAt(i),countT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;

        int need = countT.size();
        int have = 0;
        int resLeft = -1 , resRight = -1, resLen = Integer.MAX_VALUE;
        
        for(int right = 0; right < s.length(); right++) {
            char chRight = s.charAt(right);
            countS.put(chRight,countS.getOrDefault(chRight,0) + 1);

            if(countT.containsKey(chRight) && countT.get(chRight).equals(countS.get(chRight))) {
                have++;
            }
            
            while(have == need) {
                if(right - left + 1 < resLen) {
                    resLeft = left;
                    resRight = right;
                    resLen = right - left + 1;
                }
                char chLeft = s.charAt(left);
                countS.put(chLeft,countS.get(chLeft) - 1);
                if(countT.containsKey(chLeft) && countS.get(chLeft) < countT.get(chLeft)) {
                    have--;
                }
                left++;
            }

        }

        if(resLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(resLeft,resRight+1);

    }
}
