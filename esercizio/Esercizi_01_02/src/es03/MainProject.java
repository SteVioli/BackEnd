package es03;


import java.util.Scanner;

public class MainProject {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        while(true) {

            System.out.println("Ciao! Inserisci una stringa e te la stamperò separando le varie lettere");
            String word = sc.nextLine();
            if(!word.equals(":q")){
                String newName = "";
                int info = word.length();
                int i = 0;
                for(String string : word.split("")) {
                	
                	
                    newName += string;
                    if(info-1>i) {
                    newName += ",";
                    }
                    i++;
                }
                    System.out.println(newName);
            }else {
                System.out.println("ciclo terminato");
                break;
            }

            }
    }
    }

