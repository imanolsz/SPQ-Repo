package es.deusto.spq.main;

import es.deusto.spq.client.ExampleClient;
import es.deusto.spq.client.gui.GestorVentanas;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class MainTest {

     private GestorVentanas gestorVentanas;
     private ExampleClient exampleClient;

     @Before
     public void setUp() {
         gestorVentanas = mock(GestorVentanas.class);
         exampleClient = mock(ExampleClient.class);
     }

     @Test
     public void testMain() {
         String[] args = {"localhost", "8080"};
         Main.main(args);
        
         assertNotNull(Main.getExampleClient());
         assertNotNull(Main.getGestorVentanas());
     }
}

