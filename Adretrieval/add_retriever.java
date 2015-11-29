import java.util.Map;           // Superclass of HashMap
import java.util.HashMap;       // A container that supports quick retrieval
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
//2#creative1 art1#we1 teach1 here1 creative1 art1

 


public class add_retriever {

	int total_score=0;
	int add_id;
	int frq=0;
	//int max=-10;
	public HashMap mymap = new HashMap();
	public void store_in_map()
	{
		
		
			Obj ob=new Obj();
			ob.score=total_score;
			ob.freq=frq;
			mymap.put(add_id,ob);
			//System.out.println("score for add "+add_id+" = "+total_score+" term freq= "+frq);
		
	}	

	public void calc_n_score(String posting,boolean isTitle,int wt)
	{
		StringTokenizer parser=new StringTokenizer(posting,"#");
		String temp1=parser.nextToken();
		String temp2=parser.nextToken();
		int tf=Integer.parseInt(temp2);
		
		int score=1;
		if(isTitle==true && temp1.charAt(0)=='T')
		{
			score=score*256;
		}
		else if((isTitle==false && temp1.charAt(0)=='T')||(isTitle==true && temp1.charAt(0)=='C'))
		{
			score=score*16;
		}
		else 
		{
			score=score*8;
		}
		//System.out.println("wt "+wt);
		score=(score*wt);
		total_score+=score;
		//System.out.println("score "+total_score);
		frq++;
	}

	public void merge(String postings[],int n,boolean isTitle ,int wt[])
	{
		
		for(int i=0;i<n;i++)
		{
			//System.out.println(postings[i]);
			//System.out.println("weight i= "+wt[i]+" i= "+i);
			 calc_n_score(postings[i],isTitle,wt[i]);
			
		}
		
		//retrieval_query(n,out1);


	}

	 public  int bSearch(String key, String[] a1,int count) 
	{
	        int lo = 0;
	        int hi = count;
		int val,mid=0,prev_mid=0;
	        while (hi-lo>1) 
		{
			
			
	       	      prev_mid=mid;
	             mid = (hi + lo) / 2;
			//System.out.println(mid);
		    val=key.compareTo(a1[mid]);
			//System.out.println(val+" "+a1[mid]);
	            if      (val < 0) hi = mid ;
	            else if (val> 0) lo = mid ;
	            else {
				//arr[0]= mid;
		   		//arr[1]=1;
				return mid;
			}
	        }
			
			//arr[0]= lo;
			//arr[1]=0;
			return -1;
	    }	
public void retrieve(String docid,int id,int tit_score[],String title[], int content_score[],String content[], int size1,int size2,long a[],String b[],HashMap mymap1,int size_index)
{
	
	try{
	
	add_id=id;
	mymap=mymap1;
	String filename="pUr/";
	filename+=docid;
	//System.out.println("hello "+filename);
	File f = new File(filename);
	RandomAccessFile file1 = new RandomAccessFile(f, "rw");
	String search_key=new String();
	int total=size1+size2;
	//page_id="b42";
	String[] tpostings=new String[total];
	String[] cpostings=new String[total];
	int term_frq;
	int k=0,l=0;
	int c1=0,c2=0;
	int[] tit_wt=new int[1000];
	int []content_wt=new int[1000];

	for(int h=0;h<size1;h++)
	{
		//System.out.println("hello");
		search_key=title[h];
		
		//System.out.println("searching key "+search_key);
		int index = bSearch(search_key,b,size_index);
						//get the location of the word in the primary index
		if(index!=-1)
		{	//System.out.println("found in title "+tit_score[h]);
			c1++;		
			long pos=a[index];
			file1.seek(pos);
			BufferedReader r1 = new BufferedReader(new FileReader(file1.getFD()));
			String t=r1.readLine();
			tpostings[k]=t;
			tit_wt[k++]=tit_score[h];
			//System.out.println(tpostings[k-1]);
		}
	}
	
	for(int h=0;h<size2;h++)
	{
		search_key=content[h];
		//System.out.println("searching key "+search_key);
		int index = bSearch(search_key,b,size_index);
							//get the location of the word in the primary index
		if(index!=-1)
		{	//System.out.println("found in content "+content_score[h]);
			c2++;		
			long pos=a[index];
			file1.seek(pos);
			BufferedReader r1 = new BufferedReader(new FileReader(file1.getFD()));
			String t=r1.readLine();
			cpostings[l]=t;
			content_wt[l++]=content_score[h];
			//System.out.println(cpostings[l-1]);
		}
	}
	if(c1==0 && c2==0)
	{
		//System.out.println("No relevant pages");
	}
	 if(c1!=0)
	{
		merge(tpostings,k,true,tit_wt);
	}
	if(c2!=0)
	{
		merge(cpostings,l,false,content_wt);
	}
	if(c1!=0 || c2!=0)
		store_in_map();
		file1.close();
	}catch(IOException E){}
	}
}
