// TP1.cpp : Ce fichier contient la fonction 'main'. L'exécution du programme commence et se termine à cet endroit.
//

#include <iostream>
#include "Banque.h"

int main()
{
    std::cout << "Hello World!\n";
	Banque b(10);
	int a;
	std::cout << b;
	b.ajouterCompte("Jonathan", 1, 0);
	std::cout << std::endl << b;



	for(int i = 0; i < 1000; i++)
	{
		std::cout << "Ajout du compte " << "user_" + std::to_string(i) << std::endl;

		b.ajouterCompte("user_" + std::to_string(i), i, i * 100);
		//std::cout << std::endl << b << std::endl;

	}

    for (int i = 0; i < 90; ++i)
    {

		if (i == 5)
			continue;

		std::cout << "Suppression du compte " << "user_" + std::to_string(i) << std::endl;

		b.supprimerCompte("user_" + std::to_string(i));

		std::cout << std::endl << b << std::endl;

    }

    std::cout << "BANQUE\n\n" << b << std::endl;

    std::cin >> a;
}

// Exécuter le programme : Ctrl+F5 ou menu Déboguer > Exécuter sans débogage
// Déboguer le programme : F5 ou menu Déboguer > Démarrer le débogage

// Conseils pour bien démarrer : 
//   1. Utilisez la fenêtre Explorateur de solutions pour ajouter des fichiers et les gérer.
//   2. Utilisez la fenêtre Team Explorer pour vous connecter au contrôle de code source.
//   3. Utilisez la fenêtre Sortie pour voir la sortie de la génération et d'autres messages.
//   4. Utilisez la fenêtre Liste d'erreurs pour voir les erreurs.
//   5. Accédez à Projet > Ajouter un nouvel élément pour créer des fichiers de code, ou à Projet > Ajouter un élément existant pour ajouter des fichiers de code existants au projet.
//   6. Pour rouvrir ce projet plus tard, accédez à Fichier > Ouvrir > Projet et sélectionnez le fichier .sln.
