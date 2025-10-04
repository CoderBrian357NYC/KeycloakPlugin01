# KeycloakPlugin01

**KeycloakPlugin01** is a custom Keycloak event listener plugin written in Java.  
It logs user login successes, failures, and other Keycloak user events to the console for debugging and monitoring purposes.

---

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

---

## Features

- Logs **successful logins** with user ID and IP address.
- Logs **failed logins**, including invalid credentials and expired codes.
- Logs **logout events** and other user events for monitoring.
- Simple integration with Keycloak 26.4.0 running in development mode.

---

## Prerequisites

- Java JDK 17+
- Maven 3.8+
- Keycloak 26.4.0 (server running in development mode)

---

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/CoderBrian357NYC/KeycloakPlugin01.git
   cd KeycloakPlugin01

## Build the project using Maven
2. mvn clean install

## Copy the generated JAR to your Keycloak providers folder:
3. cp target/KeycloakPlugin01-1.0-SNAPSHOT.jar <keycloak-home>/providers/

## Start Keycloak in development mode
4. cd <keycloak-home>
   bin/kc.sh start-dev

---

### Usage

Once Keycloak is running:

1. Log in to your realm (e.g., `master`) and navigate to the Admin Console.
2. Perform login attempts with any test user.
3. Observe the server logs for events captured by the plugin, including:

- Successful logins
- Failed logins
- Logout events

The plugin logs the user ID, username, IP address, and type of event.
