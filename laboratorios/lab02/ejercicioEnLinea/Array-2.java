// countEvens

public int countEvens(int[] nums) {
  int pares = 0;
  for(int i = 0 ; i < nums.length; i++){
    if(nums[i]%2==0){
      pares ++;
    }
  }
  return pares;
}

// sum13

public int sum13(int[] nums) {
    int sum = 0;
    int i = 0;
      
    while(i < nums.length) {
        if(nums[i] == 13) {
            i += 2;
        } else {
            sum += nums[i];
            i++;
        }
    }
                                          
    return sum;
}

// sum67

public int sum67(int[] nums) {
  int suma = 0;
  for(int i = 0; i < nums.length; i++){
    if(nums[i] == 6){
      for(int j = i; j < nums.length; j++){
        if(nums[j] == 7){
          i = j;
          break;
        }
      }
    }else{
      suma = suma + nums[i];
    }
  }
  return suma;
}

// has22

public boolean has22(int[] nums) {
  boolean respuesta = false;
  for(int i = 0; i < nums.length ; i++){
    if(i != (nums.length-1) && nums[i] == 2 && nums[i+1] == 2 ){
      respuesta = true;
      break;
    }
  }
  return respuesta;
}

// lucky13

public boolean lucky13(int[] nums) {
  boolean res = true;
  for(int i = 0; i < nums.length; i++){
    if(nums[i] == 1 || nums[i] == 3){
      res = false;
      break;
    }
  }
  return res;
}
