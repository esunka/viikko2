package ohtu.verkkokauppa;

public interface IPankki {
	
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
}