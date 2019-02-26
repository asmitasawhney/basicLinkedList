import java.io.*; 
import java.util.*;
class Assignment3
{
	public static void main(String args[]) throws Exception
	{
		String file = args[0];	

		LinkedList<String[]> listobj = new LinkedList<String[]>();
		//ArrayList<String> arraylist= new ArrayList<String>();
		String [] parts;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) 
		{
 		   String line;
		   boolean flag=false;
		   while ((line = br.readLine()) != null) 
		   {
		       parts = line.split(" ");
		       switch(parts[0])
		       {
				case "insert":
					listobj.add(Arrays.copyOfRange(parts, 1, parts.length));
					System.out.println("Record added: " +parts[1]+ " -> " +parts[2]);
					break;

				case "delete":
					flag=false;
					for(String[] str : listobj)
					{
						if(str[0].equals(parts[1]))
						{
							listobj.remove(str);
							System.out.println("Data entry with index " +str[0]+ " removed");
							flag=true;
						}
	
					}
					if(!flag)
                                                System.out.println("Record with index " +parts[1]+ " not found");

					break;

				case "update":
					flag=false;
					String [] tmp = Arrays.copyOfRange(parts, 1, parts.length);
					int i=0;
					for(String[] str : listobj)
	                                {
        	                        	if(str[0].equals(parts[1]))
                	                        {
                                                       	listobj.set(i, tmp);
							i++;
	                                                System.out.println("Data entry with index " +str[0]+ " updated");
							flag=true;
                        	                }
                                	}
					if(!flag)
                                                System.out.println("Record with index " +parts[1]+ " not found");

					break;

				case "search":

					flag=false;
					for(String[] str : listobj)
                                        {
                                                if(str[0].equals(parts[1]))
                                                {
                                                        System.out.println("Requested data: " +str[0]+ " -> " +str[1]);
							flag=true;
                                                }

                                        }
					if(!flag)
						System.out.println("Record with index " +parts[1]+ " not found");

					break;

				default:
					System.out.println("Invalid option");
		       }

    		   }
		}
		catch (Exception e)
		{
			System.out.println("Error reading file");
		}

	}
}
