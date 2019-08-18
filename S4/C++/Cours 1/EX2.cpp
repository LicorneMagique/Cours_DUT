#include <iomanip>
#include <iostream>
#include <string>

using namespace std;

void affiche(int x, double y) {
    cout << "affiche 1" << endl;
    cout << x << " " << y << endl;
}

void affiche(double x, int y) {
    cout << "affiche 2" << endl;
    cout << x << " " << y << endl;
}

int main() {
    int i1 = 5;
    int i2 = -3;
    double d1 = 3.1415926535897932384626;
    double d2 = -47.968;
    affiche(i1, d1);
    affiche(d1, i1);
    // Les lignes suivantes empêchent la compilation car aucune fonction ne correspond
    //affiche(i1, i2);
    //affiche(d1, d2);
    return 0;
}
