JC = javac
JFLAGS = -classpath .
JD = javadoc
JDFLAGS = -protected -splitindex -use -author -version -d ./javadoc
RM = rm -f
JR = java

CLASSES = \
		Inventory.java \
		Device.java \
		App.java \
		Smartphone.java \
		Laptop.java \
		Smartwatch.java \
		Headphones.java \
		TV.java \


all : App.class

run : 
	$(JR) App

classes : $(CLASSES:.java=.class)

%.class : %.java
	$(JC) $(JFLAGS) $<

doc:
	$(JD) $(JDFLAGS) *.java 

clean:
	$(RM) *.class 
	$(RM) inventory_report.txt

cleandoc:
	$(RM) -r ./javadoc