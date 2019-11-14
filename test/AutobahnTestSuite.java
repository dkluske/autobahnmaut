/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author 17wi1115
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({autobahnmaut.datenbank.DatenbankTest.class, autobahnmaut.datenbank.UserManagerTest.class, autobahnmaut.datenbank.FahrtenManagerTest.class , autobahnmaut.datenbank.FahrzeugManagerTest.class, autobahnmaut.datenbank.StatistikManagerTest.class})
public class AutobahnTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
