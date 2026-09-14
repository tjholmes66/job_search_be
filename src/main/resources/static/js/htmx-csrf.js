document.addEventListener("DOMContentLoaded", () => {
    document.body.addEventListener('htmx:configRequest', (evt) => {
        // Read the token and header name from the meta tags
        const token = document.querySelector('meta[name="_csrf"]').getAttribute('content');
        const headerName = document.querySelector('meta[name="_csrf_header"]').getAttribute('content');

        // Push the CSRF token into the outgoing HTMX request headers
        evt.detail.headers[headerName] = token;
    });
});