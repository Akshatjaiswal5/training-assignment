import java.io.*;
import java.util.*;
class SerializationTest {
 public static void main(String args[])throws Exception{

  Student s1= new Student("Akshat","05/02/2001",new Address("Khandwa","M.P.","India",450001));
  Student s2= new Student("Sadhana","06/12/2001",new Address("Indore","M.P.","India",456001));
  Student s3= new Student("Dhruv","15/01/2001",new Address("Indore","M.P.","India",456001));
  Student s4= new Student("Sanskar","09/08/2001",new Address("Raisen","M.P.","India",458001));

  List<Student> students=new ArrayList<>(4);
  students.add(s1);
  students.add(s2);
  students.add(s3);
  students.add(s4);

  FileOutputStream fos= new FileOutputStream(args[0]);
  ObjectOutputStream oos= new ObjectOutputStream(fos);
  oos.writeObject(students);
 }
}