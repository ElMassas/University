clean:	
	rm -rf countries students

all:
	gcc -std=gnu99 -Wall *.c -o higher-ed

valgrind:
	valgrind ./higher-ed < $(T) --track-origins=yes --leak-check=full --show-leak-kinds=all --tool=memcheck

run:
	/usr/bin/time  ./higher-ed < $(F)


testA:
	./higher-ed < testes/teste-A-1.in > testes/teste-A-1.o-meu-out
	$(info ************* TEST-A-1 is done *************)
	./higher-ed < testes/teste-A-2.in > testes/teste-A-2.o-meu-out
	$(info ************* TEST-A-2 is done *************)

testADiff:
	diff testes/teste-A-1.out testes/teste-A-2.o-meu-out
	$(info ************* DIFF-A-1 is done *************)
	diff testes/teste-A-2.out testes/teste-A-2.o-meu-out
	$(info ************* DIFF-A-1 is done *************)


testB:
	./higher-ed < testes/teste-B-1.in > testes/teste-B-1.o-meu-out
	$(info ************* TEST-B-1 is done *************)
	./higher-ed < testes/teste-B-2.in > testes/teste-B-2.o-meu-out
	$(info ************* TEST-B-2 is done *************)
	./higher-ed < testes/teste-B-3.in > testes/teste-B-3.o-meu-out
	$(info ************* TEST-B-2 is done *************)
	
testBDiff:
	diff testes/teste-B-1.out testes/teste-B-1.o-meu-out
	$(info ************* DIFF-B-1 is done *************)
	diff testes/teste-B-2.out testes/teste-B-2.o-meu-out
	$(info ************* DIFF-B-2 is done *************)
	diff testes/teste-B-3.out testes/teste-B-3.o-meu-out
	$(info ************* DIFF-B-3 is done *************)


testC:
	./higher-ed < testes/teste-C-1.in > testes/teste-A-1.o-meu-out
	$(info ************* TEST-C-1 is done *************)
	
	./higher-ed < testes/teste-C-2.in > testes/teste-C-2.o-meu-out
	$(info ************* TEST-C-2 is done *************)
	
	./higher-ed < testes/teste-C-3.in > testes/teste-C-3.o-meu-out
	$(info ************* TEST-C-3 is done *************)
	

testCDiff:
	diff testes/teste-C-1.out testes/teste-C-1.o-meu-out
	$(info ************* DIFF-C-3 is done *************)
	diff testes/teste-C-2.out testes/teste-C-2.o-meu-out
	$(info ************* DIFF-C-3 is done *************)
	diff testes/teste-C-3.out testes/teste-C-3.o-meu-out
	$(info ************* DIFF-C-3 is done *************)

testD:
	./higher-ed < testes/teste-D-1.in > testes/teste-D-1.o-meu-out
	$(info ************* TEST-D-1 is done *************)
	./higher-ed < testes/teste-D-2.in > testes/teste-D-2.o-meu-out
	$(info ************* TEST-D-2 is done *************)
	./higher-ed < testes/teste-D-3.in > testes/teste-D-3.o-meu-out
	$(info ************* TEST-D-3 is done *************)
	
testDDiff:
	diff testes/teste-D-1.out testes/teste-D-1.o-meu-out
	$(info ************* DIFF-D-1 is done *************)
	diff testes/teste-D-2.out testes/teste-D-2.o-meu-out
	$(info ************* DIFF-D-1 is done *************)
	diff testes/teste-D-3.out testes/teste-D-3.o-meu-out
	$(info ************* DIFF-D-1 is done *************)
