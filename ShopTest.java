import static org.junit.Assert.*;
import org.junit.Test;
/**
 * ShopTest class can help us test the bugs inComputer and the ResaleShop.
 */
public class ShopTest {

    /**
     * It test the price that the constructor of the Computer file for the Computer.
     * It fails if the price of the Computer is not the correct price.
     */
    @Test
    public void testPrice() {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 32, "High Sierra", 2019, 1000);
        shop.inventory.add(computer);
        assertTrue(computer.price==32);   
    }

    /**
     * It test the memory that the constructor of the Computer file for the Computer.
     * It fails if the memory of the Computer is not the correct memory.
     */
    @Test
    public void testMemory() {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 512, "High Sierra", 2019, 1000);
        shop.inventory.add(computer);
        assertTrue(computer.memory==512);   
    }

    /**
     * It test the setPrice method.
     * It fails if the price of the Computer is not the updated price.
     */
    @Test
    public void testSetPrice() {
        Computer computer = new Computer("2019 MacBook Air", "Intel", 256, 16, "High Sierra", 2019, 1000);
        computer.setPrice(1500);
        assertEquals(1500, computer.price);
    }

    /**
     * It test the setPrice method.
     * It fails if the price of the Computer we set is a negative number and it does not throw exception.
     */
    @Test(expected=Exception.class)
    public void testSetPriceException() {
        Computer computer = new Computer("2019 MacBook Air", "Intel", 256, 16, "High Sierra", 2019, 1000);
        computer.setPrice(-500);
    }

    /**
     * It test the setOS method.
     * It fails if the OS of the Computer is not the updated OS.
     */
    @Test
    public void testSetOS() {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 512, "High Sierra", 2019, 1000);
        computer.setOS("Sequoia");
        shop.inventory.add(computer);
        assertTrue(computer.operatingSystem=="Sequoia");   
    }

    /**
     * It test the getYear method.
     * It fails if the year we get from the Computer is not the correct price.
     */
    @Test
    public void testGetYear() {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 512, "High Sierra", 2019, 1000);
        shop.inventory.add(computer);
        assertEquals(2019, computer.getYear());
    }

    /**
     * It test the constructor method.
     * It fails if the year we get from the Computer is older than the first computer was invented.
     */
    @Test
    public void testTooOld() {
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 512, "High Sierra", 1900, 1000);
        assertTrue(computer.yearMade>1945); 
    }

    /**
     * It test the toString method.
     * It fails if the return string of this function does not change the attributes into strings ingoring the problems in the constructor.
     */
    @Test
    public void testToString() {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 512, "High Sierra", 2019, 1000);
        shop.inventory.add(computer);
        String output=computer.toString();
        assertTrue(output.contains("2019 MacBook Air"));
        assertTrue(output.contains("Intel"));
        assertTrue(output.contains("256"));
        assertTrue(output.contains("16"));
        assertTrue(output.contains("High Sierra"));
        assertTrue(output.contains("2019"));
        assertTrue(output.contains("0")); 
    }

    
    /**
     * It test the buy method.
     * It fails if the inventory does not contain the computer that we bought.
     */
    @Test
    public void testBuyComputer() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 16, "High Sierra", 2019, 1000);
        shop.buy(computer);
        assertTrue(shop.inventory.contains(computer));
    }

    /**
     * It test the buy method that should throw exceptions.
     * It fails if it can buy a same computer that has already existed in the inventory.
     */
    @Test(expected=Exception.class)
    public void testBuySameObject()throws Exception{
        ResaleShop shop=new ResaleShop();
        Computer newComputer=new Computer("2019 MacBook Pro", "Intel", 256, 16, "High Sierra", 2019, 1000);
        shop.buy(newComputer);
    }

    /**
     * It test the sell method.
     * It fails if the inventory does contain the computer that we sold.
     */
    @Test
    public void testSellComputer() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2019 MacBook Air", "Intel", 256, 16, "High Sierra", 2019, 1000);
        shop.inventory.add(computer);
        shop.sell(computer);
        assertFalse(shop.inventory.contains(computer));
    }

    /**
     * It test the sell method that should throw exceptions.
     * It fails if it can sell a computer that does not exist in the inventory.
     */
    @Test(expected=Exception.class)
    public void testSellNonexistentObject() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2030 MacBook Air", "Intel", 256, 16, "High Sierra", 2030, 1000);
        shop.sell(computer);
    }

    /**
     * It test the printInventory method.
     * It fails if printInventory cannot print the inventory in a new resale shop.
     */
    @Test
    public void testPrintInventory() {
        ResaleShop shop = new ResaleShop();
        shop.printInventory(); 
    }

    /**
     * It test the refurbish method that should throw exceptions.
     * It fails if it can refurbish a computer that does not exist in the inventory.
     */
    @Test(expected=Exception.class)
    public void testRefurbish() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2030 MacBook Air", "Intel", 256, 16, "High Sierra", 2030, 1000);
        shop.refurbish(computer,"Sequoia" );
    }

    /**
     * It test the refurbish method that set the OS of the computer.
     * It fails if the OS it want to refurbish is not the OS that the Computer changes into ignoring the problems in setOS.
     */
    @Test
    public void testRefurbishOS() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2020 MacBook Pro", "Intel", 256, 16, "High Sierra", 2020, 1000);
        shop.inventory.add(computer);
        shop.refurbish(computer,"Sequoia");
        assertEquals("None",computer.operatingSystem);
    }

    /**
     * It test the refurbish method that should not change the OS of the computer.
     * It fails if it can refurbish a computer's OS if the new OS we input is "None".
     */
    @Test
    public void testRefurbishNotUpdateOS() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2020 MacBook Pro", "Intel", 256, 8, "High Sierra", 2020, 900);
        shop.inventory.add(computer);
        shop.refurbish(computer, "None");
        assertEquals("High Sierra", computer.operatingSystem); 
    }

    /**
     * It test the refurbish method that update the price of the computer before 2000.
     * It fails if the refurbished price of a computer older than 2000 is not 0.
     */
    @Test
    public void testRefurbish2000() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("1999 MacBook Pro", "Intel", 256, 8, "High Sierra", 1999, 900);
        shop.inventory.add(computer);
        shop.refurbish(computer, "Sequoia");
        assertEquals(0, computer.price); 
    }

    /**
     * It test the refurbish method that update the price of the computer between 2000 and 2012.
     * It fails if the refurbished price of a computer between 2000 and 2012 is not 250.
     */
    @Test
    public void testRefurbish2012() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2010 MacBook Pro", "Intel", 256, 8, "High Sierra", 2010, 900);
        shop.inventory.add(computer);
        shop.refurbish(computer, "Sequoia");
        assertEquals(250, computer.price); 
    }
    
    /**
     * It test the refurbish method that update the price of the computer between 2012 and 2018.
     * It fails if the refurbished price of a computer between 2000 and 2012 is not 550.
     */
    @Test
    public void testRefurbish2018() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2017 MacBook Pro", "Intel", 256, 8, "High Sierra", 2017, 900);
        shop.inventory.add(computer);
        shop.refurbish(computer, "Sequoia");
        assertEquals(550, computer.price); 
    }

    /**
     * It test the refurbish method that update the price of the computer after 2018.
     * It fails if the refurbished price of a computer after 2018 is not 1000.
     */
    @Test
    public void testRefurbishOtherYear() throws Exception {
        ResaleShop shop=new ResaleShop();
        Computer computer=new Computer("2025 MacBook Pro", "Intel", 256, 8, "High Sierra", 2025, 900);
        shop.inventory.add(computer);
        shop.refurbish(computer, "Sequoia");
        assertEquals(1000, computer.price); 
    }

    /**
     * It runs all the unit tests.
     */
    public static void main(String[] args) throws Exception{
        ShopTest runTests=new ShopTest();
        runTests.testPrice();
        runTests.testMemory();
        runTests.testSetPrice();
        runTests.testSetPriceException();
        runTests.testSetOS();
        runTests.testGetYear();
        runTests.testTooOld();
        runTests.testToString();
        runTests.testBuyComputer();
        runTests.testBuySameObject();
        runTests.testSellComputer();
        runTests.testSellNonexistentObject();
        runTests.testPrintInventory();
        runTests.testRefurbishOS();
        runTests.testRefurbishNotUpdateOS();
        runTests.testRefurbish2000();
        runTests.testRefurbish2012();
        runTests.testRefurbish2018();
        runTests.testRefurbishOtherYear();
    }
    
}
