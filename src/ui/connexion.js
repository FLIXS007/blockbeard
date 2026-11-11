const formulaire = document.querySelector("#form-connexion");
const message = document.querySelector("#message-connexion");

formulaire.addEventListener("submit", async (event) => {
    event.preventDefault();

    const email = formulaire.elements.email.value;
    const password = formulaire.elements.password.value;

    message.textContent = "Tentative de connexion...";

    const { data, error } =
        await supabaseClient.auth.signInWithPassword({
            email: email,
            password: password
        });

    if (error) {
        message.textContent = "Identifiants incorrects.";
        console.error(error);
        return;
    }

    message.textContent = "Connexion réussie !";
    console.log("Utilisateur connecté :", data.user);
});
