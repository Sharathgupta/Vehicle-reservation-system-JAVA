import java.io.*;
import java.util.*;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.*;


public class w extends JApplet
{
	car c;
	order o;
	ret r;	
	
	//Font fl;
	JFrame l;
	
	public void init()
	{
		try
		{
			l=new JFrame("OK");
			java.awt.Font fl = new java.awt.Font("ALGERIAN",java.awt.Font.BOLD, 15);
			JTabbedPane t=new JTabbedPane();
			c=new car();
			o=new order();
			r=new ret();	
		
			t.setFont(fl);
			
			t.add("RENT",c);
			t.add("RETURN",r);
			t.add("LIST OF VEHICLES",o);
		
			t.setBackgroundAt(0,new java.awt.Color(23,100,200));
			t.setBackgroundAt(1,new java.awt.Color(244,0,6));
			t.setBackgroundAt(2,new java.awt.Color(16,214,61));


			Container con=getContentPane();
			JScrollPane jsp=new JScrollPane(t,20,30);
			con.add(jsp);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(l,e);
		}
	}



}

class car extends JPanel implements ActionListener,ItemListener
{
		
	JLabel ltitle,lname,ldname,lctype,ldob,lreg,ldid,lsdate,ledate,ldl,lv,ld;                
	
	JTextField tcname,tdname,tsyr,teyr,tdyr,tdid,tr1,tr2,tr3,tr4;	

	Choice sdate,smnth,edate,emnth,ddate,dmnth,vtype;

           Checkbox cac,pr,fu;

	CheckboxGroup bg;

	JButton R;

	java.awt.Font f,fo,ft,fl;
	
	JFrame fr;

	Date D;
	
	Hashtable H,hv;
	
	Icon icon;

			
	public car()throws IOException
	{	
		
		

		PrintWriter pv=new PrintWriter(new FileWriter("rv.txt",true) );
		PrintWriter pd=new PrintWriter(new FileWriter("rd.txt",true) );


		pv.close();
		pd.close();

		icon = new ImageIcon("s.png");
		
		lname=new JLabel("VEHICLE NAME : ");
		ldname=new JLabel("DRIVER's NAME : ");
		lctype=new JLabel("VEHICLE TYPE : ");
		ldob=new JLabel("DRIVER's DOB   : ");
		lreg=new JLabel("VEHICLE's REG-NO : ");
		ldid=new JLabel("DRIVER's ID-NO : ");
		lsdate=new JLabel("START DATE : ");
		ledate=new JLabel("END DATE :");
		ldl=new JLabel(" DRIVING LICENCE : ");
		lv=new JLabel("[    VEHICLE FORM    ]");
		ld=new JLabel("[    DRIVER  FORM    ]");
		ltitle=new JLabel("[] THE TRAVEL BUREAU []");
				
		tcname=new JTextField(15);
		tdname=new JTextField(15);
		tdid=new JTextField(15);
		tr1=new JTextField(2);
		tr2=new JTextField(2);
		tr3=new JTextField(4);
		tr4=new JTextField(5);	
		tdyr=new JTextField(4);
		tsyr=new JTextField(4);
		teyr=new JTextField(4);
			
		sdate=new Choice();
		smnth=new Choice();
		edate=new Choice();
		emnth=new Choice();
		ddate=new Choice();
		dmnth=new Choice();	
		vtype=new Choice();
		
		D=new Date();
				
		H=new Hashtable();
		hv=new Hashtable();
		
		vtype.add("SMALL CAR");
		vtype.add("FAMILY CAR");
		vtype.add("LUXURY CAR");
		vtype.add("SMALL VAN");
		vtype.add("LARGE VAN");

		H.put("1",30);
		H.put("3",31);
		H.put("4",30);
		H.put("5",31);
		H.put("6",30);
		H.put("7",31);
		H.put("8",31);
		H.put("9",30);
		H.put("10",31);
		H.put("11",30);
		H.put("12",31);
		
		
		for(int i=1;i<=31;i++)
		{
			sdate.add(Integer.toString(i));
			edate.add(Integer.toString(i));
			ddate.add(Integer.toString(i));
		
		}
	
		for(int i=1;i<=12;i++)
		{
			smnth.add(Integer.toString(i));
			emnth.add(Integer.toString(i));
			dmnth.add(Integer.toString(i));
		}

		bg=new CheckboxGroup();
		pr=new Checkbox(" PROVISIONAL",bg,true);
		fu=new Checkbox(" COMPLETE",bg,false);
		cac=new Checkbox("AIR CONDITION FACILITY");
		
		R=new JButton(" RENT ");	
	
		f = new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD , 15);	
		fo = new java.awt.Font("ALGERIAN", java.awt.Font.BOLD , 25);
		ft = new java.awt.Font("Old English Text MT", java.awt.Font.BOLD , 32);
		fl=new java.awt.Font("Blackoak Std",java.awt.Font.BOLD,32);
		
