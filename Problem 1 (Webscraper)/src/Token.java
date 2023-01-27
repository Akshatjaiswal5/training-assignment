class Token implements Comparable
{
 int freq;
 String word;

 public int compareTo(Object obj){
  Token other=(Token) obj;
  return other.freq-this.freq;
 }
 public Token(String word,int freq) {
  this.word=word;
  this.freq=freq;
 }
}