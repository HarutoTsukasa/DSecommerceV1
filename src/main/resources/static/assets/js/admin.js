let temaActual = "light";

function alternarTema() {
    temaActual = temaActual === "light" ? "dark" : "light";
    document.documentElement.setAttribute("data-bs-theme", temaActual);
    document.getElementById("btnTema").textContent = temaActual === "light" ? "🌙" : "☀️";
}

document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("btnTema")?.addEventListener("click", alternarTema);

    // DataTables
    $("#tablaProductos").DataTable({ pageLength: 5, language: { url: "" } });
    $("#tablaPedidos").DataTable({ pageLength: 5 });

    // --- CRUD Productos ---
    const modal = new bootstrap.Modal(document.getElementById("prodModal"));

    document.getElementById("btnNuevoProd").addEventListener("click", () => {
        document.getElementById("prodId").value = "";
        document.getElementById("prodNombre").value = "";
        document.getElementById("prodDesc").value = "";
        document.getElementById("prodPrecio").value = "";
        document.getElementById("prodStock").value = "";
        document.getElementById("prodImg").value = "";
    });

    document.querySelectorAll(".btn-edit-prod").forEach(btn => {
        btn.addEventListener("click", () => {
            const d = btn.dataset;
            document.getElementById("prodId").value = d.id;
            document.getElementById("prodNombre").value = d.nombre;
            document.getElementById("prodDesc").value = d.desc || "";
            document.getElementById("prodPrecio").value = d.precio;
            document.getElementById("prodStock").value = d.stock;
            document.getElementById("prodImg").value = d.img || "";
            modal.show();
        });
    });

    document.getElementById("btnGuardarProd").addEventListener("click", async () => {
        const id = document.getElementById("prodId").value;
        const payload = {
            nombre: document.getElementById("prodNombre").value,
            descripcion: document.getElementById("prodDesc").value,
            precio: parseFloat(document.getElementById("prodPrecio").value),
            stock: parseInt(document.getElementById("prodStock").value),
            imagenUrl: document.getElementById("prodImg").value
        };

        // Necesitamos vendedor para crear: se usa el admin semilla (id 1).
        if (!id) payload.vendedor = { id: 1 };

        const url = id ? `/api/productos/${id}` : "/api/productos";
        const method = id ? "PUT" : "POST";
        try {
            const res = await fetch(url, {
                method,
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(payload)
            });
            if (!res.ok) throw new Error("Fallo al guardar");
            location.reload();
        } catch (e) {
            alert("Error: " + e.message);
        }
    });

    document.querySelectorAll(".btn-del-prod").forEach(btn => {
        btn.addEventListener("click", async () => {
            if (!confirm("¿Eliminar producto?")) return;
            await fetch(`/api/productos/${btn.dataset.id}`, { method: "DELETE" });
            location.reload();
        });
    });

    // --- Pedidos: eliminar ---
    document.querySelectorAll(".btn-del-orden").forEach(btn => {
        btn.addEventListener("click", async () => {
            if (!confirm("¿Eliminar pedido?")) return;
            await fetch(`/api/ordenes/${btn.dataset.id}`, { method: "DELETE" });
            location.reload();
        });
    });
});