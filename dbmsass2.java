import java.util.*;
import java.io.*;

class transaction implements Runnable {
	int n;
	database db;
	
	public transaction(database db) {
		this.db=db;
	}
    
	
	
	public void run() {
		Random s=new Random();
		int p=s.nextInt(5)+1;
		if (this.n==1) {
			int fno=s.nextInt(10)+1;
			int pid=s.nextInt(50)+1;
			this.reserve(this.db.arr.get(fno-1),pid);
			
		}
		
		else if (this.n==2) {
			int fno=s.nextInt(10)+1;
			int pid=s.nextInt(50)+1;
			this.cancel(this.db.arr.get(fno-1),pid);
			
			
		}
		
		else if (this.n==3) {
			int pid=s.nextInt(50)+1;
			
			
		}
		
		else if (this.n==4) {
			
			int sum=this.total_res(this.db);
			
		}
		
		else if (this.n==5) {
			int fno1=s.nextInt(10)+1;
			int fno2=fno1;
			while (fno2==fno1) {
				fno2=s.nextInt(10)+1;
				
			}
			int pid=s.nextInt(50)+1;
			this.transfer(this.db.arr.get(fno1-1),this.db.arr.get(fno2-1),pid);
		}
	}
	
	public ArrayList<Integer> my_flights(int id){
		ArrayList<Integer> m=new ArrayList<Integer>();
		for (int k=0;k<this.db.arr.size();k++) {
			for (int kk=0;kk<this.db.arr.get(k).cap;kk++) {
				if (this.db.arr.get(k).arr[kk].id==id) {
					m.add(k);
					break;
					
				}
				
			}
		}
		return m;
		
	}
	
	public int total_res(database db) {
		int sum=0;
		for (int y=0;y<db.arr.size();y++) {
			sum+=db.arr.get(y).filledcap;
			
		}
		return sum;
		
	}
	
	public void transfer(flight g,flight h,int pid) {
		if (h.filledcap==h.cap) {
			return;
		}
		int m=0;
		for (int k=0;k<g.cap;k++) {
			if (g.arr[k].id==pid) {
				m=1;
				break;
			}
			
		}
		if (m==0) {
			return;
		}
		
		cancel(g,pid);
		reserve(h,pid);
		
	}
	
	public void cancel(flight g,int pid) {
		for (int y=0;y<g.cap;y++) {
			if (g.arr[y].id==pid) {
				g.arr[y].id=-1;
				g.filledcap-=1;
				break;
				}
				
			}
		
	}
	
	public void reserve(flight g,int pid) {
		int l=0;
		for (int y=0;y<g.cap;y++) {
			if (g.arr[y].id==pid) {
				l=1;
				break;
				
			}
		}
		if (l==0) {
			for (int y=0;y<g.cap;y++) {
				if (g.arr[y].id==-1) {
					g.arr[y].id=pid;
					g.filledcap+=1;
					break;
				}
				
					
					
				}
		}
		
	}
	
	
}

class database{
	ArrayList<flight> arr;
	//ArrayList<Integer> passengers;
	public database () {
		this.arr=new ArrayList<flight>();
		//this.passengers=new ArrayList<Integer>();
	}
	
	
}

class flight{
	int no;
	int cap;
	int filledcap;
	seat[] arr;
	
	public flight (int cap,int no) {
		this.no=no;
		this.cap=cap;
		this.filledcap=0;
		this.arr=new seat[cap];
		
	}
}

class seat{
	int id;
	public seat() {
		this.id=-1;
	}
	
    public void reserve_seat(int id) {
    	this.id=id;
    }
    
    public void unreserve_seat() {
    	this.id=-1;
    }
}






public class dbmsass2 {

	public static void main(String[] args) {
		

	}

}
