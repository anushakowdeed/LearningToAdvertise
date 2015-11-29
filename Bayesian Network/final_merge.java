import java.io.*;
import java.lang.*;
import java.util.*;
public class final_merge
{
	public void merge_pUr()
	{
		int merge_count=0;
//		try t=new try();
		int flag=0;
		File f1,f2,f;
		int val,id,id1,count,docid1,docid2,docid;
		String line1,line2,term1,term2,name,term;
	  
		File folder1,folder2;
			folder1= new File("./index1");
                        folder2= new File("./r");
                File files1[] = folder1.listFiles();
                File files2[] = folder2.listFiles();
		ArrayList<File> A=new ArrayList<File>();
		for(File F:files1)
		{
			if(F.isFile())
				A.add(F);
		}
		Collections.sort(A);
               ArrayList<File> B=new ArrayList<File>();
		for(File F:files2)
		{
			if(F.isFile())
				B.add(F);
		}
		Collections.sort(B);
                int i=0;int j=0;
                for (i=0,j=0;i<A.size();i++,j++)
		{
		     

                         f1=A.get(i);
			 f2=B.get(j);	
                       // System.out.println("f1:"+f1+"F2:"+f2);	
			try{
			
				
			        name="./pUr/";
				name+=(f1.toString().substring(9));
				//System.out.println(name);
				String Bu1,Bu2;
				BufferedReader buf1 = new BufferedReader(new FileReader(f1));
				BufferedReader buf2 = new BufferedReader(new FileReader(f2));
			 	BufferedWriter out = new BufferedWriter(new FileWriter(name));
				// BufferedWriter out1 = new BufferedWriter(new FileWriter("rough"));
				line1=buf1.readLine();line2=buf2.readLine();
				String nline1,nline2;
			  while(true)
			  {
				  nline1=line1;
				  nline2=line2;
				  StringTokenizer st1 = new StringTokenizer(line1, "#");
				  StringTokenizer st2 = new StringTokenizer(line2, "#");
				  term1 = st1.nextToken();
				  term2=st2.nextToken();
				//System.out.print(term1+" ");
				//System.out.print(term2+" ");
				val=term1.compareTo(term2);
				if(val<0)
				{
					out.write(line1);out.write("\n");
					line1=buf1.readLine();
				}
				else if(val>0)
				{
                                       	merge_count++;
                                      //  System.out.println("line2"+line2);
					out.write(line2);out.write("\n");
					line2=buf2.readLine();
				}
				else
				{

					//out.write(line1);
					
					StringTokenizer st11=new StringTokenizer(line1,"#");
					StringTokenizer st22=new StringTokenizer(line2,"#");
					String te=st11.nextToken();
					te=st22.nextToken();
					int a= Integer.parseInt(st11.nextToken());
					int b=Integer.parseInt(st22.nextToken());
					a+=b;
					StringBuffer buff=new StringBuffer(te);
					buff.append("#");
					buff.append(a);
					out.write(buff.toString());
					out.write("\n");
					line1=buf1.readLine();
					line2=buf2.readLine();
					
				
				}
				if(line1==null || line2==null)
					break;
				//st2=null;
			}
			if(line2!=null)
			{
				while(line2!=null)
				{
					out.write(line2);out.write("\n");
					line2=buf2.readLine();
					
				}
			}
			else
			if(line1!=null)
			{
				while(line1!=null)
				{
					out.write(line1);out.write("\n");
					line1=buf1.readLine();
					
				}
			}
			buf1.close();buf2.close();out.close();
			}catch(IOException E){}
			//System.out.println("merged lines = "+merge_count);
			merge_count=0;
		}	
		
		
		
	
		
	}
}
