package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchPlayer() {
        assertTrue(stats.search("Semenko").getName().equals("Semenko"));
    }
    @Test
    public void findTeam() {
        assertTrue(stats.search("Semenko").getTeam().equals("EDM"));
    }
    @Test
    public void teamSize() {
        assertEquals(1,stats.team("PIT").size());
    }
    @Test
    public void findTopScorers() {
        assertTrue(stats.topScorers(1).get(0).getName().equals("Gretzky"));
    }
/*
    @Test
    public void findTopScorers2() {
        assertTrue(stats.topScorers(-1).get(0).getName().equals("Gretzky"));
    }*/
    @Test
    public void usefulTest() {

        assertNotEquals(stats.search("notme"),"qualityTest");
    }
}
