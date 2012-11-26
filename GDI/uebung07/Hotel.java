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
 * @param reservierungsnummer Hieraus werden die Daten wie der Zeitraum der Reservierung,... benötigt.
 * @param kunde Um zu wissen, wer die Zimmerreservierung storniert.
 * @return Der Kunde erhält eine Stornierungsbestätigung.
 */
	String stornieren(int reservierungsnummer, Personendaten kunde);

/**
 * 	Wenn der Kunde per Kreditkarte zahlen möchte, werden diese Daten benötigt.
 * @param kreditkarte Hierin sind die Kreditkartendaten des SKunden gespeichert.
 * @param reservierungsnummer Um den Preis berechnen zu können, werden die Daten des Aufenthaltes benötigt
 * @return Zahlungsquittung
 */
	String bezahlen(KKDaten kreditkarte, int reservierungsnummer);

/**
 * 	Wenn der Kunde per EC-Karte zahlen möchte, werden diese Daten benötigt.
 * @param ecKarte Hierin sind die EC-Karte des SKunden gespeichert.
 * @param reservierungsnummer Um den Preis berechnen zu können, werden die Daten des Aufenthaltes benötigt
 * @return Zahlungsquittung
 */
	String bezahlen(ECKarte ecKarte, int reservierungsnummer);
/**
 * 	
 * @param bar
 * @param reservierungsnummer
 * @return
 */
	String bezahlen(boolean bar, int reservierungsnummer);
/**
 * 	
 * @param reservierungsnummer
 * @return
 */
	String einchecken(int reservierungsnummer);
/**
 * 	
 * @param reservierungsnummer
 * @return
 */
	String auschecken(int reservierungsnummer);
/**
 * 	
 * @param uhrzeit
 */
	void weckerStellen(String uhrzeit);
/**
 * 	
 * @param beschreibung
 * @param reservierungsnummer
 */
	void beschwerdeEinreichen(String beschreibung, int reservierungsnummer);
/**
 * 	
 * @param artikelnummer
 * @param reservierungsnummer
 */
	void bestellungAufsZimmer(int artikelnummer, int reservierungsnummer);
	
}
kunde{
}

kreditkarte{
	String name;
	String vorname;
	String kontonummer;
	int sicherheitscode;
}
eckarte{
	String name;
	String vorname;
	String kontonummer;
	int bankleitzahl;
	String bic;
	String iban;
}