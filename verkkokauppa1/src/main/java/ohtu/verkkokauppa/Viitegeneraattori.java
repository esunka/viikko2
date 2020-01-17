package ohtu.verkkokauppa;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Viitegeneraattori implements IViite{

    private int seuraava = 1;
    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
