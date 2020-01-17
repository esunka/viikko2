package ohtu.verkkokauppa;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Kauppa {
    @Autowired
    private IVarasto varasto;
    @Autowired
    private IPankki pankki;

    private Ostoskori ostoskori;
    @Autowired
    private IViite viitegeneraattori;

    private String kaupanTili = "33333-44455";
/*
    public Kauppa(IVarasto varasto2, IPankki pankki2, IViite generaattori2) {
        varasto = varasto2;
        pankki = pankki2;
        viitegeneraattori = generaattori2;
        kaupanTili = "33333-44455";
    }*/

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
