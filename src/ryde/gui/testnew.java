package ryde.gui;

public class testnew {

    static testnew  sestnew;

    int  k=3;
    static int  b=3;

    public testnew(){
        System.out.println("dddddddddddd");
        sfsd(k,b);
        System.out.println(k);
        System.out.println(b);
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
