class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length, index = 0;  
        int[] result = new int[n-k+1];

        for(int i=0;i<n;i++){
            
            while(!deque.isEmpty() && deque.peekFirst() <= i-k){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);

            if(i >= k-1){
                result[index++] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}

