import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;


public class Jaccard{

             static public Matrix transform(Matrix termDocumentMatrix)
             {
                 int numDocs = termDocumentMatrix.getColDimension();
                 Matrix similarityMatrix = new Matrix(termDocumentMatrix.getColDimension(), termDocumentMatrix.getColDimension());
                 for (int i = 0; i < numDocs; i++)
                 {
                     Matrix sourceDocMatrix = termDocumentMatrix.getMatrix(
                             0, termDocumentMatrix.getRowDimension() - 1, i,i);
                         for (int j = 0; j < numDocs; j++)
                         {
                             Matrix targetDocMatrix = termDocumentMatrix.getMatrix(
                                     0, termDocumentMatrix.getRowDimension() - 1, j,j);
                             similarityMatrix.set(i, j,
                                     computeSimilarity(sourceDocMatrix, targetDocMatrix));
                         }
                 }
                 return similarityMatrix;
             }
   
             static double computeSimilarity(Matrix source, Matrix target)
             {
                 double intersection = 0.0D;
                 for (int i = 0; i < source.getRowDimension();i++)
                 {
                     intersection += Math.min(source.get(i, 0), target.get(i, 0));
                 }
                 if (intersection > 0.0D)
                 {
                     double union = source.norm1() + target.norm1() - intersection;
                     return intersection / union;
                 }
                 else
                 {
                     return 0.0D;
                 }
             }
            
             public String jackMain(String pageid, String fname) throws IOException
             {
            	 String fname1="Similarity/sim_";
            	 fname1+=pageid;
		// System.out.println(pageid);            	
		 //System.out.println(fname1);
            	 BufferedWriter out=new BufferedWriter(new FileWriter(fname1));
            	 BufferedReader br = new BufferedReader(new FileReader(fname));
            	 //System.out.println(fname);
            	 double[][] m=new double[10000][1000];
                 int[] doc_name=new int[6];
                 String[] term=new String[10000];

                  int j=0,i=0;
                   while (true)
                   {
                      	String st1 = br.readLine();
                      	if (st1==null)
                      	    break;
                     	// System.out.println(st1);
                     	 j=0;
                     	 StringTokenizer parser=new StringTokenizer(st1,"#");
                     	 term[i]=parser.nextToken();
                     	 while(parser.hasMoreTokens())
                     	 {
                     	    doc_name[j]=j;        
                     	     String temp=parser.nextToken();
                     	    
                     	        m[i][j]=Double.parseDouble(temp);
                     	               j++;
                     	 }
                     	 i++;
                    }
		   /* System.out.println("PRINTING MATRIX");
          	    for(int x=0;x<i;x++)
		    {
			System.out.print(term[x]);
			for(int y=0;y<j;y++)
			{
				System.out.print(m[x][y]+"  ");
			}System.out.println("");
		    }*/
                 Matrix docTermMatrix=new Matrix(m,i,j);
                 int c=docTermMatrix.getColDimension();
                 Matrix similarityMatrix=new Matrix(c,c);
                 similarityMatrix=transform(docTermMatrix);
                 similarityMatrix.printMatrix();
                 String b= similarityMatrix.storeMatrix();
		//System.out.println("STRING ISSS "+b);
                 out.write(pageid);
                 out.write('#');
                 out.write(b);
                 
                 out.close();
                 br.close();
               return b;                 
             }
             
}

 class Matrix{
     Integer row,col;
     double [][] matrix=new double[10000][1000];
   
     Matrix (int x, int y)
     {
         for(int i=0;i<x;i++)
             for(int j=0;j<y;j++)
                 matrix[i][j]=0;
         row=x;
         col=y;
     }

     Matrix(double a[][],int r,int c)
     {
         for(int i=0;i<r;i++)
             for(int j=0;j<c;j++)
                 matrix[i][j]=a[i][j];
         row=r;
         col=c;
     }
     Matrix getMatrix(int r1,int r2,int c1,int c2)
     {
         Matrix m=new Matrix(r2-r1+1,c2-c1+1);
         for(int i=r1;i<=r2;i++)
             for(int j=c1;j<=c2;j++)
                 m.matrix[i-r1][j-c1]=this.matrix[i][j];
       //  m.printMatrix();
         return m;
       
    }
     void printMatrix() {
                 for(int j=0;j<col;j++)
             
                 {
                     System.out.print(matrix[0][j]+" ");
                 }
                 System.out.println("");
    }
    
     String storeMatrix(){
    	 StringBuffer b=new StringBuffer();
    	 for(int j=0;j<col;j++)
    	 {
    		  double sim=matrix[0][j];
    		  String firstDouble= sim +"";
    		  b.append(firstDouble);
    		  b.append("#");
    	 }
	
    	 return b.toString() ;
     }
     
     int getRowDimension(){
         return row;
     }
     int getColDimension(){
         return col;
     }
     void set(int r,int c,double val)
     {
       
                this.matrix[r][c]=val;
     }
     double get(int i,int j)
     {
         return this.matrix[i][j];
     }
    
     double norm1(){
         double sum=0;
         for(int i=0;i<row;i++)
             for(int j=0;j<col;j++)
                 sum+=this.matrix[i][j];
             return sum;
       
     }
   
 }
