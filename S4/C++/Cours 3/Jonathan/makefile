TP1 : TP1.o Banque.o Compte.o
	g++ TP1.o Banque.o Compte.o -o TP1 -std=c++14
Banque.o : Banque.cpp Banque.h Compte.h
	g++ -Wall -pedantic -c Banque.cpp -std=c++14
Compte.o : Compte.cpp Compte.h
	g++ -Wall -pedantic -c Compte.cpp -std=c++14
TP1.o : TP1.cpp Banque.h Compte.h
	g++ -Wall -pedantic -c TP1.cpp -std=c++14