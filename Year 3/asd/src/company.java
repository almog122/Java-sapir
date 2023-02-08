import java.util.ArrayList;
public class company {
	
	//attributes 
	private String name; //company name
	private String user;//company username
	private String pass;//company password
	private int adsNum = 0;//company number of ads published
	private String idCom;//company id
	private publishAdv[] advCom;//company published ads
	
	
	//constructor
	public company(String name, String user, String pass, int numOfAds) {
		
		//if all fields are correct value
		if(set_name(name) && set_user(user) && set_pass(pass) && set_adsNum(numOfAds)) {
			this.advCom = new publishAdv[0];
			set_idCompany("0");
		}
		
		//if one of the fields is incorrect value
		set_idCompany(null);
	
	}
	
	
	
	//setters
	
	public void set_idCompany(String id) {
		if( Integer.parseInt(id) >=0 )
			this.idCom = id;
		else
			this.idCom = null;
	}
	
	
	
	public boolean set_name(String name) {
		if(name != "" || name != null) {
			this.name = name;
			return true;
		}
		return false; 
	}
	
	
	
	public boolean set_user(String user) {
		if(user != ""|| user != null) {
			this.user = user;
			return true;
		}
		return false;
	}
	
	
	
	public boolean set_pass(String pass) {
		if(name != "" || name != null) {
			this.pass = pass;
			return true;
		}
		return false;
	}
	
	
	
	public boolean set_adsNum(int adsNum) {
		if(adsNum > 0) {
			this.adsNum = adsNum;
			return true;
		}
		return false;
	}
	
	
	
	public boolean addAdv(publishAdv ad) {
		publishAdv[] temp = new publishAdv[advCom.length + 1];
		
		if(advCom.length >= 0) {
			for(int i = 0; i < advCom.length; i++) {
				temp[i] = advCom[i];
			}
			temp[temp.length - 1] = ad;
			return true;
		}
		return false;
			
	}
	
	
	
	
	//gets
	
	public String getName() {
		return this.name;
	}
	
	
	
	public String getUser() {
		return this.user;
	}
	
	
	
	public String getPass() {
		return this.pass;
	}
	
	
	
	public int getAdsNum() {
		return this.adsNum;
	}
	
	
	
	public String getIdCompany() {
		return this.idCom != null ?  this.idCom : null ;
	}
	
	
	
	public int getNumCurrectAdvs() {
		return advCom.length;
	}
	
	
	
	public int getMyCredit() {
		return (this.adsNum - advCom.length);
	}
	
	
	
	public boolean getIsPublishById(String id) {
		for(publishAdv item : advCom) {
			if(item.get_adId() == id)
				return item.get_status();
		}
		return false;
	}
	
	
	
	public String[] getStringAllAds() {
		int size = advCom.length;
		if(size == 0)
			return null;
		String[] arr = null;
		arr = new String[size];
		int ind=0;
		for(publishAdv item : advCom) {
			arr[ind] = item.get_adId();
			ind++;
		}
		return arr;
		
	}
	
	
	public ArrayList<publishAdv> getAllAds() {
		ArrayList<publishAdv> arr = null;
		int size = advCom.length;
		if(size == 0)
			return arr; //null
		
		arr = new ArrayList<publishAdv>();
		for(publishAdv item : advCom)
			arr.add(item);
		return arr;	
	}
	
}
