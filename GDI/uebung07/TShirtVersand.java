package uebung07;
 
interface TShirtVersand{
	String rechnungen(Personendaten kunde, int bestellnummer);	 
	
	String bestellung(Personendaten kunde, int bestellnummer, int artikelnummer )
}
