IPASS – Ontwerpdocument
=======================

***Ipass occasions project***

| Datum      | 05-05-2020 |
|------------|------------|
| __Versie__ | __0__      |
| __Auteur__ | __Jayh de Cuba__   |

---

# Inhoud
 - [1 Inleiding](#1-inleiding)
   - [§1 Doelgroep (optioneel)](#§1-doelgroep-(optioneel))
   - [§2 Leeswijzer (optioneel)](#§2-leeswijzer-(optioneel))
 - [2 Overzicht](#2-overzicht)
 - [3 Use Cases](#3-use-cases)
   - [§1 Actoren](#§1-actoren)
   - [§2 Use Case Templates](#§2-use-case-templates)
   - [§3 Wireframes](#§3-wireframes)
 - [4 Domeinmodel](#4-domeinmodel)
 - [5 Technologieën](#5-technologieën)
 - [6 Overdracht](#6-overdracht)
 - [7 Referenties](#7-referenties)

---

# 1 Inleiding
In de eerste periode van het 1e leerjaar ICT had ik een gesprek met mijn nicht. Het ging over het maken van websites en apps voor bedrijven en hoe leuk het mij leek om dat later als baan te hebben. Zij vertelde mij dat ze als hobby auto’s inkocht in Duitsland en het dan weer door verkocht in Nederland met als eindresultaat winst. De hobby werd uiteindelijk  een succes en transformeerde in een klein occasions bedrijf (Huibers Auto’s) in 2017. Bij Huibers Auto’s werken mijn nicht (als bijbaan) en haar man. Haar man verkoopt de auto’s en mijn nicht doet de administratie. 

Huibers auto’s komt aan klanten door mond tot mond reclame en een Facebookpagina dat contactgegevens bevat. Helaas bevat het nog geen aanbod van de auto’s die zich daar actueel bevinden. Daarom vroeg mijn nicht mij om voor haar ooit een website te maken. 
Waarop ze zelf de auto’s kan plaatsen met daarvan alle gegevens, zodat toekomstige klanten meer informatie kunnen vinden van de auto’s  en de kwaliteit van de relaties met de klanten zullen stijgen. 


---

# 2 Overzicht
Korte beschrijving wat het systeem geacht wordt te doen. Eventueel indeling in subsystemen met een korte beschrijving van een subsysteem.

---

# 3 Use Cases

![GitHub Logo](https://raw.githubusercontent.com/jayh475/IPASS_Project_Occasions/master/IPASS_Project_Occasions/Images/Class%20Diagram%20Ocassions.jpg?token=ANT36TQKUGC4QY5PEFFRAOC6YT7SY)
[[Images/ClassDiagramOcassions.jpg]]


•	1. De admin kan een auto toevoegen. 
De admin voert een naam in, een afbeelding, km-stand, bouwjaar, prijs, en brandstof type. 

•	2. De admin kan  wijzingen aanbrengen aan de gegevens van de auto.
De admin kan bij de auto’s in het hoofdscherm op wijzigen klikken, dan kan ze alle gegevens wijzingen die genoemd worden in use case 1. 

•	3. De admin kan auto’s verwijderen.
De admin kan auto’s verwijderen door naast het knopje wijzigen op het knopje verwijderen te klikken, hierna komt er een pop-upvenster met de tekst: “weet u het zeker?”. 

•	4. De admin kan berichten ontvangen van gebruikers  met en zonder account.
Er bestaat een tab met bericht sturen en die is ook aanwezig voor gebruikers die geen account hebben. 

•	5. Zowel de admins als gebruikers kunnen inloggen. 
Het inloggen wordt gedaan met een emailadres en de daarbij horende wachtwoord. Als één van beiden niet werken dan zal er in het scherm een zin staan met: “wachtwoord en of emailadres kloppen niet. 

•	6. Zowel de admins als gebruikers kunnen uitloggen. 
Om uit te loggen kunnen zowel de gebruiker als de admin bovenin het hoofdscherm een knop vinden met uitloggen en daarop klikken. Daarna worden ze uitgelogd. 

•	7. De gebruiker kan zowel ingelogd als niet ingelogd  een bericht sturen naar een admin. 
De gebruikers drukken op het tabje bericht en dan worden ze gevraagd om hun email adres (optioneel), naam, vraag/opmerking, onderwerp. 

•	8. De gebruiker kan auto’s in zijn/haar favorieten-lijst zetten. 
De gebruiker drukt op de button voeg toe als favoriet, dan wordt er een lijst gemaakt met favoriete auto’s die de gebruiker altijd kan bekijken.

•	9. De gebruiker kan notificaties ontvangen van nieuwe auto’s in zijn email inbox. 
De gebruiker kan er voor kiezen om mail te ontvangen in zijn of haar inbox, met daarin auto’s die net binnen zijn gekomen. 

•	10. Zowel voor de admins als de gebruikers moet er ook gefiltert kunnen worden op de verschillende aspecten die benoemt worden in use case 1. 

•	11 Registratie gebruikers. 
De gebruikers kunnen een account aanmaken met hun emailadres en zelfgekozen wachtwoord. 

•	12. Registratie admins(optioneel)  
Met een button registreren voor admins, kan alleen een admin een andere admin maken. 

•	13. Admins berichten naar gebruikers
De admins kunnen ook berichten sturen naar gebruikers die een account hebben aangemaakt op de website. 



## §1 Actoren
Actor templates, per actor met de template 

## §2 Use Case Templates


## §3 Wireframes
Een wireframe voor elke use case.

---

# 4 Domeinmodel
Hieronder wordt er een beschrijving gegeven van het klassediagram dat te vinden is in de image directory onder de naam "Ocassions-diagram.jpg"


| Entiteit | Beschrijving |
|----------|--------------|
|  Car    |    De entiteit Car heeft de attributen: name, image, kilometre,yearOfManufacture, price en fuelType. |
| Account  |     De entiteit Account heeft de attributen: email, password, accountId,birthday, accounttype en een refferentie naar Car door de arraylist favorite cars. Ook heeft Account een referentie met Message door de arraylist myMessages.     |
|  Message  |    De eniteit Message heeft de attributen: topic, question, name, email, dateOfSend (daarin wordt de lokale tijd in opgeslagen).      |
|           |         |


---

# 5 Technologieën
Voor het realiseren van de applicatie wordt gebruik van de volgende methodieken en technieken: UML, Java, SQL, HTML, CSS, J2EE (Servlets), Rest (Jax-RS), Applicatieserver 
& HTTP-protocol en een datastore. Beschrijf ook welke frameworks je gebruikt, hiervan neem je ook de versie en het licentiemodel op.

---

# 6 Overdracht
Hier wordt een installatiehandleiding en een sumiere gebruikershandleiding beschreven. Ook eventuele gebruikersnamen en wachtwoorden moet bekend worden om de werking van het programma aan te tonen.

---

# 7 Verwijzingen
Geef hier de bronnenlijst. Gebruik de APA stijl om de bronnen te vermelden.
