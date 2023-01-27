import java.util.*;
import java.io.*;

class Demo{
 static Scanner scanner= new Scanner(System.in);
 static BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in)); 
 static EmployeeManager em;
 public static void main(String args[])
 {
  
  try{
   em=EmployeeManager.getInstance(args[0]);
   boolean flag=true;
   while(flag)
   {
    System.out.println("Enter a choice:");
    System.out.println("[1] Add Employee");
    System.out.println("[2] Delete Employee");
    System.out.println("[3] Search Employee");
    System.out.println("[4] Display all Employees");
    System.out.println("[0] Exit");
    System.out.print("Your Input(press enter when done):");
    int selected = scanner.nextInt();

    switch(selected)
    {
      case 1: addEmployee(); break;
      case 2: deleteEmployee(); break;
      case 3: searchEmployee(); break;
      case 4: displayAllEmployees(); break;
      case 0: flag=false; break;
      default: defaultMessage(); break;
    }
   }
  }
  catch(Exception e)
  {
   System.out.print(e.getMessage());
  }
 }
 public static void addEmployee() throws Exception{
  System.out.println("Enter Name:");
  String enteredName=bufferedReader.readLine().trim();
  System.out.println("Enter Email:");
  String enteredEmail=scanner.next().trim();
  System.out.println("Enter Age:");
  Integer enteredAge=scanner.nextInt();
  System.out.println("Enter Date of Birth(dd/mm/yyyy):");
  Date enteredDate=new Date(scanner.next().trim());

  Employee employee= new Employee(enteredName,enteredEmail,enteredAge,enteredDate);
  em.addEmployee(employee);

  System.out.println(employee);
  System.out.println("Added Successfully");
 }
 public static void deleteEmployee() throws Exception{
  System.out.println("Enter the id of Employee to be deleted:");
  Integer enteredId=scanner.nextInt();
  em.deleteEmployee(enteredId);

  System.out.println("Employee deleted Successfully");
 }
 public static void searchEmployee() throws Exception{
  System.out.println("Enter Query:");
  String query=scanner.next().trim();

  System.out.println("Sort by:");
  System.out.println("[1] Name");
  System.out.println("[2] Email");
  System.out.println("[3] Age");
  System.out.println("[4] Date of Birth");
  int selected = scanner.nextInt();
  String sortBy="";
  switch(selected){
   case 1: sortBy="name";break;
   case 2: sortBy="email";break;
   case 3: sortBy="age";break;
   case 4: sortBy="dateOfBirth";break;
   default: break;
  }
 
  System.out.println("Sort order:");
  System.out.println("[1] Ascending");
  System.out.println("[2] Descending");
  selected = scanner.nextInt();
  String sortOrder=(selected==2)?"desc":"asc";

  List<Employee> results=em.searchEmployees(query,sortBy,sortOrder);
  for(Employee s:results)
   System.out.println(s);
 }
 public static void displayAllEmployees() throws Exception{
  List<Employee> allEmployees=em.getAllEmployees();
  System.out.println(allEmployees);
 }

 public static void defaultMessage(){
  System.out.println("Invalid Input, try again");
 }
  
}
