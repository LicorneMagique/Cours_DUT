// J'en suis là → https://openclassrooms.com/fr/courses/1916641-dynamisez-vos-sites-web-avec-javascript/1917728-les-fonctions
// https://openclassrooms.com/fr/courses/1631636-simplifiez-vos-developpements-javascript-avec-jquery

// Cours de Champin : https://perso.liris.cnrs.fr/pierre-antoine.champin/enseignement/intro-js/slides/s1.html

/* ---------- ---------- Notes du premier cours d'Open Classroom ---------- ---------- */

// Cours : https://openclassrooms.com/fr/courses/2984401-apprenez-a-coder-avec-javascript/

// Le bon vieux système d'affichage
console.log("Hello Wordl!");

// Déclaration de variables globales
{michel = "";
// Déclaration de variables normales
var michel = "";
// Déclaration de variables accessibles uniquement dans le bloc
let michel = "";}

console.log(michel); // Affiche 'undefined' par défaut

// Pour une variable dont la valeur ne change jamais
const pi = 3.1415926535897932384626;

// Backticks = ``
// modèle de libellé = template literal = `la chaine qui se trouve entre les backticks`
// On peut y trouver des expressions indiquées par la syntaxe ${expression}
const country = "France";
const x = 3;
const y = 7;
console.log(`Je vis en ${country}`); // "Je vis en France"
console.log(`${x} + ${y} = ${x + y}`); // "3 + 7 = 10"

// On peut forcer un type (ou une convertion)
const nb = 5;
const txt = Number(nb);

// Interractions avec l'utilisateur
/*{const prenom = prompt("Entrez votre prénom :");
alert(`Bonjour, ${prenom}`);
const nb = Number(prompt("Entrez un nombre : "));}*/

// Les fonctions 'if', 'else', 'while', 'for', 'switch' et les opérateurs logiques sont les mêmes qu'en Java

// Déclaration des fonctions normales (nommées)
function nomDeMaFonction() {
    console.log("Bonjour !");
}

// Déclaration des fonctions anonymes (non nommées)
// Méthode 1
const varFonctionAnonyme = function(prenom) {
    const message = `Bonjour, ${prenom} !`;
    return message;
}
// Méthode 2 : la fonction fléchée (fat arrow function)
const varFonctionAnonyme2 = (prenom) => {
    const message = `Bonjour, ${prenom} !`;
    return message;
}
// Méthode 3 : version compressée de la méthode 2 (à utiliser quand il n'y a qu'une seule ligne), le return devient implicite
const varFonctionAnonyme3 = prenom => `Bonjour, ${prenom} !`;

// Création d'objets
const stylo = {
    type: "bille",
    couleur: "bleu",
    marque: "Bic",
    toString() {
        return `${this.type}, ${this.couleur} et ${this.marque}`;
    }
};

console.log(stylo.toString());

// Création de classes
class Stylo {
    constructor(type, couleur, marque) {
      this.type = type;
      this.couleur = couleur;
      this.marque = marque;
    }
    toString() {
        return `${this.type}, ${this.couleur} et ${this.marque}`;
    }
}

{const stylo = new Stylo("plume", "noir", "Fontaine");
console.log(stylo.toString());

// Héritage : il s'agit de la notion de prototype en JavaScript
const VIP = Object.create(new Stylo());} // VIP hérite de Stylo

// Déclaration d'un tableau (en JS le type des objets n'importe pas)
{const tableau = ["Bonjour", 7, { message: "Coucou maman" }, true];
const taille = tableau.length;

// Extension directe sur les chaînes de caractères
console.log("ABC".length);

// Parcours optimisé des tableaux
// Méthode 1 : la fonction forEach()
tableau.forEach(element => {
    console.log(element);
  });
// Méthode 2 : le for optimisé
for (const element of tableau) {
    console.log(element);
}}

// Ajout à la fin du tableau : push(element)
// Ajout au début du tableau : unshift(element)
// Supprimer tout en récupérant le dernier élément du tableau : pop()

{const motInitial = "Coucou";
// Mettre en majuscules une chaîne de caractères
var motMinuscule = motInitial.toUpperCase();
// Mettre en minuscules une chaîne de caractères
var motMajuscule = motInitial.toLowerCase();

console.log("Azerty" === "azerty");
console.log("Azerty" == "azerty");

// On peut parcourir une chaîne de caractères avec le for optimisé
for (const lettre of "test") {
    console.log(lettre);
}
// Mais avec un forEach() il faut la convertir en un vrai tableau de caractères
Array.from("test").forEach(lettre => {
    console.log(lettre);
});}

// Fonctions pour vérifier le début ou la fin d'une chaîne de caractères : startsWith() et endsWith()
{const chanson = "Honky Tonk Women";
console.log(chanson.startsWith("Honk")); // true
console.log(chanson.endsWith("men")); // true

// Obtenir la première position du premier caractère d'un mot :
console.log(chanson.indexOf("Tonk")); // 6
console.log(chanson.indexOf("is")); // -1

// Le split()
const listeMois = "Jan,Fev,Mar,Avr,Mai,Jun,Jul,Aou,Sep,Oct,Nov,Dec";
const mois = listeMois.split(",");
console.log(mois[0]); // "Jan"
console.log(mois[11]);} // "Dec"

/* ---------- ---------- Notes du TP avec Jonathan ---------- ---------- */

// Cours sur le addEventListener : https://developer.mozilla.org/fr/docs/Web/API/EventTarget/addEventListener

// Liste des types d'événements des eventListener : https://developer.mozilla.org/fr/docs/Web/Events

/* fin des notes TP */

// La fonction confirme :
if (confirm('Voulez-vous exécuter le code JavaScript de cette page ?')) {
    alert('Le code a bien été exécuté !');
}

// Attention
do {
    //blablabla
} while (condition); // le ';'