		fr=new JFrame();

		
		
		lname.setFont(f);
		ldname.setFont(f);
		lctype.setFont(f);
		ldob.setFont(f);
		lreg.setFont(f);
		ldid.setFont(f);
		lsdate.setFont(f);
		ledate.setFont(f);
		ldl.setFont(f);
		tcname.setFont(f);
		tdname.setFont(f);
		tdid.setFont(f);
		tr1.setFont(f);
		tr2.setFont(f);
		tr3.setFont(f);
		tr4.setFont(f);
		tdyr.setFont(f);
		tsyr.setFont(f);
		teyr.setFont(f);
		vtype.setFont(f);
		sdate.setFont(f);
		smnth.setFont(f);
		edate.setFont(f);
		emnth.setFont(f);
		ddate.setFont(f);
		dmnth.setFont(f);
		cac.setFont(f);
		pr.setFont(f);
		fu.setFont(f);
		lv.setFont(fo);
		ld.setFont(fo);
		ltitle.setFont(ft);	
		
		R.setIcon(icon);
		R.setToolTipText("Click to confirm Booking");
		R.setFont(fl);
	

		R.addActionListener(this);
		sdate.addItemListener(this);
		smnth.addItemListener(this);
		edate.addItemListener(this);
		emnth.addItemListener(this);
		ddate.addItemListener(this);
		dmnth.addItemListener(this);
		vtype.addItemListener(this);
	

		setLayout(null);


		R.setBounds(500,600,350,35);
		
		lname.setBounds(190,30,138,50);
		tcname.setBounds(345,45,100,25);		
		
		ldname.setBounds(800,30,200,50);
		tdname.setBounds(950,40,200,25);
		
		lctype.setBounds(190,95,138,50);
		vtype.setBounds(345,107,125,25);	
		
		ldob.setBounds(800,95,200,50);	
		ddate.setBounds(950,107,50,50);
		dmnth.setBounds(1000,107,50,50);
		tdyr.setBounds(1050,107,50,25);		

		lreg.setBounds(190,155,200,50);
		tr1.setBounds(360,170,30,25);
		tr2.setBounds(400,170,30,25);
		tr3.setBounds(440,170,35,25);
		tr4.setBounds(490,170,50,25);

		ldid.setBounds(800,155,200,50);
		tdid.setBounds(960,165,200,25);

		cac.setBounds(190,220,200,50);
		ldl.setBounds(800,220,200,50);
		pr.setBounds(985,220,150,50);
		fu.setBounds(985,260,150,50);

		lsdate.setBounds(190,300,150,50);
		sdate.setBounds(310,312,50,50);
		smnth.setBounds(360,312,50,50);
		tsyr.setBounds(410,312,50,25);

		ledate.setBounds(800,300,150,50);
		edate.setBounds(955,312,50,50);
		emnth.setBounds(1005,312,50,50);
		teyr.setBounds(1055,312,50,25);

		lv.setBounds(225,350,400,200);		
		ld.setBounds(850,350,400,200);
		ltitle.setBounds(425,450,600,200);

