JCC = javac
JVM = java

# define a makefile variable for compilation flags
# the -g flag compiles with debugging information
#
JFLAGS = -g

# typing 'make' will invoke the first target entry in the makefile 
# (the default one in this case)
#
default: Customer.class Queue.class Register.class Store.class Simulation.class Simulator.class

# this target entry builds the Average class
# the Average.class file is dependent on the Average.java file
# and the rule associated with this entry gives the command to create it
#
Customer.class: Customer.java
	$(JCC) $(JFLAGS) Customer.java

Register.class: Register.java
	$(JCC) $(JFLAGS) Register.java

Store.class: Store.java
	$(JCC) $(JFLAGS) Store.java

Simulation.class: Simulation.java
	$(JCC) $(JFLAGS) Simulation.java

Simulator.class: Simulator.java
	$(JCC) $(JFLAGS) Simulator.java

Queue.class: Queue.java
	$(JCC) $(JFLAGS) Queue.java

test: Simulator.class
	$(JVM) Simulator 50 20 4 10

# To start over from scratch, type 'make clean'.  
# Removes all .class files, so that the next make rebuilds them
#
clean: 
	$(RM) *.class
