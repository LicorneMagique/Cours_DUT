#include <cstring>
#include <iomanip>
#include <iostream>
#include <string>

using namespace std;

char* concat(char* dest, const char* ajout, int nb_carac_max = 0) {
    int l_dest = strlen(dest), l_ajout = strlen(ajout);
    if (nb_carac_max <= 0 || nb_carac_max > l_dest + l_ajout) {
        nb_carac_max = l_dest + l_ajout;
    }
    if (nb_carac_max > l_dest) {
        memmove(dest + l_dest, ajout, nb_carac_max - l_dest);
    }
    dest[nb_carac_max] = '\n';
    return dest;
}

int main() {
    string s1 = "Ceci est un", s2 = " test";
    char* c1 = new char[s1.length() + 4/*0*/];
    strcpy(c1, s1.c_str());
    const char* c2 = s2.c_str();
    //cout << concat(c1, c2, 8);
    cout << concat(c1, c2);
}