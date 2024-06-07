JC = javac
JFLAGS = -g
TARGET = Main
SOURCES = AVLTree.java Main.java Stock.java StockDataManager.java


default: $(TARGET)

$(TARGET): $(SOURCES)
	$(JC) $(JFLAGS) $^
	java $(TARGET) input.txt


clean:
	rm -f *.class

doc:
	javadoc -private -d doc AVLTree.java Main.java Stock.java StockDataManager.java

.PHONY: clean default