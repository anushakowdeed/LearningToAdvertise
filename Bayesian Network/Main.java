import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static String filename=new String();
	public static String fname=new String();

     public static void main(String args[])  {
    	 
    	 try{
    
		 expanded_page_index e=new  expanded_page_index();
		 e.index_pages();
		 expanded_merge m=new expanded_merge();
		 m.merge_index();

    		 File folder = new File("./index");
    	        File files[] = folder.listFiles();
    	        ArrayList<File> A=new ArrayList<File>(Arrays.asList(files));

    	        Collections.sort(A);
    	        for (int i=0;i<A.size();i++) 
    			{
    	        	filename=A.get(i).toString();
    	        	String pageid=filename.substring(8);
			System.out.println("pageid= "+pageid);
    	        	File folder1 = new File(filename);
    	        	 File inner_files[] = folder1.listFiles();
    	        	 
    	 			ArrayList<File> B=new ArrayList<File>(Arrays.asList(inner_files));
    	 			//System.out.println(B.size());
    	 			Collections.sort(B);
    	 			  for (int j=0;j<B.size();j++)
    	 			  {
    	 				fname=B.get(j).toString();
    	 				makeMatrix r=new makeMatrix();
    	 				String out_matrix=r.read_file(pageid,fname);
    	 				String f="Matrix/matrix_";
    	 				f+=pageid;
    	 				Jaccard jack = new Jaccard();
    	 				String arr=jack.jackMain(pageid,f);
    	 				probability prob = new probability();
    	 				prob.calc_prob(arr,out_matrix,pageid);
    	 			  }
    	 		 }
 			final_merge f=new final_merge();
			f.merge_pUr();
			new_primary_index pi= new new_primary_index();
			pi.prime_index();
    	 }catch(Exception e){
    		 System.out.println(e);
    	 
    	}
     }
   

}
