const API_AUTH_URL = window.location.port === "8080" || window.location.hostname.includes("onrender.com")
    ? "/api/auth"
    : "http://localhost:8080/api/auth";

const formulaire = document.querySelector("#form-connexion");
const message = document.querySelector("#message-connexion");

formulaire.addEventListener("submit", async (event) => {
    event.preventDefault();

    const email = formulaire.elements.email.value.trim();
    const password = formulaire.elements.password.value;

    message.textContent = "Tentative de connexion...";

    try {
        const reponse = await fetch(`${API_AUTH_URL}/connexion`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                email: email,
                password: password
            })
        });

        if (!reponse.ok) {
            const erreurData = await reponse.json().catch(() => null);
            message.textContent =
                (erreurData && erreurData.message) || "Identifiants incorrects.";
            return;
        }

        const joueur = await reponse.json();
        localStorage.setItem("joueurConnecte", JSON.stringify(joueur));

        message.textContent = `Connexion réussie ! Bonjour ${joueur.nomJoueur}`;
        console.log("Utilisateur connecté :", joueur);
        window.location.href = "accueil.html";
    } catch (erreur) {
        message.textContent = "Impossible de joindre le serveur Spring Boot.";
        console.error(erreur);
    }
});
