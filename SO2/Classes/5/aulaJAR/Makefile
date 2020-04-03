classes/so2/B.class: src/B.java
	javac -d classes src/B.java
classes/so2/A.class: src/A.java classes/so2/B.class
	javac -d classes -classpath classes src/A.java


clean:
	rm -rf classes/* demo.jar

demo.jar: classes/so2/A.class
	@echo "a fazer o jar..."
	# nome do JAR: argumento f e o nome "demo.jar"
	# definir o conteudo para o MANIFEST: argumento m e o nome do ficheiro informacao_para_Manifest.txt
	# adicionar pasta so2, dentro da pasta classes: "-C classes so2"
	jar cfm demo.jar informacao_para_Manifest.txt -C classes so2


run: demo.jar
	java -jar demo.jar
	## para executar outra classe: java -classpath demo.jar NOME
	## exemplo: java -classpath demo.jar so2.A       # ... isto foi indicado via Manifest Main-Class

