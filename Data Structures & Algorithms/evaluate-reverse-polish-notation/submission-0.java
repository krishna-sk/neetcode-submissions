class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> operators = Set.of("+","-","*","/");
        for(String token : tokens){
            if(operators.contains(token)){
                int b = stack.poll();
                int a = stack.poll();
                stack.push(performOperation(a,b,token));
            }else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.poll();
    }

    public int performOperation(int a, int b, String token){
        return switch(token){
            case "+" -> a + b;
            case "-" -> a -b;
            case "*" -> a *b;
            default -> a/b;
        };
    }
}
