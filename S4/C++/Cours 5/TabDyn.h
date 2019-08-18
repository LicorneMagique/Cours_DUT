
class TabDyn
{
    double *m_cases_1D; // tableau dynamique 1D ;
    int m_taille;
    // taille actuelle du tableau dynamique
    int m_capacite;
    // nombre de cases allouées/réservées à un instant t ; on a toujours
    // m_capacite>=m_taille
  public:
    // Constructeurs
    TabDyn(int taille = 3, double val = 0);
    TabDyn(const TabDyn &);
    // Le destructeur
    ~TabDyn();
    // Accesseurs
    int getTaille() const { return m_taille; }
    int size() const { return m_taille; }
    // Modifieur
    bool resize(int nouvelle_taille, double val = 0); // à utiliser pour redimensionner le tableau
    // Opérateurs
    TabDyn &operator=(const TabDyn &);
    double &operator[](int indice);
    const double &operator[](int indice) const;
    friend ostream &operator<<(ostream &, const TabDyn &);
    // ... À vous de terminer la spécification
};