# 🤝 Nuestro Código de Colaboración: Trabajando Juntos en el Repositorio

**¡Bienvenidos al equipo!** Estas normas están diseñadas para asegurar que trabajemos de manera coordinada, que nuestro código se mantenga limpio y que nuestra historia de proyecto sea fácil de entender. Piénsalo como nuestro mapa de carreteras para no tener atascos en el desarrollo.

---

## I. 🗺️ El Mapa de Rutas: Flujo de Trabajo y Versiones

Esta sección explica cómo manejamos las "carreteras principales" y las "rutas secundarias" de nuestro código.

### A. Cuidado de las Vías Principales (Main y Develop)

1.  **Zona Intocable:** Las ramas **`main`** (lo que ven nuestros usuarios) y **`develop`** (nuestro código en pruebas) son como **autopistas protegidas**. **Nadie** sube cambios directamente a ellas.
2.  **`main` es Oro:** La rama `main` siempre debe ser **perfectamente estable**. Solo la tocamos para sacar una nueva versión probada.
3.  **`develop` es Base:** La rama `develop` es nuestro **punto de encuentro**. Debe estar siempre **funcional** para que el equipo pueda trabajar. Los cambios solo entran aquí con un **sello de aprobación** (un Pull Request revisado).

### B. Rutas Individuales: Creación de Ramas

1.  **Tu Propio Espacio:** Para cada tarea (funcionalidad nueva o arreglo), crea una **rama individual** partiendo **siempre desde `develop`**. Es tu taller personal.
2.  **Etiquetas Claras:** Nombra tu rama usando estas etiquetas para saber qué estás haciendo de un vistazo:
    * **`feature/`** (Si es algo nuevo)
    * **`bugfix/`** (Si es para arreglar un error)
    * **`hotfix/`** (Si es un arreglo urgente que va directo a producción)
3.  **Limpieza:** Una vez que tu trabajo se ha unido a `develop`, **borra tu rama**. ¡Espacio limpio, mente limpia!

### C. El Sello de Versión

1.  **Etiquetas Numéricas:** Usamos un sistema de **versionado simple (ej. 1.0.3)** para que todos sepan exactamente qué versión estamos usando.
2.  **Diario de Cambios:** Cuando sacamos una nueva versión, debemos **actualizar el archivo `CHANGELOG.md`** para que todos sepan qué novedades trae esa versión.

---

## II. 📝 Registrando la Historia: Commits y Calidad del Código

Queremos que la historia de nuestro repositorio sea un diario ordenado, no un revoltijo.

### A. La Regla de los Commits

1.  **Pequeños y Frecuentes:** Haz *commits* **pequeños** y **a menudo**. Cada *commit* debe ser como un paso en la receta: solo un cambio lógico a la vez.
2.  **Mensajes Informativos:** El mensaje debe ser claro y decir **qué tipo de cambio es** (`feat`, `fix`, etc.) y **qué hiciste**.
    * *Ejemplo:* `fix: Corregir error de validación en campo de teléfono`

### B. Mantenimiento y Seguridad

1.  **Basura Cero:** **No subas archivos generados** (carpetas de *build*, logs, archivos temporales) al repositorio. Solo el código fuente.
2.  **La Lista de Ignorados:** Mantén el archivo `.gitignore` **siempre al día** para evitar subir accidentalmente la "basura".
3.  **Secreto Profesional:** **Nunca subas contraseñas, claves o credenciales de acceso**. Esto es crítico. Toda configuración sensible va fuera del código (en archivos `.env` o en servicios de secretos).

### C. Limpieza y Estilo

1.  **El Estilo del Equipo:** Debemos seguir todos el **mismo estilo de codificación** (uso de comillas, espaciado, nombres de variables) para que el código parezca escrito por una sola persona.
2.  **No Dejar Restos:** **No dejes código comentado que ya no uses**. ¡Si ya no sirve, bórralo!

---

## III. ✅ El Control de Calidad: Pull Requests (PR)

Un Pull Request es el momento formal donde pedimos que nuestro trabajo sea revisado antes de unirlo a `develop`.

### A. Preparación del PR

1.  **Sincronización:** **Antes de crear un PR**, asegúrate de que tu rama está al día con los últimos cambios en `develop`. Así evitamos conflictos innecesarios.
2.  **La Solicitud:** Tu PR debe incluir:
    * **Qué hiciste** (Descripción clara).
    * **Por qué lo hiciste** (Relación con la tarea/error).
    * **Cómo lo probaste** (Pasos que el revisor puede seguir).
3.  **Tamaño Manejable:** Los PR deben ser **pequeños**. Es más fácil revisar 50 líneas bien que 500 mal.

### B. Pruebas y Aprobación

1.  **Tu Responsabilidad:** Eres responsable de **probar tu código localmente** y verificar que todo funciona antes de pedir revisión.
2.  **Luz Verde:** Todos los *tests* automáticos (si los tenemos) **deben pasar** antes de solicitar una revisión.
3.  **El Visto Bueno:** **Nadie fusiona su propio PR**. Debe tener la **aprobación** de un compañero o del responsable técnico.
4.  **Revisión Constructiva:** Al revisar, sé detallado y enfócate en ayudar, no en criticar.

---

## IV. 🗣️ Hablemos: Comunicación y Bloqueos

La comunicación fluida es clave para evitar malentendidos y avanzar rápido.

1.  **Decisiones en Equipo:** Los grandes cambios (tecnología, arquitectura) se **discuten y deciden en conjunto**.
2.  **Avisa si te Bloqueas:** Si encuentras un **bloqueo** que te impide avanzar (un error insuperable, un problema de dependencias), **avisa inmediatamente al equipo**. No pierdas horas en silencio; la ayuda está a un mensaje de distancia.
3.  **Documentar los Cambios:** Si haces un cambio grande en cómo funciona el sistema o cómo se instala, **actualiza la documentación** (`README.md` o documentación interna). Ayuda a que los demás se pongan al día sin preguntar.