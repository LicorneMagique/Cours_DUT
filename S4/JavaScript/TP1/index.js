// Ajout du trigger sur la page
window.addEventListener("load", () => start());

start = () => {
	document.querySelector("button").disabled = true; // Désactivation du bouton
	document.querySelectorAll("input.tested").forEach(inp => {

		console.log(inp);
		const pwdSpan = document.querySelector("span#pwdPercent");
		const errorDiv = document.querySelector("div#errors");

		inp.addEventListener("input", () => {
			pwdSpan.innerHTML = "";
			errorDiv.innerHTML = "";
			let error = false;
			const map = new Map();
			document.querySelectorAll("input.tested").forEach((l) => {
				map[l.id] = document.querySelector(`#${l.id}.tested`);
			});

			for(let inp in map)
			{
				map[inp].classList.remove("error");
			}

            // Vérification de l'âge
			if (map["age"].value < 18) {
				error = true;
				map["age"].classList.add("error");
				console.debug("Erreur Age");
				const pError = document.createElement("p");
				pError.innerText = "Vous devez avoir au moins 18 ans";
				errorDiv.appendChild(pError);
            }

            // Vérification de l'identifiant
			if (!map["id"].value.match("^[a-zA-Z]{1,12}$")) {
				error = true;
				map["id"].classList.add("error");
				console.debug("Erreur id");
				const pError = document.createElement("p");
				pError.innerText = "Votre identifiant doit faire entre 1 et 12 caractères et uniquement composé de lettres";
				errorDiv.appendChild(pError);
			}

            // On vérifie que les mots de passes sont identitiques
			if (!(map["pwdC"].value === map["pwd"].value)) {
				error = true;
				map["pwdC"].classList.add("error");
				console.debug("Erreur Pwdc");
				const pError = document.createElement("p");
				pError.innerText = "Les mots de passes ne sont pas identitiques";
				errorDiv.appendChild(pError);
			}

            // Vérification de la checkbox des CGU
			if (!map["cgu"].checked) {
				error = true;
				map["cgu"].classList.add("error");
				console.debug("Erreur Cgu");
				const pError = document.createElement("p");
				pError.innerText = "Vous devez valider les conditions générales d'utilisation";
				errorDiv.appendChild(pError);
			}

			const pwd = map["pwd"].value; // Mot de passe
            let pwdF = 100; // Pourcentage du mot de passe bien tapé

            // Vérification de la taille du mot de passe
			if (pwd.length < 8) {
				error = true;
				pwdF-= 20;
				map["pwd"].classList.add("error");
				console.debug("Erreur pwd");
				const pPwdError = document.createElement("p");
				pPwdError.innerText = "Le mot de passe doit faire au moins 8 caractères";
				errorDiv.appendChild(pPwdError);
			}

            // Vérification de la présence de lettre(s) minuscule(s) dans le mot de passe
			if (!pwd.match("[a-z]+")) {
				error = true;
				pwdF-= 20;
				map["pwd"].classList.add("error");
				const pPwdError = document.createElement("p");
				pPwdError.innerText = "Le mot de passe doit au moins 1 une lettre minuscule";
				errorDiv.appendChild(pPwdError);
			}

            // Vérification de la présence de lettre(s) majuscule(s) dans le mot de passe
			if (!pwd.match("[A-Z]+")) {
				error = true;
				pwdF-= 20;
				map["pwd"].classList.add("error");
				const pPwdError = document.createElement("p");
				pPwdError.innerText = "Le mot de passe doit  avoir au moins 1 une lettre majuscule";
				errorDiv.appendChild(pPwdError);
			}

            // Vérification de la présence de chiffre(s) dans le mot de passe
			if (!pwd.match("[0-9]")) {
				error = true;
				pwdF-= 20;
				map["pwd"].classList.add("error");
				const pPwdError = document.createElement("p");
				pPwdError.innerText = "Le mot de passe doit faire au moins 1 chiffre";
				errorDiv.appendChild(pPwdError);
			}

            // Vérification de la présence de caractère spécial dans le mot de passe
			if (!pwd.match("[^0-9]+[^a-z]+[^A-Z]")) { // Ni chiffre ni lettre
				error = true;
				pwdF-= 20;
				map["pwd"].classList.add("error");
				const pPwdError = document.createElement("p");
				pPwdError.innerText = "Le mot de passe doit faire au moins 1 caractère spécial";
				errorDiv.appendChild(pPwdError);
			}

            // Affichage du pourcentage du mot de passe bien tapé
			let pError = document.createElement("span");
			pError.innerText = `${pwdF}%`;
			pwdSpan.appendChild(pError);


			console.debug("");
            console.log(map);
            
            // Gestion de l'état du bouton
			document.querySelector("button").disabled = error;
		});
	});
};
