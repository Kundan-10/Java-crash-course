package Que1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Person implements Comparable<Person>{

    private String name;
    private int age;
    
    
    private void person() {
		// TODO Auto-generated method stub

	}
    
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Person other) {
	   return Integer.compare(this.age, other.age);
	}

    
  public static void main(String[] args) {
      List<Person> people = new ArrayList<>();
      people.add(new Person("kundan", 50));
      people.add(new Person("amit", 70));
      people.add(new Person("kunal", 30));
      
      Collections.sort(people);      
      
      System.out.println("sort: by age");
      System.out.println(people);
      
      Collections.sort(people, new NameCamparator());
      System.out.println("\n Sort: by name:");
      System.out.println(people);
}  
    
  
}
