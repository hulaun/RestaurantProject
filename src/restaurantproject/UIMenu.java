/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurantproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ACER
 * @param <T>
 */
public abstract class UIMenu<T> {
    protected String title;
    protected ArrayList<T> mChon;
    
    public UIMenu(){}

    public UIMenu(String td, String[] mc) {
        title = td;
        mChon = new ArrayList<>();
        for(String s:mc) mChon.add((T)s);
    }
    
    public void display(){
        System.out.println(title);
        System.out.println("------------------------------");
        for(int i =0; i<mChon.size();i++){
            System.out.println((i+1) +"."+mChon.get(i));
        }
        System.out.println("------------------------------");
    }
    
    public int getSelected() {
        display();
        Scanner sc = new Scanner(System.in);
        
        int tmp = 0;
        while (tmp <= 0 || tmp > mChon.size()) {
            System.out.print("Choose an option: ");
            tmp = sc.nextInt();

            if (tmp <= 0 || tmp > mChon.size()) {
                System.out.println("Invalid option!");
            }
        }

        return tmp;
    }
    
    public abstract void execute(int n);
            
    public void run(){
        while(true){
            int n=getSelected();
            execute(n);
            if(n>=mChon.size()) break;
        }
    }
}
