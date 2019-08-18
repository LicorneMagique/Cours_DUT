bool TabDyn::resize(int nouvelle_taille, double val)
{
    if (nouvelle_taille == m_taille)
        return true; // succès
    int min_tailles = (nouvelle_taille < m_taille) ? nouvelle_taille : m_taille;
    if ((nouvelle_taille > 10) && (nouvelle_taille > m_capacite || nouvelle_taille < m_capacite / 2))
    { // cas où la réallocation est intéressante
        double *new_tab = new (std::nothrow) double[nouvelle_taille * 2];
        if (new_tab == NULL)
        {
            cout << " La reallocation a echouee ! On conserve l'ancien tableau! " << endl;
            return false; // échec
        }
        // on recopie l'ancien tableau dans le nouveau
        for (int i = 0; i < min_tailles; i++)
            new_tab[i] = m_cases_1D[i];
        delete[] m_cases_1D;
        m_cases_1D = new_tab;
        m_capacite = nouvelle_taille * 2;
    }
    // on complète les éventuelles cases restantes par la valeur
    for (int i = min_tailles; i < nouvelle_taille; i++)
        m_cases_1D[i] = val;
    m_taille = nouvelle_taille;
    return true; // succès
}
// ... À vous de terminer l’implémentation