class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n%2==1){
            return false;
        }

        Map<Character,Character> map = Map.of(')','(',']','[','}','{');

        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0;i<s.length();i++){
            char currentChar = s.charAt(i);
            if(map.containsKey(currentChar)){
                if(stack.isEmpty() || map.get(currentChar) != stack.pop()){
                    return false;
                }
            }else{
                stack.push(currentChar);
            }
        }

        return stack.isEmpty();
    }
}
