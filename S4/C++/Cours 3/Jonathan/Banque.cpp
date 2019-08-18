#include "Banque.h"
#include <iostream>
#include <cstring>

Banque::Banque(int nbct)
{
	this->nbct = nbct;
	this->nbc = 0;
	comptes = new Compte[nbct];
}

Banque::Banque(const Banque& other): nbc(other.nbc),
                                     nbct(other.nbct)
{
	this->comptes = new Compte[nbct];
	for(int i = 0; i < nbct; i++)
	{
		comptes[i] = Compte(other.comptes[i]);
	}
}

void Banque::ajouterCompte(std::string nomCompte, float solde, float decouvertMax)
{
	comptes[nbc] = Compte(nomCompte, solde, decouvertMax);

	nbc++;
	if (nbc == nbct)
		redimensionneTableauComptes(2 * nbct);


}

void Banque::supprimerCompte(std::string nomCompte)
{
	for (int i = 0; i < nbc; i++)
	{
		if (comptes[i].nom_compte() == nomCompte)
			decaleGauche(i);
	}
	nbc--;

	if (nbc <= nbct / 2)
		redimensionneTableauComptes(nbct / 2);
}

void Banque::supprimerCompte(int numCompte)
{
	for (int i = 0; i < nbc; i++)
	{
		if (comptes[i].numero_compte() == numCompte)
			decaleGauche(i);
	}

	nbc--;

	if (nbc <= nbct / 2)
		redimensionneTableauComptes(nbct / 2);

}



void Banque::redimensionneTableauComptes(size_t nouvelleTaille)
{
	std::cout << "Reallocation de nbct, nouvelle taille : " << nouvelleTaille << std::endl;
	Compte* newComptes = new (std::nothrow) Compte[nouvelleTaille];
	if (newComptes == NULL)
	{
		std::cout << "Erreur alloc" << std::endl;

	}
	int min = nouvelleTaille;
	if (min > nbc)
		min = nbc;
	memcpy(newComptes, comptes, min * sizeof(Compte));

	this->nbct = nouvelleTaille;
	std::cout << comptes << std::endl;
	delete [] comptes;
	comptes = newComptes;


}


Banque& Banque::operator=(const Banque& other)
{
	if (this == &other)
		return *this;
	nbc = other.nbc;
	nbct = other.nbct;
	return *this;
}




Banque::~Banque()
{
	std::cout << "Destruction de la banque" << std::endl;
	delete [] comptes;
}

int Banque::getNbct()
{
	return nbct;
}


int Banque::getNbc()
{
	return nbc;
}





/**
 * \brief D�calle les comptes suivants vers la gauche en �crasant celui � la position pos
 * \param pos 
 */
void Banque::decaleGauche(int pos) const
{
	while(pos < nbc-1)
	{
		comptes[pos] = comptes[pos + 1];
		pos++;
	}

}

std::ostream& operator<<(std::ostream& os, const Banque& obj)
{
	os << "Banque :"
		<< "\n\tNombre de compte : " << obj.nbc
		<< "\n\tNombre de compte possible : " << obj.nbct;
		os << "\n\tDetail des comptes : ";

	if (obj.nbc > 0)
	{

		for (int i = 0; i < obj.nbc; i++)
		{
			os << "\t" << obj.comptes[i];
		}
	}
	else
	{
		os << "\n\aucun";
	}

	return os;
}
