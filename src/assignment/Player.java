/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment;

/**
 *
 * @author ONG KAI YIN
 */
public class Player {
    
    String name;
    int age ;
    double height,weight;
    String position;
    int salary;

    public Player(String name, int age, double height, double weight, String position, int salary) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.salary = salary;
    }
    
    public String toString (){
       return String.format("%s %d %.2f %.2f %s %d\n",name,age,height,weight,position,salary);
    }
    
    public String printPlayer(){
       return String.format("| %-15s | %-5d |%10.2f |%10.2f |%10s |%7d  |\n",name,age,height,weight,position,salary);
    }
    
    
}
