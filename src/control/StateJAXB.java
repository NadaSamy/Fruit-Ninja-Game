package control;


import java.io.*;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class StateJAXB {
	
	ReadXml readXml;
	public  List<GameState> list=new ArrayList<GameState>();

	public void readXML(JAXBContext jc) throws JAXBException
	{
		Unmarshaller unmarshaller=jc.createUnmarshaller();
		 readXml=(ReadXml) unmarshaller.unmarshal(new File("Fruit.xml"));
		 list=readXml.getGameList();
		if(readXml.getGameList().isEmpty())
		{
			System.out.println("list is empty");
			
		}
		else {
			for(int i=0; i<readXml.getGameList().size();i++)
			{
				//System.out.println("best score "+ readXml.getGameList().get(i).getBest_score());

			}
		}
	}
	
	
public List<GameState> getList() {
		return list;
	}


public static void writeXml(JAXBContext jc,List<GameState>  list) 
{
	ReadXml read =new ReadXml();
	read.setGameList(list);
	
		
		try {
			Marshaller  marshaller = jc.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			OutputStream output=new FileOutputStream("Fruit.xml");
			marshaller.marshal(read, output);
		} catch (JAXBException e) {
			e.printStackTrace();
			System.out.println("error jaxb catch1");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("error jaxb catch2");

		}   
		
		
				
	
}

}
