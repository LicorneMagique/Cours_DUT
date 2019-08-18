#include <iomanip>
#include <iostream>
#include <string>

using namespace std;

int main()
{
    cout << "Entrer du texte : ";
    string test;
    cin >> test;
    cout << "Vous avez entré : " << test << endl;

    cout << "Entrer un nombre (int) : ";
    int testInt;
    cin >> testInt;
    cout << "Vous avez entré : " << testInt << endl;

    cout << "Entrer nombre (short) : ";
    short testShort;
    cin >> testShort;
    cout << "Vous avez entré : " << setfill('c') << setw(20) << testShort << endl;

    cout << "Entrer un nombre (Long) : ";
    long testLong;
    cin >> testLong;
    cout << "Vous avez entré : " << testLong << endl;

    cout << "Entrer un nombre (char) : ";
    char testChar;
    cin >> testChar;
    cout << "Vous avez entré : " << testChar << endl;

    cout << "Entrer un nombre (float) : ";
    float testFloat;
    cin >> testFloat;
    cout << "Vous avez entré : " << setprecision(3) << testFloat << endl;

    cout << "Entrer un nombre (double) : ";
    double testDouble;
    cin >> testDouble;
    cout << "Vous avez entré : " << testDouble << endl;

    cout << "Entrer un nombre (char *) : ";
    char *testCharS;
    cin >> testCharS;
    cout << "Vous avez entré : " << testCharS << endl;

    return 0;
}