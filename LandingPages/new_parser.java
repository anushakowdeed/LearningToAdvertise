
import java.util.Map;           // Superclass of HashMap
import java.util.TreeMap;       // A container that supports quick retrieval
import java.util.Iterator;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*;
import java.lang.*;
import java.util.*;
import  java.util.StringTokenizer;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;


class new_parser
{
	public static String filename1=new String();

	public static String getFilename()
	{
		return filename1;
	}

public void parse_xml() 
{	
 
    try {
 
	SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
 	
	 SaxHandler handler = new SaxHandler();
	
		
	File folder = new File("./landing");
        File files[] = folder.listFiles();
        ArrayList<File> A=new ArrayList<File>(Arrays.asList(files));
        Collections.sort(A);

        for (int i=0;i<A.size();i++) 
	{
			String filename=A.get(i).toString();
                       //filename="landing/add_11";
			//System.out.println(filename);
			//System.out.println("sending file "+filename.substring(10));
			filename1=filename;
		        saxParser.parse(filename, handler);

	}		
      

     } catch (Exception e) {
       e.printStackTrace();
     }
 
   }
}

class SaxHandler extends DefaultHandler 
{


	private boolean btitle = false;
	private boolean bcontent = false;
	private StringBuffer title= new StringBuffer();
	private StringBuffer content= new StringBuffer(); 
	

public void startElement(String uri, String localName,String qName, 
                Attributes attributes) throws SAXException {

		if (qName.equalsIgnoreCase("web:Title")) 
		{
			btitle = true;
		}
 
		
		if (qName.equalsIgnoreCase("web:Description")) {
			bcontent = true;
		}
}

public void characters(char ch[], int start, int length) throws SAXException 
{
 
		if (btitle) 
		{			

			title.append(new String(ch,start,length));	
		}
 
 
		if (bcontent) 
		{
			
			content.append(new String(ch,start,length));
		}
 
		
}
 
public void endElement(String uri, String localName,
		String qName) throws SAXException {
 
			
			if (btitle)
			 {
				
				btitle = false;
				//title.delete(0, title.length());

 			}
			
 			if (bcontent) 
			{
		
				
				bcontent = false;
				//content.delete(0, content.length());
				//System.out.println("hello.....add end!!");
			}
			if (qName.equalsIgnoreCase("web:Web")) 
			{
					//System.out.println("TITLE  "+title);
					//System.out.println("CONTENT  "+content);
					StringBuffer a=new StringBuffer();
					a.append(title);
					a.append(" ");
					a.append(content);
					//System.out.println("HELLOOO!!!");
					//System.out.println(a);
					//System.out.println("page end!!!");
					String out_file="./landing1/";
					String file1=new_parser.getFilename();
					String f=file1.substring(14); 
					int temp=Integer.parseInt(f);
					if(temp<10)
					{
						file1=new String("000");
						file1+=f;
						out_file+=file1;
					}
					else if(temp<100)
					{
						file1=new String("00");
						file1+=f;
						out_file+=file1;
					}
					else if(temp<1000)
					{
						file1=new String("0");
						file1+=f;
						out_file+=file1;						
					}
					else
						out_file+=f;
					//System.out.println("writing to file "+out_file);
					try{
								
							BufferedWriter out=new BufferedWriter(new FileWriter(out_file));
							//
							
							//System.out.println(a);
							
							out.write(a.toString());
							out.close();	
					} catch (Exception e) {
     					  e.printStackTrace();
     					}	
					content.delete(0, content.length());	
					title.delete(0, title.length());
			}
		
	}
}    


