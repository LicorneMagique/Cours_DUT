public class DocBibliotheque {
	private String code_archivage;
	private String titre;
	private String auteurPrincipal;
	private int anneePublication;
        private String etatPhysique;
	//sur l'etagere;
	//emprunte;
	//sur la pile des retours;
        //sur la section reservation;
        private MembreBibliotheque membreQuiEmprunte;
        private MembreBibliotheque membreQuiReserve;
        private static int nombreDocEmprunte;
        private static int nombreDocSurPileRetour;
        private static int nombreDocSurSectionReservation;
	
	public DocBibliotheque(String newCode, String newTitre,
                String newAuteur, int newAnnee) {
            this.code_archivage = newCode;
            this.titre = newTitre;
            this.auteurPrincipal = newAuteur;
            this.anneePublication = newAnnee;
            this.etatPhysique = "sur l'etagere";
            this.membreQuiEmprunte = null;
            this.membreQuiReserve = null;
	}

	public String getCode_archivage() {
            return code_archivage;
	}

	public void setCode_archivage(String code_archivage) {
            this.code_archivage = code_archivage;
	}

	public String getTitre() {
            return titre;
	}

	public void setTitre(String titre) {
            this.titre = titre;
	}

	public String getAuteurPrincipal() {
            return auteurPrincipal;
	}

	public void setAuteurPrincipal(String auteurPrincipal) {
            this.auteurPrincipal = auteurPrincipal;
	}

	public int getAnneePublication() {
            return anneePublication;
	}

	public void setAnneePublication(int anneePublication) {
            this.anneePublication = anneePublication;
	}

        public String getEtatPhysique() {
            return etatPhysique;
        }
        
        
        public int getNombreDocEmprunte() {
            return nombreDocEmprunte;
        }
        
        public int getNombreDocSurPileRetour() {
            return nombreDocSurPileRetour;
        }
        
        public int getNombreDocSurSectionReservation() {
            return nombreDocSurSectionReservation;
        }
        
        public void emprunter(MembreBibliotheque newMembreQuiEmprunte) {
            //1 : livre est sur etagere
            //-> changer etat livre + changer membre qui emprunte
            //2 : livre est sur section reservation ET emprunteur=this.emp
            //-> changer etat livre + changer membre qui emprunte + membre qui reserve
            if (this.etatPhysique.equals("sur l'etagere")) {
                this.etatPhysique = "est emprunte";
                this.membreQuiEmprunte = newMembreQuiEmprunte;
            }
            else if (this.etatPhysique.equals("sur la section reservation")
                    && this.membreQuiReserve == newMembreQuiEmprunte) {
                this.etatPhysique = "est emprunte";
                this.membreQuiEmprunte = newMembreQuiEmprunte;
                this.membreQuiReserve = null;
            }
        }
        
        public void reserver(MembreBibliotheque newMembreQuiReserve) {
            //le livre est emprunte ET le membre qui reserve n'est pas celui qui emprunte
            //-> changer le membre qui reserve
            if (this.etatPhysique.equals("est emprunte")
                    && !this.membreQuiEmprunte.equals(newMembreQuiReserve)) {
                this.membreQuiReserve = newMembreQuiReserve;
            }
        }
                
        public void annulerReservation(MembreBibliotheque membreQuiAnnule) {
            //membre qui annule == membre qui reserve
            //-> 1 : emprunte :
                //membre qui reserve = null
            //-> 2 : sur la pile des retours :
                //membre qui reserve = null
            //-> 3 : sur la section reservation :
                //membre qui reserve = null ET sur l'etagere
            if (this.membreQuiReserve.equals(membreQuiAnnule)) {
                this.membreQuiReserve = null;
                if (this.etatPhysique.equals("sur la section reservation")) {
                    this.etatPhysique = "sur l'etagere";
                }
            }
        }
        
        public void rangerDoc() {
            //sur la pile des retours
            //-> 1 : il n'est pas reserve :
                //le mettre sur l'etagere
            //-> 2 : il est reserve :
                //le mettre sur la section reservation
            if (this.etatPhysique.equals("sur la pile des retours")) {
                if (this.membreQuiReserve == null) {
                    this.etatPhysique = "sur l'etagere";
                    nombreDocSurSectionReservation++;
                }
                else {
                    this.etatPhysique = "sur la section reservation";
                }
                nombreDocSurPileRetour--;
            }
        }
        
        public void retournerDoc() {
            //livre emprunte
            //-> mettre membre qui emprunte a null ET mettre livre sur pile retour
            if (this.etatPhysique.equals("est emprunte")) {
                this.etatPhysique = "sur la pile des retours";
                this.membreQuiEmprunte = null;
                nombreDocEmprunte--;
                nombreDocSurPileRetour++;
            }
        }

        @Override
        public String toString() {
            return "Code d'archivage : "+ this.code_archivage +
                "\nTitre : " + this.titre +
                "\nAuteur principal : " + this.auteurPrincipal +
                "\nAnnee de publication : " + this.anneePublication +
                "\nEtat physique : " + this.etatPhysique +
                "\nMembre ayant reserve : " + this.membreQuiReserve +
                "\nMembre entrain d'emprunter : " + this.membreQuiEmprunte;
        }
}
