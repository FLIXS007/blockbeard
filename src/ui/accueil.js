const joueurStocke = localStorage.getItem("joueurConnecte");

if (!joueurStocke) {
    window.location.href = "pageconnexion.html";
} else {
    const joueur = JSON.parse(joueurStocke);
    console.log("Joueur connecté sur l'accueil :", joueur.nomJoueur);
}

const boutonDeco = document.querySelector("#bouton-Deco");

if (boutonDeco) {
    boutonDeco.addEventListener("click", () => {
        localStorage.removeItem("joueurConnecte");
        window.location.href = "pageconnexion.html";
    });
}
