import org.jsoup.*;
import org.jsoup.nodes.Document;

class Demo
{
	public static void main(String ar[])throws Exception
	{
		long x=System.currentTimeMillis();
		Document doc=Jsoup.connect("https://www.britannica.com/art/short-story").get();
		
		String text = doc.body().text();
		System.out.println(System.currentTimeMillis()-x);
		// System.out.println(text);
	}
}