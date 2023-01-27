import java.io.*;
import java.util.*;
class DeserializationTest {
 public static void main(String args[]) throws Exception{

  FileInputStream fis= new FileInputStream(args[0]);
  ObjectInputStream ois= new ObjectInputStream(fis);
  ArrayList students= (ArrayList)ois.readObject();

  for(int i=0;i<4;i++)
   System.out.println(students.get(i));
 }
}