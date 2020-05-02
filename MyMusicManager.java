import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
class Node 
{
	  int id;
	String mName;
	String artist;
	int size;
	Node lc;
	Node rc;
	Node()
	{
		
	}
	Node(int id,String nm ,String artist,int size)
	{
		this.artist=artist;
		this.id=id;
		this.size=size;
		this.mName=nm;
		lc=null;
		rc=null;
	}
	
	
}
class MusicManager
{
	
	Node rNode;
	int id=0;
	//Scanner sc=new Scanner(System.in);
	BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
	 MusicManager()
	 {
		 rNode=null;								
	 }
	
	void create()
	{
		Node temp,ptr;
		String mName,artist;
		int ch,flag,size;
		Scanner sc=new Scanner(System.in);
		try
		{
			do
			{
				/*System.out.println("Enter id:");
				id=sc.nextInt();*/
				id=id+1;
				System.out.println("Enter Song name:");
				mName=buff.readLine();
				System.out.println("Enter size of song:");
				size=sc.nextInt();
				System.out.println("Enter Artist name:");
				artist=buff.readLine();
				temp=new Node(id,mName,artist,size);
				if(rNode==null)
				{
					rNode=temp;												//if it is First song
					System.out.println("Song added successfully");
				}
				else
				{
					ptr=rNode;
					flag=0;
					while(flag==0)											//do this untill flag=0
					{
						if(temp.mName.compareToIgnoreCase(ptr.mName)<0)		//if song name is less than root
						{
							if(ptr.lc==null)
							{
								ptr.lc=temp;								//if ptr.lc==null then attached song
								flag=1;
								
								System.out.println("Song added successfully");
							}
							else
							{
								ptr=ptr.lc;									//oterwise go to left side
								
							}
							
						}
						else if(temp.mName.compareToIgnoreCase(ptr.mName)>=0)			//if song name is greater than root
						{
							if(ptr.rc==null)
							{
								ptr.rc=temp;										//if ptr.rc==null then attached song
								flag=1;
								
								System.out.println("Song added successfully");
							}
							else
							{
								ptr=ptr.rc;											//oterwise go to Right side
							}
							
						}
					
					}
					
				}
				System.out.println("Do you want to continue 0 or 1");
				ch=sc.nextInt();
			}while(ch!=0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void shuffle(Node rNode)
	{
		if(rNode!=null)
		{
			shuffle(rNode.lc);																					//traverse Left
			System.out.print("\n"+rNode.id+"	"+rNode.mName+"			"+rNode.artist+"			"+rNode.size);		//diplay the Song data
			shuffle(rNode.rc);																					//traverse Right
			
		}
	}
	Node search()
	{
		Node ptr; 
		Node temp=new Node();
		Scanner sc=new Scanner(System.in);
		String mName,artist;
		ptr=rNode;
		int flag=0;
		try
		{
			System.out.println("Enter song name:");									//accept Song name
			mName=buff.readLine();
			System.out.println("Enter the artist name:");								//accept Song Artist
			artist=buff.readLine();
			while(ptr!=null)
			{
				
					if(mName.compareToIgnoreCase(ptr.mName)==0 && artist.compareToIgnoreCase(ptr.artist)==0 )			//check the name and artist name both are equal not
					{
						flag=1;														//if yes then break;
						break;			
					}
					else if(mName.compareToIgnoreCase(ptr.mName)<0 )
					{
						ptr=ptr.lc;													//if entered song name is less then ptr.songName then traverse left
					}
					else if(mName.compareToIgnoreCase(ptr.mName)>0)
					{
						ptr=ptr.rc;												//if entered song name is greater then ptr.songName then traverse right
					}
				
			}
			if(flag==1)
			{
				
				temp=ptr;														//if Song found then assign to temp to ptr
			}
			if(flag==0)
			{
				
				temp=null;														//if Song Not found then assign to temp to null
			}
		}
		catch(Exception e)
		{
			
		}
		return temp;
	}
	void update()
	{
		Node ptr; 
		Scanner sc=new Scanner(System.in);
		String mName,artist;
		int size;
		ptr=rNode;
		int flag=0;
		try
		{
			System.out.println("Enter song name:");					//accept Song name
			mName=buff.readLine();
			System.out.println("Enter the artist name:");
			artist=buff.readLine();										//accept Song Artist
			while(ptr!=null)
			{
				
					if(mName.compareToIgnoreCase(ptr.mName)==0)				//check the name are equal not
					{
						flag=1;
						break;
					}
					else if(mName.compareToIgnoreCase(ptr.mName)<0)
					{
						ptr=ptr.lc;											//if entered song name is less then ptr.songName then traverse left
						
					}
					else if(mName.compareToIgnoreCase(ptr.mName)>0)
					{
						ptr=ptr.rc;										//if entered song name is greater then ptr.songName then traverse left
						
					}
				
			}
			if(flag==1)
			{
				System.out.println("Enter new Artist name:");
				artist=sc.nextLine();
				ptr.artist=artist;										//if song fount then change its data
				System.out.println("Enter Song Size:");
				size=sc.nextInt();
				ptr.size=size;
				System.out.println("Sucessfully updated...");
				
			}
			else
			{
				System.out.println("Song Not found!!!");			//otherwise diplay "song Not Found"
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	Node insert(Node rNode,String nm,String artist,int s)
	{
		id=id+1;
		if(rNode==null)
		{
			Node temp;
			temp=new Node(id,nm,artist,s);									//if root==null then attached Song as a root node
			rNode=temp;
			return rNode;
		}
		else
		{
			if(nm.compareToIgnoreCase(rNode.mName)<0)
			{
				rNode.lc=insert(rNode.lc,nm,artist,s);					//if entered song name is less then ptr.songName then attached to left
			}
			else
			{
				rNode.rc=insert(rNode.rc,nm,artist,s);					//if entered song name is greater then ptr.songName then attached to rignt
			}
			
			return rNode;
		}
	}
	void addToFav(String nm,String artist,int s,int id)
	{
		Node ptr;
		int flag;
		Node temp=new Node(id,nm,artist,s);
		if(rNode==null)
		{
			
			rNode=temp;														//if it is First song
			System.out.println("Song added successfully");
		}
		else
		{
			ptr=rNode;
			flag=0;
			while(flag==0)											//do this untill flag=0
			{
				if(temp.mName.compareToIgnoreCase(ptr.mName)<0)			//if song name is less than root
				{
					if(ptr.lc==null)
					{
						ptr.lc=temp;
						flag=1;										//if ptr.lc==null then attached song
						System.out.println("Song added successfully");
					}
					else
					{
						ptr=ptr.lc;									//Otherwise Traverse left
						
					}
					
				}
				else if(temp.mName.compareToIgnoreCase(ptr.mName)>=0)			//if song name is greater than root
				{
					if(ptr.rc==null)
					{
						ptr.rc=temp;											//if ptr.rc==null then attached song
						flag=1;
						System.out.println("Song added successfully");
					}
					else
					{
						ptr=ptr.rc;												//Otherwise Traverse left
					}
					
				}
			
			}
			
		}
	}
	void delete()
	{
		Node ptr,parent; 
		Scanner sc=new Scanner(System.in);
		String mName,artist;
		int size;
		ptr=rNode;
		parent=rNode;
		int flag=0;
		try
		{
			System.out.println("Enter song to be Deleted:");
			mName=buff.readLine();											//Accpet song name
			while(ptr!=null)												//seached the song in Musiclist
			{
				
					if(mName.compareToIgnoreCase(ptr.mName)==0)
					{
						flag=1;	
						break;
						
					}
					else if(mName.compareToIgnoreCase(ptr.mName)<0)
					{
						parent=ptr;
						ptr=ptr.lc;
						
					}
					else if(mName.compareToIgnoreCase(ptr.mName)>0)
					{
						parent=ptr;
						ptr=ptr.rc;	
					}
				
			}
			if(flag==1)																	//if Song found in PlayList
			{
				if(ptr.lc==null && ptr.rc==null)										//if the song is Leaf node
				{
					if(parent.lc==ptr)
					{
						parent.lc=null;													
						id=id-1;														//if it is at left child of Parent then parent.lc=null
						System.out.println("Song deleted Sucessfully....");
					}
					else
					{
						parent.rc=null;
						id=id-1;
						System.out.println("Song deleted Sucessfully....");				//if it is at Right child of Parent then parent.lc=null
					}
				}
				else if(ptr.lc!=null && ptr.rc==null)									//if only left Child and no right child
				{
					if(parent.lc==ptr)
					{
						parent.lc=ptr.lc;											//if ptr or searched song is at left side of parent 
						id=id-1;
						System.out.println("Song deleted Sucessfully....");
					}
					else
					{
						parent.rc=ptr.lc;
						id=id-1;														//if ptr or searched song is at right side of parent 
						System.out.println("Song deleted Sucessfully....");
					}
				}
				else if(ptr.rc!=null && ptr.lc==null)									//if it having Right child and No right child
				{
					if(parent.lc==ptr)
					{
						parent.lc=ptr.rc;														//if ptr or searched song is at left side of parent 
						id=id-1;
						System.out.println("Song deleted Sucessfully....");
					}
					else
					{
						parent.rc=ptr.rc;
						id=id-1;																//if ptr or searched song is at right side of parent 
						System.out.println("Song deleted Sucessfully....");
					}
					
				}
				else if(ptr.lc!=null && ptr.rc!=null)										//if it having Both child
				{
					
					if(parent.lc==ptr)
					{																		//if ptr or searched song is at left side of parent 
						Node p=ptr.rc;														//go the right
						while(p.lc!=null)
						{
							parent=p;														//then travere left untill leaf node
							p=p.lc;
						}
						if(parent!=null)
						{
							ptr.mName=p.mName;
							ptr.artist=p.artist;											//copy the leaf node data to Seached Node 
							ptr.size=p.size;
							ptr.id=p.id;
							parent.lc=p.rc;
							p=null;
							id=id-1;
							System.out.println("Song deleted Sucessfully....");
						}
					}
					else																	//if ptr or searched song is at left side of parent 
					{
						Node p=ptr.lc;														//go the Left
						while(p.rc!=null)
						{
							parent=p;														//then travere right untill leaf node
							p=p.rc;
						}
						if(parent!=null)
						{
							ptr.mName=p.mName;
							ptr.artist=p.artist;
							ptr.size=p.size;											//copy the leaf node data to Seached Node
							parent.rc=p.lc;
							p=null;
							System.out.println("Node deleted Sucessfully....");
						}
					}
				}
			}
			else
			{
				System.out.println("Song Not Found in PlayList");
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
public class MyMusicManager
{
	public static void main(String[] args) 
	{
		MusicManager b=new MusicManager();
		MusicManager m=new MusicManager();
		System.out.println("______________WELL-COME TO MUSIC MANAGER__________");
		BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		int ch,op;
		do
		{
			System.out.println("\n\t1.Create music list \n\t2.Display Music list\n\t3.Insert new song in list\n\t4.Search song in list\n\t5.Update a song information in list\n\t6.Delete song from list\n\t7.Add to Favourite\n\t8.Display Favourite List");
			System.out.println("\nEnter your choice:");
			op=sc.nextInt();
			switch(op)
			{
			case 1:
					b.create();
					break;
			case 2:
					System.out.println("\nId	Song Name				Artist			Size	");
					b.shuffle(b.rNode);
					break;
			case 3:
					String songName,artist;
					int size;
					try
					{
						System.out.println("Enter Song Name:");
						songName=buff.readLine();
						System.out.println("Enter Artist:");
						artist=buff.readLine();
						System.out.println("Enter Size:");
						size=sc.nextInt();
						Node inserted=b.insert(b.rNode,songName,artist,size);
						System.out.println("Song added in list Sucessfully!!!");
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					break;
			case 4:
					Node search=b.search();
					if(search!=null)
					{
						System.out.println("id          : "+search.id);
						System.out.println("Song Name is: "+search.mName);
						System.out.println("Artist      : "+search.artist);
						System.out.println("Size        : "+search.size);
					}
					else
					{
						System.out.println("Not Found!!!! ");
					}
					break;
			case 5:
					b.update();
					break;
			case 6:
					b.delete();
					break;
			case 7:
					Node searched=b.search();
					//System.out.println(searched.mName);
					m.addToFav( searched.mName,searched.artist,searched.size,searched.id);
					break;
			case 8:
					m.shuffle(m.rNode);
					break;
			default:
					System.out.println("Something went wrong......");
			}
			System.out.println("\nDo you want to continue '0' or'1'");
			ch=sc.nextInt();
		}while(ch!=0);
		
	}
	
}
