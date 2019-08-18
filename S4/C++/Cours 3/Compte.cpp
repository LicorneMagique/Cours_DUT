#include "Compte.h"

using namespace std;

Compte::Compte(string newNomCompte, float montantIni, float newDecouvertMax)
{
    this->nomCompte = newNomCompte;
    this->soldeCompte = montantIni;
    this->decouvertMax = newDecouvertMax;
}

Compte::Compte(const Compte &compte)
{
    this->nomCompte = compte.getNom();
    this->soldeCompte = 0;
    this->decouvertMax = 0;
}

int Compte::getNumero()
{
    return this->numeroCompte;
}

string Compte::getNom()
{
    return this->nomCompte;
}

float Compte::getSolde()
{
    return this->soldeCompte;
}

int Compte::getDernierNumeroAttribue()
{
    return this->numeroAttribue;
}

void Compte::debiter(float montant)
{
    this->soldeCompte -= montant;
}

void Compte::crediter(float montant)
{
    this.soldeCompte += montant;
}

string Compte::afficher()
{
    cout << "Numéro du compte : " << this->numeroCompte << endl
         << "Nom du compte : " << this->nomCompte << endl
         << "Solde du compte" << this->soldeCompte << endl
         << "Découvert maximum du compte : " << this->decouvertMax << endl;
}
