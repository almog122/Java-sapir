import java.util.ArrayList;

//Almog Fadida 315544437
//Yair Nisa-El 206005373

public class company {
	
	//Attributes 
	private String idCom=null;
	private String name;
	private String user;
	private String pass;
	private ArrayList<publishAdv> advCom;
	
	
	//Constructor
	public company(String name, String user, String pass, int numOfAds) {
	
		if(set_name(name) && set_user(user) && set_pass(pass)) {
			this.advCom = new ArrayList<publishAdv>();
			set_idCompany("0");
		}		
		
		
	}
	
	
	
	//SETs
	
	public void set_idCompany(String id) {
		if( Integer.parseInt(id) >=0 )
			this.idCom = id;
		else
			this.idCom = "-1";
	}
	
	
	
	public boolean set_name(String name) {
		if(name != "") {
			this.name = name;
			return true;
		}
		return false; 
	}
	
	
	
	public boolean set_user(String user) {
		if(user != "") {
			this.user = user;
			return true;
		}
		return false;
	}
	
	
	
	public boolean set_pass(String pass) {
		if(name != "") {
			this.pass = pass;
			return true;
		}
		return false;
	}
	
	
		
	
	public void addAdv(publishAdv val) {
		advCom.add(val);
	}

	
	//GETs	
	
	public String getName() {
		return this.name;
	}

	
	public String getUser() {
		return this.user;
	}

	public String getPass() {
		return this.pass;
	}	
	
	public String getIdCompany() {
		return this.idCom != null ?  this.idCom : null ;
	}
	
	public int getSizeOfAdvCom() {
		return advCom.size();
	}
	
	public boolean getIsPublishById(String id) {
		for(publishAdv item : advCom) {
			if(item.get_adId() == id)
				return item.get_status();
		}
		return false;
	}
	
	
	
	public String[] getIdOfAllAds() {
		
		if(advCom.size() == 0)
			return null;
		
		String[] arr = null;
		arr = new String[advCom.size()];

		
		int i = 0;
		for(publishAdv com : advCom) {
			arr[i++] = com.get_adId();
		}
		
		return arr;
		
	}
	
	
	public ArrayList<publishAdv> getAllAds() {
		ArrayList<publishAdv> arr = null;
		int size = advCom.size();
		if(size == 0)
			return arr; //null
		
		arr = new ArrayList<publishAdv>();
		for(publishAdv item : advCom)
			arr.add(item);
		return arr;	
	}
	
}
