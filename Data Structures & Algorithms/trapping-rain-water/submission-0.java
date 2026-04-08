class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
            rightMax[n-1-i] = Math.max(rightMax[n-i],height[n-1-i]);
        }
        int water = 0;
        for(int i=0;i<n;i++){
            water += Math.min(leftMax[i], rightMax[i])-height[i];
        }

        return water;
    }
}
/**
         [0 2 0 3 1 0 1 3 2 1]
    lm : [0 2 2 3 3 3 3 3 3 3]
    rm : [3 3 3 3 3 3 3 3 2 1]

*/
