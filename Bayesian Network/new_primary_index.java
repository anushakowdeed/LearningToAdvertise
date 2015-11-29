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

public class new_primary_index {

	public void prime_index()
	{
		try
		{
			File folder = new File("./pUr");
        		File files[] = folder.listFiles();
       			 ArrayList<File> A=new ArrayList<File>(Arrays.asList(files));
        		Collections.sort(A);
			
			//System.out.println(A.size());
			 for (int p=0;p<A.size();p++)
			 {
				String filename=A.get(p).toString();
                       		
				//System.out.println(filename);
				String name="primary_index/primary_";
				//System.out.println(filename.substring(7));
				name+=filename.substring(6);
				BufferedReader buf1 = new BufferedReader(new FileReader(filename));
				BufferedWriter out = new BufferedWriter(new FileWriter(name));
				int count=0;String line1;line1=buf1.readLine();
				long byte_count=0;
			//System.out.println("p= "+p);
				while(true)
				{	
					String term,str;
					String line2=new String(line1);
					byte[] b = line1.getBytes();
					//System.out.println(b.length);
					StringTokenizer parser=new StringTokenizer(line1,"#");
					term=parser.nextToken();
						//System.out.println(line1);
						//System.out.println(term);
				
						StringBuffer st=new StringBuffer();
						//System.out.println("written");
						st.append(term);
						st.append("#");	
						st.append(byte_count);	
						out.write(st.toString());
						out.write("\n");		
					//if(count==15)
					//{	//count=0;
				//		break;
				//	}	
				
				
					byte_count+=b.length+1;
					//System.out.println("index_byte= "+byte_count);
					 
				
					count++;
					line1=buf1.readLine();
					if(line1==null)
						break;
				}

				out.close();
				buf1.close();
			}
		}catch(IOException E){}
	}
}
