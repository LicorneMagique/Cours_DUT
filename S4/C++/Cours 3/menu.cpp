#include <iostream>

using namespace std;

void fonction0() {
    cout << "Vous voulez sortir du programme";
    cout << endl;
}

void fonction1() {
    cout << "Vous voulez ajouter un compte";
    cout << endl;
}

void fonction2() {
    cout << "Vous voulez supprimer un compte";
    cout << endl;
}

void fonction3() {
    cout << "Vous voulez afficher les details de la banque";
    cout << endl;
}

void fonction4() {
    cout << "Vous voulez créditer un compte";
    cout << endl;
}

void fonction5() {
    cout << "Vous voulez débiter un compte";
    cout << endl;
}

int main() {
    
    int a = -1;

    while (a != 0) {

        cout << "Menu : \n";
        cout << "1 : Ajouter un compte \n";
        cout << "2 : Supprimer un Compte \n";
        cout << "3 : Afficher les details de la banque\n";
        cout << "4 : Credite un compte\n";
        cout << "5 : Debiter un compte\n";
        cout << "0 : Sortie" << endl;

        cin >> a;

        switch(a) {
            case 0:
                fonction0();
                break;

            case 1:
                fonction1();
                break;

            case 2:
                fonction2();
                break;

            case 3:
                fonction3();
                break;

            case 4:
                fonction4();
                break;

            case 5:
                fonction5();
                break;
        }
    }
    return 0;
}
