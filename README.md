# Deployment Steps:
### Local Setup of Server in Eclipse:
  1. Clone “TrojanHousing/Backend.git” and import project Backend into Eclipse workspace (Make sure that your project is using Java 21).
  2. Create a MySQL Schema named TrojanHousingDB or run create.sql script in the top of the project folder on a MySQL workspace setup at localhost 3306 with username root and password root.
  3. Run the main application located at src/main/java/trojanHousing/backend/TrojanHousingBackendApplication.java as a java application to start the Spring Boot server.
  4. On startup, the tables will be created in the TrojanHousingDB schema, and the server will start. Finally, run PropertyLoader.java as a java application after your first server startup to populate the database.
  5. The server will now be running, and the database will be populated. Launch the Frontend server to access Trojan Housing Finder.
