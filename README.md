# RMI-Enabled Online Banking Platform

This module adds a Java distributed-systems project to the workspace. It combines:

- Java RMI for remote banking operations
- JDBC for persistence against MySQL/MariaDB
- Java TCP sockets for real-time transaction notifications
- Transaction rollback for money movement and loan disbursement
- Role-based access control for customer and admin workflows
- Audit logging for sensitive actions

## Module Layout

- `src/banking`: Java source code
- `config/application.properties.example`: database and network settings template
- `sql/schema.sql`: relational schema used by the server bootstrap
- `run-server.ps1`: compile and start the bank server
- `run-client.ps1`: compile and start the CLI client

## Requirements

- Java 24 or later
- MySQL/MariaDB running locally
- A MySQL JDBC driver jar

## Setup

1. Copy `config/application.properties.example` to `config/application.properties`
2. Update the database credentials if needed
3. Either point `MYSQL_CONNECTOR_JAR` to your JDBC driver jar or place the jar in `online-banking-rmi\lib`

Example:

```powershell
Set-Location C:\wamp64\www\Booking_System\online-banking-rmi
Copy-Item .\config\application.properties.example .\config\application.properties
$env:MYSQL_CONNECTOR_JAR = "C:\path\to\mysql-connector-j-9.3.0.jar"
```

You can also drop either of these into `online-banking-rmi\lib`:

- `mysql-connector-j-*.jar`
- `mariadb-java-client-*.jar`

## Run The Server

```powershell
Set-Location C:\wamp64\www\Booking_System\online-banking-rmi
powershell -ExecutionPolicy Bypass -File .\run-server.ps1
```

On first startup the server:

- creates the schema from `sql/schema.sql`
- seeds demo users and accounts if they do not already exist
- starts the RMI registry
- begins dispatching socket-based notifications

## Run A Client

Open a second terminal:

```powershell
Set-Location C:\wamp64\www\Booking_System\online-banking-rmi
$env:MYSQL_CONNECTOR_JAR = "C:\path\to\mysql-connector-j-9.3.0.jar"
powershell -ExecutionPolicy Bypass -File .\run-client.ps1
```

## Demo Accounts

These users are seeded automatically by the server:

- `alice` / `Password123!`
- `bob` / `Password123!`
- `admin` / `Admin123!`

## Security Notes

This is a teaching-oriented simulation, but it still includes a few realistic controls:

- PBKDF2 password hashing with per-user salts
- random session tokens for authenticated RMI calls
- access checks to ensure customers only read their own accounts
- rollback on failed transfers and failed loan disbursements
- audit entries for login, transfers, loans, and admin access
- socket notification registration tied to an authenticated session

For a production deployment, add TLS for both RMI and sockets, secrets management, rate limiting, and stronger fraud rules.
