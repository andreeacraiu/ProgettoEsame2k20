# Progetto esame
### Indice



- [Presentazione ed avvio del progetto](https://github.com/andreeacraiu/ProgettoEsame2k20#presentazione-progetto)
- [Spring boot app](https://github.com/andreeacraiu/ProgettoEsame2k20#spring-boot-app)
- [Eseguire richieste](https://github.com/andreeacraiu/ProgettoEsame2k20#Eseguire-richieste)
- [Statistiche](https://github.com/andreeacraiu/ProgettoEsame2k20#statistiche)
- [GUI](https://github.com/andreeacraiu/ProgettoEsame2k20#gui)
- [Diagrammi UML](https://github.com/andreeacraiu/ProgettoEsame2k20#diagrammi-UML)
- [Software utilizzati](https://github.com/andreeacraiu/ProgettoEsame2k20#software-utilizzati)

### Presentazione ed avvio del progetto
L'applicazione elaborata per l'esame di Luglio 2020 è un Web Service, un sistema software che risponde alle chiamate di un Client per ottenere informazioni su un data-set di tweet. Tale data-set è stato estrapolato da un [URL](https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=destinazionemarche&count=100) che a partire dai post contenenti l'hashtag #destinazionemarche è possibile analizzare gli utenti creatori dei tweet al fine di dedurre quelli provenienti dall'estero. Inoltre, possono essere effettuate statistiche sui campi d'interesse e monitorare l'andamento settimanale della frequenza dei tweet esteri .

Il progetto è stato sviluppato utilizzando l'IDE [Eclipse](https://www.eclipse.org/downloads/) con l'utilizzo del quale è possibile aprire il progetto seguendo queste indicazioni:


- Tasto destro nel `Package Explorer -> Import -> Project from GIT (with Smart Import)`;

- Copiare nella finestra che si è appena aperta l'[URL del progetto](https://github.com/andreeacraiu/ProgettoEsame2k20);

- Una volta importato, basterà selezionare il progetto nel `Package Explorer`, tasto destro, opzione `Run As -> Spring Boot App`;

### Spring Boot App
Spring Boot è una soluzione "convention over configuration" (configurazione minima o addirittura assente) per il framework Spring di Java, che è stato rilasciato nel 2012 e riduce la complessità di configurazione di nuovi progetti Spring. A questo scopo, Spring Boot definisce una configurazione di base che include le linee guida per l'uso del framework e tutte le librerie di terze parti rilevanti, rendendo quindi l'avvio di nuovi progetti il più semplice possibile. 
Spring Boot offre i seguenti vantaggi:

- Possibilità di incorporare direttamente applicazioni web server;

- Configurazione Maven semplificata;

- Configurazione automatica di Spring, ove possibile;

I file di archivio per Spring Boot possono essere creati accedendo al servizio web [Spring Initializr](https://start.spring.io), creare la configurazione di Spring Boot e scaricarla poi come modello di progetto finito.

### Eseguire richieste
Nel momento in cui viene avviata l'applicazione, i dati forniti sono in formato JSON: 

```json
[
{
        "created_at": "Mon Jul 13 10:24:33 +0000 2020",
        "id": 1282621931498414081,
        "text": "MarcheTourism: Che meraviglia il racconto di lonelyplanet_it nelle #Marche!\n\nDate un'occhiata ai luoghi, alle stori… https://t.co/xvsmrs7p8U",
        "language_post": "it",
        "name": "Il PassettoAncona",
        "screen_name": "passettoancona",
        "location_user": "Ancona, Marche",
        "id_user": "498961351",
        "numpost_user": 350
    }
      
]
```
Ogni tweet è caratterizzato dai principali campi presi in considerazione ai fini del progetto:

```json
[
    {
        "name": "screen_name",
        "sourceField": "Nome a schermo dell'utente",
        "type": "String"
    },
    {
        "name": "numpost_user",
        "sourceField": "Numero totale di post dell'utente",
        "type": "long"
    },
    {
        "name": "name",
        "sourceField": "Nome dell'utente",
        "type": "String"
    },
    {
        "name": "created_at",
        "sourceField": "Data di creazione del tweet",
        "type": "String"
    },
    {
        "name": "id",
        "sourceField": "Descrive in modo univoco il post",
        "type": "long"
    },
    {
        "name": "text",
        "sourceField": "Campo testuale del post",
        "type": "String"
    },
    {
        "name": "id_user",
        "sourceField": "Descrive in modo univoco l'utente",
        "type": "String"
    },
    {
        "name": "language_post",
        "sourceField": "Lingua del post",
        "type": "String"
    },
    {
        "name": "location_user",
        "sourceField": "Luogo degli utenti",
        "type": "String"
    }
    ]
```

Il seguente Diagramma dei casi d'uso mostra le richieste che il client può effettuare tramite API REST GET:
<img src="https://github.com/andreeacraiu/ProgettoEsame2k20/blob/master/umlDIAGRAM/USE_CASE_DIAGRAM.png">

Per eseguire le richieste GET si può installare un API testing (per esempio Postman), oppure tramite richiesta all'URL http://localhost:8080/.

|    TIPO        |rotta                          |descrizione                                              |
|----------------|-------------------------------|---------------------------------------------------------|
|GET             |/data                          |restituisce i tweet con i relativi dati                  |
|GET             |/metadata                      |restituisce gli alias utilizzati per la descrizione del tweet         |
|GET             |/stat                          |restituisce numero totale di utenti esteri (per lingua)                        |
|GET             |/stats?field="campo scelto"    |restituisce i luoghi oppure le lingue dei post con conteggio                |
|GET             |/freq?field="lingua scelta"    |restituisce la frequenza settimanale dei tweet esteri|

### Statistiche

L'applicazione permette di:
- Effettuare delle statistiche su due dei campi più importanti di tipo String:

Esempio richiesta `http://localhost:8080/stats?field="language_post"`:
![Recordit GIF](http://g.recordit.co/pb6cuhnZmP.gif)

- Calcolare la frequenza settimanale dei tweet esteri:

Esempio richiesta `http://localhost:8080/freq?field="en"`:
![Recordit GIF](http://g.recordit.co/145qqOxvHR.gif)

- Calcolare il numero totale di utenti esteri (per lingua):

Esempio richiesta `http://localhost:8080/stat`:
![Recordit GIF](http://g.recordit.co/axZCKFv8JB.gif)

### GUI

L'acronimo GUI sta per Graphical User Interface ed è l'insieme di tutti i componenti grafici (es. icone, pulsanti, finestre pop-up,...) attraverso cui noi possiamo interagire con il computer. Per garantire il funzionamento dell'applicazione anche per utenti poco esperti è stata implementata un'interfaccia grafica molto semplice, ma efficace: 

<img src="https://github.com/andreeacraiu/ProgettoEsame2k20/blob/master/GUI.png">

Sono stati importati questi due package:

- java.awt -> fornisce il modello degli eventi, componenti grafiche e la struttura di base

- java.swing -> libreria di componenti grafici basati su AWT (Abstract Windowing Toolkit)

