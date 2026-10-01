class MinStack {

    private final Deque<Integer> stack;
    private final Deque<Integer> queue;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.queue = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.addFirst(val);
        if(queue.isEmpty() || queue.peekLast() >= val) {
            queue.addLast(val);
        }
    }
    
    public void pop() {        
        int top = stack.removeFirst();
        if(queue.peekLast() == top) {
            queue.pollLast();
        }
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        if(queue.isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
        return queue.peekLast();
    }
}
