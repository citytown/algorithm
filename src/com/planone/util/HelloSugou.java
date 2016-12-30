package com.planone.util;

public class HelloSugou {

	 public static synchronized void main(String[] a){
         Thread t=new Thread(){
             public void run(){Sogou();}
     };
     t.start();
     System.out.print("Hello");
     }
     static synchronized void Sogou(){
     System.out.print("Sogou");
    }
}
