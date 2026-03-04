package MicroBank;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class MicroBank {

        public static void main(String[] args) {
            System.out.println("HELLO! The program is running");

    double balance = 0.0;

    System.out.println("-- MicroBank Starting--");

    try {
        File file = new File("input.data");
        System.out.println("looking for file:" + file.getAbsolutePath());
        Scanner scanner = new Scanner(file);

        if(!scanner.hasNextLine()) {
            System.out.println("File is empty");

        }

         while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[]parts = line.split(",");

            if (parts.length >= 3){
                String type = parts[1].trim();
                double amount = Double.parseDouble(parts[2].trim());

                if (type.equals("deposit")) {
                    balance += amount;
                } else if (type.equals("withdrawal")) {
                    balance -= amount;
                }
            }


            }

            scanner.close();
            System.out.println("Final Balance: " + balance);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}




                //String type = parts[1].trim();
                //double amount = Double.parseDouble(parts[2].trim());
                //if (type.equals("deposit")) {
                   // balance += amount;
               // } else if (type.equals("withdrawal")) {
                //    balance -= amount;
                
            