		add(R);	
		add(lname);
		add(tcname);
		add(ldname);
		add(tdname);
		add(lctype);
		add(vtype);
		add(ldob);
		add(ddate);
		add(dmnth);
		add(tdyr);
		add(lreg);
		add(tr1);
		add(tr2);
		add(tr3);
		add(tr4);
		add(ldid);
		add(tdid);
		add(cac);
		add(ldl);
		add(pr);	
		add(fu);
		add(lsdate);
		add(sdate);
		add(smnth);		
		add(tsyr);
		add(ledate);
		add(edate);
		add(emnth);
		add(teyr);
		add(lv);
		add(ld);
		add(ltitle);

	}
	


		
	
	public void actionPerformed(ActionEvent e)
	{
		
		check();
	}
	

	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource()==vtype)
		{
			if(vtype.getSelectedItem()=="LUXURY CAR")
			{
				cac.setState(true);	
			}
			JOptionPane.showMessageDialog(fr,"                    THE TRAVEL BUREAU\n\nList of Charges / day\n\n1. SMALL CAR : £ 30\n2. FAMILY CAR : £ 40\n3. LUXURY CAR : £ 150\n4. SMALL VAN : £ 50\n5. LARGE VAN : £ 70\n\n*Air Condition facility 10% extra except for luxury car\n\n*On return early discounts for unused days are\nSmall cars 100%\nLuxury cars 30%\nRemaining 50%\n\n**On late return Penalty as follows:\n30% / day for Luxury cars\n20% / day for remaining");
		}			





	}
	
	public void check()
	{
		try
		{
			Integer.parseInt(tr2.getText());
			Integer.parseInt(tr4.getText());
						
			BufferedReader ve=new BufferedReader(new FileReader("rv.txt"));
			BufferedReader di=new BufferedReader(new FileReader("rd.txt"));
			
			String x,y;

			while( (x=ve.readLine()) != null )
			{
				y=di.readLine();
				String xi[]=x.split(" ");
				String yi[]=y.split(" ");
				hv.put(xi[3],yi[4]);
			}


			ve.close();
			di.close();
			
			if(tcname.getText().length()==0)
			{
				JOptionPane.showMessageDialog(fr,"Vehicle name field empty");
			}
			else if(tdname.getText().length()==0)
			{
				JOptionPane.showMessageDialog(fr,"Driver name field empty");
			}
			else if(tsyr.getText().length()!=4 || teyr.getText().length()!=4 || tdyr.getText().length()!=4 )
			{
				JOptionPane.showMessageDialog(fr,"Date field's year to be in \nyyyy form");
			}
			else if(tdid.getText().length()==0)
			{
				JOptionPane.showMessageDialog(fr,"Driver's ID field empty");
			}
			else if(tr1.getText().length()!=2)
			{
				JOptionPane.showMessageDialog(fr,"Vehicle's Reg no 1st field to be of 2 letters\n Indicating state like KA for KARNATAKA");
			}
			else if(tr2.getText().length()!=2)
			{
				JOptionPane.showMessageDialog(fr,"Vehicle's Reg no 2nd field to be of 2 digits\n Indicating province of a state 09");	
			}
			else if( tr3.getText().length()==0 ||tr4.getText().length()==0 )
			{
				JOptionPane.showMessageDialog(fr,"Some are all unfilled in \n 3rd 4th field of Vehicle Reg no");	
			}
			else if( Integer.parseInt(tsyr.getText()) < D.getYear()+1900 )
			{
				JOptionPane.showMessageDialog(fr,"Start Year field \n Shouldn't be less than present year "+ String.format("%d",D.getYear()+1900));
			}
			else if( Integer.parseInt(teyr.getText()) < D.getYear()+1900 )
			{
				JOptionPane.showMessageDialog(fr,"End Year field \n Shouldn't be less than present year "+ String.format("%d",D.getYear()+1900));
			}
			else if( Integer.parseInt(smnth.getSelectedItem())< D.getMonth()+1 && Integer.parseInt(tsyr.getText()) == D.getYear()+1900 )
			{
				JOptionPane.showMessageDialog(fr,"Start month field \n Shouldn't be less than present Month "+ String.format("%d",D.getMonth()+1));	
			}
			else if( Integer.parseInt(emnth.getSelectedItem())< D.getMonth()+1 && Integer.parseInt(teyr.getText()) == D.getYear()+1900 )
			{
				JOptionPane.showMessageDialog(fr,"End month field \n Shouldn't be less than present Month "+ String.format("%d",D.getMonth()+1));	
			}
			else if( Integer.parseInt(sdate.getSelectedItem())< D.getDate() && Integer.parseInt(smnth.getSelectedItem()) == D.getMonth()+1 && Integer.parseInt(tsyr.getText()) == D.getYear()+1900 )
			{
				JOptionPane.showMessageDialog(fr,"Start Date field \n Shouldn't be less than present Date "+ String.format("%d",D.getDate()));	
			}
			else if( Integer.parseInt(edate.getSelectedItem())< D.getDate() && Integer.parseInt(emnth.getSelectedItem()) == D.getMonth()+1 && Integer.parseInt(teyr.getText()) == D.getYear()+1900 )
			{
				JOptionPane.showMessageDialog(fr,"End Date field \n Shouldn't be less than present Date "+ String.format("%d",D.getDate()));	
			}
			else if( vtype.getSelectedItem()=="LUXURY CAR" && cac.getState()==false )
			{
				JOptionPane.showMessageDialog(fr,"AC is compulsory for luxury car");	
			}
			else if( Integer.parseInt(tdyr.getText()) >=  D.getYear()+1900 )
			{
				JOptionPane.showMessageDialog(fr,"Invalid Driver's DOB");	
			}
			else if((vtype.getSelectedItem()=="SMALL CAR") && ( (D.getYear()+1900-Integer.parseInt(tdyr.getText()) < 17) || (fu.getState()==false)) )
			{
				JOptionPane.showMessageDialog(fr,"To rent small car\n1.Driver's age should be >17\n2.Driver should have Complete DL");	
			}
			else if((vtype.getSelectedItem()=="FAMILY CAR" || vtype.getSelectedItem()=="SMALL VAN") && ( (D.getYear()+1900-Integer.parseInt(tdyr.getText()) < 21) || (fu.getState()==false)) )
			{
				JOptionPane.showMessageDialog(fr,"To rent small van / Family Car\n1.Driver's age should be >21\n2.Driver should have Complete DL");	
			}
			else if((vtype.getSelectedItem()=="LUXURY CAR" || vtype.getSelectedItem()=="LARGE VAN") && ( (D.getYear()+1900-Integer.parseInt(tdyr.getText()) < 25) || (fu.getState()==false)) )
			{
				JOptionPane.showMessageDialog(fr,"To rent Luxury Car / Large Van\n1.Driver's age should be >25\n2.Driver should have Complete DL");	
			}
			else if(Integer.parseInt(tsyr.getText())>Integer.parseInt(teyr.getText()))
			{
				JOptionPane.showMessageDialog(fr,"Start Date to be < End Date");
			}
			else if(Integer.parseInt(tsyr.getText())==Integer.parseInt(teyr.getText()) && Integer.parseInt(smnth.getSelectedItem())>Integer.parseInt(emnth.getSelectedItem()))
			{
				JOptionPane.showMessageDialog(fr,"Start Date to be < End Date");
			}	
			else if(Integer.parseInt(tsyr.getText())==Integer.parseInt(teyr.getText()) && Integer.parseInt(smnth.getSelectedItem())==Integer.parseInt(emnth.getSelectedItem()) && Integer.parseInt(sdate.getSelectedItem())>Integer.parseInt(edate.getSelectedItem()))
			{
				JOptionPane.showMessageDialog(fr,"Start Date to be < End Date");
			}
			else if(Integer.parseInt(smnth.getSelectedItem())==2 && ( Integer.parseInt(sdate.getSelectedItem())>29 && Integer.parseInt(tsyr.getText())%4==0) )
			{
				JOptionPane.showMessageDialog(fr,"Invalid Start Date");
			}
			else if(Integer.parseInt(smnth.getSelectedItem())==2 && Integer.parseInt(sdate.getSelectedItem())>28 )
			{
				JOptionPane.showMessageDialog(fr,"Invalid Start Date");
			}
			else if((Integer)H.get(smnth.getSelectedItem())<Integer.parseInt(sdate.getSelectedItem()))
			{
				JOptionPane.showMessageDialog(fr,"Invalid Start Date");
			}
			else if(Integer.parseInt(emnth.getSelectedItem())==2 && ( Integer.parseInt(edate.getSelectedItem())>29 && Integer.parseInt(teyr.getText())%4==0) )
			{
				JOptionPane.showMessageDialog(fr,"Invalid End Date");
			}
			else if(Integer.parseInt(emnth.getSelectedItem())==2 && Integer.parseInt(edate.getSelectedItem())>28 )
			{
				JOptionPane.showMessageDialog(fr,"Invalid End Date");
			}
			else if((Integer)H.get(emnth.getSelectedItem())<Integer.parseInt(edate.getSelectedItem()))
			{
				JOptionPane.showMessageDialog(fr,"Invalid End Date");
			}
			else if(Integer.parseInt(dmnth.getSelectedItem())==2 && ( Integer.parseInt(ddate.getSelectedItem())>29 && Integer.parseInt(tdyr.getText())%4==0) )
			{
				JOptionPane.showMessageDialog(fr,"Invalid Driver's DOB");
			}
			else if(Integer.parseInt(dmnth.getSelectedItem())==2 && Integer.parseInt(ddate.getSelectedItem())>28 )
			{
				JOptionPane.showMessageDialog(fr,"Invalid Driver's DOB");
			}
			else if((Integer)H.get(dmnth.getSelectedItem())<Integer.parseInt(ddate.getSelectedItem()))
			{
				JOptionPane.showMessageDialog(fr,"Invalid End Date");
			}
			else if(hv.containsKey(String.format("%s%S%S%S",tr1.getText(),tr2.getText(),tr3.getText(),tr4.getText())))
			{
				JOptionPane.showMessageDialog(fr,"Selected Vehicle Out for Rent");
			}
			else if(hv.containsValue(tdid.getText()))
			{
				JOptionPane.showMessageDialog(fr,"Selected Driver Out on Duty");
			}
			else
			{
				write();
				
			}
			

		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(fr,e);
		}
	}
	public void write()
	{
		try
		{
			String str=tcname.getText()+" "+vtype.getSelectedItem()+" "+tr1.getText()+tr2.getText()+tr3.getText()+tr4.getText()+" "+sdate.getSelectedItem()+" "+smnth.getSelectedItem()+" "+tsyr.getText()+" "+edate.getSelectedItem()+" "+emnth.getSelectedItem()+" "+teyr.getText()+" "+cac.getState();
			
			PrintWriter pv=new PrintWriter(new FileWriter("rv.txt",true) );
			pv.println(str);
			pv.close();

			str=tdname.getText()+" "+ddate.getSelectedItem()+" "+dmnth.getSelectedItem()+" "+tdyr.getText()+" "+tdid.getText();
			
			PrintWriter pd=new PrintWriter(new FileWriter("rd.txt",true));
			pd.println(str);
			pd.close();

			tcname.setText("");
			tr1.setText("");
			tr2.setText("");
			tr3.setText("");
			tr4.setText("");
			tsyr.setText("");
			teyr.setText("");
			tdyr.setText("");
			tdid.setText("");
			tdname.setText("");
			cac.setState(false);	
			fu.setState(false);
			
			JOptionPane.showMessageDialog(fr,"Record Saved");

			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(fr,e);
		}
	}
}
			


