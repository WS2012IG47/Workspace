package uebung07;

interface Hotel{
/**
 * Ein Zimmer für einen gewissen Zeitraum reservieren
 * @param anreise Das Datum der Anreise um zu wissen, ab wann das Zimmer reserviert werden soll.
 * @param abreise Das Datum der Abreise um zu wissen, bis wann das Zimmer reserviert werden soll.
 * @param artikelnummer Um den Umfang der Reserrvierung zu wissen. Wie z.B. Vollpension, Halbpension,...
 * @param kunde Die Daten des Kunden um zu wissen, für wen das Zimmer reserviert ist.
 * @param kreditkarte Die Kreditkartendaten werden zur Authentifizierung des Kunden bei der Bestätigung benötigt.
 * @param extrawünsche Hier drin werden eventuelle Extrawünsche des Kunden gespeichert.
 * @return Als Bestätigung erhält der Kunde eine Reservierungsnummer.
 */
	int reservierung (String anreise, String abreise, int artikelnummer, Personendaten kunde, KKDaten kreditkarte, String extrawünsche);

/**
 * Falls der Kunde seine Reservierung stornieren möchte. 	
 * @param reservierungsnummer Diese Nummer wird benötigt, um die vorhandenen Reservierungsdaten abzufragen.
 * @param kunde Um zu wissen, wer die Zimmerreservierung storniert.
 * @return Der Kunde erhält eine Stornierungsbestätigung.
 */
	String stornieren(int reservierungsnummer, Personendaten kunde);

/**
 * 	Wenn der Kunde per Kreditkarte zahlen möchte, werden diese Daten benötigt.
 * @param kreditkarte Hierin sind die Kreditkartendaten des Kunden gespeichert.
 * @param reservierungsnummer Um den Preis berechnen zu können, werden die Daten des Aufenthaltes benötigt
 * @return Zahlungsquittung 
 */
	String bezahlen(KKDaten kreditkarte, int reservierungsnummer);

/**
 * 	Wenn der Kunde per EC-Karte zahlen möchte, werden diese Daten benötigt.
 * @param ecKarte Hier drin sind die EC-Karten Daten des Kunden gespeichert.
 * @param reservierungsnummer Um den Preis berechnen zu können, werden die Daten des Aufenthaltes benötigt.
 * @return Zahlungsquittung 
 */
	String bezahlen(ECKarte ecKarte, int reservierungsnummer);
	
/**
 * Beim Check-in des Kunden wird nur die Reservierungsnummer gebraucht.	
 * @param reservierungsnummer Damit das Hotel weiß, welches Zimmer, auf welchen Namen mit welchen Sonderleistungen der Kunde gebucht hat.
 * @return Ein String mit allen Daten und Sonderwünchen des Kunden wird ausgegeben.
 */
	String einchecken(int reservierungsnummer);

/**
 * Beim auschecken benötigt der Kunde seine Reservierungsnummer, damit das Hotel weiß, welches Zimmer abgerechnet werden muss.	
 * @param reservierungsnummer Um den Preis berechnen zu können, werden die Daten des Aufenthaltes benötigt
 * @return Es wird eine Rechnung ausgegeben auf der alle eventuellen Sonderwünsche des Kunden mit einbezogen werden.
 */
	String auschecken(int reservierungsnummer);
}
