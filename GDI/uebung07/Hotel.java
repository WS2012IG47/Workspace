package uebung07;


interface Hotel{
/**
 * Ein Zimmer für einen gewissen Zeitraum
 * @param anreise
 * @param abreise
 * @param artikelnummer
 * @param kunde
 * @param kreditkarte
 * @param extrawünsche
 * @return
 */
	int reservierung (String anreise, String abreise, int artikelnummer, Personendaten kunde, KKDaten kreditkarte, String extrawünsche);
/**
 * 	
 * @param reservierungsnummer
 * @param kunde
 * @return
 */
	String stornieren(int reservierungsnummer, Personendaten kunde);
/**
 * 	
 * @param kreditkarte
 * @param reservierungsnummer
 * @return
 */
	String bezahlen(KKDaten kreditkarte, int reservierungsnummer);
/**
 * 	
 * @param ecKarte
 * @param reservierungsnummer
 * @return
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
	void bestellungAufsZimmer(int artikelnummer, int reservierungsnummer)
	
	
}