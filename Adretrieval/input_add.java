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
import java.lang.Object;

@SuppressWarnings("unchecked")
public class input_add 
{
	public static HashMap mymap1 = new HashMap();
	//static String docid="w501";
	//static String docid="w451";	
	//static String docid="b521";
	//static String docid="w262";
        static String docid[]=new String[1000];
        static File folder = new File("./indx");
        
	//static String docid="b32";
	//static String docid="b392";
	//static String docid="w441";
	static String [] add_title=new String[1000];
		static	String [] add_content=new String[1000];
			static int [] tit_score=new int[1000];
			static int [] content_score=new int[1000];
	public static String cleanStore(String tempStr)
	{
		 TreeSet<String> set = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);

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


		String temp=new String();
					
			boolean b = set.contains(tempStr);
			if(b==false)
			{
			
				Stemmer stem1 = new Stemmer();
				//temp=stem1.stem_word1(tempStr);
				//if(temp.length()>2)
                                 temp=stem1.stripAffixes(tempStr);
					return	temp;	
			
				
			}
			
				return null;
		
	}

	public static void convertMap(HashMap mp, int score[],String str[]) 
	{
    		Iterator it = mp.entrySet().iterator();
		int i=0;
    		while (it.hasNext()) 
		{
        		Map.Entry pairs = (Map.Entry)it.next();
		        //System.out.println(pairs.getKey() + " = " + pairs.getValue());
        		//it.remove(); // avoids a ConcurrentModificationException
			str[i]=pairs.getKey().toString();
			score[i]=(Integer)pairs.getValue();
			i++;
  		}
	}


	public static void main(String args[]) throws Exception

	{
		try{
                                
                        File files[] = folder.listFiles();
                       BufferedWriter out=new BufferedWriter(new FileWriter("./Relevant_ads.txt"));
			 BufferedWriter out1=new BufferedWriter(new FileWriter("./precision_recall.txt"));
        		ArrayList<File> A=new ArrayList<File>(Arrays.asList(files));
        		Collections.sort(A);
                        int count1=0;
			 for (int i=0;i<A.size();i++) 
			{
			
			
				String filename=A.get(i).toString();
                                String fname=filename.substring(7);
				docid[i]=fname;
                        	//System.out.println(docid[i]);
				count1++;
			}
                               //System.out.println(count1);
				//out.close();
			//System.out.print(doci[0]);
                              
                        for(int k=0;k<=147;k++)
                          {
				String file="indx/";
				file+=docid[k];
				System.out.println(docid[k]);
				BufferedReader br1 =new BufferedReader(new FileReader(file));
				String page_title=br1.readLine();
				out1.write(docid[k]);
				out1.write("  ");                            
			        out.write(docid[k]);
                                out.write("     ");
				out.write(page_title);
                                out.write("\n");
				br1.close();
				String filename="primary_index/primary_";
				filename+=docid[k];
				BufferedReader buf1 = new BufferedReader(new FileReader(filename));
			 	String term1,term2;
			 	int size_index=10000;
			 	long[] a=new long[size_index];
			 	String[] b=new String[size_index];
			 	String line1;
			 	int j1=0;
				int count=0;

                                
			 	while(true)
			 	{
					 add_title=new String[1000];
					 add_content=new String[1000];
					 tit_score=new int[1000];
					 content_score=new int[1000];
					
					line1=buf1.readLine();
					if(line1==null)
						break;
					count++;
					StringTokenizer parser=new StringTokenizer(line1,"#");
					term1=parser.nextToken();
					term2=parser.nextToken();
					long v=Long.parseLong(term2.toString());
					a[j1]=v;
					b[j1]=term1;
					//System.out.println(a[j1]+"  "+b[j1]);
					j1++; 
				}
				buf1.close();


			BufferedReader br =new BufferedReader(new FileReader("new_ads.txt"));
			String query=new String();
			int add_id;
			
			int i=0,j=0;
			String temp1;
			while(true)
			{
				HashMap title_token= new HashMap();
				HashMap content_token=new HashMap();
				long start = System.currentTimeMillis();
				query=br.readLine();					//read each advertisment details one by one
				if(query==null) break;
				//System.out.println(query);
				String t1=new String(query);
				StringTokenizer st=new StringTokenizer(t1,"#");				
				//add_id=st.nextToken();
				temp1=st.nextToken();
				add_id=Integer.parseInt(temp1);				// retrieve add id
				temp1=st.nextToken();
				StringTokenizer st1=new StringTokenizer(temp1," ");
				i=0;	
				int max=-1;						//storing no of tokens in the title	
				while(st1.hasMoreTokens())
				{
					String t=st1.nextToken();
					String s=new String();
					if(t.length()>2)
					{
						s=cleanStore(t);
					
						if(s!=null)
						{
							StringBuffer word=new StringBuffer();				
							word.append("T");
							word.append(s);
							//add_title[i++]=word.toString();
							if(title_token.containsKey(word.toString())==false)
							{
								
								title_token.put(word.toString(),1);
								if(1>max) max=1;
							}
							else
							{
								int val=(Integer)title_token.get(word.toString());
								val++;
								title_token.put(word.toString(),val);
								if(val>max) max=val;
							}	
							word.delete(0, word.length());
							word.append("C");
							word.append(s);
							if(title_token.containsKey(word.toString())==false)
							{
								
								title_token.put(word.toString(),1);
								if(1>max) max=1;
							}
							else
							{
								int val=(Integer)title_token.get(word.toString());
								val++;
								title_token.put(word.toString(),val);
								if(val>max) max=val;
							}	
							
						}				
					}
				}
				temp1=st.nextToken();
				// System.out.println(temp1);
				StringTokenizer st2=new StringTokenizer(temp1," ");
				j=0;							//storing no of tokens in the content
				while(st2.hasMoreTokens())
				{
					String t=st2.nextToken();
					String s=new String();
					if(t.length()>2)
					{
						s=cleanStore(t);
					
						if(s!=null)
						{
							StringBuffer word=new StringBuffer();					
							word.append("T");
							word.append(s);
							//add_content[j++]=word.toString();
							if(content_token.containsKey(word.toString())==false)
							{
								
								content_token.put(word,1);
								if(1>max) max=1;
							}
							else
							{
								int val=(Integer)content_token.get(word.toString());
								val++;
								content_token.put(word.toString(),val);
								if(val>max) max=val;
							}
							word.delete(0, word.length());
							word.append("C");
							word.append(s);
							//put_content[j++]=word.toString();			//retrieve content tokens
							if(content_token.containsKey(word.toString())==false)
							{
								
								content_token.put(word.toString(),1);
								if(1>max) max=1;
							}
							else
							{
								int val=(Integer)content_token.get(word.toString());
								val++;
								content_token.put(word.toString(),val);
								if(val>max) max=val;
							}						
						}				
					}
				}
				convertMap(title_token, tit_score,add_title);
				convertMap(content_token, content_score,add_content);
				//System.out.println(add_id+"***");
				i=title_token.size();
				j=content_token.size();
				
				add_retriever ar=new add_retriever();
		
				ar.retrieve(docid[k],add_id,tit_score,add_title,content_score,add_content,i,j,a,b,mymap1,count);				
                               				//out.write(docid[k]);
		


			}
			
			br.close();
			List keys = new ArrayList();
	      	 	keys.addAll(mymap1.keySet());
			Collections.sort(keys, new Comparator() {
		    	public int compare(Object a, Object b) {
			Obj s11=(Obj)mymap1.get(a);
			Obj s21=(Obj)mymap1.get(b);
			int st1=s11.score;
			int st2=s11.freq;
			int st3=s21.score;
			int st4=s21.freq;
			//System.out.println(st1+" "+st2+" "+st3+" "+st4);
			
	    		if(st1<=st3)
				return 1;
			
			else 	
				return -1;
		        
		    }
		});
		out.write("TOP 10 RELEVANT ADS ");
		
                out.write("\n");
		int listsize = keys.size();
  				
		RandomAccessFile smap = new RandomAccessFile("ads.txt", "r");
		int smplen=(int)smap.length();
		byte[] bytemparr = new byte[smplen];
		smap.seek(0);
		smap.read(bytemparr);
		String s=new String(bytemparr);
		String []secmaparray=s.split("\n");
		
		int cnt=1,flag=0;
		String s1;out.write("\n");
		long seek_offset,seek_end,total;
		String[] text;
		int i1=0;
		//System.out.println("TOP 10  "+listsize);
		//System.out.println();
		while(i1<listsize && cnt<=10) 
		{

			
			int id=Integer.parseInt(keys.get(i1).toString().trim());
			int low=0;
			int high = secmaparray.length-1;
			int mid = (low+high) /2;

			while(high-low!=1)
			{
				String substr=secmaparray[mid].substring(0,secmaparray[mid].indexOf('#'));
				int prid = Integer.parseInt(substr);
				
				if( id < prid)
				{
					high = mid;
					mid = (low+high)/2;
				}
				else if(prid==id)
				{
					low  = mid;
					flag=1;
					break;
				}
				else
				{
					low = mid;
					mid = (low+high)/2;
				}
			}
			
			
			i1++;
			String string=secmaparray[low];
			StringTokenizer stz=new StringTokenizer(string,"#");
			String ts=stz.nextToken();
			//System.out.print(ts);
			StringBuffer buff = new StringBuffer();
			buff.append(ts);
			int rel=0;
			if(cnt<=5)
				rel=2;
			else
				rel=1;
			buff.append(":");
			buff.append(rel);
			buff.append(",");
			out1.write(buff.toString());
                        out.write(ts);
                        out.write(" 	");
                        out.write("Title: "+stz.nextToken());
                        out.write(" 	");
                        out.write("\tDescription: "+stz.nextToken());
                        out.write("\n");
                        /*System.out.println(ts);
			System.out.print("   ");	
			System.out.print("Title: "+stz.nextToken());
			System.out.print(" ");
			System.out.print("\tDescription: "+stz.nextToken());		
			System.out.println("");*/	
			cnt++;	
		}
		out.write("\n");
		out1.write("\n");
		//System.out.println("\n");
                }
                out.close();
		out1.close();
		PrecisionRecall pr=new PrecisionRecall();
		pr.precison_main();
		}catch(IOException E){}
	}

}
class Obj
{
	
	int score;
	int freq;	
}
