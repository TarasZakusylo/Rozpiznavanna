import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

/////////////////////////////////////////
abstract class OneLayerNet { 
	int        m_in_size; // neurons count on in-layer 
	int        m_out_size; // neurons count on out-layer 
	byte[]     m_I; // inputs  
	byte[]     m_O; // outputs 
	double[]   m_S; // states 
	double[][] m_W; // weight matrix
	
	////////////////////////////////////
	public OneLayerNet(int in_size, int out_size) {
		m_in_size=in_size;
		m_out_size=out_size;
		m_I=new byte[in_size]; 
		m_O=new byte[out_size];
		m_S=new double[out_size];
		m_W=new double [out_size][in_size];
		initWeight();
	}
	
	////////////////////////////////////
	public void printOut() {
		System.out.print(" OUT => ");
		for(int i=0;i<m_out_size;i++)	{
			System.out.print(m_O[i]);
			System.out.print(' ');
		}
		System.out.println();
	}
    
	////////////////////////////////////
	
	public void printIn() {
		System.out.print(" IN => ");
		for(int i=0;i<m_in_size;i++) {
			System.out.print(m_I[i]);
			System.out.print(' ');
		}
		System.out.println();
	}

	////////////////////////////////////
	public void step() {
		for(int i=0;i<m_out_size;i++) {
			m_S[i]=s(i); 
			m_O[i]=f(m_S[i]); 
		}
	}
	
	////////////////////////////////////	
	 void initWeight()	{

		Random rnd = new Random();
		for(int j=0;j<m_out_size;j++) {   
			for(int i=0;i<m_in_size;i++) {	
				m_W[j][i]=Math.sin(rnd.nextInt(4711))/2.0F;
			}
		}

	}
	////////////////////////////////////
	abstract byte f(double s); 
	abstract double s(int j); 
};

//================================================================

class Perceptron extends OneLayerNet { 
	 byte   T=0;
	 byte   LO=-1;
	 byte   HI=+1; 
	 double ETA=0.001F; // teching speed

	 double   m_err; // error of net
	 double[] m_E;   // error vector of output layer
	 byte[]   m_IDO; // ideal out for teaching

	////////////////////////////////////
	public Perceptron(int in_size, int out_size){	
        super(in_size,out_size);
        m_E=new double[out_size];
	    m_IDO=new byte[out_size];
	}

	////////////////////////////////////
	public void teach()	{
		for(int j=0; j<m_out_size; j++) {
			for(int i=0 ; i<m_in_size; i++) {
				m_W[j][i]+= ETA*m_I[i]*m_E[j]; 
			}
		}
	}
	
	////////////////////////////////////
	 void outError() {
		m_err=0.0F;
   		for(int j=0;j<m_out_size;j++) {
			m_E[j]=m_IDO[j]-m_S[j];
			m_err+=0.5F*(m_E[j]*m_E[j]);
		}
	}
	
	/////////////////////////////////
	 byte f(double s) {
		return (s<T)?LO:HI; 
	}
	
	////////////////////////////////////
	 double s(int j) {
		double sum=0;
		for(int i=0;i<m_in_size;i++) { sum+=m_I[i]*m_W[j][i]; }
		return sum;
	}
};

//================================================================
class Classificator extends Perceptron	{
	 byte MARK=79;   // O
	 byte NOMARK=46; // .
	 int X=5;  // pattern horizontal size
	 int Y=7;  // pattern vertical size 
	 
	 int N=1; // patterns number  //  мах
	 
	 String g = "";

		static Scanner vsi ;
		 String Reading1  = "";
		 String Reading2 ;
		 String [][] Reading = new String [1][9] ;
		 String  s_rozmirnict = ("system" + "/" + "rozmirnict" + ".java");
			 {
				try {
					vsi = new Scanner(new File(s_rozmirnict));
				} catch (Exception ez) {
					JOptionPane.showMessageDialog(null, " Помилка");
				}
	
				while (vsi.hasNext()) {
					for (int row = 0; row < Reading.length; row++) {
					 
						Reading1 = Reading1 + vsi.next();
					}
				}
				vsi.close(); 
				int a = Integer.parseInt(Reading1);
				N=a;
			 }
			
	 

