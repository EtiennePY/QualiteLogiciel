README du projet de Qualite logicielle


Auteurs : 
Antoine Hervieu et Etienne Grall sous la supervision du professeur Royer.
Explication du code et contexte
Ce projet decrit la sortie du parking precedemment modelise lors du projet precedent.


Environnement de travail : 
Windows 8.1 et Windows 10 avec Java 8.


Avancee : 

Le travail a ete realise selon les directives de l'enonce. Bien que quelques marqueurs PMD subsistent comme detaille plus loin.

La banque a ete modelisee par une classe MockBanque bouchon conformement aux directives.

 
Pour les tests pour eviter d'eventuels effets de bords indesirables, un package mocks contient toutes les classes susceptibles d'avoir des effets de bords dans la pratique c'est-a-dire toute les classes sauf DateTicket (on ne voudrait pas reellement que la barriere se leve a chaque fois que l'on teste nos classes...)


Le diagramme UML a un peu evolue par rapport a ce qu'il etait dans le projet UML. En effet de la theorie a la pratique il y a de nombreuses nouvelles considerations qui surgissent. 
La structure des cartes et tickets a notamment evoluees avec une classe abstraite pour distinguer les vrais tickets et cartes de l'absence de tickets ou de cartes (en singleton) et parmi les vrais tickets et cartes une autre classe abstraite pour ne pas dupliquer le code qui gerent la gestion de l'identifiant.

Des classes singletons ont ete realisees pour les tickets et les cartes (CarteWithout et TicketWithout) afin de ne pas avoir a manipuler null lorsque le client n'a pas de carte ou ticket.



Detail du code :

Le projet contient trois dossiers:

- src qui contient les classes du parking reparties par packages logiques (les cartes dans le packages cartes et ainsi de suite). On retrouve dans chaque package un package pour l'implementation et un package pour l'interface. La structure est plus agreable et de plus elle peut se reveler etre fondamental lors de l'utilisation de certains paradigme de programmation comme la programmation par composant avec OSGi par exemple.


- tests qui contient deux packages pour les tests JUnit et les classes bouchons (mocks).

- main qui contient les cinq scenarii des mains decris precedemment.

- ressources qui contient les documents specifies par l'enonce.


Scenarii des mains :

Il y a 5 scenarii.
- Un client abonne sort normalement MainAbonneOk.
- Un client abonne n'a pas de carte d'abonnement MainAbonnePbCarte.
- Un client abonne n'a pas la bonne voiture (c'est un parking strict !) MainAbonnePbImmatriculation.
- Un client non-abonne sort normalement MainNonAbonneOk.
- Un client non abonne a un ticket qui n'est plus dans le systeme informatique.


Checkstyle : 

La regle utilisee est Google Checks - (global).

Le dossier src est completement propre.
Les tests JUnit repondent de façon etrange a Checkstyle, les niveaux d'indentation ne sont pas logiques. Ce package est donc exempt de l'utilisation de Checkstyle.



PMD :

Exemples de problemes detectes avec PMD :

- Declarer des attributs comme final car ils ne sont pas modifier apres avoir ete declares.

- modifier des noms de variables car ils etaient trop longs, trop courts ou inadaptes.

- Corriger des anomalies DU et DD.


Quasiment tout a ete verifie, toutefois quelques marqueurs subsistent :

- Dans le cas d'une classe ayant un constructeur vide, PMD n'est pas satisfait que l'on l'ecrive (UnecessaryConstructor) ou qu'on ne l'ecrive pas (AtLeatOneConstructor). Nous avons fait le choix de les mettre car ces constructeurs peuvent etre importants pour certains frameworks comme Spring par exemple.

- LawOfDemeter : les appels imbriques generent systematiquement des erreurs meme lorsqu’ils sont triviaux ou inevitables.

- GuardLogStatement et GuardLogStatementJavaUtil ne fonctionnent pas bien sous PMD et l'utilisation des niveaux info et warning dans des branches generera toujours des marqueurs PMD. Source : https://stackoverflow.com/questions/24114677/there-is-log-block-not-surrounded-by-if-pmd-violation

- Dans les mains : AvoidFinalVariable et LocalVariablehouldBeFinal s'oppose mutuellement lors de l'initialisation des composants. Pour eviter de mettre des final partout rendant le code moins visible nous gardons LocalVariablehouldBeFinal.

- Une anomalie DU (DataFlowAnalysis) peu evidente a resoudre avec des boucles if renvoyant des erreurs en cas de problemes dans LecteurBancaire.



FindBugs :

Exemple de problemes detectes avec FindBugs :

- Une variable ne servait pas a la suite de l'execution.

Il n'y a plus aucuns bugs au niveau par defaut.


Tests JUnit :
Sur le dossier src, les tests JUnit ont une couverture de 100% par instructions et par branches.
Pour tester, il est possible de lancer la suite de tests AllTests.java.

Exemples de problemes detectes avec JUnit :

- Des methodes n'etaient pas appelees ou ne servaient pas.

- Certains objets n'etaient pas correctement initialises, ces erreurs n'etaient pas syntaxique et donc difficile a detecter sans un test rigoureux.


