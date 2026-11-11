const formulaire = document.querySelector("#form-inscription");
const message = document.querySelector("#message-inscription");

formulaire.addEventListener("submit", async (event) => {
    event.preventDefault();

    const pseudo = formulaire.elements.pseudo.value;
    const email = formulaire.elements.email.value;
    const password = formulaire.elements.password.value;

    message.textContent = "Création du compte...";

    const { data, error } = await supabaseClient.auth.signUp({
        email: email,
        password: password,
        options: {
            data: {
                pseudo: pseudo
            }
        }
    });

    if (error) {
        message.textContent = error.message;
        console.error(error);
        return;
    }

    message.textContent =
        "Compte créé. Vérifie ton adresse e-mail si une confirmation est demandée.";

    console.log("Utilisateur créé :", data.user);
});
