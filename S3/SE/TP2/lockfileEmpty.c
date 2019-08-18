#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<fcntl.h>
#include<unistd.h>
#include<errno.h>
#include<sys/stat.h>
#include<sys/types.h>

#define BUFF_SIZE 30
#define VARIANT_LOCK 2 //0: pas de verrouillage 
                       //1: verrouillage bloquant 
                       //2: tentative de verrouillage (non bloquant)
					   
struct contact {
    int id;                		    //ID supposé unique
    char name[BUFF_SIZE];        	//Le nom de famille
    char firstName[BUFF_SIZE];   	//Le prenom
};

// 1) Non le verrouillage ne fonctionne que pour des accès en écriture.
// 2) F_TLOCK pose un verrou avec un appel non bloquant (renvoie une erreur s'il y a déjà un verrou) et F_TEST vérifie s'il y a déjà un verrou.

int litUneEntree(int fd);
void scanContact(struct contact* unContact);
void affichage(char* fileName);
void ajout(char* fileName);
void affichageEntree(char* fileName);
void modificationEntree(char* fileName);
int verrouillage(int fd, int offset, int variant);
void deverrouillage(int fd, int offset);

void usage(char* string) {
    fprintf(stderr,"Usage: %s fileName\n",string);
    exit(1);
}

int main(int argc, char* argv[]) {
    char fileName[256];
    int choix;

    if(argc < 2) usage(argv[0]);

    strcpy(fileName, argv[1]);

    while(1) {
        printf(" 0-quit\n 1-Affichage complet\n 2-Affichage i-eme entree\n 3-Ajout d'une entree\n 4-Modification i-eme entree\n");
        printf("Choix: ");
        fflush(stdout);
        scanf("%d", &choix);

        switch(choix) {
            case 0:
                exit(0);
            case 1:
                affichage(fileName);
                break;
            case 2:
                affichageEntree(fileName);
                break;
            case 3:
                ajout(fileName);
                break;
            case 4:
                modificationEntree(fileName);
                break;

            default:
                fprintf(stderr,"Choix incorrect\n");
        }
    }

    return(0);
} //fin du main


//Lit une entree struct contact dans le fichier pointer par le descripteur fd
int litUneEntree(int fd) {
	int nbOct;
	struct contact lectureContact;
	nbOct = read(fd, &lectureContact, sizeof(lectureContact));
	
	if (nbOct == 0) { //Si pas d'erreur de lecture
		return 0;
	}
	printf("id: %d\n", lectureContact.id);
	printf("First name: %s\n", lectureContact.firstName);
	printf("Name: %s\n", lectureContact.name);

	if (nbOct == -1) { 				//Si erreur de lecture
		perror("Error read");
		exit(1);
	}
	return 1;
} //fin de affiche

//Met à jour un contact saisit au clavier
void scanContact(struct contact* unContact) {
    printf("id: ");
    fflush(stdout);
    scanf("%d", &unContact -> id);
    printf("First name: ");
    fflush(stdout);
    scanf("%s", unContact -> firstName);
    printf("Name: ");
    fflush(stdout);
    scanf("%s", unContact -> name);
	
} //fin de scanContact

//Affiche la totalité du fichier 
void affichage(char* fileName) {
    int len = 100, buff[len], fd, nbOct;
    fd = open(fileName, O_RDONLY | O_CREAT, 0777);  	//Ouverture ou création du fichier
    if (fd < 0) { 										//Si erreur d'ouverture de fichier
        perror("Error open file");
    }
    while(nbOct = read(fd, buff, len) > 0) {	//Tant qu'il y a des données à lire
        if (write(1, buff, nbOct) != nbOct) {   //On essaye de les écrire
            perror("Error write");
        }
    }
    if (nbOct < 0) {
        perror("Error read");
    }
    close(fd);
}

//Demande à l'utilisateur le numéro de l'entrée (ieme entrée dans le fichier) à afficher puis l'affiche
void affichageEntree(char* fileName) {
	int i;
	int fd;
	printf("Entrer le numéro de l'entrée\n");
	scanf("%d", &i);
	if ((fd = open(fileName, O_RDONLY)) == -1) {	//Ouverture du fichier
		perror("Error open file");
		exit(1);
	}
	else	
	lseek(fd, i*64, SEEK_SET);
	litUneEntree(fd);
}

//Ajoute une entree en fin de fichier
void ajout(char* fileName) {
	int fd;
	struct contact newContact;
	scanContact(&newContact);
	if ((write(fd, &newContact, sizeof(newContact))) == -1) {	//Ecriture dans le fichier
		perror("Error write");
		exit(1);
	}	
	if ((fd = open(fileName, O_WRONLY | O_CREAT | O_APPEND, 0777)) == -1) { //Ouverture ou création du fichier
		perror("Error open file");
		exit(1);
	}	
}


//Modifie une entree donnee 
void modificationEntree(char* fileName) {
	int i;
	int fd;
	printf("Entrez le numéro de l'entrée\n");
	scanf("%d", &i);
	
	struct contact modifContact;
	scanContact(&modifContact);
	if ((fd = open(fileName, O_WRONLY)) == -1) {	//Ouverture du fichier
		perror("Error open file");
		exit(1);
	}
	lseek(fd, i*64, SEEK_SET);
	if ((write(fd, &modifContact, sizeof(modifContact))) == -1) { //Ecriture dans le fichier
		perror("Error write");
		exit(1);
	}	
} //fin de modificationEntree

//Variant 0: pas de lock
//Variant 1: lock bloquant
//Variant 2: lock non-bloquant


int verrouillage(int fd, int offset, int variant) {
    return(0);
}

//Deverouille -> Attention a l'offset: un offset invalide peut creer des petits bouts de fichier verrouille.
void deverrouillage(int fd, int offset) {}
