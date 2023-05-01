package es.deusto.spq.client.gui;

import org.junit.*;

public class VentanaMenuTest{
	private VentanaMenu vm;
	
	@Before
	public void setUp() throws Exception {
		vm = new VentanaMenu();
	}	
	@Test
	public void mostrarMenu(){
		vm.setVisible(true);
	}
}
