class MinStack {

    Deque<Pair> stack; 

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Pair(val,val));
        }else{
            stack.push(new Pair(val,Math.min(stack.peek().min,val)));
        }
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        return stack.peek().min;
    }

    class Pair{
        int value;
        int min;

        public Pair(int value, int min){
            this.value = value;
            this.min = min;
        }
    }
}
