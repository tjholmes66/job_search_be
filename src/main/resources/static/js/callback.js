document.addEventListener("DOMContentLoaded", function() {
    // 1. Parse the tokens/codes from the URL fragment (#) or query string (?)
    const urlParams = new URLSearchParams(window.location.hash.replace("#", "?"));
    const accessToken = urlParams.get("access_token");
    const idToken = urlParams.get("id_token");
    const expiresIn = urlParams.get("expires_in") || 3600;

    if (accessToken) {
        // 2. Calculate cookie expiration
        const date = new Date();
        date.setTime(date.getTime() + (expiresIn * 1000));
        const expires = "expires=" + date.toUTCString();

        // 3. Store the token in a local cookie
        // Secure: Sent only over HTTPS; SameSite=Strict: Prevents CSRF
        document.cookie = `AUTH_TOKEN=${accessToken}; ${expires}; path=/; Secure; SameSite=Strict`;

        if (idToken) {
            document.cookie = `ID_TOKEN=${idToken}; ${expires}; path=/; Secure; SameSite=Strict`;
        }

        // 4. Redirect the user to the home/dashboard page
        window.location.href = "/dashboard.html";
    } else {
        // Handle authentication failure or code exchange errors
        console.error("Authentication failed: No token found in callback URL.");
        window.location.href = "/index.html";
    }
});
