const API_AUTH_URL = "http://localhost:8080/api/auth";

const formulaire = document.querySelector("#form-inscription");
const message = document.querySelector("#message-inscription");

formulaire.addEventListener("submit", async (event) => {
    event.preventDefault();

    const pseudo = formulaire.elements.pseudo.value.trim();
    const email = formulaire.elements.email.value.trim();
    const password = formulaire.elements.password.value;

    message.textContent = "Création du compte...";

    try {
        const reponse = await fetch(`${API_AUTH_URL}/inscription`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                pseudo: pseudo,
                email: email,
                password: password
            })
        });

        if (!reponse.ok) {
            const erreurTexte = await reponse.text();
            message.textContent = erreurTexte || "Erreur lors de l'inscription.";
            return;
        }

        const joueur = await reponse.json();
        message.textContent = `Compte créé ! Bienvenue ${joueur.nomJoueur}.`;
        formulaire.reset();
        console.log("Utilisateur créé :", joueur);
    } catch (erreur) {
        message.textContent = "Impossible de joindre le serveur Spring Boot.";
        console.error(erreur);
    }
});
