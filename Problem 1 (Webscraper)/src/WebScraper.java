import org.jsoup.*;
import org.jsoup.nodes.Document;
import java.util.*;
import java.io.*;
class WebScraper
{
 public Token[][] freqTable;
 public Token[] totalResults;
 int urlCount,wordCount;
 List<String> urls,words;


 void processUrlNumber(int i) throws Exception{
  Document doc=Jsoup.connect(urls.get(i)).get();
		String[] wordsInTheUrl = doc.body().text().replaceAll("[^a-zA-Z\\w]", " ").split(" ");

  for(int j=0;j<wordCount;j++)
  {
   int count=0;
   for(String s: wordsInTheUrl)
    if(words.get(j).equalsIgnoreCase(s))
     count++;
   freqTable[i][j]=new Token(words.get(j),count);
  }  
 }
 

 void process() throws Exception{
 
  for(int i=0;i<urlCount;i++)
   processUrlNumber(i);

  for(int j=0;j<wordCount;j++)
  {
   int count=0;
   for(int i=0;i<urlCount;i++)
    count+=freqTable[i][j].freq;
   totalResults[j]=new Token(words.get(j),count);
  }

 }


 void loadFiles(String urlFileName,String wordFileName) throws Exception{
  if(!new File(urlFileName).exists())
   new FileWriter(urlFileName);
  FileReader fr = new FileReader(urlFileName);
  BufferedReader br = new BufferedReader(fr);
  this.urls=new ArrayList<String>();
  String url = br.readLine();
  while (url != null)
  {
   urls.add(url); 
   url = br.readLine();
  }
  br.close();
  fr.close();

  if(!new File(wordFileName).exists())
  new FileWriter(wordFileName);

  fr = new FileReader(wordFileName);
  br = new BufferedReader(fr);
  this.words=new ArrayList<String>();
  String word = br.readLine();
  while (word != null)
  {
   words.add(word); 
   word = br.readLine();
  }
  urlCount=urls.size();
  wordCount=words.size();
  freqTable= new Token[urlCount][wordCount];
  totalResults=new Token[wordCount];

  // System.out.println(words);
  // System.out.println(urls);
  // System.out.println("words:"+wordCount);
  // System.out.println("urls:"+urlCount);
 }


 public WebScraper(String urlFileName,String wordFileName) throws Exception{
  loadFiles(urlFileName,wordFileName);
 }
}