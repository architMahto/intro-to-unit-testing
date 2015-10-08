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
	private String invalidName = "12345 ^&*()_+";

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
	
	/*
	 * Testing comparable interface
	 */
	@Test
	public void testComparable() {
		Object o = null;						// null object
		Object o2 = "This is really a String";	// a String, not a Person
		Person p = new Person();				// used to compare to myPerson
		int expected1 = 1;						// expected when myPerson > p
		int expected0 = 0;						// expected when myPerson == p
		int expectedm1 = -1;					// expected when myPerson < p
		
		// cannot compare against null
		assertEquals("Null value should be less than our person!", expected1, myPerson.compareTo(o));
		// cannot compare against non-person
		assertEquals("Non-person should be less than our person!", expected1, myPerson.compareTo(o2));
	
		//last name set on one
        myPerson.setLastName(lastName);
        assertEquals("Person with nothing set should be less than person with last name set"
        				, expected1, myPerson.compareTo(p));
        assertEquals("Person with nothing set should be less than person with last name set"
        				, expectedm1, p.compareTo(myPerson));	
        myPerson.setLastName(null);
        
        //first name set on one
        myPerson.setFirstName(firstName);
        assertEquals("Person with nothing set should be less than person with first name set"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with nothing set should be less than person with first name set"
				, expectedm1, p.compareTo(myPerson));	
        myPerson.setFirstName(null);
        
        //age set on one
        myPerson.setAge(age);
        assertEquals("Person with nothing set should be less than person with age set"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with nothing set should be less than person with age set"
				, expectedm1, p.compareTo(myPerson));
        
        //no ln set, first name set on left, no ln, no fn set on right. age irrellevant
        myPerson.setFirstName(firstName);
        myPerson.setAge(age);
        assertEquals("Person with nothing set should be less than person with first name and age set"
        				, expected1, myPerson.compareTo(p));
        assertEquals("Person with nothing set should be less than person with first name and age set"
    					, expectedm1, p.compareTo(myPerson));
        p.setAge(age);
        assertEquals("Person with only age set should be less than person with first name and age set"
				, expected1, myPerson.compareTo(p));
        assertEquals("Person with only age set should be less than person with first name and age set"
				, expectedm1, p.compareTo(myPerson));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetInvalidFirstName() {
		// first, make sure fails if valid input
		myPerson.setFirstName(firstName);		
		myPerson.setFirstName(invalidName);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetInvalidFirstNameConstructor() {
		// first, make sure fails if valid input
		myPerson = new Person(firstName, lastName, age);		
		myPerson = new Person(invalidName, lastName, age);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetInvalidLastName() {
		// first, make sure fails if valid input
		myPerson.setLastName(lastName);		
		myPerson.setLastName(invalidName);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetInvalidLastNameConstructor() {
		// first, make sure fails if valid input
		myPerson = new Person(firstName, lastName, age);
		myPerson = new Person(firstName, invalidName, age);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetInvalidAge() {
		// first, make sure fails if valid input
		myPerson.setAge(age);		
		myPerson.setAge(-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetInvalidAgeConstructor() {
		// first, make sure fails if valid input
		myPerson = new Person(firstName, lastName, age);
		myPerson = new Person(firstName, lastName, -1);
	}
}
