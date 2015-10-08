public class Person implements Comparable {
	
	private String firstName;
	private String lastName;
	private int age;
	
	public Person() {
		
	}
	
	public Person (String firstName, String lastName, int age) {
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		if (!validateNameString(firstName))
			throw new IllegalArgumentException("Name must only contain characters. " + 
											   "Symbols, numbers, and punctuation are not allowed.");
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		if (!validateNameString(lastName))
			throw new IllegalArgumentException("Name must only contain characters. " + 
											   "Symbols, numbers, and punctuation are not allowed.");
		this.lastName = lastName;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		if (age < 0)
			throw new IllegalArgumentException("Age must be greater than or equal to zero");
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
		
		// both have no last name
		if (thisLastNameNull && objLastNameNull) {
			if (!thisFirstNameNull && objFirstNameNull)
				// left has first name set, right does not have anything set
				return 1;
			else if (thisFirstNameNull && !objFirstNameNull)
				// right has first name
				return -1;
		}
		
		return -99;
	}
	
	private boolean validateNameString(String nameToValidate) {
		if (nameToValidate != null && !nameToValidate.equals("")) {
			// regex to validate String
			String pattern = "[A-Za-z]*";
			return nameToValidate.matches(pattern);
		}
		return true;
	}
	
}