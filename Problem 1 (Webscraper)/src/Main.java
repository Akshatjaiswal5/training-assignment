import java.util.*;
class Main
{
  

 public static void main(String args[]) throws Exception{
  WebScraper ws= new WebScraper(args[0],args[1]);
  ws.process();
  for(int j=0;j<ws.urlCount;j++)
  {
   Arrays.sort(ws.freqTable[j]);
   System.out.println(ws.urls.get(j));
   for(int i=0;i<3;i++)
    System.out.println(ws.freqTable[j][i].word+": "+ws.freqTable[j][i].freq);
  
   System.out.println("--------------------------------");
  }
  
  Arrays.sort(ws.totalResults);
  System.out.println("final results:");
  for(int i=0;i<ws.wordCount;i++)
    System.out.println(ws.totalResults[i].word+" "+ws.totalResults[i].freq);
  
  
 }
}