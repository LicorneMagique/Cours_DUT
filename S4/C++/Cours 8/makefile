main : main.o
	g++ main.o -o main -std=c++14
main.o : main.cpp
	g++ -Wall -pedantic -c main.cpp -std=c++14
run :
	./main
clean :
	rm main main.o