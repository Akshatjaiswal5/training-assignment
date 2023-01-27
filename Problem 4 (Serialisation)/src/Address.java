import java.io.*;
class Address implements Serializable{
 String city;
 String state;
 String country;
 Integer pinCode;

 public String toString() {
  return "{ city: "+city+",\n state: "+state+",\n country:"+country+",\n pinCode: "+pinCode+", }";
	}

 public Address(String city, String state, String country, Integer pinCode)
 {
  this.city=city;
  this.state=state;
  this.country=country;
  this.pinCode=pinCode;
 }
}