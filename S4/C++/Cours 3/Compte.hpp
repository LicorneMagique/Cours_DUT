class Compte
{
    private:
        int numeroCompte;
        string nomCompte;
        float decouvertMax, soldeCompte;

    public:
        static int numeroAttribue = 0;
        Compte(string newNomCompte, float montantIni, float newDecouvertMax);
        Compte(const Compte &);
        getNumero();
        getNom();
        getSolde();
        getDernierNumeroAttribue();
        afficher();
        debiter(float);
        crediter(float);
}
