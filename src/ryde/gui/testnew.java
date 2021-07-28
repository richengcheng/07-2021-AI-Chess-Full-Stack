package ryde.gui;

public class testnew {

    static testnew  sestnew;

    int  k=3;
    static int  b=3;

    public testnew(){
     /* System.out.println("dddddddddddd");
        sfsd(k,b);
        System.out.println(k);
        System.out.println(b);
        */

        Math.random();
        for(int i=0;i<20;i++) {
            double b=Math.random() * 10;
            b=b/2;
            int k =(int)b;
            System.out.println(k);
        }

    };


    public void sfssd(int k){
        k++;
    }

    public  void sfsd(int k,int b){
        sfssd(k);
        b++;
    }

    public static void main(String[] args) {

         sestnew =new testnew();

    }


}
