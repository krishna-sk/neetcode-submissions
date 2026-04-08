class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, countOfZeros = 0;
        long product = 1;
        int[] result = new int[n];

        for(int num : nums){
            if(num==0){
                countOfZeros++;
            }else{
                product *=num; 
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i] !=0){
                if(countOfZeros > 0){
                    result[i] = 0;
                }else{
                    result[i] = (int)(product/nums[i]);
                }
            }else{
                if(countOfZeros==1){
                    result[i] = (int) product;
                }else{
                    result[i] =0;
                }
            }
        }

        return result;
    }
}  
