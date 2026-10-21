// Estado del tema solo en memoria. Sin localStorage.
let temaActual = "light";

function alternarTema() {
    temaActual = temaActual === "light" ? "dark" : "light";
    document.documentElement.setAttribute("data-bs-theme", temaActual);
    document.getElementById("btnTema").textContent = temaActual === "light" ? "🌙" : "☀️";
}

document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("btnTema")?.addEventListener("click", alternarTema);

    // Carrito en memoria (no persiste, no usa localStorage).
    const carrito = [];
    document.querySelectorAll(".btn-anadir").forEach(btn => {
        btn.addEventListener("click", () => {
            carrito.push(btn.dataset.nombre);
            btn.textContent = "Añadido ✓";
            setTimeout(() => btn.textContent = "Añadir", 1200);
        });
    });

    // Login fake contra /api/auth/login
    document.getElementById("formLogin")?.addEventListener("submit", async (e) => {
        e.preventDefault();
        const email = document.getElementById("loginEmail").value;
        const password = document.getElementById("loginPass").value;
        const msg = document.getElementById("loginMsg");
        msg.classList.remove("d-none");
        msg.textContent = "Verificando...";
        try {
            const res = await fetch("/api/auth/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ email, password })
            });
            const data = await res.json();
            if (data.autenticado) {
                msg.className = "alert alert-success small";
                msg.textContent = "Sesión iniciada. (Seguridad real se añadirá con Spring Security).";
            } else {
                msg.className = "alert alert-danger small";
                msg.textContent = "Credenciales inválidas.";
            }
        } catch {
            msg.className = "alert alert-danger small";
            msg.textContent = "Error de red.";
        }
    });

    // Formulario de contacto (solo simulación)
    document.getElementById("formContacto")?.addEventListener("submit", (e) => {
        e.preventDefault();
        alert("Mensaje enviado (simulado).");
        e.target.reset();
    });
});