public class Main {
    public static void main(String[]args){
        for(int i=0;i<=50; i+=2){
            long inicio = System.currentTimeMillis();
            ways(i);
            long fin = System.currentTimeMillis();
            long tiempo = fin-inicio;
            System.out.println(i+"//"+tiempo);
        }
    }
    
    public static int ways(int n){
      if(n<=2){
            return n;
        }else{
            return ways(n-1) + ways(n-2);   
        } 
    }
}