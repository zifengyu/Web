import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class GetPage {

	public static void main(String[] arges) {
		//http://book.kanunu.org/book/4044/44030.html


		Document doc;
		int book	= 5;
		int base	= 8169;
		int start	= 181170;
		int end		= 181242;

		try {
			FileWriter tfw = new FileWriter("C:\\asset\\book" + book + "_title.xml");
			tfw.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
			tfw.write("<resources>\n");
			tfw.write("<string-array name=\"book" + book + "_titles\">\n");
			//FileWriter fw = new FileWriter("C:\\book" + book + ".xml");

			//fw.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
			//fw.write("<resources>\n");

			for (int ch = 0; ch <= end - start; ++ch) {
				String url = "http://book.kanunu.org/book3/" + base + "/" + (start + ch) + ".html";

				doc = Jsoup.connect(url).get();

				Elements elems = doc.select("td[width=820][align=left][bgcolor=#FFFFFF]");
				String content = elems.get(0).text();

				String title = doc.select("font[color=#dc143c][size=4]").get(0).text();

				FileWriter fw = new FileWriter("C:\\asset\\book" + book + "_ch" + ch);
				tfw.write("<item>" + title + "</item>");
				//fw.write("<string name=\"b" + book + "_ch" + ch + "\">");
				fw.write(title + " \n");
				fw.write("  ");

				for (int i = 0; i < content.length(); ++i) {
					if (content.substring(i, i + 1).equals(" ")) {
						fw.write("\n");
					}
					String text = content.substring(i, i + 1);
					if (text.equals("“")) {
						fw.write("「");
					} else if (text.equals("”")) {
						fw.write("」");
					} else {
						if (text.equals(" ")) {
							if (i > 0 && !content.substring(i - 1, i).equals(" "))
								fw.write("  ");
						} else {
							fw.write(text);
						}
					}
				}

				//fw.write("\n</string>\n");
				fw.close();
			}
			//fw.write("</resources>\n");
			tfw.write("</string-array>\n");
			tfw.write("</resources>\n");
			tfw.close();



		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
}
