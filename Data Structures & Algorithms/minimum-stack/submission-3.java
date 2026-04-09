class MinStack {

    Deque<Long> stack; 
    long min = 0;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push((long) val);
            min = val;
        }else{
            if(val < min){
                stack.push(2L * val-min);
                min = val;
            }else{
                stack.push((long)val);
            }
        }
    }
    
    public void pop() {
        long top = stack.pop();
        if(top < min){
            min = 2L * min - top;
        }
    }
    
    public int top() {
       long top = stack.peek();

       if(top<min){
            return (int) min;
       }else{
        return (int) top;
       }
    }
    
    public int getMin() {
        return (int) min;
    }

}

/**

    5 6 1

    min : 5 | 3
    val : 3 | 2 * val - min

*/
