package MicroBank;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Transaction{
    String date;
    String type;
    double amount;

    public Transaction(String date, String type, double amount){
        this.date = date;
        this.type = type;
        this.amount = amount;
    }
        //whiting the class

    public String toString(){
        return String.format("%s, %s, %.2f",this.date, this.type, this.amount);
    }  

    class AccountBalance{
        String date;
        double balance;
     {}
        public AccountBalance(String date, double balance){
            this.date = date;
            this.balance = balance;
        } 
    


    
    
        public String toString(){
        
            return String.format("%s, %.2f", this.date, this.balance);
        }
    }
}

class ReadData {
    public static ArrayList<Transaction> readData(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            ArrayList<Transaction> data = new ArrayList<>();

            // Skip header line
            

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String date = parts[0].trim();
                String typeOfTransaction = parts[1].trim();
                double amount = Double.parseDouble(parts[2].trim());
                data.add(new Transaction(date, typeOfTransaction, amount));

                //love ja
            }
            scanner.close();
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }
}







public class MicroBank {

    public static void main(String[] args) {
        String inputFileName = "./src/MicroBank/input.data";
        ArrayList<Transaction> transactions = ReadData.readData(inputFileName);
        System.out.println("HELLO! The program is running");

        double balance = 0.0;

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
            if (transaction.type.equalsIgnoreCase("deposit")) {
                balance += transaction.amount;
            } else if (transaction.type.equalsIgnoreCase("withdrawal")) {
                balance -= transaction.amount;
            } else {
                System.err.println("Unknown transaction type: " + transaction.type);
            }
            System.out.printf("current Balance: %.2f\n", balance);
            
        }
        System.out.printf("Final Balance: %.2f\n", balance);

        System.out.printf("-- MicroBank Starting--");

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
                
            
