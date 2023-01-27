import java.io.*;
import java.util.*;
class Student implements Serializable{

	private static final long serialVersionUID=10l;
 private String firstName;
	private String dateOfBirth;
	//private Date dateOfBirth;
 private Address address;
 
 public Student(String firstName, String dateOfBirth, Address address) {
  this.firstName=firstName;
  this.dateOfBirth=dateOfBirth;
		//this.dateOfBirth=new Date(dateOfBirth);
  this.address=address;
 } 

 public String toString() {
  return "{ Name: "+firstName+",\n dateOfBirth: "+dateOfBirth+",\n address:"+address+", }";
	}
}