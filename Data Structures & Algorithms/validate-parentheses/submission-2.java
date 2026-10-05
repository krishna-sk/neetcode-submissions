class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = Map.of(']', '[', '}', '{', ')', '(');
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char currChar = s.charAt(i);
            if (map.containsKey(currChar)) {
                if (stack.isEmpty() || stack.pop() != map.get(currChar)) {
                    return false;
                }
            } else {
                stack.push(currChar);
            }
        }

        return stack.isEmpty();
    }
}
