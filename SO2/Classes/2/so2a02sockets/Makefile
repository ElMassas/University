JFLAGS = -g
JC = javac
JVM= java 

# insira aqui as regras para o make
.SUFFIXES: .java .class

.java.class:
		$(JC) $(JFLAGS) $*.java


run:
	$(JVM) -classpath classes src/so2.EchoServer 
	$(JVM) -classpath classes src/so2.EchoClient $(A1) $(A2) "$(A3)"


# eliminar temporarios e .class
clean:
	find . -name \*~ | xargs rm -f
	find . -name \*.class | xargs rm -f
