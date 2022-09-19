import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class wordsInSites {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//maybe find all instances of a user-inputted word in a user-inputted website url
		//purpose is to do something like ctrl+f but for all pages/subsections in a thing.
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the website you want to search: ");
		System.out.println("Input the word you want to find: ");
		String website = scanner.nextLine();
		String word = scanner.nextLine();
		System.out.println("Website: " + website);
		System.out.println("Word: " + word);
		//use HTMLUnit
		WebClient web = new WebClient();
		HtmlPage page = web.getPage(website);
		WebResponse response = page.getWebResponse();
		String content = response.getContentAsString();
		System.out.println(content);
		
	}

}
