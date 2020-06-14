IPASS – Ontwerpdocument
=======================

***Ipass occasions project***

| Datum      | 05-05-2020 |
|------------|------------|
| __Versie__ | _0_.2     |
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
![use case diagram](https://raw.githubusercontent.com/jayh475/IPASS_Project_Occasions/master/IPASS_Project_Occasions/Images/UseCase-diagram.jpg?token=ANT36TW4YGMUYOSAIY5SILS62VBHQ)

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

•	9. Zowel voor de admins als de gebruikers moet er ook gefiltert kunnen worden op de verschillende aspecten die benoemt worden in use case 1. 

•	10 Registratie gebruikers. 
De gebruikers kunnen een account aanmaken met hun emailadres en zelfgekozen wachtwoord. 

•	11. Registratie admins(optioneel)  
Met een button registreren voor admins, kan alleen een admin een andere admin maken. 

•	12. Admins berichten naar gebruikers
De admins kunnen ook berichten sturen naar gebruikers die een account hebben aangemaakt op de website. 



## §1 Actoren
|Use Case : Auto toevoegen |   uitwerking  |
|----------|--------------|
| Rolnaam:        | eigenaar(admin)     |
|  Functienaam:        | De functienamen van de eigenaar zijn auto's toevoegen   |
| Omschrijving van de rol: | De rol van de eigenaar(admin) is om auto's toe te voegen aan het scherm.De auto's kunnen dan gezien worden door zowel gebruikers met account en gebruikers zonder account.       |
|  Uitoefenaren:  |  In de organisatie mogen alleen eigenaren auto's toevoegen aan de lijst met auto's.        |


|  Use Case : Auto bewerken |   uitwerking  |
|----------|--------------|
| Rolnaam:        | eigenaar(admin)     |
|  Functienaam:        | De functienamen van de eigenaar zijn auto's wijzigen   |
| Omschrijving van de rol: | De rol van de eigenaar(admin) is om een auto te wijzigen doormiddel van het kenteken. Het kenteken is de id voor een auto, daarop wordt gezocht en daarmee kunnen alle andere waardes van de auto veranderd worden.        |
|  Uitoefenaren:  |  In de organisatie mogen alleen eigenaren auto attributen wijzigen.       |







## §2 Use Case Templates

|  Use Case : Auto toevoegen |   uitwerking  |
|----------|--------------|
| id:        | OW01 v0.1   |
|naam:        |Auto toevoegen    |
|actoren:        | eigenaar   |


#####beschrijving
De eigenaar kan een auto toevoegen bestaande uit merk(i), model(i), kenteken(i), kentekenplaat(i), bouwjaar(i),prijs(i), kilometerstand(i)
,brandstof type(i) en een afbeelding Url van de auto(i). Het systeem controleert of de auto al in het systeem staat door het controleren van alle gegegens en daarna van het kentekenplaat. Als de auto nog niet in het systeem staat, worden de gegevens opgeslagen en staat er een nieuwe auto in de lijst. 

#####Scenario
|  nummer |   uitwerking  |
|----------|--------------|
|  1      |  Systeem vraagt om de volgende gegevens: merk(i), model(i), kenteken(i), kentekenplaat(i), bouwjaar(i),prijs(i), kilometerstand(i),brandstof type(i) en een afbeelding Url van de auto(i).|
|   2     | Eigenaar verstrekt deze gegevens.  |
|    3    | Systeem valideert de ingevoerde gegevens  |
|    4    | Als auto  bestaat in de list)  | 
|   5     | Systeem geeft foutmelding     |
|  6   |Systeem gaat verder met stap 1     |
|  7   |  Doe zolang er een auto toegevoegd wordt dat nog niet bestaat   |
|  8   |  als de auto nog niet bestaat wordt die toegevoegd aan de lijst met autos op aanbod occasions  |
|     |    |
|     |    |


|  Use Case : Auto bewerken |   uitwerking  |
|----------|--------------|
| id:        | OW01 v0.2   |
|naam:        |Auto bewerken   |
|actoren:        | eigenaar   |

#####beschrijving
De eigenaar kan een auto bewerken doormiddel van het (i)kenteken. De attributen die te wijzigen zijn bestaan uit merk(i), model(i), kenteken(i), kentekenplaat(i), bouwjaar(i),prijs(i), kilometerstand(i)
,brandstof type(i) en een afbeelding Url van de auto(i). Het systeem controleert of de auto al in het systeem staat door het controleren van de kentekenplaat. Als de auto nog niet in het systeem staat worden de gegevens opgeslagen en staat de auto gewijzigd in de lijst. 

#####Scenario
|  nummer |   uitwerking  |
|----------|--------------|
|  1      |  Systeem vraagt om de volgende gegevens: bestaande kenteken(i), merk(i), model(i), kentekenNieuw(i), kentekenplaat(i), bouwjaar(i),prijs(i), kilometerstand(i),brandstof type(i) en een afbeelding Url van de auto(i).|
|   2     | Eigenaar verstrekt deze gegevens.  |
|    3    | Systeem valideert de ingevoerde gegevens  |
|    4    | Als auto  bestaat in de list)  | 
|   5     | Systeem geeft foutmelding     |
|  6   |Systeem gaat verder met stap 1     |
|  7   |  Doe zolang er een auto toegevoegd wordt dat nog niet bestaat   |
|  8   |  als de auto nog niet bestaat wordt die toegevoegd aan de lijst met autos op aanbod occasions  |
|     |    |
|     |    |









## §3 Wireframes
use case: Auto toevoegen:
![aanmaken auto](https://raw.githubusercontent.com/jayh475/IPASS_Project_Occasions/master/IPASS_Project_Occasions/Images/moqupAanmakenCar.png?token=ANT36TRVGVPWUWL6G3ECNCK62VBBU)

![toegevoegde auto](https://raw.githubusercontent.com/jayh475/IPASS_Project_Occasions/master/IPASS_Project_Occasions/Images/aanbodOcassionsmoqup.png?token=ANT36TUDCSTEC4CH5B63NA262VA6K)



---

# 4 Domeinmodel
Hieronder wordt er een afbeelding en een beschrijving gegeven van het klassediagram.
![klasse diagram](https://raw.githubusercontent.com/jayh475/IPASS_Project_Occasions/master/IPASS_Project_Occasions/Images/Class%20Diagram%20Ocassions.jpg?token=ANT36TVFLCXBM5ANCSIV4HC62VBMC)


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

getting json and putting it in html. 
https://www.youtube.com/watch?v=DG4obitDvUA

how to center an object 
https://css-tricks.com/quick-css-trick-how-to-center-an-object-exactly-in-the-center/


https://stackoverflow.com/questions/14976495/get-selected-option-text-with-javascript

static logbinder voor tomcat errors
https://stackoverflow.com/questions/7421612/slf4j-failed-to-load-class-org-slf4j-impl-staticloggerbinder

login page
https://medium.com/swlh/how-to-create-your-first-login-page-with-html-css-and-javascript-602dd71144f1

replace object 
https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_redirect_webpage

register form 
https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_register_form

session storage 
https://www.youtube.com/watch?v=RxUc6ZWwgfw&t=192s

filteren met selectbox
https://codereview.stackexchange.com/questions/140420/filter-options-of-select-box-using-input-box-value

popup login 
https://www.w3schools.com/howto/tryit.asp?filename=tryhow_js_popup_form


