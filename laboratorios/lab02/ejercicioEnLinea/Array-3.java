// fix34

public int[] fix34(int[] nums) {
    int pos = 0;
    while(pos < nums.length && nums[pos] != 3)
     pos++; 
    int bus4 = pos + 1;
    while(bus4 < nums.length && nums[bus4] != 4)
      bus4++;             
    while(pos < nums.length) {
        if(nums[pos] == 3) {
          int temp = nums[pos+1];
          nums[pos+1] = nums[bus4];
          nums[bus4] = temp;                                  
          while(bus4 < nums.length && nums[bus4] != 4)
          bus4++;
      }
        pos++;
    }

    return nums;
}

// fix54

public int[] fix45(int[] nums) {
  for (int i = 0; i < nums.length; i++) {
    if (nums[i] == 4) {
      for (int j = 0; j < nums.length; j++) {
        if (nums[j] == 5) {
          if (j > 0 && nums[j-1] != 4) {
            int tmp = nums[i+1];
            nums[i+1] = 5;
            nums[j] = tmp;
          } 
          else if (j == 0) {
            int tmp = nums[i+1];
            nums[i+1] = 5;
            nums[j] = tmp;
          }
                     
        }
      }
    }
  }
  return nums;
}

// canBalance

public boolean canBalance(int[] nums) {
  int izq = 0;
  
  for (int i = 0; i < nums.length; i++) {
    izq += nums[i];
    int der = 0;
    for (int j = nums.length-1; j > i; j--) {
      der += nums[j];
    }
    if (der == izq)
      return true;
  }
  return false;
}

// linearIn

public boolean linearIn(int[] outer, int[] inner) {
  int sin = 0;
  if(inner.length == 0) {
     return true;
  }
 
  int pos = 0;
  for(int i = 0; i < outer.length; i++) {
    if(outer[i] == inner[pos]) {
      sin++;
      pos++;
    }else if(outer[i] > inner[pos]){
      return false;
    }
    if(sin == inner.length)
      return true;
  }
  return false;
}

// squareUp

public int[] squareUp(int n) {
  int[] sobra = new int[n * n];
  int ayu = 1, pos = 0;
  if(n == 0) { return sobra; }
  for(int i = n-1; i < sobra.length; i+=n) {
     pos = i;
     for(int j = 1; j <= ayu; j++) {
       if(j == 0) { break; }
       sobra[pos] = j;
       pos--;
     }
     ayu++;
  }
  return sobra;
}

























