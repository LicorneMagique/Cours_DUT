console.log("Hello World!");

function compteNombreVoyelle(chaine) {
    var voyelles = "aeiouy";
    var compteur = 0, i;
    for (let lettre of chaine) {
        if (voyelles.indexOf(lettre) !== -1) {
            compteur++;
        }
    }
    return compteur;
}

function trouvePlusPetitElement(tab) {
    var min;
    for (let i = 0; i < tab.length; i++) {
        if (i === 0 || min > tab[i]) {
            min = tab[i];
        }
    }
    return min;
}

function getAVG(tab) {
    var total = 0;
    for (let nb of tab) {
        total += nb;
    }
    return total/tab.length;
}

var tab = [34, 12, 9, 45, 0, -2];

console.log(compteNombreVoyelle("Ceci est un test"));
console.log(trouvePlusPetitElement(tab));
console.log(getAVG(tab));
