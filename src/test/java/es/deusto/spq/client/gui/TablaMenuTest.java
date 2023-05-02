package es.deusto.spq.client.gui;

import static org.junit.Assert.*;

import org.junit.*;

public class TablaMenuTest {
    private TablaMenu menu;

	@Before
	public void setUp() throws Exception{
		menu = new TablaMenu();
	}
    @Test
    public void testGetMenuVegetariano() {
        Object[][] vegetariano = menu.getMenuVegetariano();
        assertEquals(12, vegetariano.length);
        assertArrayEquals(new Object[]{"Bravas", 3.50, "0", "Si"}, vegetariano[0]);
        assertArrayEquals(new Object[]{"Menestra de verduras", 7.10, "0", "Si"}, vegetariano[1]);
    }
}

