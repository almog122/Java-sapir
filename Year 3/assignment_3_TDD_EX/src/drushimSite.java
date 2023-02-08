import java.util.ArrayList;
//Almog Fadida 315544437
//Yair Nisa-El 206005373

public class drushimSite implements DrushimBridge {
	
	//attributes
	
	//domain , role and area
	private ArrayList<String> domainArr;
	private ArrayList<String> roleArr;
	private ArrayList<String> areaArr;
	
	
	//company and ads
	private ArrayList<company> companyArr;
	private ArrayList<publishAdv> adsArr;
	
	private static int comID = 0;
	private static int adID = 0;
	
	
	drushimSite(){
		this.domainArr = new ArrayList<String>();
		this.roleArr = new ArrayList<String>();
		this.areaArr = new ArrayList<String>();
		this.companyArr = new ArrayList<company>();
		this.adsArr = new ArrayList<publishAdv>();
	}
	
	//adding new domain
	public void addDomain(String string) {
		this.domainArr.add(string);
	}
	
	//adding new role
	public void addRole(String string) {
		this.roleArr.add(string);
	}
	
	//adding new area
	public void addArea(String string) {	
		this.areaArr.add(string);
	}
	
	/**
	 * @param name - Company name
	 * @param user - Username
	 * @param pass - Password
	 * @param numOfAds - number of ads
	 * @return company ID if succeed. Otherwise null
	 */
	public String addCompany(String name, String user, String pass, int numOfAds) {
		
		company com = new company(name, user, pass, numOfAds);
		
		//Check that the company doesn't already exist
		if(com.getIdCompany() == "0" ) {
			
			drushimSite.comID++;
			com.set_idCompany(String.valueOf(comID));
			
			this.companyArr.add(com);
			
			return com.getIdCompany();
			
		} else 
			return null;
	}
	
	/**
	 * Search company ID by company name
	 * @param name
	 * @return company ID if found. Otherwise null
	 */
	public String getCompanyId(String name) {
		
		for(company com : this.companyArr) {
			
			String comName = com.getName();
			
			if(comName == name)
				return com.getIdCompany();		
		}
		
		return null;
	}
	
	/**
	 * Get your company credit
	 * @param user - company username
	 * @param pass - company password
	 * @return amount of ads can be published
	 */
	public int getMyCredit(String user, String pass) {
		
		int num = -1;//In case we didn't found the company
		
		for(company com : this.companyArr)
			if(com.getUser() == user && com.getPass() == pass)
					num = com.getSizeOfAdvCom();
		
		return num;
	}
	
	/**
	 * Add new ad
	 * @param user - company username
	 * @param pass - company password
	 * @param domain - ad domain
	 * @param role - ad title
	 * @param desc - ad description
	 * @param area - job area
	 * @return ad ID if succeed. Otherwise null.
	 */
	public String addNewAd(String user, String pass, String domain, String role, String desc, String area) {
		
		for(company com : this.companyArr)
			if(com.getUser() == user && com.getPass() == pass) {
				
				int id;
				
				if(set_domain(domain) && set_role(role) && set_area(area)) { 
					
					publishAdv newAd = new publishAdv(domain, role, desc, area);
					
					if(newAd != null) {

						id = ++adID;
						
						newAd.set_adId(String.valueOf(id));
						
						//add new ad
						adsArr.add(newAd);
						
						//add ad to company
						com.addAdv(newAd);
						
						//return ad id
						return String.valueOf(id);
	
					}			
				}	
			}
		
		return null;
	}
	
	/**
	 * get all company's ads ids
	 * @param user - company username
	 * @param pass - company password
	 * @return array of ads' ids.
	 */
	public String[] getMyAdsIds(String user, String pass) {
		
		String[] arr = null;
		
		for(company com : this.companyArr)
			if(com.getUser() == user && com.getPass() == pass) {
				arr = com.getIdOfAllAds();
			}	
		
		return arr;
	}
	
	/**
	 * Filter all open ads by role/doamin/area
	 * If a filter field is not null the returned ads' fields must be equal to filter fields. 
	 * Example: search by role:  searchAds("...",null,null)
	 * Example: search by area and role:  searchAds("...",null,"...")
	 * Example: get all open ads:  searchAds(null,null,null)
	 * @param domain
	 * @param role
	 * @param area
	 * @return Array of ads' ids. If one of the arguments are wrong, return NULL.
	 */
	public String[] getAds(String domain, String role, String area) {
		
		String[] adsArr = null;
		ArrayList<publishAdv> temp = null;
		
		searchJob search = new searchJob(domain, role, area);
		
		//open ads
		if(domain == null && role == null && area == null) {
			int i = 0;
			temp = search.filterOpenOnly(); 
			
			if(temp.size() == 0)
				return null;
			
			adsArr = new String[temp.size()];
			
			for(publishAdv ad : temp) {
				adsArr[i] = ad.get_adId();
				i++;
			}
			
		} else {
			int i = 0;
			
			temp = new ArrayList<publishAdv>();
			
			temp = search.searchAd();
			
			if(temp.size() == 0)
				return null;
			
			adsArr = new String[temp.size()];
			
			for(publishAdv val : temp) {
				adsArr[i] = val.get_adId();
				i++;
			}
		}
		
		return adsArr;
	}

	
	
	/**
	 * get Ad information
	 * @param id ad id
	 * @return array contains ad information
	 * [ "company id", "domain", "role", "desc", "area", "status"]
	 */
	public String[] getAd(String id) {
		
		String[] infoOfAd = null;
		
		for(company com : this.companyArr) {
			
			ArrayList<publishAdv> allComAds = com.getAllAds();
			
			int size = allComAds.size();
			
			if(size != 0)
				for(publishAdv ad : allComAds)
					
					if(ad.get_adId() == id) {
						
						infoOfAd = new String[6];
						infoOfAd[0] = com.getIdCompany(); //company id
						infoOfAd[1] = ad.get_domain(); //domain
						infoOfAd[2] = ad.get_role(); //role
						infoOfAd[3] = ad.get_desc(); //desc
						infoOfAd[4] = ad.get_area(); //area
						infoOfAd[5] = String.valueOf( ad.get_status() ); //status
					}
		}
		
		return infoOfAd; 
		
	}
	
	
	
	/**
	 * Close ad
	 * @param user company's username
	 * @param pass company's password
	 * @param id - ad's id
	 * @return TRUE if succeed. Otherwise FALSE
	 */
	public boolean closeAd(String user, String pass, String id) {
		
		for(company com : this.companyArr)
			if(com.getUser() == user && com.getPass() == pass) {
				return com.getIsPublishById(id);
			}
		return false;
		
	}
	
	//setters
	private boolean set_domain(String domain){
		for(String dom : this.domainArr)
			if(dom == domain)
				return true;
		
		return false;
	}
	
	private boolean set_role(String role){
		for(String rol : this.roleArr)
			if(rol == role)
				return true;
		
		return false;
	}
	
	private boolean set_area(String area){
		for(String ar : this.areaArr)
			if(ar == area)
				return true;
		
		return false;
	}
	
}
