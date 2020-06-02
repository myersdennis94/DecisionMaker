![logo](/images/logo.png)

This program makes a decision from user input options. Options are entered via a table in GUI. The program allows a custom number of trails in choosing an option. If options are not changed between runs, further runs are allowed and the total statistics of all runs will be shown. This repository also contains the inspiration for the GUI implementation, a C++ CLI implementation. 
### GUI Implementation
The functionality of the Java GUI implementation allows for user input through a table. Rows can be added to the table via the "+ Row" button allowing for input of more options. Upon inputting options, click the "Update Options" button to update the user input options for decision making functionality. Once options are input, click "Run Decision Maker" and specify the number of trails to be taken. The textbox on screen will show the winner of the trials and the table will show the results of the trials. Any changes made to option choices will erase stats of prior runs.

![Screen 1](/images/s1.png)

![Screen 2](/images/2.png)

### C++ Implementation
The functionality of the cpp file is to allow the user to insert items for the program to decide between then choose whether to receive an instant decision or "spin a wheel" for a decision. Upon spinning the wheel, the user can decide between to spin manually and receive statistics about spins every spin, or spin x amount of times and receive the totals after x spins.

![Screen 3](/images/cli.png)

### Compilation
To compile the program, download the repository via git. Use the command
> javac -d classes <path_to_repository_from_cwd>/*.java

This will create the classes folder to hold the compiled java files in your current working directory. 
### Running
To run the program, use the command 
> java -cp classes DecisionMaker.DecisionMain

This command must be run in the same directory as the classes directory.