	 double ERR=0.0001F;// max net error
	 int MAX_ITER=555; //max number iteration of teaching
	 int IN_SIZE=X*Y; 
	 int OUT_SIZE=10;
	
	 byte[][] m_patterns;  
	 byte[][] m_targets;
     byte[][] m_tests;

	///////////////////////////////////////////////
	public Classificator(){
        //super(IN_SIZE,OUT_SIZE);
        super(35,10);
		m_patterns=new byte[N][IN_SIZE];  
		m_targets=new byte[N][OUT_SIZE];
		m_tests=new byte[N][IN_SIZE];
	}

	///////////////////////////////////////////////
	public int loadPatterns(String file) {
		return load(file,m_patterns,IN_SIZE);
	}
	
	///////////////////////////////////////////////
	public int loadTests(String file) {
		return load(file,m_tests,IN_SIZE);
	}

	///////////////////////////////////////////////
	public int loadTargets(String file)	{
		return load(file,m_targets,OUT_SIZE);
	}
	
	///////////////////////////////////////////////
	public void teach() {
		int n=0; // pattern nunmber
		int m=0;
		int iter=0; // iteration number 
		double err=0.0F;  // current error

		Random rnd = new Random();

		for(iter=0;iter<MAX_ITER;iter++) {
			err=0.0F;
			///////////////////////
			// test
			for(n=0;n<N;n++) {
				setPattern(n);
				step();
				outError();
				err=(m_err>err)?m_err:err; //max error
			}
			//
			////////////////////////
			
			if(err<=ERR){break;}
			
			/////////////////////////
			// correct 
			for(m=0;m<N*10;m++) {
				// random from [0,N-1]
				n=rnd.nextInt(N);
				setPattern(n);
				step();
				outError();
				super.teach();
			}
			//
			/////////////////////
		}
	}
	
	///////////////////////////////////////////////
	public void makeTest() 	{
		for(int n=0;n<N;n++)  {   // мін 
			setTest(n);
			printIn();
			step();
			printOut();
			System.out.println();
		}
	}

	///////////////////////////////////////////////
	public void printIn() 	{
		
		
 
		for(int j=0;j<Y;j++) 	{
			for(int i=0;i<X;i++){
		//		System.out.print((char)((m_I[j*X+i]==HI)?MARK:NOMARK));
				g=g+(char)((m_I[j*X+i]==HI)?MARK:NOMARK);
				if((char)((m_I[j*X+i]==HI)?MARK:NOMARK)=='.'){
					g=g+" ";
				}
				
			}
		//	System.out.println();
			g=g+"\n";
		}
	//	System.out.println();
		g=g+"\n";
		
	//	JOptionPane.showMessageDialog(null, g);
	}

	///////////////////////////////////////////////
	public void printOut()	{
		for(int j=0;j<OUT_SIZE;j++)	{
			if(m_O[j]==HI) 	{
				System.out.println(j);
			 	g=g+"\n      "+j+"\n"+"\n";
				JOptionPane.showMessageDialog(null, g);		
				g="";
				return;
			}
		}
		System.out.println("unknown");
		
	}
	
	
	///////////////////////////////////////////////
	 int load(String file,byte [][] m, int size)	{
	   int buf=0; // read buffer
	   int n=0; // pattern number
	   int i=0; // pattern element number

		try { 
		   FileInputStream pat = new FileInputStream(file);
  		   try {
			  while((buf=pat.read())!=-1)	{
				  if(buf==MARK||buf==NOMARK) {
					  m[n][i]=((buf==MARK)?HI:LO); 
					  if(++i>=size) { 
						  i=0; 
						  if(++n>=N){break;}
					  }
				  }
			  }
			  pat.close();
           } catch (IOException e) { System.out.println("IO error");  }

        } 
        catch (FileNotFoundException e) { System.out.println("File not found"); }

		return 0;
	}
	
	///////////////////////////////////////////////
	 void setPattern(int n) {
		if(n>(N-1)|n<0){ return;}
		m_I=m_patterns[n]; 
		m_IDO=m_targets[n];
	}
	
	///////////////////////////////////////////////
	 void setTest(int n) {
		if(n>(N-1)|n<0){ return;}
		m_I=m_tests[n]; 
	}
};

