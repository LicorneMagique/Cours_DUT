#include "Compte.h"
#include "iostream"

using namespace std;

int Compte::numeroAttribue = 0;

Compte::Compte() : nomCompte("Not Defined"), decouvertMax(-1), soldeCompte(-1)
{

}

Compte::Compte(string nom, float solde, float dMax) : nomCompte(nom), decouvertMax(dMax), soldeCompte(solde)
{
	numeroCompte = numeroAttribue;
	numeroAttribue++;
}

Compte::Compte(const Compte& other): 
                                     nomCompte(other.nomCompte),
                                     soldeCompte(0),
                                     decouvertMax(0)
{
	numeroCompte = numeroAttribue;
	numeroAttribue++;
}

Compte& Compte::operator=(const Compte& other)
{
	if (this == &other)
		return *this;
	numeroCompte = other.numeroCompte;
	nomCompte = other.nomCompte;
	soldeCompte = other.soldeCompte;
	decouvertMax = other.decouvertMax;
	return *this;
}

int Compte::numero_compte() const
{
	return numeroCompte;
}

std::string Compte::nom_compte() const
{
	return nomCompte;
}

float Compte::solde_compte() const
{
	return soldeCompte;
}

float Compte::decouvert_max() const
{
	return decouvertMax;
}

void Compte::afficher() const
{
	cout << "Compte n" << numeroAttribue << " Nom : " << nomCompte << " Solde : " << soldeCompte << "€ Decouvert max : " << decouvertMax << "€" <<endl;
}

void Compte::crediter(float x)
{
	if (x > 0)
		soldeCompte += x;
}

void Compte::debiter(float x)
{
	if (x > 0 && soldeCompte + decouvertMax - x > 0)
		soldeCompte -= x;
}

int Compte::getDernierNumeroAttribue()
{
	return numeroAttribue;
}

