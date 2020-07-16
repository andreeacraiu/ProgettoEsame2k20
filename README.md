# Progetto esame
### Indice



- [Presentazione ed avvio del progetto](https://github.com/andreeacraiu/ProgettoEsame2k20#presentazione-progetto)
- [Spring boot app](https://github.com/andreeacraiu/ProgettoEsame2k20#spring-boot-app)
- [Eseguire richieste](https://github.com/andreeacraiu/ProgettoEsame2k20#Eseguire-richieste)
- [Statistiche](https://github.com/andreeacraiu/ProgettoEsame2k20#statistiche)
- [Protocollo HTTP](https://github.com/andreeacraiu/ProgettoEsame2k20#protocollo-http)
- [GUI](https://github.com/andreeacraiu/ProgettoEsame2k20#gui)
- [Diagrammi UML](https://github.com/andreeacraiu/ProgettoEsame2k20#diagrammi-UML)
- [Software utilizzati](https://github.com/andreeacraiu/ProgettoEsame2k20#software-utilizzati)
- [Autore](https://github.com/andreeacraiu/ProgettoEsame2k20#autore)

### Presentazione ed avvio del progetto
L'applicazione elaborata per l'esame di Luglio 2020 è un Web Service, un sistema software che risponde alle chiamate di un Client per ottenere informazioni su un data-set di tweet. Tale data-set è stato estrapolato da un [URL](https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=destinazionemarche&count=100) il quale, partire dai post contenenti l'hashtag #destinazionemarche permette di analizzare gli utenti creatori dei tweet al fine di dedurre quelli provenienti dall'estero. Inoltre, possono essere effettuate statistiche sui campi d'interesse e monitorare l'andamento settimanale della frequenza dei tweet esteri filtrandoli per lingua.

L'applicazione è stata sviluppata utilizzando l'IDE [Eclipse](https://www.eclipse.org/downloads/) con il quale è possibile aprire il progetto seguendo queste indicazioni:


- Tasto destro nel `Package Explorer -> Import -> Project from GIT (with Smart Import) -> Clone URI`;

- Copiare nella finestra che si è appena aperta l'[URL del progetto](https://github.com/andreeacraiu/ProgettoEsame2k20);

- Una volta importato basterà selezionare il progetto nel `Package Explorer`, tasto destro, opzione `Run As -> Spring Boot App (oppure GUI_Runner)`;

### Spring Boot App
Spring Boot è una soluzione "convention over configuration" (configurazione minima o addirittura assente) per il framework Spring di Java, che è stato rilasciato nel 2012 e riduce la complessità di configurazione di nuovi progetti Spring. A questo scopo, Spring Boot, definisce una configurazione di base che include le linee guida per l'uso del framework e tutte le librerie di terze parti rilevanti rendendo quindi l'avvio di nuovi progetti il più semplice possibile. 
Spring Boot offre i seguenti vantaggi:

- Possibilità di incorporare direttamente applicazioni web server;

- Configurazione Maven semplificata;

- Configurazione automatica di Spring, ove possibile;

I file di archivio per Spring Boot possono essere creati accedendo al servizio web [Spring Initializr](https://start.spring.io), creare la configurazione di Spring Boot e scaricarla poi come modello di progetto finito.

### Eseguire richieste
Nel momento in cui viene avviata l'applicazione i dati forniti sono in formato JSON: 

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

* **Effettuare delle statistiche su due dei campi più importanti di tipo String (language_post e location_user)**:

Esempio richiesta `http://localhost:8080/stats?field="language_post"`:
![Recordit GIF](http://g.recordit.co/pb6cuhnZmP.gif)

* **Calcolare la frequenza settimanale dei tweet esteri**:

Esempio richiesta `http://localhost:8080/freq?field="en"`:
![Recordit GIF](http://g.recordit.co/145qqOxvHR.gif)

* **Calcolare il numero totale di utenti esteri (per lingua)**:

Esempio richiesta `http://localhost:8080/stat`:
![Recordit GIF](http://g.recordit.co/axZCKFv8JB.gif)


### Protocollo HTTP

Il protocollo HTTP funziona mediante un modello richiesta/risposta. Il client invia una richiesta al server, il quale la interpreta e restiuisce una risposta correlata da un codice.
I codici di stato sono composti da tre numeri di cui il primo indica il tenore della risposta:

- Se il numero inizia con 2 la richiesta è corretta ed è stata processata con successo;
- Se inizia con 4 il client ha eseguito una richiesta non corretta;
- Se inizia con 5 si è verificato un errore al server;

|        Codice Riposta         |    Significato                          |
| :---------------------------: | :---------------------------------------|
|          `200 - OK`           | Operazione eseguita con successo. |
|      `400 - BAD REQUEST`      | Richiesta non formulata correttamente. |
|       `404 - NOT FOUND`       | Field immesso incorretto o chiamata inesistente. |
| `500 - INTERNAL SERVER ERROR` | Generico errore interno al server.|

- Esempio: 

<img src="https://github.com/andreeacraiu/ProgettoEsame2k20/blob/master/STATUS.png">



### GUI

L'acronimo GUI sta per Graphical User Interface ed è l'insieme di tutti i componenti grafici (es. icone, pulsanti, finestre pop-up,...) attraverso cui l'utente può  interagire con il computer. Per garantire il funzionamento dell'applicazione anche per utenti poco esperti è stata implementata un'interfaccia grafica molto semplice, ma efficace: 

<img src="https://github.com/andreeacraiu/ProgettoEsame2k20/blob/master/GUI_.png">

E' possibile avviare la GUI scegliendo GUI_Runner nella finestra di avvio dell'applicazione:

<img src="https://github.com/andreeacraiu/ProgettoEsame2k20/blob/master/GUI_RUNNER.png">

**Sono state importate due librerie**:

- java.awt -> fornisce il modello degli eventi, componenti grafiche e la struttura di base

- javax.swing -> libreria di componenti grafici basati su AWT (Abstract Windowing Toolkit)

Quando l'utente interagisce con l'interfaccia grafica cliccando su uno dei cinque bottoni si scaturisce un evento. Il ricevitore, listener, è l’oggetto che deve rispondere all’evento implementando l’interfaccia ActionListener:

```json

	private class nomeclasse implements ActionListener {
        @Override
         public void actionPerfomed(ActionEvent e) {
            //corpo del metodo
         }
        } 
```

Un bottone può essere creato usando la classe JButtton del package Swing:

```json

	JButton button=new JButton("nome bottone");
```

### Diagrammi UML

UML (Unified Modeling Language) è un linguaggio basato su diagrammi utilizzati per progettare un sistema software sia dal punto di vista strutturale che comportamentale. 
Il progetto è organizzato in package rispettando il pattern architetturale MVC (model-view-controller):

<img src="https://github.com/andreeacraiu/ProgettoEsame2k20/blob/master/umlDIAGRAM/PACKAGE_DIAGRAM.png">

Ogni package è costituito a sua volta dalle seguenti classi:

* **Package it.univpm.Progetto2k20**

<img src="https://github.com/andreeacraiu/ProgettoEsame2k20/blob/master/umlDIAGRAM/PACKAGE_APPLICATION.png">

* **Package it.univpm.Progetto2k20.controller**

<img src="https://github.com/andreeacraiu/ProgettoEsame2k20/blob/master/umlDIAGRAM/PACKAGE_CONTROLLER.png">

* **Package it.univpm.Progetto2k20.GUI**

<img src="https://github.com/andreeacraiu/ProgettoEsame2k20/blob/master/umlDIAGRAM/PACKAGE_GUI.png">

* **Package it.univpm.Progetto2k20.model**

<img src="https://github.com/andreeacraiu/ProgettoEsame2k20/blob/master/umlDIAGRAM/PACKAGE_MODEL_.png">

* **Package it.univpm.Progetto2k20.service**

<img src="https://github.com/andreeacraiu/ProgettoEsame2k20/blob/master/umlDIAGRAM/PACKAGE_SERVICE.png">

* **Package it.univpm.Progetto2k20.stats**

<img src="https://github.com/andreeacraiu/ProgettoEsame2k20/blob/master/umlDIAGRAM/PACKAGE_STATS.png">

* **Package it.univpm.Progetto2k20.utils** 

<img src="https://github.com/andreeacraiu/ProgettoEsame2k20/blob/master/umlDIAGRAM/PACKAGE_UTILS.png">

Per visionare i diagrammi di sequenza, si faccia riferimento alla cartella denominata [umlDIAGRAM](https://github.com/andreeacraiu/ProgettoEsame2k20/tree/master/umlDIAGRAM) presente nella repository.


### Software utilizzati

* [Eclipse](https://www.eclipse.org/) - ambiente di sviluppo integrato
* [Spring Boot](https://spring.io/projects/spring-boot) - framework per  sviluppo applicazioni Java
* [Maven](https://maven.apache.org/) - strumento di gestione di progetti

### Autore

- [Craiu Andreea](https://github.com/andreeacraiu)
