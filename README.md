# Training Komplexaufgabe S02

>**ACHTUNG:** Wie mit ihnen besprochen habe ich an der Aufgabenstellung Modifizierung durchgeführt, 
>da ansonsten mein HEAP nicht ausreichend gewesen wäre. Die entsprechenden Änderungen habe ich hier gekennzeichnet.

Zu Simulationszwecken wird ein zu sprengendes Gesteinsmassiv als Matrix <del>(L: 1000, B: 1000, H: 1000)</del>
_(L: 100, B: 100, H: 100)_ mit <del>1 Mrd.</del> _1 Mio._ Elementen und Zeichen aus dem Pool [A, B , C , G , X] dargestellt. 
Die Matrix wird zufällig mit den Zeichen befüllt. Die Wahrscheinlichkeit für das Zeichen G ist 1% (0.01). 
Durch die Sprengung
werden Blöcke <del>(i) 100x100x100</del> 20x20x20, (ii) <del>50x50x50</del> _10x10x10_ und (iii) <del>10x10x10</del> _5x5x5_ erzeugt. Für die Sprengung existieren
die Varianten E01 und E02. E01 erzeugt zwischen 30% bis 45% (zufällig bestimmt) Blöcke (ill). E02
erzeugt zwischen 40% bis 70% (zufällig bestimmt) Blöcke (iii). Für die Verladung der Blöcke auf einen
LKW steht eine Anlage mit 6 Fächern zur Verfügung. Jedes Fach hat eine Kapazität von maximal <del> 2
Mio. </del> _20.000_ Zeichen. Nach der Sprengung werden die Blöcke zufällig ausgewählt und auf die Fächer verteilt.
Der Prozess der Zuordnung stoppt, wenn zum 10. Mal ein ausgewählter Block nicht einem Fach
zugeordnet werden konnte. Ein LKW kann maximal <del>10 Mio.</del> _100.000_ Zeichen transportieren. Die Fächer der
Anlage sind so zu öffnen, dass die vorhandene Kapazität eines LKW maximal genutzt wird. Die Fächer
werden geöffnet, der LKW mit den Blöcken beladen, die Fächer werden geschlossen und neu befüllt.
Ein nicht befüllter LKW wird der Anlage zugeführt und der Prozess beginnt erneut. Der Prozess der
Verladung endet, wenn alle Blöcke durch LKW abtransportiert wurden. Ein LKW bringt die Blöcke zu
einer Verarbeitungseinheit. Die Verarbeitungseinheit hat für jede Größe eines Blocks eine definierte
Produktionslinie (PLO1, PLO2 und PL03). PL01 ist verantwortlich für die Blöcke mit der Größe
<del>100x100x100 </del> _20x20x20_. Für die Zerkleinerung stehen PLO1 die Verfahren X01 und X02 zur Verfügung. X01
zerkleinert einen Block <del>100x100x100</del> 20x20x20 in 8 Blöcke <del>50x50x50</del> _10x10x10_, die Weiterverarbeitung erfolgt durch PL02.
X02 verkleinert einen Block <del>100x100x100</del> _20x20x20_ in <del>1000</del> _64_ Blöcke der Größe <del>10x10x10</del> _5x5x5_, die Weiterverarbeitung
erfolgt durch PLO3. PL02 ist verantwortlich für die Blöcke mit der Größe <del>50x50x50</del> _25x25x25_. PLO2 zerkleinert
einen Block der Größe <del>50x50x50</del> _25x25x25_ in <del>125</del> _8_ Blöcke der Größe <del>10x10x10</del> _5x5x5_, die Weiterverarbeitung erfolgt
durch PL03. PLO3 speichert die <del>1 Mio.</del> _8000_ Blöcke in einem zentralen Speicher für die Weiterverarbeitung.