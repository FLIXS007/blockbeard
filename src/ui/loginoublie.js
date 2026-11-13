
const formulaire = document.querySelector("#form-oubli");
const message = document.querySelector("#message-oubli");

formulaire.addEventListener("submit", async (event) => {
    event.preventDefault();

    const email = formulaire.elements.email.value.trim();

    message.textContent = "Envoi en cours...";

    const { data, error } = await supabaseClient.auth.resetPasswordForEmail(
        email,
        {
            redirectTo: window.location.origin + "/reinitialisation.html"
        }
    );

    if (error) {
        message.textContent = error.message;
        console.error(error);
        return;
    }

    message.textContent =
        "Si un compte existe avec cette adresse, un email de réinitialisation va être envoyé.";

    formulaire.reset();

    console.log("Email de réinitialisation demandé :", data);
});
