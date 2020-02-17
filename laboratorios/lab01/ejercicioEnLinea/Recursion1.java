public class Recursion1{

public int factorial(int n) {
    if(n==1){
      return 1;
    }else return n * factorial(n-1);
  }

public int bunnyEars(int bunnies) {
    if(bunnies==0){
      return 0;
    }else if(bunnies==1){
      return 2;
      
    }else return 2 + bunnyEars(bunnies-1);
  }
public int bunnyEars2(int bunnies) {
    if(bunnies == 0){
      return 0;
    }else if (bunnies==1){
      return 2;
    }else if (bunnies%2 == 0){
      return 3 + bunnyEars2(bunnies-1);
    }else return 2 +  bunnyEars2(bunnies-1);
  }
public int triangle(int rows) {
    if (rows == 0){
      return 0;
    }else if(rows == 1){
      return 1;
      
    }else return rows + triangle(rows-1);
  }
public int sumDigits(int n) {
    if (n/10 == 0 ){
      return n;
    }else return sumDigits(n/10) + n%10;
  }
public int count7(int n) {
  
    if (n == 0){
      return 0;
      }  
     else if(n%10 == 7){
     return 1+count7(n/10);
     }else {
      return count7(n/10);
     }
    }
public int count8(int n) {
        if(n==0){
          return 0;
        }
        if(n%10 == 8 && n % 100 == 88){
        return 2 + count8(n/10);
        }
        if(n%10 == 8){
        return 1 + count8(n/10);
        }
        return count8(n/10);
      }
public int powerN(int base, int n) {
    if(base==0){
      return 0;
    }
    if(n==0){
      return 1;
    }
    if(n==1){
      return base;
    }
    return base * powerN(base,n-1);
  }   
}
    



    