#pragma once
#include <string>
#include <ostream>

class Compte
{
public:

	Compte();
	
	Compte(std::string nom, float solde, float dMax);

	Compte(const Compte& other);

	Compte& operator=(const Compte& other);


	int numero_compte() const;

	std::string nom_compte() const;

	float solde_compte() const;

	float decouvert_max() const;

	void afficher() const;

	void crediter(float x);
	void debiter(float x);


	friend std::ostream& operator<<(std::ostream& os, const Compte& obj)
	{
		return os << "\n\t\tCompte : "
			<< "\n\t\t\tnumeroCompte: " << obj.numeroCompte
			<< "\n\t\t\tnomCompte: " << obj.nomCompte
			<< "\n\t\t\tsoldeCompte: " << obj.soldeCompte
			<< "\n\t\t\tdecouvertMax: " << obj.decouvertMax;
	}

	static int getDernierNumeroAttribue() ;

private:
	int numeroCompte;
	std::string nomCompte;
	float soldeCompte;
	float decouvertMax;
	static int numeroAttribue;

};


