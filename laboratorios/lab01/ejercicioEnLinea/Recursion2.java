public class Recursion2{

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) 
        return target == 0;
        return groupNoAdj(start + 2, nums, target - nums[start])
        || groupNoAdj(start + 1, nums, target);
    }

    public boolean splitArray(int[] nums) {
        return ayuda(0, nums, 0, 0);
    }
       
    private boolean ayuda(int inicio, int[] nums, int sum1, int sum2) {
          if (inicio >= nums.length) 
          return sum1 == sum2;
          return ayuda(inicio + 1, nums, sum1 + nums[inicio], sum2)
          || ayuda(inicio + 1, nums, sum1, sum2 + nums[inicio]);
    }

    public boolean splitOdd10(int[] nums) {
        return ayuda(0, nums, 0, 0);
    }
    private boolean split(int inicio, int[] nums, int sum1, int sum2) {
          if (inicio >= nums.length)
            return sum1 % 10 == 0 && sum2 % 2 == 1 || sum1 % 2 == 1
            && sum2 % 10 == 0;
          return split(inicio + 1, nums, sum1 + nums[inicio], sum2)
           || split(inicio + 1, nums, sum1, sum2 + nums[inicio]);
    }

    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) return target == 0;
       
          int sum = nums[start];
          int count = 1;
          for (int i = start + 1; i < nums.length; i++)
            if (nums[i] == nums[start]) {
              sum += nums[i];
              count++;
            }
          return groupSumClump(start + count, nums, target - sum)
            || groupSumClump(start + count, nums, target);
    }
      
      
      
   


      
}