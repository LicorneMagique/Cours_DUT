#include <iomanip>
#include <iostream>
#include <string>

using namespace std;

void echange(int& i1, int& i2) {
    int tmp = i1;
    i1 = i2;
    i2 = tmp;
}

void echange(double& d1, double& d2) {
    double tmp = d1;
    d1 = d2;
    d2 = tmp;
}

int main() {
    int nb1 = 4, nb2 = -3;
    double db1 = 2.42, db2 = -1.618;
    cout << "Avant échange avec int : " << nb1 << ", " << nb2 << endl;
    echange(nb1, nb2);
    cout << "Après échange avec int : " << nb1 << ", " << nb2 << endl;
    cout << "Avant échange avec double : " << db1 << ", " << db2 << endl;
    echange(db1, db2);
    cout << "Après échange avec double : " << db1 << ", " << db2 << endl;
    return 0;
}