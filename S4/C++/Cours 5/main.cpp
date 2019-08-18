#include "Point3D.h"
#include <iostream>

using namespace std;

int main()
{
    Point3D p1 = Point3D(-1, 2, 3);
    Point3D p2 = Point3D(2, -1.5, 4);

    cout << "Voici p1 : " << p1 << endl
         << "Voici p2 : " << p2 << endl
         << "Voici p1 + p2 : " << p1 + p2 << endl
         << "Voici p1 + 2 : " << p1 + 2 << endl
         << "Voici p1 - p2 : " << p1 - p2 << endl
         << "Voici p1 - 2 : " << p1 - 2 << endl
         << "Voici p1 * p2 : " << p1 * p2 << endl
         << "Voici p1 * 4 : " << p1 * 4 << endl;

    return EXIT_SUCCESS;
}