class order extends JApplet implements ActionListener,ItemListener
{
	Choice C;
		
	JButton B;

	JTextArea T;
	
	JPanel P;

	java.awt.Font f;
	
	JLabel L;

	JFrame fr;

	
	public order()
	{
		try
		{
		PrintWriter x=new PrintWriter(new FileWriter("rv.txt",true));
		PrintWriter y=new PrintWriter(new FileWriter("rd.txt",true));

		x.close();
		y.close();
		
		C=new Choice();
		T=new JTextArea(15,50);
		P=new JPanel();
		B=new JButton(" SORT ");	
		L=new JLabel("                                             ");
		fr=new JFrame();

		f=new java.awt.Font("Papyrus",java.awt.Font.BOLD,25);	
		
		B.setFont(f);
		T.setFont(f);		

		B.addActionListener(this);
		C.addItemListener(this);
		
		C.add("Vehicle reg no");	
		C.add("Driver id");
		C.add("Vehicle name");
		C.add("Driver name");	
		
		B.setToolTipText("Click to sort Based on Selected Field");

		C.setFont(f);

		P.add(C);
		P.add(L);
		P.add(B);
		
		add(BorderLayout.NORTH,P);
		add(BorderLayout.CENTER,T);

		T.setEditable(false);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(fr,e);
		}		

	}
	public void actionPerformed(ActionEvent e)
	{
		sort(C.getSelectedItem());
	}
	public void itemStateChanged(ItemEvent e)
	{
		T.setText("");
		JOptionPane.showMessageDialog(fr,"You have chosen to sort\nBased on\n"+"\"   "+C.getSelectedItem()+"   \""+"\nClick on Sort to Start");
	}
	public void sort(String str)
	{
		try
		{
	
		BufferedReader r=new BufferedReader(new FileReader("rv.txt"));
		BufferedReader s=new BufferedReader(new FileReader("rd.txt"));
		String con="";
		
		
		if(str.equals("Vehicle reg no"))	
		{
			String ttl="\t\tList Based On Vehicle Registration Number(s)\n\n";	
			
			String st;
			
			ArrayList A=new ArrayList();	
			

			while( (st=r.readLine()) != null)
			{
				String st1[]=st.split(" "),st2=s.readLine();
				
				con=st1[3]+"  "+st1[0]+"  "+st1[1]+"  "+st1[2]+"  "+st1[4]+"  "+st1[5]+"  "+st1[6]+"  "+st1[7]+"  "+st1[8]+"  "+st1[9]+"  "+st1[10]+"\n";
				con+=st2;
				con+="\n---------------------------------------------------------------------------------------------------------------\n";
				
				A.add(con);	
			}

			if(A.size()!=0)
			{
				Collections.sort(A);
				con=ttl;
				for(int i=0;i<A.size();i++)
					con+=A.get(i);
				T.setText(con);;				
			}
			else
			{
				T.setText("");
				JOptionPane.showMessageDialog(fr,"No records found");
			}
		}
		else if(str.equals("Driver id"))
		{
					
			String ttl="\t\tList Based On Driver(s) id's\n\n";	
			
			String st;
			
			ArrayList A=new ArrayList();	
			

			while( (st=s.readLine()) != null)
			{
				String st1[]=st.split(" "),st2=r.readLine();
				
				con=st1[4]+"  "+st1[0]+"  "+st1[1]+"  "+st1[2]+"  "+st1[3]+"\n";
				con+=st2;
				con+="\n---------------------------------------------------------------------------------------------------------------\n";
				
				A.add(con);	
			}

			if(A.size()!=0)
			{
				Collections.sort(A);
				con=ttl;
				for(int i=0;i<A.size();i++)
					con+=A.get(i);
				T.setText(con);				
			}
			else
			{
				T.setText("");
				JOptionPane.showMessageDialog(fr,"No records found");
			}
	




		}
		else if(str.equals("Vehicle name"))
		{
			
			String ttl="\t\tList Based On Vehicle Name(s)\n\n";	
			
			String st;
			
			ArrayList A=new ArrayList();	
			

			while( (st=r.readLine()) != null)
			{
				String st1[]=st.split(" "),st2=s.readLine();
				
				con=st1[1]+"  "+st1[2]+"  "+st1[0]+"  "+st1[3]+"  "+st1[4]+"  "+st1[5]+"  "+st1[6]+"  "+st1[7]+"  "+st1[8]+"  "+st1[9]+"  "+st1[10]+"\n";
				con+=st2;
				con+="\n---------------------------------------------------------------------------------------------------------------\n";
				
				A.add(con);	
			}

			if(A.size()!=0)
			{
				Collections.sort(A);
				con=ttl;
				for(int i=0;i<A.size();i++)
					con+=A.get(i);
				T.setText(con);;				
			}
			else
			{
				T.setText("");
				JOptionPane.showMessageDialog(fr,"No records found");
			}

		}
		else if(str.equals("Driver name"))
		{
			String ttl="\t\tList Based On Driver Name(s)\n\n";	
			
			String st;
			
			ArrayList A=new ArrayList();	
			

			while( (st=s.readLine()) != null)
			{
				String st1[]=st.split(" "),st2=r.readLine();
				
				con=st1[0]+"  "+st1[1]+"  "+st1[2]+"  "+st1[3]+"  "+st1[4]+"\n";
				con+=st2;
				con+="\n---------------------------------------------------------------------------------------------------------------\n";
				
				A.add(con);	
			}

			if(A.size()!=0)
			{
				Collections.sort(A);
				con=ttl;
				for(int i=0;i<A.size();i++)
					con+=A.get(i);
				T.setText(con);;				
			}
			else
			{
				T.setText("");
				JOptionPane.showMessageDialog(fr,"No records found");
			}
		}

		r.close();
		s.close();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(fr,e);
		}
	}
	


} 

