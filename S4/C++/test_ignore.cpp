#include <iostream>
#include <cstdlib> // EXIT_SUCCESS
#include <string>

using namespace std;

int main()
{
    string s1, s2;
    cout << " Saisir chaine1: ";
    cin >> s1;
    cin.ignore(80, '\n'); // on supprime les caractères jusqu'au "retour chariot" du buffer de lecture
    cout << " Saisir chaine2: ";
    getline(cin, s2);
    cout << " voici les deux chaines saisies: " << s1 << " et " << s2 << endl;

    system("pause");

    return EXIT_SUCCESS;
}
