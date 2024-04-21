/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author ONG KAI YIN
 */

import java.io.*;


public class NBA {
    
    
    public static void AppendData(String data,String file){  
        try{
        PrintWriter pw = new PrintWriter(new FileOutputStream(file,true));
        pw.write(data);
        pw.close();
        
        }catch(FileNotFoundException e){
           e.printStackTrace();
        }
    }
    
    public static void addPlayer(String name){
        
        // file store NBA players at agent market
         String File="C:\\Users\\ONG KAI YIN\\Desktop\\Players.txt";
         
         // file store teams player
         String TeamFile="C:\\Users\\ONG KAI YIN\\Desktop\\team.txt";
         
         
         try {
             BufferedReader br = new BufferedReader(new FileReader(File));
             String r;
             String [] read;
             
             // check whethere got player added
             int check=0;
             
             int count=0;
             
             while((r=br.readLine())!=null){
                 read=r.split(" ");
                 Player player = new Player(read[0],Integer.parseInt(read[1]),Double.parseDouble(read[2]),Double.parseDouble(read[3]),read[4],Integer.parseInt(read[5]));
                 if(read[0].equals(name)){
                     AppendData(player.toString(),TeamFile);
                     check++;
                 }else{
                    if(count==0){
                       RewriteData(player.toString(),File);
                       count++;
                    }else{
                        AppendData(player.toString(),File);
                    }
                 }
             }
             
             System.out.println(Check(check));
             printTeam();
             br.close();
             
         }catch(IOException e){
            e.printStackTrace();
         }
         
         
    }
    
    public static String Check(int check){
        if(check>0){
          return "Player is found and succesffuly added to the team";
        }else{
           return "Player is not found";
        }
    }
    
    
    public static void Delete(String name){
        
        // file store NBA players at agent market
         String File="C:\\Users\\ONG KAI YIN\\Desktop\\Players.txt";
         
         // file store teams player
         String TeamFile="C:\\Users\\ONG KAI YIN\\Desktop\\team.txt";
        
         try{
             BufferedReader br = new BufferedReader(new FileReader(TeamFile));
             String r;
             String read[];
             int count=0;
             
             while((r=br.readLine())!=null){
               read=r.split(" ");
               Player player = new Player(read[0],Integer.parseInt(read[1]),Double.parseDouble(read[2]),Double.parseDouble(read[3]),read[4],Integer.parseInt(read[5]));
               if(!read[0].equals(name)){
                   if(count==0){
                       RewriteData(player.toString(),TeamFile);
                       count++;
                   }else{
                       AppendData(player.toString(),TeamFile); 
                   }
                   
               }else{
                   // Put back agent market file
                  AppendData(player.toString(),File);
               }
             }
             printTeam();
             br.close();
             
         }catch(IOException e){
            e.printStackTrace();
         }
    }
    
    public static void RewriteData(String data, String file){
        try{
        PrintWriter pw = new PrintWriter(new FileOutputStream(file));
        pw.write(data);
        pw.close();
        
        }catch(FileNotFoundException e){
           e.printStackTrace();
        }
    }
    
        public static void printTeam(){
            String file="C:\\Users\\ONG KAI YIN\\Desktop\\team.txt";
            String s;
            String read[];
            System.out.println("The latest team member :");
            System.out.println("-".repeat(66));
            System.out.printf("|%10s       |%5s |%10s |%10s |%10s |%7s  |\n","Name","Age","Height","Weight","Position","Salary");
            System.out.print("-".repeat(66));
            System.out.println("");

            try{
                BufferedReader br = new BufferedReader(new FileReader(file));
                while((s=br.readLine())!=null){
                    read=s.split(" ");
                Player player = new Player(read[0],Integer.parseInt(read[1]),Double.parseDouble(read[2]),Double.parseDouble(read[3]),read[4],Integer.parseInt(read[5]));
                    System.out.print(player.printPlayer());
                    System.out.println("-".repeat(66));
                }
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            
        }
    
    public static void main(String[] args) {
        addPlayer("cc");
    }
}
