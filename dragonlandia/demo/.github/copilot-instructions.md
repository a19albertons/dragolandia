# GitHub Copilot / Agent instructions for Dragolandia

Short, actionable guidance to help an AI code agent be productive in this repository.

## Project summary
- Small Java (Maven) CLI demo game (Dragonlandia) using an MVC-ish structure:
  - Packages: `controlador` (controllers), `model` (entities), `dao` (data access), `vista` (CLI views).
  - Persistence: Jakarta Persistence + Hibernate; entities annotated with `@Entity` and some explicit `@Table`/`@Inheritance`.
  - DB: MySQL (configured for local Docker in `docker-compose.yml`).

## High level architecture & important files
- Main entry: `com.example.App` calls `Controlador.iniciarJuego()` → CLI `Vista` drives flow.
- Persistence and transactions:
  - JPA persistence unit: `src/main/resources/META-INF/persistence.xml` (unit name `dragolandiaServizo`).
  - Hibernate-specific config: `src/main/resources/hibernate.cfg.xml` (contains mappings and MySQL connection values).
  - Singleton EntityManagerFactory: `src/main/java/com/example/controlador/HibernateSingleton.java` — code obtains EntityManagers via `getEntityManager()`.
- Common patterns:
  - DAOs create an `EntityManager`, begin/commit transactions and close the `EntityManager` in finally-block (`com.example.dao.*`).
  - `Hechizo` uses SINGLE_TABLE inheritance (`@Inheritance(strategy = InheritanceType.SINGLE_TABLE)`);
  - `Mago` defines `@OneToMany(fetch = FetchType.EAGER, cascade = {PERSIST, MERGE})` for `conjuros`.

## How to run / debug locally (explicit commands)
- Start DB and phpMyAdmin (dev):
  - `docker compose up -d` (starts MySQL on 3306 and phpMyAdmin on 8080)
  - phpMyAdmin: http://localhost:8080 (PMA_HOST `mysql` inside compose)
- Run the app from the project root:
  - Recommended (no executable jar provided):
    - `mvn -Dexec.mainClass=com.example.App -Dexec.classpathScope=runtime exec:java`
  - Alternative:
    - `mvn package` then run via the IDE; note: built jar **does not** include dependencies (no shade plugin configured).
- Tests:
  - `mvn test` — reports live in `target/surefire-reports/`.

## Important configuration notes and gotchas
- DB credentials and schema
  - Default DB settings in `persistence.xml` and `hibernate.cfg.xml`: database `dragolandia`, user `dam2user`, password `1234..`.
  - `hibernate.hbm2ddl.auto=update` will alter DB schema automatically — be careful when running against a production DB.
- If you change the DB credentials, update both `persistence.xml` and `hibernate.cfg.xml` (or prefer to centralize config via environment variables).
- The persistence unit name (`dragolandiaServizo`) must match the one used by `HibernateSingleton`.

## Conventions and code patterns to follow
- Languages & naming: code and comments are in Spanish — maintain this style for clarity.
- Entity conventions:
  - Use `GenerationType.IDENTITY` for primary keys (consistent with existing entities).
  - If adding entities, you can rely on `exclude-unlisted-classes=false` in `persistence.xml` (no need to list every entity). If you rely on `hibernate.cfg.xml` mappings, add the mapping there too.
- DAOs:
  - Follow existing pattern of obtaining an `EntityManager` from `HibernateSingleton`, using `EntityTransaction` and ensuring `em.close()` in finally.
  - Keep error handling consistent (current code prints to stdout). Consider adding a logging framework if you change behavior — note tests and existing code will expect `System.out` messages.

## Testing & CI hints
- Unit tests are JUnit 4 tests (see `src/test/java/...` and `pom.xml` dependency).
- DB-dependent tests: run `docker compose up -d` before executing tests that need the DB.

## When adding features / PR checklist
- Ensure new entities are either picked by JPA (annotated and on classpath) or add mappings to `hibernate.cfg.xml` if using Hibernate mappings explicitly.
- Update or add tests in `src/test/java`. Run `mvn test` locally and inspect `target/surefire-reports/` for failures.
- If touching DB credentials or schema behavior, document the change in `README.md` and update `docker-compose.yml` if needed.

## Examples (quick snippets)
- Create and persist a `Mago` (pattern used in `ControladorMago`/`MagoDAO`):

```java
Mago m = new Mago("Gundalf", 10, 3, new ArrayList<>());
MagoDAO dao = new MagoDAO();
dao.guardarMago(m);
```

## Questions for reviewers
- Do you want to centralize DB config into environment variables instead of keeping credentials in `persistence.xml` / `hibernate.cfg.xml`?
- Should we add a lightweight logging dependency (e.g., slf4j-simple) so prints can be replaced by loggers in a follow-up?

---
If anything is unclear or you'd like me to add quick troubleshooting snippets (e.g., how to inspect DB with `docker exec` or how to create a runnable fat JAR), tell me which sections to expand. 

<!-- End of Copilot instructions -->