package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//| Comparable                   | Comparator                                 |
//| ---------------------------- | ------------------------------------------ |
//| Package: `java.lang`         | Package: `java.util`                       |
//| Natural/default ordering     | Custom ordering                            |
//| Method: `compareTo()`        | Method: `compare()`                        |
//| Implemented inside the class | Separate class, anonymous class, or lambda |
//| One sorting logic            | Multiple sorting logics                    |

//Comparable: Default (natural) ordering defined inside the Employee class (compareTo()).
//Comparator: Custom ordering defined outside the Employee class (compare() or Comparator.comparing...), 
//            allowing multiple sorting strategies (by ID, by name, descending, etc.).


class Employee implements Comparable<Employee>{
	int id;
	String name;


	public Employee(int id , String name) {
		this.id= id;
		this.name = name;
	}
	
//	Rule of compareTo()

//	Return Value	Meaning
//	Negative (< 0)	Current object comes before the other object
//	0	Both objects are equal
//	Positive (> 0)	Current object comes after the other object

	@Override
	public int compareTo(Employee o) {
		
// Prefer Integer.compare(this.id, o.id) over this.id - o.id 
		//because subtraction can overflow for large integer values.
		
		return  Integer.compare( this.id, o.id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return this.id + this.name;
	}
}

 
class EmployeeComparator{
	
}

public class A_ArraySOrt_comparable_Comoparable {

public static void main(String[] args) {
	
	Employee[] employees = {
		    new Employee(10, "Shivz"),
		    new Employee(500, "ahivzz"),
		    new Employee(25, "Shivy")
		};

		Arrays.sort(employees);

		System.out.println(Arrays.toString(employees));
	
	Employee emp1 = new Employee(10, "Shivz");
	Employee emp2 = new Employee(05, "ahiva");
	Employee emp3 = new Employee(25, "Shivy");
	
	List<Employee> employeeList = new ArrayList<Employee>();
	employeeList.add(emp1);
	employeeList.add(emp2);
	employeeList.add(emp3);
	
  Collections.sort(employeeList);
  System.out.println(employeeList);
  
  
  //-------------Comparator example   Array----------------
  
  //Sort by id (Descending)
  Arrays.sort(employees,
	        Comparator.comparingInt(Employee::getId).reversed());
  System.out.println(Arrays.toString(employees));
  //Sort by name (Descending)
  Arrays.sort(employees , Comparator.comparing(Employee::getName).reversed());
  System.out.println(Arrays.toString(employees));
 // Using a Lambda (Java 8)
  Arrays.sort(employees , (e1,e2)->  Integer.compare(e1.id, e2.id));
  System.out.println(Arrays.toString(employees));
 //Mulktgiple sort
  Arrays.sort(employees,
	        Comparator.comparing(Employee::getName)
	                  .thenComparingInt(Employee::getId));
  
  
  //-------------Comparator example   Array List----------------
//Sort by id (Descending)
  Collections.sort(employeeList,
	        Comparator.comparingInt(Employee::getId).reversed());
  System.out.println(employeeList);
  
   Collections.sort(employeeList , Comparator.comparing(Employee::getId).thenComparing(Employee::getName));
   
   System.out.println(employeeList);
   //ABove is similar to below
   Collections.sort(employeeList, new Comparator<Employee>() {
	    @Override
	    public int compare(Employee e1, Employee e2) {

	        int result = Integer.compare(e1.getId(), e2.getId());

	        if (result != 0) {
	            return result;
	        }

	        return e1.getName().compareTo(e2.getName());
	    }
	});
   
}

	
	

}
