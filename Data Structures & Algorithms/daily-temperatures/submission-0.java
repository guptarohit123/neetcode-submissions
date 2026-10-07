class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] output = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {
            int current = temperatures[i];
            while(!stack.isEmpty() && stack.peek()[1] < current ) {
                int[] prev = stack.pop();
                output[prev[0]] = i - prev[0];
            }
            int[] entry = new int[]{i,current};
            stack.push(entry);
        }

        while(!stack.isEmpty()) {            
            output[stack.pop()[0]] = 0;
        }

        return output;
        
    }
}
