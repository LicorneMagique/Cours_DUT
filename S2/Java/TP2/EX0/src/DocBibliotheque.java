public class DocBibliotheque {
	private String code_archivage;
	private String titre;
	private String auteurPrincipal;
	private int anneePublication;
        private String etatPhysique;
	//sur l'étagère;
	//emprunté;
	//sur la pile des retours;
        //sur la section reservation;
	private boolean estReserve;
	
	public DocBibliotheque(String newCode, String newTitre, String newAuteur, int newAnnee) {
		this.code_archivage = newCode;
		this.titre = newTitre;
		this.auteurPrincipal = newAuteur;
		this.anneePublication = newAnnee;
                this.etatPhysique = "sur l'étagère";
		this.estReserve = false;
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
        
        private boolean disponible() {
            if (this.etatPhysique == "sur l'étagère" || this.etatPhysique == "sur la pile des retours"){
                return true;
            }
            return false;
        }
        
        public void emprunter() {
            if (disponible() && this.estReserve == false) {
                this.etatPhysique = "est emprunté";
            }
        }
        
        public void reserver() {
            if (this.estReserve == false && !disponible()) {
                this.estReserve = true;
            }
        }
                
        public void annulerReservation() {
            if (this.estReserve == true) {
                this.estReserve = false;
            }
        }
        
        public void rangerLivre() {
            if (this.etatPhysique == "sur la pile des retours") {
                if (this.estReserve == true) {
                    this.etatPhysique = "sur la section reservation";
                }
                else {
                    this.etatPhysique = "sur l'étagère";
                }
            }
        }
        
        public void retournerLivre() {
            if (this.etatPhysique == "est emprunté") {
                this.etatPhysique = "sur la pile des retours";
            }
        }

}