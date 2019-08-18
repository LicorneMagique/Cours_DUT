#include <iomanip>
#include <iostream>
#include <string>

using namespace std;

string& concat_string(string& dest, const string& ajout, int nb_carac_max = 0) {
    int l_dest = dest.size(), l_ajout = ajout.size();
    if (nb_carac_max <= 0 || nb_carac_max >= l_dest + l_ajout) {
        dest = dest + ajout;
    }
    else {
        if (nb_carac_max > l_dest) {
            dest = dest + ajout.substr(0, nb_carac_max - l_dest);
        }
        else if (nb_carac_max < l_dest) {
            dest = dest + ajout.substr(0, nb_carac_max);
        }
    }
    return dest;
}

int main() {
    string s1 = "Ceci est un";
    const string s2 = " test";
    cout << concat_string(s1, s2) << endl;
    // La taille n'a maintenant plus d'importance
}