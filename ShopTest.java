import static org.junit.Assert.*;
import org.junit.Test;

public class ShopTest {

    @Test
    public void testPrice() {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 32, "High Sierra", 2019, 1000);
        shop.inventory.add(computer);
        assertTrue(computer.price==32);   
    }

    @Test
    public void testMemory() {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 512, "High Sierra", 2019, 1000);
        shop.inventory.add(computer);
        assertTrue(computer.memory==512);   
    }

    @Test
    public void testSetPrice() {
        Computer computer = new Computer("2019 MacBook Air", "Intel", 256, 16, "High Sierra", 2019, 1000);
        computer.setPrice(1500);
        assertEquals(1500, computer.price);
    }

    @Test
    public void testSetOS() {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 512, "High Sierra", 2019, 1000);
        computer.setOS("Sequoia");
        shop.inventory.add(computer);
        assertTrue(computer.operatingSystem=="Sequoia");   
    }

    @Test
    public void testGetYear() {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 512, "High Sierra", 2019, 1000);
        shop.inventory.add(computer);
        assertEquals(2019, computer.getYear());
    }


    @Test
    public void testToString() {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 512, "High Sierra", 2019, 1000);
        shop.inventory.add(computer);
        String result = computer.toString();
        assertTrue(result.contains("2019 MacBook Air"));
        assertTrue(result.contains("Intel"));
        assertTrue(result.contains("256"));
        assertTrue(result.contains("16"));
        assertTrue(result.contains("High Sierra"));
        assertTrue(result.contains("2019"));
        assertTrue(result.contains("1000")); 
    }

    @Test
    public void testBuyComputer() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 16, "High Sierra", 2019, 1000);
        shop.buy(computer);
        assertTrue(shop.inventory.contains(computer));
    }

    @Test(expected=Exception.class)
    public void testBuySameObject() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        shop.buy(computer);
    }

    @Test
    public void testSellComputer() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 16, "High Sierra", 2019, 1000);
        shop.inventory.add(computer);
        shop.sell(computer);
        assertFalse(shop.inventory.contains(computer));
    }

    @Test(expected=Exception.class)
    public void testSellNonexistentObject() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2030 MacBook Air", "Intel", 256, 16, "High Sierra", 2030, 1000);
        shop.sell(computer);
    }

    @Test
    public void testPrintInventory() {
        ResaleShop shop = new ResaleShop();
        shop.printInventory(); 
    }


    @Test
    public void testRefurbishOS() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2020 MacBook Pro", "Intel", 256, 16, "High Sierra", 2020, 1000);
        shop.inventory.add(computer);
        shop.refurbish(computer,"Sequoia");
        assertEquals("Sequoia",computer.operatingSystem);
    }

    @Test
    public void testRefurbish2000() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("1999 MacBook Pro", "Intel", 256, 8, "High Sierra", 1999, 900);
        shop.inventory.add(computer);
        shop.refurbish(computer, "Sequoia");
        assertEquals(0, computer.price); 
    }

    @Test
    public void testRefurbish2012() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2010 MacBook Pro", "Intel", 256, 8, "High Sierra", 2010, 900);
        shop.inventory.add(computer);
        shop.refurbish(computer, "Sequoia");
        assertEquals(2500, computer.price); 
    }
    
    @Test
    public void testRefurbish2018() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2017 MacBook Pro", "Intel", 256, 8, "High Sierra", 2017, 900);
        shop.inventory.add(computer);
        shop.refurbish(computer, "Sequoia");
        assertEquals(550, computer.price); 
    }

    @Test
    public void testRefurbishOtherYear() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2025 MacBook Pro", "Intel", 256, 8, "High Sierra", 2025, 900);
        shop.inventory.add(computer);
        shop.refurbish(computer, "Sequoia");
        assertEquals(1000, computer.price); 
    }

    @Test
    public void testRefurbishNotUpdateOS() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2020 MacBook Pro", "Intel", 256, 8, "High Sierra", 2020, 900);
        shop.inventory.add(computer);
        shop.refurbish(computer, "None");
        assertEquals("High Sierra", computer.operatingSystem); 
    }

    public static void main(String[] args) throws Exception{
        ShopTest runTests=new ShopTest();
        runTests.testPrice();
        runTests.testMemory();
        runTests.testSetPrice();
        runTests.testSetOS();
        runTests.testGetYear();
        runTests.testToString();
        runTests.testBuyComputer();
        runTests.testBuySameObject();
        runTests.testSellComputer();
        runTests.testSellNonexistentObject();
        runTests.testRefurbishOS();
        runTests.testRefurbish2000();
        runTests.testRefurbish2012();
        runTests.testRefurbish2018();
        runTests.testRefurbishOtherYear();
        runTests.testPrintInventory();
        runTests.testRefurbishNotUpdateOS();
    }
    
}
