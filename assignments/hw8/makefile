JC = javac
JFLAGS = -g
TARGET = Main
TEST = Test
SOURCES = Main.java Person.java SocialNetworkGraph.java
TEST_SOURCES = Test.java Person.java SocialNetworkGraph.java

default: run

test: $(TEST)

$(TEST): $(TEST_SOURCES)
	$(JC) $(JFLAGS) $(TEST_SOURCES)
	java $(TEST)

run: $(TARGET)

$(TARGET): $(SOURCES)
	$(JC) $(JFLAGS) $(SOURCES)
	java $(TARGET)

clean:
	rm -f *.class

doc:
	javadoc -private -d doc $(SOURCES)

.PHONY: clean default test run doc
