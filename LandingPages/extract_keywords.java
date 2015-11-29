
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



public class extract_keywords
{


	public static void main(String args[]) throws IOException
	{
		new_parser np= new new_parser();
		np.parse_xml();
		BufferedWriter out=new BufferedWriter(new FileWriter("./new_ads.txt"));
		BufferedReader br=new BufferedReader(new FileReader("./ads.txt"));	
		File folder = new File("./landing1");
        	File files[] = folder.listFiles();
        	ArrayList<File> A=new ArrayList<File>(Arrays.asList(files));
        	Collections.sort(A);
		 for (int i=0;i<A.size();i++) 
		{
			String line=br.readLine();
			if(line==null)
				break;
			//System.out.println("LINE IS "+line);
			
			String filename=A.get(i).toString();
			//System.out.println("File read is "+ filename);			
			read_page r=new read_page();
			r.read_file(filename,out,line);
		}
		out.close();
	}
}

 class read_page
{
	static HashMap myHash=new HashMap();
	 static Set<String> set;
         LinkedHashMap sort_map = new LinkedHashMap();
        		//HashMap<String, Integer> smap = new LinkedHashMap<String, Integer>();
	
	read_page()
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

	
	public static void hash_add(String temp1)
	{
    // int term_freq;	
     		int val=1;
		//System.out.println("here");
		
		if(myHash.containsKey(temp1.toString())==false)
		{
			val=1;
		}
		else
		{
			val=(Integer)myHash.get(temp1.toString());
			val++;
		}
		myHash.put(temp1.toString(),val);
		
		//System.out.println("here");

	}	

static public void cleanStore(String tempStr)
	{
		
			boolean b = set.contains(tempStr);
			if(b==false)
			{
				hash_add(tempStr.toString().toLowerCase());
				
			}
		}

	

    public static LinkedHashMap sortHashMapByValuesD(HashMap passedMap)		// The sort function that is used to sort the values.
  {
   	 List mapKeys = new ArrayList(passedMap.keySet());
    	 List mapValues = new ArrayList(passedMap.values());
    	 Collections.sort(mapValues,Collections.reverseOrder());
    //Collections.sort(values, );
   // Collections.sort(mapKeys);
         int count=0,size=0;
         LinkedHashMap sortedMap = 
         new LinkedHashMap();
         LinkedHashMap sort_Map = 
          new LinkedHashMap();
         Iterator valueIt = mapValues.iterator();
         while (valueIt.hasNext()) {
         Object val = valueIt.next();
         Iterator keyIt = mapKeys.iterator();
       
        while (keyIt.hasNext()) {
               Object key = keyIt.next();
               String comp1 = passedMap.get(key).toString();
               String comp2 = val.toString();
            
            if (comp1.equals(comp2)){
                    passedMap.remove(key);
                    mapKeys.remove(key);
                    sortedMap.put((String)key,(Integer)val);
                    size++;
                    break;
            }

        }

    }
       Iterator iterator = sortedMap.keySet().iterator();  
   
	while (iterator.hasNext()) {  
   		String key = iterator.next().toString();  
   		String value = sortedMap.get(key).toString();  
                count++;
               // if(count<=50)
                //{
                     sort_Map.put(key,value);
                 //}
                //else
                 // break;
   		  //   System.out.println("count:"+count+"Key-value:"+key + " " + value);  
	   } 
           
       return sort_Map;
}
	
public void read_file(String filename, BufferedWriter out, String line1)
	{	
		try{

		
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while(true)
			{
				String line=br.readLine();
				if(line==null) break;
				StringBuffer content=new StringBuffer(line);
			
				for(int o=0;o<content.length();o++)
				{
					if ((content.charAt(o) >= 65 && content.charAt(o) <= 90) || (content.charAt(o) >= 97 && content.charAt(o) <= 122) || content.charAt(o)==' ')
					{
						
					}
					else
						content.setCharAt(o,' ');				
				}
				
				line=content.toString();
				//System.out.println(line);
				StringTokenizer parser=new StringTokenizer(line," ");
				while ( parser.hasMoreTokens() )
				{	
					String tempStr = parser.nextToken();
					//System.out.println(tempStr);
					cleanStore(tempStr); 
				}
		    	}
                      read_page r1=new read_page();
                      
                                            StringBuffer stbuff=new StringBuffer(line1);
                      sort_map=r1.sortHashMapByValuesD(myHash);
					stbuff.append("$$");
                                        Iterator it = sort_map.keySet().iterator();  
					int cnt=0;
                                        while (it.hasNext()) 
						{  
   							String key = it.next().toString();  
   						        String value = sort_map.get(key).toString();  
               					       stbuff.append(key);
						
							stbuff.append(" ");
                                                       // System.out.println(key+":"+value);
                                                        if(cnt==20) break;
                                                       // out.write(buff.toString());
							//doc=null;
							//innerhash=null;
                                                  //buff.setLength(0);out.write("\n");
   		 				        //System.out.println("Key-value:"+key + " " + value);  
						cnt++;	  					 
						} 
						
						out.write(stbuff.toString());
						out.write("\n");
		    }catch (Exception e){//Catch exception if any
	 		 System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
			}
}
}
