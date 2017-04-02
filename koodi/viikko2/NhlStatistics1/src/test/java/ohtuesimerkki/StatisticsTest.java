/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

/**
 *
 * @author jaro
 */
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
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
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    } 
    
    @Test
    public void searchTest() {
        String name = "Semenko";
        Player test = stats.search(name);
        assertEquals(name, test.getName());
    }
    
    @Test
    public void teamTest() {
        String teamName = "EDM";
        List<Player> testTeam = stats.team(teamName);
        assertEquals(testTeam.size(), 3);
    }
    
    @Test
    public void topScorersTest() {
        int howMany = 2;
        List<Player> topList = stats.topScorers(howMany);
        assertEquals(3, topList.size());
    }
}
