package Que2;

public class Box <T>{
	
	private T item;

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
	public static void main(String[] args) {
		Box<Integer> intBox=new Box<>();
		intBox.setItem(10);
		
		int intVal=intBox.getItem();
		 System.out.println("Integer value: " + intVal);
		 
	        Box<String> strBox = new Box<>();
	        strBox.setItem("Hello");
	        
	        String strValue = strBox.getItem();
	        System.out.println("String value: " + strValue);
	}

}
