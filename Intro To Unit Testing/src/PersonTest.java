import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class PersonTest {
	
	private String firstName = "James";
	private String lastName = "Kirk";
	private int age = 50;
	private Person myPerson;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		myPerson = new Person();
	}

	@After
	public void tearDown() throws Exception {
		myPerson = null;
	}
	
	/*
	 * Testing constructors for Person class
	 */
	
	@Test
	public void testConstructors() {
		Person p1 = null;
		assertNull("Person was not null as expected", p1);
		
		Person p2 = new Person();
		assertNotNull("Person was not instantiated as expected", p2);
		
		
		Person p3 = new Person(firstName, lastName, age);
		assertNotNull("Person was not instantiated as expected", p3);
		
		
		//fail("Explicit constructor values not set as expected");
	}
	
	/*
	 * Testing get() and set() methods for firstName, lastName, and age parameters
	 */
	
	@Test
	public void testGetSetFirstName() {
		Person p1 = new Person();
		p1.setFirstName(firstName);
		assertEquals("First Name was not set as expected", firstName, p1.getFirstName());
	}
	
	@Test
	public void testGetSetLastName() {
		Person p1 = new Person();
		p1.setLastName(lastName);
		assertEquals("Last Name was not set as expected", lastName, p1.getLastName());
	}
	
	@Test
	public void testGetSetAge() {
		Person p1 = new Person();
		p1.setAge(age);
		assertEquals("Age was not set as expected", age, p1.getAge());
	}
	/*
	 * Testing toString() method
	 */
	@Test
	public void testToString() {
		myPerson.setFirstName(firstName);
		myPerson.setLastName(lastName);
		myPerson.setAge(age);
		
		String personString = myPerson.toString();
		
		assertTrue("Person toString does not contain firstName", personString.contains(firstName));
		assertTrue("Person toString does not contain lastName", personString.contains(lastName));
		assertTrue("Person toString does not contain age", personString.contains(String.format("%d", age)));
	}
}
