

import java.util.Map;           // Superclass of HashMap
import java.util.TreeMap;       // A container that supports quick retrieval
import java.util.Iterator;
import javax.xml.parsers.SAXParser;
import java.io.*;
import  java.util.StringTokenizer;

public class probability
{

	static  void QuickSort(double a[], int lo0, int hi0,String b[]) {
  	  int lo = lo0;
   	 int hi = hi0;
   	double mid;

    if (hi0 > lo0) {

      /*
       * Arbitrarily establishing partition element as the midpoint of the
       * array.
       */
      mid = a[(lo0 + hi0) / 2];

      // loop through the array until indices cross
      while (lo <= hi) {
        /*
         * find the first element that is greater than or equal to the
         * partition element starting from the left Index.
         */
        while ((lo < hi0) && (a[lo]>mid))
          ++lo;

        /*
         * find an element that is smaller than or equal to the
         * partition element starting from the right Index.
         */
        while ((hi > lo0) && (a[hi]<mid))
          --hi;

        // if the indexes have not crossed, swap
        if (lo <= hi) {
         double t = a[hi];
          a[hi] = a[lo];
          a[lo] = t;
	  
	 String te = b[hi];
          b[hi] = b[lo];
          b[lo] = te;

          ++lo;
          --hi;
        }
      }

      /*
       * If the right index has not reached the left side of array must
       * now sort the left partition.
       */
      if (lo0 < hi)
        QuickSort(a, lo0, hi,b);

      /*
       * If the left index has not reached the right side of array must
       * now sort the right partition.
       */
      if (lo < hi0)
        QuickSort(a, lo, hi0,b);

    }
  }

	public static void calc_prob(String similarity, String out_prob,String pageid) throws IOException
	{
		StringTokenizer st=new StringTokenizer(similarity,"#");
		double[] sim=new double[6];
		String docid=st.nextToken();
		int c=0;
		while(st.hasMoreTokens())
		{
			sim[c++]=Double.parseDouble(st.nextToken());
			//System.out.println(sim[c-1]);
		}

		String fname="r/";
		fname+=pageid;
		BufferedWriter out=new BufferedWriter(new FileWriter(fname));
		BufferedReader br = new BufferedReader(new FileReader(out_prob));
		double A=0.8;
		//int N=;
		double []prob=new double[10000];
		String []terms=new String[10000];
		int i=0;
		while(true)
		{
			int[] doc_wts=new int[7];

			//String term=new String();
			String line=br.readLine();
			if(line==null) break;
			StringTokenizer parser=new StringTokenizer(line,"#");
			terms[i]=parser.nextToken();
			int wi0=Integer.parseInt(parser.nextToken());
			int n=0;
			while(parser.hasMoreTokens())
			{
				doc_wts[n++]=Integer.parseInt(parser.nextToken());
			}
			double sum=0;
			for(int j=0;j<6;j++)
			{
					sum+=doc_wts[j]*sim[j];
			}
			prob[i]=wi0*(1-A)+(A*sum);
			i++;
		}

		QuickSort(prob, 0, i,terms);
		for(int y=0;y<i;y++)
		{
			//System.out.println(" "+prob[y]);
		}
		double top_prob=prob[0];
		//System.out.println("top "+top_prob);
		TreeMap<String,String> mymap=new TreeMap();
		for(int y=0;y<i;y++)
		{
			StringBuffer buff=new StringBuffer();
			double B=prob[y]/top_prob;
			if(B>=0.05)
			{

				buff.append(terms[y]);
				buff.append("#");
				buff.append("1");
				mymap.put(terms[y],buff.toString());
			}


		}

		Iterator iterator = mymap.entrySet().iterator();
		 while (iterator.hasNext()) 
		 {

			 Map.Entry entry = (Map.Entry) iterator.next();
			//System.out.println(entry.getKey().toString());
			 String tf=entry.getValue().toString();
			//System.out.println(tf);
			out.write(tf);
			out.write("\n");
		}
			out.close();
	}

}
