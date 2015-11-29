import java.io.*;
import  java.util.StringTokenizer;

public class makeMatrix
{
	 public String read_file(String pageid,String fname)	{
		 String fname1=new String();
		try{
		int[] tfs=new int[7];
		 fname1="Matrix/matrix_";
		fname1+=pageid;
		//System.out.println("reading from "+fname);
		BufferedWriter out=new BufferedWriter(new FileWriter(fname1));
		BufferedReader br = new BufferedReader(new FileReader(fname));

		while(true)
		{
			for(int i=0;i<=6;i++)
				tfs[i]=0;
			String st = br.readLine();
			//System.out.println(st);
			if(st==null) break;
			StringTokenizer parser=new StringTokenizer(st,"$");

			String term=parser.nextToken();
			//System.out.println(term);
			StringTokenizer stz=new StringTokenizer(parser.nextToken(),"#");
			while(stz.hasMoreTokens())
			{
				StringTokenizer stz1=new StringTokenizer(stz.nextToken(),",");
				int doc_id=Integer.parseInt(stz1.nextToken());
				tfs[doc_id]=Integer.parseInt(stz1.nextToken());
				//System.out.println("HIIIIIIIIIII "+doc_id+" "+tfs[doc_id]);
			}
			StringBuffer buff=new StringBuffer(term);

			for(int i=0;i<6;i++)
			{
				buff.append("#");
				buff.append(tfs[i]);
				//buff.append("#");
				//buff.append(B);
			}
			//System.out.println(buff);
			out.write(buff.toString());

			out.write("\n");
		}
		out.close();
		}catch(IOException e){}

		return fname1;

      }

}

