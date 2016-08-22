### Summary of Command Line Application

#### Compile application
Enter command: `javac src/main/java/*.java`

#### Run application
Enter command: `java -cp src/main/java Application [text file path]`

Example: `java -cp ./src units.Application src/test/resources/input_one.txt`

NOTE: Receipt output will be found in the 'sales_taxes_java/receipts' directory

#### Run tests
Enter command: `mvn clean test`

NOTE: `brew install maven` to utilize the Apache Maven build tool

### Assumptions
* Each input file requires an individual output file

* Rules for exempt items currently are limited to chocolate(s), book(s), and pills

* All sales tax calculations are rounded up to the nearest 0.05, so that any decimal greater than 0.0 will be rounded upward

#### Design
* Application runs in the command line along with file path to input file (shopping basket)

* Output's (receipt) filename contains its time-stamp that reflects date and time when the shopping basket was run

* The entry point to the program is the Application class, which then triggers the following:

	* FileHandler class initiates a processor and converts each line to an Item object

	* In the conversion process, each item will be added to a shopping basket that the processor is aware of

	* As the quarter back of the program, the processor tells the Sales Tax Calculator to calculate and update the items and shopping basket with their sales taxes and totals

	* The processor also calls on the printer to format and print the receipt

	* Each new receipt will be found in the 'sales_taxes_java/receipts' directory


#### Utilized tools
The implementation of this program utilized the following:
* Java 1.8
* Eclipse text editor
* Apache Maven build tool
* JUnit testing framework
