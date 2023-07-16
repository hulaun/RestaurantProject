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
    Scanner sc = new Scanner(System.in);
    
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
    
    public int getSelected(){
        display();
        String choice;
        do{
            System.out.print("Enter a selection: ");
            choice = sc.nextLine();
            if(!choice.matches("\\d{1,2}")) System.out.println("Invalid choice. Please enter numbers only");
        }while(!choice.matches("\\d{1,2}"));
        return Integer.parseInt(choice);
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
