
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


public class expanded_page_index {
 
	public static String filename=new String();
	public static String fname=new String();

	public static String getFilename()
	{
		return fname;
	}
   public static void index_pages() {
	
 
    try {

		
	File folder = new File("./split");
        File files[] = folder.listFiles();
        ArrayList<File> A=new ArrayList<File>(Arrays.asList(files));
        Collections.sort(A);

        for (int i=0;i<A.size();i++) 
		{
		
			filename=A.get(i).toString();
			//System.out.println("hey   "+filename);
                       File folder1 = new File(filename);
			 File inner_files[] = folder1.listFiles();
			ArrayList<File> B=new ArrayList<File>(Arrays.asList(inner_files));
			//System.out.println(B.size());
			Collections.sort(B);
			  for (int j=0;j<B.size();j++)
			  {
				fname=B.get(j).toString();
				//System.out.println("hello "+fname);
				read_web_page r=new read_web_page();
				r.read_file(fname);
			  }
		 }		
      

     } catch (Exception e) {
       e.printStackTrace();
     }
 
   }
}

class read_web_page{
	
	TreeMap myHash=new TreeMap();
	 Set<String> set;
	//String temp=new String();
	read_web_page()
	{
		 set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);

		set.add("I");
		set.add("a");
		set.add("the");
		set.add("an");
		set.add("are");
		set.add("by");
		set.add("com");
		set.add("from");
		set.add("it");
		set.add("is");
		set.add("of"); set.add("in"); set.add("those");
		set.add("through");set.add("that");
		set.add("this");set.add("were");
		set.add("was");set.add("who");
		set.add("what");set.add("will");
		set.add("our");set.add("too");
		set.add("you");	set.add("and");
		set.add("they");set.add("its");
		set.add("some");set.add("sometimes");		  
		set.add("which");set.add("how");
		set.add("his");set.add("her");
		set.add("for");set.add("www");
		set.add("few");set.add("http");
		set.add("down");set.add("redirect");
		set.add("did");
		set.add("cannot");
		set.add("but");
		set.add("both");
		set.add("between");
		set.add("being");
		set.add("here");
		set.add("himself");
		set.add("herself");
		set.add("during");
		set.add("each");		  
		set.add("with");
		set.add("these");
		set.add("same");
		set.add("ourselves");
		set.add("should");
		set.add("such");
		set.add("than");
		set.add("their");
		set.add("them");
		set.add("then");
		set.add("because");
		set.add("and");		  
		set.add("again");
		set.add("against");
		set.add("above");
		set.add("all");
		set.add("been");
		set.add("after");
		set.add("doing");
		set.add("further");
		set.add("while");
		set.add("doing");
		set.add("itself");		  
		set.add("would");
		set.add("any");		  
		set.add("there");
		set.add("nor");
		set.add("often");
		set.add("has");
		set.add("over");
		set.add("every");
		set.add("very");
		set.add("also");
		set.add("until");
		set.add("under");
		set.add("something");		  
		set.add("may");
		set.add("have");
		set.add("other");
		set.add("many");
		set.add("not");
		set.add("much");
		set.add("however");
		set.add("like");
		set.add("must");
		set.add("without");
		set.add("about");
		set.add("use");
		set.add("used");
		set.add("almost");
		set.add("common");
		set.add("still");
		set.add("when");
		set.add("can");
		set.add("never");
		set.add("having");
		set.add("had");
		set.add("even");
		set.add("give");
		set.add("among");
		set.add("towards");
		set.add("others");
		set.add("since");
		set.add("took");
		set.add("a");
set.add("a's");
set.add("able");
set.add("about");
set.add("above");
set.add("according");
set.add("accordingly");
set.add("across");
set.add("actually");
set.add("after");
set.add("afterwards");
set.add("again");
set.add("against");
set.add("ain't");
set.add("all");
set.add("allow");
set.add("allows");
set.add("almost");
set.add("alone");
set.add("along");
set.add("already");
set.add("also");
set.add("although");
set.add("always");
set.add("am");
set.add("among");
set.add("amongst");
set.add("an");
set.add("and");
set.add("another");
set.add("any");
set.add("anybody");
set.add("anyhow");
set.add("anyone");
set.add("anything");
set.add("anyway");
set.add("anyways");
set.add("anywhere");
set.add("apart");
set.add("appear");
set.add("appreciate");
set.add("appropriate");
set.add("are");
set.add("aren't");
set.add("around");
set.add("as");
set.add("aside");
set.add("ask");
set.add("asking");
set.add("associated");
set.add("at");
set.add("available");
set.add("away");
set.add("awfully");
set.add("b");
set.add("be");
set.add("became");
set.add("because");
set.add("become");
set.add("becomes");
set.add("becoming");
set.add("been");
set.add("before");
set.add("beforehand");
set.add("behind");
set.add("being");
set.add("believe");
set.add("below");
set.add("beside");
set.add("besides");
set.add("best");
set.add("better");
set.add("between");
set.add("beyond");
set.add("both");
set.add("brief");
set.add("but");
set.add("by");
set.add("c");
set.add("c'mon");
set.add("c's");
set.add("came");
set.add("can");
set.add("can't");
set.add("cannot");
set.add("cant");
set.add("cause");
set.add("causes");
set.add("certain");
set.add("certainly");
set.add("changes");
set.add("clearly");
set.add("co");
set.add("com");
set.add("come");
set.add("comes");
set.add("concerning");
set.add("consequently");
set.add("consider");
set.add("considering");
set.add("contain");
set.add("containing");
set.add("contains");
set.add("corresponding");
set.add("could");
set.add("couldn't");
set.add("course");
set.add("currently");
set.add("d");
set.add("definitely");
set.add("described");
set.add("despite");
set.add("did");
set.add("didn't");
set.add("different");
set.add("do");
set.add("does");
set.add("doesn't");
set.add("doing");
set.add("don't");
set.add("done");
set.add("down");
set.add("downwards");
set.add("during");
set.add("e");
set.add("each");
set.add("edu");
set.add("eg");
set.add("eight");
set.add("either");
set.add("else");
set.add("elsewhere");
set.add("enough");
set.add("entirely");
set.add("especially");
set.add("et");
set.add("etc");
set.add("even");
set.add("ever");
set.add("every");
set.add("everybody");
set.add("everyone");
set.add("everything");
set.add("everywhere");
set.add("ex");
set.add("exactly");
set.add("example");
set.add("except");
set.add("f");
set.add("far");
set.add("few");
set.add("fifth");
set.add("first");
set.add("five");
set.add("followed");
set.add("following");
set.add("follows");
set.add("for");
set.add("former");
set.add("formerly");
set.add("forth");
set.add("four");
set.add("from");
set.add("further");
set.add("furthermore");
set.add("g");
set.add("get");
set.add("gets");
set.add("getting");
set.add("given");
set.add("gives");
set.add("go");
set.add("goes");
set.add("going");
set.add("gone");
set.add("got");
set.add("gotten");
set.add("greetings");
set.add("h");
set.add("had");
set.add("hadn't");
set.add("happens");
set.add("hardly");
set.add("has");
set.add("hasn't");
set.add("have");
set.add("haven't");
set.add("having");
set.add("he");
set.add("he's");
set.add("hello");
set.add("help");
set.add("hence");
set.add("her");
set.add("here");
set.add("here's");
set.add("hereafter");
set.add("hereby");
set.add("herein");
set.add("hereupon");
set.add("hers");
set.add("herself");
set.add("hi");
set.add("him");
set.add("himself");
set.add("his");
set.add("hither");
set.add("hopefully");
set.add("how");
set.add("howbeit");
set.add("however");
set.add("i");
set.add("i'd");
set.add("i'll");
set.add("i'm");
set.add("i've");
set.add("ie");
set.add("if");
set.add("ignored");
set.add("immediate");
set.add("in");
set.add("inasmuch");
set.add("inc");
set.add("indeed");
set.add("indicate");
set.add("indicated");
set.add("indicates");
set.add("inner");
set.add("insofar");
set.add("instead");
set.add("into");
set.add("inward");
set.add("is");
set.add("isn't");
set.add("it");
set.add("it'd");
set.add("it'll");
set.add("it's");
set.add("its");
set.add("itself");
set.add("j");
set.add("just");
set.add("k");
set.add("keep");
set.add("keeps");
set.add("kept");
set.add("know");
set.add("knows");
set.add("known");
set.add("l");
set.add("last");
set.add("lately");
set.add("later");
set.add("latter");
set.add("latterly");
set.add("least");
set.add("less");
set.add("lest");
set.add("let");
set.add("let's");
set.add("like");
set.add("liked");
set.add("likely");
set.add("little");
set.add("look");
set.add("looking");
set.add("looks");
set.add("ltd");
set.add("m");
set.add("mainly");
set.add("many");
set.add("may");
set.add("maybe");
set.add("me");
set.add("mean");
set.add("meanwhile");
set.add("merely");
set.add("might");
set.add("more");
set.add("moreover");
set.add("most");
set.add("mostly");
set.add("much");
set.add("must");
set.add("my");
set.add("myself");
set.add("n");
set.add("name");
set.add("namely");
set.add("nd");
set.add("near");
set.add("nearly");
set.add("necessary");
set.add("need");
set.add("needs");
set.add("neither");
set.add("never");
set.add("nevertheless");
set.add("new");
set.add("next");
set.add("nine");
set.add("no");
set.add("nobody");
set.add("non");
set.add("none");
set.add("noone");
set.add("nor");
set.add("normally");
set.add("not");
set.add("nothing");
set.add("novel");
set.add("now");
set.add("nowhere");
set.add("o");
set.add("obviously");
set.add("of");
set.add("off");
set.add("often");
set.add("oh");
set.add("ok");
set.add("okay");
set.add("old");
set.add("on");
set.add("once");
set.add("one");
set.add("ones");
set.add("only");
set.add("onto");
set.add("or");
set.add("other");
set.add("others");
set.add("otherwise");
set.add("ought");
set.add("our");
set.add("ours");
set.add("ourselves");
set.add("out");
set.add("outside");
set.add("over");
set.add("overall");
set.add("own");
set.add("p");
set.add("particular");
set.add("particularly");
set.add("per");
set.add("perhaps");
set.add("placed");
set.add("please");
set.add("plus");
set.add("possible");
set.add("presumably");
set.add("probably");
set.add("provides");
set.add("q");
set.add("que");
set.add("quite");
set.add("qv");
set.add("r");
set.add("rather");
set.add("rd");
set.add("re");
set.add("really");
set.add("reasonably");
set.add("regarding");
set.add("regardless");
set.add("regards");
set.add("relatively");
set.add("respectively");
set.add("right");
set.add("s");
set.add("said");
set.add("same");
set.add("saw");
set.add("say");
set.add("saying");
set.add("says");
set.add("second");
set.add("secondly");
set.add("see");
set.add("seeing");
set.add("seem");
set.add("seemed");
set.add("seeming");
set.add("seems");
set.add("seen");
set.add("self");
set.add("selves");
set.add("sensible");
set.add("sent");
set.add("serious");
set.add("seriously");
set.add("seven");
set.add("several");
set.add("shall");
set.add("she");
set.add("should");
set.add("shouldn't");
set.add("since");
set.add("six");
set.add("so");
set.add("some");
set.add("somebody");
set.add("somehow");
set.add("someone");
set.add("something");
set.add("sometime");
set.add("sometimes");
set.add("somewhat");
set.add("somewhere");
set.add("soon");
set.add("sorry");
set.add("specified");
set.add("specify");
set.add("specifying");
set.add("still");
set.add("sub");
set.add("such");
set.add("sup");
set.add("sure");
set.add("t");
set.add("t's");
set.add("take");
set.add("taken");
set.add("tell");
set.add("tends");
set.add("th");
set.add("than");
set.add("thank");
set.add("thanks");
set.add("thanx");
set.add("that");
set.add("that's");
set.add("thats");
set.add("the");
set.add("their");
set.add("theirs");
set.add("them");
set.add("themselves");
set.add("then");
set.add("thence");
set.add("there");
set.add("there's");
set.add("thereafter");
set.add("thereby");
set.add("therefore");
set.add("therein");
set.add("theres");
set.add("thereupon");
set.add("these");
set.add("they");
set.add("they'd");
set.add("they'll");
set.add("they're");
set.add("they've");
set.add("think");
set.add("third");
set.add("this");
set.add("thorough");
set.add("thoroughly");
set.add("those");
set.add("though");
set.add("three");
set.add("through");
set.add("throughout");
set.add("thru");
set.add("thus");
set.add("to");
set.add("together");
set.add("too");
set.add("took");
set.add("toward");
set.add("towards");
set.add("tried");
set.add("tries");
set.add("truly");
set.add("try");
set.add("trying");
set.add("twice");
set.add("two");
set.add("u");
set.add("un");
set.add("under");
set.add("unfortunately");
set.add("unless");
set.add("unlikely");
set.add("until");
set.add("unto");
set.add("up");
set.add("upon");
set.add("us");
set.add("use");
set.add("used");
set.add("useful");
set.add("uses");
set.add("using");
set.add("usually");
set.add("uucp");
set.add("v");
set.add("value");
set.add("various");
set.add("very");
set.add("via");
set.add("viz");
set.add("vs");
set.add("w");
set.add("want");
set.add("wants");
set.add("was");
set.add("wasn't");
set.add("way");
set.add("we");
set.add("we'd");
set.add("we'll");
set.add("we're");
set.add("we've");
set.add("welcome");
set.add("well");
set.add("went");
set.add("were");
set.add("weren't");
set.add("what");
set.add("what's");
set.add("whatever");
set.add("when");
set.add("whence");
set.add("whenever");
set.add("where");
set.add("where's");
set.add("whereafter");
set.add("whereas");
set.add("whereby");
set.add("wherein");
set.add("whereupon");
set.add("wherever");
set.add("whether");
set.add("which");
set.add("while");
set.add("whither");
set.add("who");
set.add("who's");
set.add("whoever");
set.add("whole");
set.add("whom");
set.add("whose");
set.add("why");
set.add("will");
set.add("willing");
set.add("wish");
set.add("with");
set.add("within");
set.add("without");
set.add("won't");
set.add("wonder");
set.add("would");
set.add("would");
set.add("wouldn't");
set.add("x");
set.add("y");
set.add("yes");
set.add("yet");
set.add("you");
set.add("you'd");
set.add("you'll");
set.add("you're");
set.add("you've");
set.add("your");
set.add("yours");
set.add("yourself");
set.add("yourselves");
set.add("z");
set.add("zero");
	}


	public void writeHashMap(String docid) 
	{
       		
	try{
		
		String fname=new String();
		//long prev_val=0;
		String var=new String();
		String f=new String();
		f=expanded_page_index.getFilename();
		
		var=f.substring(8);	
		long new_val;int tf;
		fname="./index/";
		fname+=var;
		if(f.length()==13)
			docid=f.substring(12);
		else
			docid=f.substring(13);
		//System.out.println(fname);
        	TreeMap innerhash=new TreeMap();
 		  FileWriter fstream1 = new FileWriter(fname);	
		BufferedWriter out = new BufferedWriter(fstream1);
		 StringBuffer buff = new StringBuffer(); 
        	Iterator iterator = myHash.entrySet().iterator();
      // 	 	Document doc = new Document();
       		 while (iterator.hasNext()) 
		{
			//prev_val=0;
 			 Map.Entry entry = (Map.Entry) iterator.next();
				
				buff.append(entry.getKey().toString());
			
			   	innerhash=(TreeMap)entry.getValue();
				Iterator it =innerhash.entrySet().iterator();
				buff.append("$");
                                buff.append(docid);
                                buff.append(",");
				//int idf=innerhash.size();
				//buff.append(idf);
				while(it.hasNext())
				 {
					 Map.Entry en = (Map.Entry) it.next();
					
					String orig_val=en.getKey().toString();
					//new_val=orig_val-prev_val;
					//buff.append("#");
					//buff.append(orig_val);
					//buff.append(",");
					tf=(Integer)en.getValue();
					buff.append(tf);
									
					}
					
				out.write(buff.toString());
				//doc=null;
		innerhash=null;buff.setLength(0);out.write("\n");		
						
				}
				
			
		
			out.close();
	
        
		
 	 }             catch(IOException ioe)

                {

                        System.out.println("Error while writing file" + ioe);

                }
         
	
    }
	
	public void hash_add(String temp,String docid,boolean isTitle)
	{

		int term_freq;
		StringBuffer temp1=new StringBuffer();
		if(isTitle==true)
			temp1.append("T");
		else
			temp1.append("C");
		temp1.append(temp);
		//System.out.println(temp1);
		TreeMap innerHash=new TreeMap();
		if(myHash.containsKey(temp1.toString())==false)
		{
			term_freq=1;
		}
		else
		{
			innerHash=(TreeMap)myHash.get(temp1.toString());
			if(innerHash.containsKey(docid)==true)
			{
				
				term_freq=(Integer)innerHash.get(docid);
				term_freq++;
				
			}
			else
			{
				term_freq=1;
			}
		}
		innerHash.put(docid,term_freq);
		myHash.put(temp1.toString(),innerHash);
		//System.out.println("written3");
		//doc=null;
		innerHash=null;
			
	}

	public void cleanStore(String tempStr,String docid,boolean isTitle)
	{
		
		if(tempStr.length()>2)
		{			
			boolean a = tempStr.contains("http");
						
				//System.out.println(tempStr);
			boolean b = set.contains(tempStr);
			
			if(b==false && a==false)
			{
				//System.out.println(tempStr);
				Stemmer stem = new Stemmer();
                                String temp3=new String();
                                temp3=stem.stripAffixes(tempStr);
				StringBuffer temp=new StringBuffer(temp3);
				//System.out.println(temp3);
				if(temp.length()>1)
					hash_add(temp.toString(),docid,isTitle);
				temp.setLength(0);
				
			}
		}

	}

	public void read_file(String filename)
	{	
	try{
		String docid=filename.substring(7);
		File file = new File(filename);
		
		long file_size=file.length();
		int size=(int)file_size;
		String line;
		BufferedReader br = new BufferedReader(new FileReader(filename));
		line=br.readLine();
		int num_bytes=line.length();
		size-=num_bytes;
		StringBuffer content=new StringBuffer(line);
	//	StringBuffer cleanData=new StringBuffer();
		for(int o=0;o<content.length();o++)
		{
			if ((content.charAt(o) >= 65 && content.charAt(o) <= 90) || (content.charAt(o) >= 97 && content.charAt(o) <= 122) || content.charAt(o)==' ') 				{
							
			}
			else
				content.setCharAt(o,' ');
		}
		line=content.toString();
		StringTokenizer parser1=new StringTokenizer(line," ");
		while ( parser1.hasMoreTokens() )
		{
			//System.out.println("written2");
			String tempStr = parser1.nextToken();
			cleanStore(tempStr,docid,true); 
		}
		//System.out.println("title "+line);
		char[]compLine = new char[size+1];
		int numread=br.read(compLine,0,size);
		//System.out.println("content ");
		String str=new String(compLine);
//		System.out.println(str);
		content=new StringBuffer(str);
		for(int o=0;o<content.length();o++)
		{
			if ((content.charAt(o) >= 65 && content.charAt(o) <= 90) || (content.charAt(o) >= 97 && content.charAt(o) <= 122) || content.charAt(o)==' ') 				{
							
			}
			else
				content.setCharAt(o,' ');
		}	
		str=content.toString();	
		//StringBuffer buff=new StringBuffer(str);	
		StringTokenizer parser=new StringTokenizer(str," ");
		//String tempStr = parser.nextToken();
		
		//cleanStore(tempStr,docid,true); 	
		while ( parser.hasMoreTokens() )
		{
			//System.out.println("written2");
			String tempStr = parser.nextToken();
			cleanStore(tempStr,docid,false); 
		}
		writeHashMap(docid) ;

	}catch (Exception e){//Catch exception if any
	  System.err.println("Error: " + e.getMessage());
		e.printStackTrace();
	}
}
}


