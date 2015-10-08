public class Person implements Comparable {
	
	private String firstName;
	private String lastName;
	private int age;
	
	public Person() {
		
	}
	
	public Person (String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return String.format("Name: %s %s \tAge: %d", getFirstName(), 
													  getLastName(), 
													  getAge());
	}
	
	public int compareTo(Object o) {
		// null or non-person-objects are less than our Person object
		if ((o == null) || !(o instanceof Person)) 
			return 1;
		
		Person p = (Person)o;
		
		boolean thisLastNameNull = this.getLastName() == null;
		boolean thisFirstNameNull = this.getFirstName() == null;
		boolean thisAgeZero = this.getAge() == 0;
		boolean objLastNameNull = p.getLastName() == null;
		boolean objFirstNameNull = p.getFirstName() == null;
		boolean objAgeZero = p.getAge() == 0;
		
		// case 1: one or more set on one side; nothing set on the other side
		if ((!thisLastNameNull || !thisFirstNameNull || !thisAgeZero) 
				&& (objLastNameNull && objFirstNameNull && objAgeZero))
			// left side is greater
			return 1;
		
		// flip side is one set on the right side and none set on the left side
		if ((thisLastNameNull && thisFirstNameNull && thisAgeZero) 
				&& (!objLastNameNull || !objFirstNameNull || !objAgeZero))
			// right side is greater
			return -1;
		
		return -99;
	}
}