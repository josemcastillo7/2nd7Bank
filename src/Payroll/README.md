## Payroll

the input is Name, Hours-worked, Hourly-rate

the output is Name, Gross-pay, Taxes, Net-pay.

so the general idea is to use a loop to iterate through the input data, calculate the gross pay, taxes, and net pay for each employee, and then print the results.

it might look like this

```pseudocode
tax_rate = 0.2
for each employee in input data:
    gross_pay = hours_worked * hourly_rate
    taxes = gross_pay * tax_rate
    net_pay = gross_pay - taxes
    print employee, gross_pay, taxes, net_pay
```

(the tax rate is 20%)

and the input data might look like this:

```
Name, Hours-worked, Hourly-rate
John Doe, 40, 15.50
Jane Smith, 35, 18.25
Bob Johnson, 45, 12.75
```
and the output might look like this:

```
Name, Gross-pay, Taxes, Net-pay
John Doe, 620.00, 124.00, 496.00
Jane Smith, 638.75, 127.75, 511.00
Bob Johnson, 566.25, 113.25, 453.00
```

### Hard Part

One of the hard parts of this project is the input of the data.
We need to read the input data from a file.
It would be best to use a function to read the data file, `input.data`

#### Python

for python, this functions could be used.

it reads in csv data, and puts it into a list of lists

```python
import csv

def read_data(file_name):
    with open(file_name, 'r') as file:
        csv_reader = csv.reader(file)
        data = [row for row in csv_reader]
    return data

input_data = read_data('input.data')
```

#### Java

for jshell (java) this one can be used.
it reads in csv data, and puts it into an ArrayList of POJO Timecards (ivars: Name:string, HoursWorked:double, HourlyRate:double)

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class Timecard {
    String Name;
    double HoursWorked;
    double HourlyRate;

    public Timecard(String name, double hoursWorked, double hourlyRate) {
        this.Name = name;
        this.HoursWorked = hoursWorked;
        this.HourlyRate = hourlyRate;
    }
}

public class ReadData {
    public static ArrayList<Timecard> readData(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            ArrayList<Timecard> data = new ArrayList<>();

            // Skip header line
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String name = parts[0].trim();
                double hoursWorked = Double.parseDouble(parts[1].trim());
                double hourlyRate = Double.parseDouble(parts[2].trim());
                data.add(new Timecard(name, hoursWorked, hourlyRate));
            }
            scanner.close();
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        }
    }
}

ArrayList<Timecard> input_data = ReadData.readData("input.data");
```
