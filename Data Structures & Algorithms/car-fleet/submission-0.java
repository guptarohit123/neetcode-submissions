class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int[][] cars = new int[position.length][2];
        for(int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars , (a,b) -> Integer.compare(b[0],a[0]));
        
        Deque<Double> timeOnTargetStack = new ArrayDeque<>();
        
        for(int i = 0; i < cars.length ; i++) {
            double currentTot =  (double)(target - cars[i][0]) / cars[i][1];
           if( timeOnTargetStack.isEmpty() || currentTot > timeOnTargetStack.peek()) {
                timeOnTargetStack.push(currentTot);                
            }
        }

        return timeOnTargetStack.size();

        
    }
}
