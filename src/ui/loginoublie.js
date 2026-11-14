const formulaire = document.querySelector("#form-oubli");
const message = document.querySelector("#message-oubli");

formulaire.addEventListener("submit", (event) => {
    event.preventDefault();
    message.textContent =
        "La réinitialisation de mot de passe sera bientôt disponible via le serveur.";
});
