# GitHub Copilot / AI agent instructions for Dragolandia ✅

## Quick summary
- Project: Small CLI Java app (Maven) named **DRAGOLANDIA** (Java 21). Main entry: `com.example.App`.
- Runtime: interactive console (Scanner-based menu) with JPA/Hibernate persistence to MySQL.
- Dev DB: `docker-compose.yml` already defines MySQL + phpMyAdmin (3306 / 8080). Persistence config in `src/main/resources/META-INF/persistence.xml`.

---

## How to run (dev flow) 🔧
1. Start DB (recommended for features that hit the DB):
   - `docker-compose up -d` (mysql + phpmyadmin). DB credentials match `persistence.xml` (DB `dragolandia`, user `dam2user`, password `1234..`).
2. Build & test:
   - `mvn clean package` — compiles and creates `target/classes`
   - `mvn test` — run unit tests (there is one simple JUnit test in `src/test/java/com/example/AppTest.java`).
3. Run app locally (from project root):
   - Quick: `mvn -Dexec.mainClass=com.example.App exec:java` (common for testing CLI runs from Maven)
   - Alternative: `mvn dependency:copy-dependencies -DoutputDirectory=target/dependency && java -cp target/classes:target/dependency/* com.example.App`
4. Debug: open `com.example.App` as Main in your IDE and run with breakpoints. The app is interactive — automated tests do not exercise menu-driven flows.

---

## Big-picture architecture & patterns 💡
- Structure follows a simple MVC-ish pattern: `controlador/` (controllers), `vista/` (console UI), `model/` (JPA entities), `dao/` (data access using JPA/Hibernate).
- Persistence: JPA entities annotated with `@Entity` (see `Mago`, `Dragon`, `Bosque`), DAO classes manage transactions manually via `HibernateSingleton.getEntityManager()`.
  - Key files: `src/main/resources/META-INF/persistence.xml` and `src/main/java/com/example/util/HibernateSingleton.java` (singleton EntityManagerFactory).
- Controllers call DAOs directly (no service layer). View-layer (`Vista`) instantiates controllers and drives the menu.
- Interactive flows: multiple `Vista*` classes read user input and call controller methods to persist/list/delete entities.

---

## Project-specific conventions & gotchas ⚠️
- Docstrings and identifiers are in **Spanish**; follow that wording for messages and new code/comments.
- Persistence unit is named **`dragolandiaServizo`** (note spelling) and is used by `HibernateSingleton`; changing it requires updating both `persistence.xml` and `HibernateSingleton`.
- DB properties are hard-coded in `persistence.xml` for dev. The docker-compose file matches these credentials — use it for local development.
- Error handling: DAOs use `System.out.println` and `e.printStackTrace()` (no logging framework). Tests and CLI expect console output behavior; keep this in mind when changing error/reporting behavior.
- Entities sometimes use EAGER fetch for convenience (e.g., `Mago.conjuros` uses `FetchType.EAGER`). Beware of lazy-loading changes affecting menu flows.
- The app depends on Java 21 (see `pom.xml` properties `maven.compiler.source`/`target`).

---

## Examples (copyable) 🔎
- Create a mago and persist (pattern used across views):
  1. `VistaMago.crearMago()` builds a `Mago` instance and calls `controlador.getControladorMago().setMago(mago); controlador.getControladorMago().guardarMago();`
  2. See `src/main/java/com/example/vista/VistaMago.java` and `src/main/java/com/example/controlador/ControladorMago.java`.
- Query all magos: `controlador.getControladorMago().obtenerTodosMagos()` which delegates to `MagoDAO.obtenerTodosMagos()`.

---

## When making changes, what to check ✅
- If you touch any entity or mapping, run `mvn test` and exercise the CLI flows (create/list/delete) against the Docker MySQL to verify schema behavior (`hibernate.hbm2ddl.auto` currently `update`).
- If you change persistence unit name or `persistence.xml` properties, update `HibernateSingleton` accordingly.
- Keep console outputs stable if tests or the interactive flows rely on specific strings (used for user prompts and small test expectations).

---

## Useful files to reference 🔗
- `pom.xml` — Java version and dependencies (Hibernate, MySQL connector).
- `docker-compose.yml` — local DB + phpMyAdmin; useful for reproducing database state.
- `src/main/resources/META-INF/persistence.xml` — JDBC/hibernate configuration.
- `src/main/java/com/example/util/HibernateSingleton.java` — EMF singleton factory.
- `src/main/java/com/example/model/` — entity conventions & mappings.
- `src/main/java/com/example/dao/` — DAO patterns (manual tx, error handling).
- `src/main/java/com/example/vista/` — interactive flows to exercise changes quickly.

---

If any part is unclear or you'd like me to add short code examples for common tasks (e.g., how to add a new entity + DAO + menu option), tell me which one and I’ll add it to this file. ✨