class ret extends JApplet implements ActionListener,ItemListener
{
	JLabel vid,erd,ard,nod,cd,fa;
	JTextField tvid,terd,tard,tnod,tmsg,tfa;
	JTextArea tcar;
	JButton B;
	java.awt.Font ft;		
	java.awt.Font fu;
	java.awt.Font f;
	java.awt.Font fi;
	java.awt.Font fo;	
	Hashtable fare;
	JFrame fr;

	long no=0;
	double cost=0;	

	ArrayList  L;
		
		
	Hashtable hv;

	public ret()
	{
		vid=new JLabel("       VEHICLE ID "); 
		erd=new JLabel("EXPECTED RETURN DATE    : ");
		ard=new JLabel(" ACTUAL  START DATE        : ");
		nod=new JLabel("     NO. OF DAYS                              : ");
		cd=new JLabel("CAR DETAILS");
		fa=new JLabel("TRAVEL FARE ");
		
		fr=new JFrame();

		tvid=new JTextField(20);
		terd=new JTextField(10);
		tard=new JTextField(10);
		tnod=new JTextField(4);
		tmsg=new JTextField(30);
		tfa=new JTextField(6);

		tcar=new JTextArea(3,50);
	
		B=new JButton("RETURN");
	
		L=new ArrayList();		

		hv=new Hashtable();
		fare=new Hashtable();
	

		ft=new java.awt.Font("Lucida Calligraphy",java.awt.Font.BOLD,20);
		fu=new java.awt.Font("Arial Rounded MT",java.awt.Font.BOLD,16);
		f=new java.awt.Font("Cooper",java.awt.Font.BOLD,16);
		fi=new java.awt.Font("Adobe Heiti Std",java.awt.Font.BOLD,30);
		fo=new java.awt.Font("Comic Sans MS",java.awt.Font.BOLD,15);	

		vid.setFont(ft);
		erd.setFont(fu);
		ard.setFont(fu);
		nod.setFont(fu);
		fa.setFont(fi);
		tfa.setFont(fi);
		tvid.setFont(f);
		cd.setFont(f);
		tcar.setFont(fo);
		tard.setFont(fu);
		terd.setFont(fu);
		tnod.setFont(fu);
		tmsg.setFont(fo);

		fare.put("SMALL CAR",30);
		fare.put("FAMILY CAR",40);
		fare.put("LUXURY CAR",150);
		fare.put("SMALL VAN",50);
		fare.put("LARGE VAN",70);
		
				
		B.addActionListener(this);

		setLayout(null);
		
		vid.setBounds(190,30,300,50);
		erd.setBounds(190,130,250,50);	
		ard.setBounds(190,180,250,50);
		nod.setBounds(170,220,270,50);
		cd.setBounds(190,260,270,50);
		fa.setBounds(190,380,400,200);		

		tvid.setBounds(500,43,200,25);
		terd.setBounds(500,143,200,25);	
		terd.setEditable(false);
		tard.setBounds(500,193,200,25);
		tard.setEditable(false);
		tnod.setBounds(500,233,200,25);
		tnod.setEditable(false);	
		tcar.setBounds(190,320,500,100);
		tcar.setEditable(false);
		tfa.setBounds(500,450,200,50);
		tfa.setEditable(false);
		tmsg.setBounds(190,550,600,25);
		tmsg.setEditable(false);

		B.setBounds(600,80,100,25);
	
		
		add(vid);
		add(erd);
		add(ard);		
		add(nod);
		add(cd);
		
		add(B);

		add(tvid);
		add(tard);
		add(terd);
		add(tnod);
		add(tcar);	
		add(fa);	
		
		add(tfa);
		add(tmsg);

		
		
	}
	public void actionPerformed(ActionEvent e)
	{
		check();
	}
	public void itemStateChanged(ItemEvent e)
	{
	
	}
	public void check()
	{
		try
		{
		PrintWriter pv=new PrintWriter(new FileWriter("rv.txt",true) );
		PrintWriter pd=new PrintWriter(new FileWriter("rd.txt",true) );
		pv.close();
		pd.close();
		
		BufferedReader ve=new BufferedReader(new FileReader("rv.txt"));
		BufferedReader di=new BufferedReader(new FileReader("rd.txt"));
			
		String x,y;

						
		while( (x=ve.readLine()) != null)
		{
			y=di.readLine();
			String xi[]=x.split(" ");
			String yi[]=y.split(" ");
			hv.put(xi[3],"\n    "+x+"\n\n    "+y);
			
			if( tvid.getText().compareTo(xi[3]) == 0 )
			{
				L.add(x);
				L.add(y);
			}
		}

		ve.close();
		di.close();

			
		if(tvid.getText().length()==0)
		{	reset();
			JOptionPane.showMessageDialog(fr,"VEHICLE ID TO BE ENTERED !");
		}
		else if(hv.containsKey(tvid.getText())==false)
		{
			JOptionPane.showMessageDialog(fr,"VEHICLE ID INVALID !");
			reset();
		}
		else
		{
			String s[]=((String)L.get(0)).split(" ");
			tcar.setText((String)hv.get(tvid.getText()));
			terd.setText("    "+s[7]+"  -  "+s[8]+"  -  "+s[9]);
			Date d=new Date();
			tard.setText("    "+s[4]+"  -  "+s[5]+"  -  "+s[6]);
			
			Date d1=new Date(Integer.parseInt(s[9])+1900,Integer.parseInt(s[8])+1,Integer.parseInt(s[7]));
			Date d2=new Date(Integer.parseInt(s[6])+1900,Integer.parseInt(s[5])+1,Integer.parseInt(s[4]));
			Date d3=new Date(d.getYear()+1900+1900,d.getMonth()+1+1,d.getDate());
					
			no=( (d1.getTime()-d2.getTime()) / (1000 * 60 * 60 * 24) ) + 1;

			long dis=0,pen=0,per;

			String ca=s[1]+" "+s[2];
			
			per= (Integer) fare.get(ca);
			cost=per*no;
		
			if((s[10].equals("true")) && (ca.equals("LUXURY CAR")==false))
			{
				cost += ( cost * 0.1);	
			}		
	
			long gap = ((d3.getTime()-d1.getTime()) / (1000 * 60 * 60 * 24));
			
			if(  gap == 0 )
			{
				tmsg.setText("Congratulations ! ! VEHICLE RETURNED ON DATE  [] no penalty [] "); 
			}
			else if(gap<0)
			{
				tmsg.setText("Congratulations ! ! VEHICLE RETURNED EARLY  [] discount applied [] ");
				dis= (d1.getTime()-d3.getTime()) / (1000 * 60 * 60 * 24) ;
				
				//tmsg.setText(Double.toString(cost));
		
				if(ca.equals("SMALL CAR"))
				{
					cost = cost - ( (dis)*(Integer)fare.get(ca)*1.0 ) ;		
				}
				else if(ca.equals("LUXURY CAR"))
				{
					cost -= ( (dis)*(Integer)fare.get(ca)*0.3 ) ;
				}
				else 
				{
					cost -= ( (dis)*(Integer)fare.get(ca)*0.5 ) ;
				}
				
						
			}
			else if(gap>0)
			{
				tmsg.setText("     Oops ! ! ! VEHICLE RETURNED LATE  [] penalty imposed [] ");
				pen= ( ( (d3.getTime()-d1.getTime() ) / (100*60*60*24) ) );
				
				//tmsg.setText(Long.toString(pen));

				if(ca.equals("LUXURY CAR"))
				{
					cost += ( (pen)*(Integer)fare.get(ca)*0.3 ) ;		
				}
				else 
				{
					cost += ( (pen)*(Integer)fare.get(ca)*0.2 ) ;
				}
			}		
	
			/*	calculating no. of days code should go here ...... 
				and fillin tfa text box with fare.... */
			
			tfa.setText("  £   "+String.format("%6.2f",cost));
			tnod.setText("     "+Long.toString( ( (d3.getTime()-d2.getTime() ) /  (1000*60*60*24) ) +1 ));
			L.clear();
			JOptionPane.showMessageDialog(fr," THANK YOU ! ! \n PLEASE PAY £ "+cost+" at the counter");
			adjust();		
		}		
	         }
		catch(Exception e)
		{
			tvid.setText("");
			JOptionPane.showMessageDialog(fr,e);
		}	


	}
	
	public void adjust() throws IOException
	{
		BufferedReader ve=new BufferedReader(new FileReader("rv.txt"));
		BufferedReader di=new BufferedReader(new FileReader("rd.txt"));
			
		String x,y,conrv="",conrd="";

		
				
		while( (x=ve.readLine()) != null)
		{
			y=di.readLine();
			String xi[]=x.split(" ");
			
			if( xi[3].compareTo(tvid.getText()) != 0)
			{
				conrv= conrv+x+"\n";
				conrd= conrd+y+"\n";
			}
		
		}
		
		PrintWriter pv=new PrintWriter(new FileWriter("rv.txt") );
		PrintWriter pd=new PrintWriter(new FileWriter("rd.txt") );
		
		pv.print(conrv);
		pd.print(conrd);
		
		pv.close();
		pd.close();
		
		ve.close();
		di.close();

		hv.remove(tvid.getText());

		reset();
	}
		
	public void reset()
	{
		tvid.setText("");terd.setText("");tard.setText("");tnod.setText("");
		tmsg.setText("");tfa.setText("");tcar.setText("");
		no=0;
		cost=0;
		L.clear();
	}
}


//<applet code="w" height=1000 width=1000> </applet>