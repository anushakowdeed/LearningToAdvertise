import java.io.*;
import java.lang.*;
import java.util.*;
public class expanded_merge
{
	public static void merge_index()
	{
		
//		try t=new try();
	File main_folder;
	main_folder = new File("./index");
	 File nfiles[] = main_folder.listFiles();
	//System.out.println(nfiles[0]);
        ArrayList<File> B=new ArrayList<File>(Arrays.asList(nfiles));
	
        Collections.sort(B);
	
	for(int g=0;g<B.size();g++)
	{
		String ff=B.get(g).toString();
		//System.out.println("Getting into folder "+ff);
		int merge_count=0;
		int flag=0;
		File f1,f2,f;
		int val,id,id1,count,docid1,docid2,docid;
		String line1,line2,term1,term2,name,term;
		String file_index1="./index/";
		String file_index2="./indx2/";
		
		file_index1+=ff.substring(8);
		file_index2+=ff.substring(8);
		//System.out.println("hellooooooooooooooo "+file_index2);
		//int c=0;
		while(true)
		{
			//c++;
			File folder;
			if(flag==0)
				folder = new File(file_index1);	//System.out.println("flag= "+flag+" Getting into folder  "+file_index1);}
			else
				folder=new File(file_index2);	//System.out.println("flag= "+flag+" Getting into folder  "+file_index2);}
		        File files[] = folder.listFiles();
			ArrayList<File> A=new ArrayList<File>();	
		
			for(File F:files)
			{
				if(F.isFile())
					A.add(F);
			}
			Collections.sort(A);
			
			if(A.size() % 2 !=0)
			{
				File fptr=A.get(A.size()-1);
				File dir;
				if (flag==0)
					dir = new File(file_index2);
				else
					dir= new File(file_index1);
				boolean s = fptr.renameTo(new File(dir, fptr.getName()));
				//System.out.println("shifting extra file");
			}
			if(A.size()<=1)
			{
				//System.out.println(A.size()+" of "+folder);
				break;
			}
			
			for (int i=0;i+1<A.size();i=i+2)
			{
				//System.out.println("Opening file "+A.get(i));
				//System.out.println("Opening file "+A.get(i+1));
				f1=A.get(i);
				f2=A.get(i+1);		
				try{
				if(flag==0)
					name=file_index2;
				else
					name=file_index1;
				int len=f1.toString().length();
				if(len==13)
					name+=(f1.toString().substring(11));
				else
					name+=(f1.toString().substring(12));
				//System.out.println("Writing to file "+name);
				f=new File(name);
				f.createNewFile();
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
					  StringTokenizer st1 = new StringTokenizer(line1, "$");
					  StringTokenizer st2 = new StringTokenizer(line2, "$");
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
						out.write(line2);out.write("\n");
						line2=buf2.readLine();
					}
					else
					{

						//out.write(line1);
						merge_count++;
						int new_docfreq=0;
						StringBuffer buff = new StringBuffer(); 
						StringTokenizer st3= new StringTokenizer(nline1 ,"$");
						StringTokenizer st4 = new StringTokenizer(nline2, "$");	
								String Buff1,Buff2;
								String str,str1;count=0;
							
								buff.append(term1);
		                                                
								Buff1= st3.nextToken();
								Buff2= st4.nextToken();
								buff.append("$");
								buff.append(st3.nextToken());
								buff.append("#");					
								buff.append(st4.nextToken());
								//System.out.println("T"+term1);

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

			}	
		
			for (int i=0;i<A.size();i++)
				(A.get(i)).delete();
		
				
			A=null;
			if(flag==0)
				flag=1;
			else
			if(flag==1)
				flag=0;
		
		}
		//System.out.println("merged lines for = "+ff+" "+merge_count);
	}
	
	}
	
}



