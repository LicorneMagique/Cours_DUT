#pragma once
#include "Compte.h"
#include <ostream>


class Banque
{
public:
	Banque(int nbct = 10);
	

	Banque(const Banque& other);

	void ajouterCompte(std::string nomCompte, float solde, float decouvertMax);
	void supprimerCompte(std::string nomCompte);
	void supprimerCompte(int numCompte);
	void redimensionneTableauComptes(size_t nouvelleTaille);
	Banque& operator=(const Banque& other);
	~Banque();
	int getNbct();
	int getNbc();


	friend std::ostream& operator<<(std::ostream& os, const Banque& obj);

private:
	void decaleGauche(int pos) const;
	int nbc, nbct;
	Compte* comptes;
};

