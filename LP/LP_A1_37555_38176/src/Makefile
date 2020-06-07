# alterar para o caminho onde estao os ficheiros
TOOLS=./

BUILDFOLDER=./build
MACHINEPACKAGE=./machine
OPERATIONSPACKAGE=./machine/operations

JAVA = java
JAVAFLAGS =
JAVAC = javac
JAVACFLAGS = -d $(BUILDFOLDER)

JCLASSPATH = $(BUILDFOLDER):$(TOOLS)

CUP = java -classpath $(JCLASSPATH) java_cup/Main 
CUPFLAGS = 

JLEX = java -classpath $(JCLASSPATH) JLex/Main
JLEXFLAGS = 

CLASSES = TISC.class parser.class Yylex.class Main.class
	  # etc ...

INTERMEDIATE_FILES = TISC.lex.java sym.java parser.java Yylex.java

.INTERMEDIATE: sym.java
.SECONDARY: TISC.lex.java Yylex.java

.PHONY: all clean run recompile MachinePackage

all: $(CLASSES)

MachinePackage TISC.class:
	$(JAVAC) $(JAVACFLAGS) $(MACHINEPACKAGE)/*.java

%.class: %.java
	$(JAVAC) $(JAVACFLAGS) $< 
	#CLASSPATH=$(JCLASSPATH) $(JAVAC) $(JAVACFLAGS) $<

Main.class: Main.java TISC.class parser.class

parser.java sym.java: TISC.cup
	$(CUP) $(CUPFLAGS) $<
	@[ -s $@ ] || { rm -f $@; exit 1; }

parser.class: parser.java Yylex.class
	CLASSPATH=$(JCLASSPATH) $(JAVAC) $(JAVACFLAGS) $<

sym.class: sym.java

TISC.lex.java: TISC.lex
	$(JLEX) $(JLEXFLAGS) $<

Yylex.java:
	ln -sf TISC.lex.java $@

Yylex.class: Yylex.java TISC.lex.java sym.class
	CLASSPATH=$(JCLASSPATH) $(JAVAC) $(JAVACFLAGS) $<

clean:
	$(RM) $(INTERMEDIATE_FILES)
	$(RM) *.class *~
	$(RM) -r $(BUILDFOLDER)

run:
	CLASSPATH=$(JCLASSPATH) $(JAVA) $(JAVAFLAGS) Main

recompile: clean all
