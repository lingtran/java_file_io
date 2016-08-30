Summary of Command Line Sales Taxes Calculator Application

BUILD IN COMMAND LINE
* In the root level of the project directory in the command line, enter commands in the following order:
	$ brew install maven
	$ mvn clean install
	$ javac src/main/java/*.java

RUN APP
* Enter command in the command line:
	$ java -cp src/main/java Application [text file path]

* Example:
	$ java -cp src/main/java Application src/test/resources/input_one.txt

* NOTE: Receipt output will be found in the 'receipts' directory

RUN TESTS
* Enter command: 
	$ mvn clean test

ASSUMPTIONS
* Each input file requires an individual output file

* Exempt items currently are limited to chocolate(s), book(s), and pills

* All sales tax calculations are rounded up to the nearest 0.05, so that any decimal greater than 0.0 will be rounded upward

DESIGN
* Application runs in the command line along with file path to input file (shopping basket)

* Output's (receipt) filename contains its time-stamp that reflects date and time when the shopping basket was run

* The entry point to the program is the Application class, which triggers the following:

	* FileHandler class initiates a processor and converts each line to an Item object

	* In the conversion process, each item is added to a shopping basket

	* The processor is aware of both the shopping basket and its items

	* As the quarter back of the program, the processor tells the Sales Tax Calculator to calculate and update the items and shopping basket with their sales taxes and totals

	* The processor also calls on the printer to format and print the receipt

	* Each new receipt will be found in the 'receipts' directory

TOOLING
The implementation of this program utilized the following:
	* JDK 1.8
	* IntelliJ IDEA editor
	* Apache Maven build tool
	* JUnit testing framework
