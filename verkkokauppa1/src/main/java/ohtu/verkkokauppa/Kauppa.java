package ohtu.verkkokauppa;

public class Kauppa {

    private IVarasto varasto;
    private IPankki pankki;
    private Ostoskori ostoskori;
    private IViite viitegeneraattori;
    private String kaupanTili;

    public Kauppa(IVarasto varasto2, IPankki pankki2, IViite generaattori2) {
        varasto = varasto2;
        pankki = pankki2;
        viitegeneraattori = generaattori2;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
