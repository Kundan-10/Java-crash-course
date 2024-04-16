package Que4;

import java.io.Serializable;

public class Student implements Serializable{
    private String name;
    private int studentId;
    
    
	public Student(String name, int studentId) {
		super();
		this.name = name;
		this.studentId = studentId;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", studentId=" + studentId + "]";
	}
    
    
}
