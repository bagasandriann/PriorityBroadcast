# Priority Broadcast

Priority Broadcast is a Java and PrimeFaces prototype for sending broadcast messages to a list of mock customers. The application demonstrates AJAX-based UI interaction, real-time progress updates, asynchronous background processing, and a mock third-party messaging integration.

## Tech Stack

- Java 21
- Spring Boot 3.5.14
- JoinFaces 5.4.3
- PrimeFaces
- Maven

## Project Structure

```text
src/main/java/com/prioritybroadcast
+-- Main.java
+-- MockMessagingService.java
+-- model
|   +-- Customer.java
+-- view
    +-- BroadcastView.java

src/main/resources/META-INF/resources
+-- broadcast.xhtml
```

## How to Run

Make sure Java 21 and Maven are available.

From the project root:

```bash
mvn spring-boot:run
```

Then open:

```text
http://localhost:8080/broadcast.xhtml
```

## Manual Test Steps

1. Open `http://localhost:8080/broadcast.xhtml`.
2. Confirm the customer table displays 10 mock customers.
3. Click `Start Priority Broadcast`.
4. Confirm the page does not fully refresh.
5. Confirm customer statuses update from `Pending` to `Sending`, then `Sent` or `Failed`.
6. Confirm the progress bar increases until it reaches 100%.
7. Confirm the broadcast status changes to `Broadcast finished`.
