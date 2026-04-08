class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length, maxArea = 0;
        int left = 0, right = n-1;
        while(left < right){

            int width = right - left;
            int height = Math.min(heights[left], heights[right]);
            int area = height * width;

            maxArea = Math.max(area,maxArea);

            if(heights[left] < heights[right]){
                left++;
                while(left < right && heights[left]<heights[left-1]){
                    left++;
                }
            }else{
                right--;
                while(left < right && heights[right] < heights[right+1]){
                    right--;
                }
            }
        }

        return maxArea;
    }
}
