main : main.o Point3D.o TabDyn.o
	g++ main.o Point3D.o -o main -std=c++14
TabDyn.o :
	g++ -Wall -pedantic -c TabDyn.cpp -std=c++14
Point3D.o : Point3D.cpp
	g++ -Wall -pedantic -c Point3D.cpp -std=c++14
main.o : main.cpp
	g++ -Wall -pedantic -c main.cpp -std=c++14
run :
	./main
clean :
	rm main main.o Point3D.o