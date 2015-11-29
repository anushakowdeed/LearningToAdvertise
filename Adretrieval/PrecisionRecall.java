import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Iterator;



public class PrecisionRecall 
{
	 static TreeMap judgemap=new TreeMap();
	 static TreeMap outmap=new TreeMap();
	 static double total_precision=0;
	static double total_recall=0;	
	
	 public static void cal_parameters(String pageid,BufferedWriter out) throws IOException
	 {
		 int intersection=0;
		 TreeMap innermap_jud= new TreeMap();
		 TreeMap innermap_out= new TreeMap();
		 innermap_jud=(TreeMap)judgemap.get(pageid);
		 innermap_out=(TreeMap)outmap.get(pageid);
		 Iterator it = (Iterator) innermap_out.entrySet().iterator();
		int i=0;
		 while(it.hasNext())
		 {
			i++;
			 Map.Entry en=(Map.Entry) it.next();
			 int id=Integer.parseInt(en.getKey().toString());
			//System.out.println("here is the id "+id);
			 if(innermap_jud.containsKey(id)==true)
				 	intersection++;
		 }
		//System.out.println(i);
		/// System.out.println(intersection);
		 int size1=10;
		 //System.out.println(size1);
		 int size2=innermap_jud.size();
		 //System.out.println(size2);
		 Double precision=(double)intersection/(double)size1;
		 Double recall=(double)intersection/(double)size2;
		 //System.out.println("Precison is "+precision);
		 //System.out.println("Recall is "+recall);
			StringBuffer buff=new StringBuffer();
			 buff.append(pageid);
			  buff.append("		");
			  buff.append(" ");
			  buff.append("		");
			  buff.append(precision);
			  buff.append("		");
			  buff.append(" ");
			  buff.append("		");
			  buff.append(recall);
			  out.write(buff.toString());
		 	 out.write("\n");
			total_precision+=precision;
			total_recall+=recall;
	 }
	public void precison_main() throws IOException
	{
		
		 BufferedWriter out=new BufferedWriter(new FileWriter("Precision_Recall_Table"));
		String pageid= new String();
		try{
			
			  out.write("PAGEID");
			  out.write("		");
			  out.write("|");
			  out.write("		");
			  out.write("PRECISION");
			  out.write("		");
			  out.write("|");
			  out.write("		");
			  out.write("RECALL");
			  out.write("\n");	  
			  FileInputStream fstream = new FileInputStream("Annotators_Judgement");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String line;
			  
			  while ((line = br.readLine()) != null)  
			  {
				  TreeMap innermap=new TreeMap();
				  
				  StringTokenizer st=new StringTokenizer(line);
					pageid=st.nextToken();
					String tmp=st.nextToken();
					StringTokenizer st1=new StringTokenizer(tmp,",");
					while(st1.hasMoreTokens())
					{
						String t=st1.nextToken();
						StringTokenizer st2=new StringTokenizer(t,":");
						 int addid=Integer.parseInt(st2.nextToken());
						 int rel=Integer.parseInt(st2.nextToken());
						 
						 	Set keys = innermap.keySet();
						 	
						 for (Iterator i = keys.iterator(); i.hasNext();) 
						 {
						     int key = (Integer) i.next();
						     int value = (Integer) innermap.get(key);
						    // System.out.println(key + " = " + value);
						 }    
						 innermap.put(addid,rel);
					}
 
					//System.out.println("Writing "+ pageid + " in map");
				    judgemap.put(pageid,innermap);  
			  }
			  in.close();
		   }catch (Exception e){
			    System.err.println("Error: " + e.getMessage());
			    }
		   
		 try{
				 
				  FileInputStream fstream = new FileInputStream("precision_recall.txt");
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String line;
				  
				  while ((line = br.readLine()) != null)  
				  {
					  TreeMap innermap=new TreeMap();
					  
					  StringTokenizer st=new StringTokenizer(line);
					    pageid=st.nextToken();
						String tmp=st.nextToken();
						StringTokenizer st1=new StringTokenizer(tmp,",");
						while(st1.hasMoreTokens())
						{
							String t=st1.nextToken();
							StringTokenizer st2=new StringTokenizer(t,":");
							 int addid=Integer.parseInt(st2.nextToken());
							 int rel=Integer.parseInt(st2.nextToken());
							 innermap.put(addid,rel);
							 Set keys = innermap.keySet();
							
							 for (Iterator i = keys.iterator(); i.hasNext();) 
							 {
							     int key = (Integer) i.next();
							     int value = (Integer) innermap.get(key);
							    // System.out.println(key + " = " + value);
							 }    

						}
		 
						//System.out.println("Writing "+ pageid + "in map");
					    outmap.put(pageid,innermap);  
				  }
				  in.close();
		  
		   		Iterator it = (Iterator)outmap.entrySet().iterator();
				 while(it.hasNext())
				 {
					 Map.Entry en=(Map.Entry) it.next();
		   			cal_parameters(en.getKey().toString(),out);
				 }
				 StringBuffer buff = new StringBuffer();
				
				  buff.append("AVERAGE");
				  buff.append("		");
				  buff.append(" ");
				  buff.append("		");
				  buff.append((total_precision/148));
				  buff.append("		");
				  buff.append(" ");
				  buff.append("		");
				  buff.append((total_recall/148));
				  out.write(buff.toString());
				  out.close();
			 }catch (Exception e)
				{
				    System.err.println("Error: " + e.getMessage());
			        }
	}
}
