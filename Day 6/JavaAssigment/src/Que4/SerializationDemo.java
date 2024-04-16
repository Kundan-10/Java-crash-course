package Que4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationDemo {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
        students.add(new Student("kundan", 101));
        students.add(new Student("akshay", 102));
        
        serializeStudents(students, "students.ser");
        
        List<Student> deserializedStudents = deserializeStudents("students.ser");
        System.out.println("Deserialized Students:");
        for (Student student : deserializedStudents) {
            System.out.println(student);
        }
	}

	private static void serializeStudents(List<Student> students, String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(students);
            System.out.println("Serialization completed successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred during serialization: " + e.getMessage());
        }
		
	}
    private static List<Student> deserializeStudents(String filename) {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            students = (List<Student>) inputStream.readObject();
            System.out.println("Deserialization completed successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred during deserialization: " + e.getMessage());
        }
        return students;
    }

}
