# GitHub Copilot / Agent instructions for Dragolandia

Short, actionable guidance to help an AI code agent be productive in this repository.

## Summary
- Small Java (Maven) CLI game using an MVC-like layout:
  - Entry: `com.example.App` → `Controlador.iniciarJuego()`
  - Packages: `controlador/`, `model/`, `dao/`, `vista/`
  - Persistence: JPA (persistence unit `dragolandiaServizo`) + Hibernate

## Quick start (commands)
- Start DB and phpMyAdmin: `docker compose up -d` (MySQL 3306, phpMyAdmin 8080)
- Run app: `mvn -Dexec.mainClass=com.example.App -Dexec.classpathScope=runtime exec:java`
- Run tests: `mvn test` (JUnit 4); inspect `target/surefire-reports/`
- Build jar: `mvn package` (jar does NOT include dependencies)

## Key code patterns (do not change without tests)
- Persistence/config:
  - `src/main/resources/META-INF/persistence.xml` (unit `dragolandiaServizo`)
  - `src/main/resources/hibernate.cfg.xml` (mappings + DB credentials)
  - `src/main/java/com/example/util/HibernateSingleton.java` provides `getEntityManager()`
- DAOs:
  - Use `EntityTransaction` begin/commit, handle exceptions, and always `em.close()` in finally blocks.
  - Follow `MagoDAO`/`MonstruoDAO` patterns for CRUD and transaction management.
- Entities:
  - `Hechizo` uses `@Inheritance(SINGLE_TABLE)`; `Mago` has `@OneToMany(fetch = EAGER, cascade = {PERSIST, MERGE})`.
  - Primary keys use `GenerationType.IDENTITY`.

## Important configuration notes
- Default DB: `dragolandia` / user `dam2user` / password `1234..` (in `persistence.xml` and `hibernate.cfg.xml`).
- `hibernate.hbm2ddl.auto=update` will alter DB schema automatically — avoid running against production DB.
- If you change DB credentials, update both `persistence.xml` and `hibernate.cfg.xml`.

## PR checklist (project-specific)
- New entity → ensure it is discoverable by JPA or add mapping in `hibernate.cfg.xml`.
- Preserve DAO transaction/close patterns; add tests that exercise DB behavior.
- Keep console output style (uses `System.out`) — tests and examples expect stdout messages.
- Run `mvn test` locally and check `target/surefire-reports/` (start DB first if tests need it).

## Key files to inspect
- App & controllers: `src/main/java/com/example/App.java`, `src/main/java/com/example/controlador/*`
- DAO examples: `src/main/java/com/example/dao/MagoDAO.java`, `MonstruoDAO.java`, `DragonDAO.java`
- Models: `src/main/java/com/example/model/*`
- Config: `src/main/resources/hibernate.cfg.xml`, `src/main/resources/META-INF/persistence.xml`, `docker-compose.yml`

If you want, I can add short runnable examples for: (a) starting DB & running tests, (b) creating a fat JAR, or (c) Docker troubleshooting. Tell me which to expand.
## Questions for reviewers
- Do you want to centralize DB config into environment variables instead of keeping credentials in `persistence.xml` / `hibernate.cfg.xml`?
- Should we add a lightweight logging dependency (e.g., slf4j-simple) so prints can be replaced by loggers in a follow-up?

---
If anything is unclear or you'd like me to add quick troubleshooting snippets (e.g., how to inspect DB with `docker exec` or how to create a runnable fat JAR), tell me which sections to expand. 

<!-- End of Copilot instructions -->