#include <iostream>
#include <vector>

using namespace std;
void affiche(vector<int> v) {
        for (vector<int>::reverse_iterator it = v.rbegin(); it != v.rend(); it++) {
            cout << ' ' << *it;
        }
        cout << '\n';
    }

int main()
{
  /*vector<int> first;                               // empty vector of ints
    vector<int> second(4, 100);                      // four ints with value 100
    vector<int> third(second.begin(), second.end()); // iterating through second
    vector<int> fourth(third);                       // a copy of third

    int myints[] = {16, 2, 77, 29};
    vector<int> fifth(myints, myints + sizeof(myints) / sizeof(int));*/
    
    vector<int> michel;
    for (int i = 0; i < 5; i++) {
        michel.push_back(i);
    }
    int jjj[] = {10,20,30,50};
    vector<int> michel2 (jjj, jjj+sizeof(jjj)/sizeof(jjj[0])); 
    affiche(michel);
    affiche(michel2);

    for (vector<int>::reverse_iterator it = michel.rbegin(); it != michel.rend(); it++) {
        cout << ' ' << *it;
    }
    cout << '\n';

    cout << sizeof(michel) << ' ' << michel.capacity();

    return 0;
    
}

