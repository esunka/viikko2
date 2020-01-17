
package ohtu.verkkokauppa;

import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Kirjanpito implements IKirjanpito {
    //private static Kirjanpito instance;
    
    private ArrayList<String> tapahtumat = new ArrayList<String>();

    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }
    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
