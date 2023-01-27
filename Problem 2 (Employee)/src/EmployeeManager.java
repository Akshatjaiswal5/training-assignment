import java.io.*;
import java.util.*;
import java.text.*;

class EmployeeManager
{
 private static EmployeeManager instance=null;
 private static String fileName;
 private HashSet<Employee> allEmployees;

 private List<String> dowloadContents() throws Exception {
  if(!new File(fileName).exists())
   new FileWriter(fileName, false);

  FileReader fr = new FileReader(fileName);
  BufferedReader br = new BufferedReader(fr);

  List<String> lines=new ArrayList<String>();
  String line = br.readLine();

  while (line != null)
  {
   lines.add(line); 
   line = br.readLine();
  }
  return lines;
 }

 private void uploadContents() throws Exception {
  FileWriter fr = new FileWriter(fileName, false);
  BufferedWriter br = new BufferedWriter(fr);
   
  for(Employee s:allEmployees)
  {
   br.write(s.getCSVLine());
   br.newLine();
  }

  br.close();
  fr.close();  
 }

 public static EmployeeManager getInstance(String fileName) throws Exception{
  if(instance==null||EmployeeManager.fileName!=fileName)
  {
   EmployeeManager.fileName=fileName;
   EmployeeManager.instance=new EmployeeManager();
  }
  return instance;
 }

 public void addEmployee(Employee employee) throws Exception {
  allEmployees.add(employee);

  FileWriter fr = new FileWriter(fileName, true);
  BufferedWriter br = new BufferedWriter(fr);

  br.write(employee.getCSVLine());

  br.close();
  fr.close(); 
 }

 public void deleteEmployee(Integer id) throws Exception{
  allEmployees.remove(new Employee(id));
  uploadContents();
 }

public List<Employee> searchEmployees(String query,String sortBy,String sortOrder) throws Exception {
 return null;
}

 public List<Employee> getAllEmployees(){
  return new ArrayList<Employee>(allEmployees);
 }
 private EmployeeManager() throws Exception{
  List<String> lines = dowloadContents();
  
  allEmployees=new HashSet<>();
  for(String line:lines)
  {
   String s[]=line.split(",");
   Integer id=Integer.parseInt(s[0]);
   String name=s[1];
   String email=s[2];
   Integer age=Integer.parseInt(s[3]);
   Date date=new Date(s[4]);
   Employee employee=new Employee(id,name,email,age,date);
   allEmployees.add(employee);
  }

 }
}