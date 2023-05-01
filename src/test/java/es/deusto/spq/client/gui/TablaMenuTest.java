package es.deusto.spq.client.gui;

import static org.junit.Assert.*;

import javax.print.event.PrintJobListener;
import javax.swing.table.DefaultTableModel;

import org.junit.*;
import org.mockito.*;

public class TablaMenuTest {
    private TablaMenu menu;

	@Before
	public void setUp() throws Exception{
		menu = new TablaMenu();
	}
    @Test
    public void testGetMenuVegetariano() {
        // Crear un modelo de tabla con datos de prueba
        DefaultTableModel model = new DefaultTableModel(new Object[][]{
            {"Plato 1", "Descripción 1", 10.0, "No"},
            {"Plato 2", "Descripción 2", 15.0, ""},
            {"Plato 3", "Descripción 3", 12.0, "Si"},
            {"Plato 4", "Descripción 4", 8.0, "No"}
        }, new String[]{"Plato", "Descripción", "Precio", "Vegetariano"});

        // Llamar al método getMenuVegetariano() y comprobar que devuelve sólo las filas vegetarianas
        Object[][] vegetariano = menu.getMenuVegetariano();
        assertEquals(12, vegetariano.length);
        assertArrayEquals(new Object[]{"Bravas", 3.50, "0", "Si"}, vegetariano[0]);
        assertArrayEquals(new Object[]{"Menestra de verduras", 7.10, "0", "Si"}, vegetariano[1]);
    }
}

