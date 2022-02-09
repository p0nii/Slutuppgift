
##Checklista: Funktionalitet för Godkänt

Ett inlägg ska bestå av:
- [x] En rubrik (Title)
- [x] Ett innehåll (Body)
- [x] ID

### Planering

- [x] Du ska i server komponenten ha en fil som heter README.md där du listar minst 10 punkter med saker du behöver göra.
- [ ] Det är uppmuntrat om du använder dig av BDD-formuleringarna (Given, when, then.

### Serverkomponenten
- [x] Servern ska använda sig av Spring-ramverket och det är i servern som alla blogginlägg sparas.
- [x] Servern ska svara på API-förfrågningar för att lista inlägg, redigera inlägg, ta bort inlägg och visa specifikt inlägg.

#### Adresser till dessa API-förfrågningar ska vara följande:
- [x] /api/v1/blog/list – Lista alla inlägg
- [x] /api/v1/blog/view/<id> - Visa ett specifikt inlägg
- [x] /api/v1/blog/update/<id> - Uppdatera ett specifikt inlägg
- [x] /api/v1/blog/delete/<id> - Ta bort ett specifikt inlägg
- [x] /api/v1/blog/create – Lägg till ett nytt inlägg

- [x] Varje förfrågan måste använda en lämplig HTTP-metod (GET, POST, PATCH et
  cetera)
- [x] Din kod ska sparas i versionhantering med Git

### Klientkomponenten:

- [x] Klientkomponenten ska vara ett textbaserat gränssnitt (CLI)
- [x] Användaren ska kunna lista/lägga till/redigera/ta bort blogginlägg via API-förfrågningar till serverkomponenten
- [x] Användaren ska kunna lista alla inlägg (ID och titel visas)
- [x] Användaren ska kunna efterfråga ett specifikt inlägg och läsa innehållet
- [x] Ingen information ska sparas i klienten
- [x] Om användaren försöker visa, ta bort, redigera eller ändra ett inlägg som inte
  finns ska det visas ett tydligt felmeddelande
- [x] Din kod ska sparas i versionshantering med Git

## Checklista: Funktionalitet för Väl Godkänt

- [x] Du ska använda dig av Dependency Injection
- [x] Du ska separera koden i en Service och en Controller
- [x] Du ska skapa en Dockerfile och skriva instruktioner om hur serverkomponenten kan startas som en docker-container, och klientkomponenten ska kunna ansluta till serverkomponenten.
- [x] Du ska använda loggning med SLF4J och logga alla API-anrop
