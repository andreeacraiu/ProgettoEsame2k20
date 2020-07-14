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
