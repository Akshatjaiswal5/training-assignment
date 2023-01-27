import java.util.*;
import java.text.*;
class Employee implements Comparable
{
 private static int counter=1;
 private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 private Integer id;
 private String name;
 private String email;
 private Integer age;
 private Date dateOfBirth;
 
 public String toString() {
  return "{ Id: "+id+", Name: "+name+", Email: "+email+", age:"+age+","+sdf.format(dateOfBirth)+",}\n";
 }

 public String getCSVLine() {
  return id+","+name+","+email+","+age+","+sdf.format(dateOfBirth);
 }

 public Employee(Integer id){
  this.id=id;
 }

 public Employee(Integer id, String name, String email, Integer age, Date dateOfBirth){
  this.id=id;
  counter= Math.max(counter,id+1);
  this.name=name;
  this.email=email;
  this.age=age;
  this.dateOfBirth=dateOfBirth;
 }
 public Employee(String name, String email, Integer age, Date dateOfBirth){
  this.id=counter++;
  this.name=name;
  this.email=email;
  this.age=age;
  this.dateOfBirth=dateOfBirth;
 }
 public int compareTo(Employee other){
  return this.id-other.id;
 }
 public int hashCode(){
  return id;
 }
 public boolean equals(Object obj){
  if (!(obj instanceof Employee))
   return false; 

  Employee other=(Employee) obj;
  return this.id==other.id;
}
}