import java.util.ArrayList;

public class RealBridge implements DrushimBridge {
	
	//Attributes
		private ArrayList<String> listDomain;//Domain
		private ArrayList<String> listRole;//Role
		private ArrayList<String> listArea;//Area
		
		private static int idCompany=0;
		private static int adId=0;
		private ArrayList<company> COMPANIES;
		private ArrayList<publishAdv> ADVs;//All advs in the Drushim site
		
		
		DrushimSite(){
			this.listDomain = new ArrayList<String>();
			this.listRole = new ArrayList<String>();
			this.listArea = new ArrayList<String>();
			
			this.COMPANIES = new ArrayList<company>();
			this.ADVs = new ArrayList<publishAdv>();
		}
		
		
		public void addDomain(String string) {
			this.listDomain.add(string.toUpperCase());
		}
		
		
		public void addRole(String string) {
			this.listRole.add(string.toUpperCase());
		}
		
		
		public void addArea(String string) {	
			this.listArea.add(string.toUpperCase());
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
		
			if(com.getIdCompany() == "0" ) {
				DrushimSite.idCompany++;
				int idTemp = DrushimSite.idCompany;
				com.set_idCompany(String.valueOf(idTemp));
				this.COMPANIES.add(com);
				return com.getIdCompany();
			} else 
				return com.getIdCompany();
		}

		
		
		/**
		 * Search company ID by company name
		 * @param name
		 * @return company ID if found. Otherwise null
		 */
		public String getCompanyId(String name) {
			
			for(company item : this.COMPANIES) {
				String objName = item.getName();
				if(objName == name)
					return item.getIdCompany();		
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
			
			int res = 0;
			for(company item : this.COMPANIES)
				if(item.getUser() == user && item.getPass() == pass)
					if(item.getNumOfAds() > 0) {
						res = item.getNumOfAds()-(item.getNumCurrectAdvs());
						int result = (res > 0) ? res : 0;
						return result;
					}//End-Condition
			return -1; //company did not find
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
		public String addNewAd(String user, String pass,
							   String domain, String role, String desc, String area) {
			for(company item : this.COMPANIES)
				if(item.getUser() == user && item.getPass() == pass) {
					int flag = 1;
					flag *= set_domain(domain);
					flag *= set_role(role);
					flag *= set_area(area);	
					//Addition check credit 
					if(item.getMyCredit() > 0)
						flag *= 1;
					else
						flag = 0;
					//Check domain, role, area contains in above lists
					int currectId;
					if(flag == 1) { 
						publishAdv objAd = new publishAdv(domain, role, desc, area);
						if(objAd != null) {
							DrushimSite.adId++;
							currectId = DrushimSite.adId;
							objAd.set_adId(String.valueOf(currectId));
							
							//add ad to ADVs
							ADVs.add(objAd);
							
							//add ad to current company
							if(item.addAdv(objAd))
								return String.valueOf(currectId);
							return null;		
						}			
					}//End-flag-Condition		
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
			String[] arr=null;
			int size=0;
			for(company item : this.COMPANIES)
				if(item.getUser() == user && item.getPass() == pass) {
					size = item.getStringAllAds().length;
					if(size == 0)
						return null;
					arr = new String[size];
					int i = 0;
					for(String val : arr) {
						arr[i] = val;
						i++;
					}
					break;
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
			
			//all open ads only
			if(domain == null && role == null && area == null) {
				int i = 0;
				temp = new ArrayList<publishAdv>();
				temp = search.searchOpenOnly(); 
				if(temp.size() == 0)
					return adsArr; //null 
				adsArr = new String[temp.size()];
				
				for(publishAdv val : temp)
					adsArr[i] = val.get_adId();
				
			} else {
				int i = 0;
				temp = new ArrayList<publishAdv>();
				temp = search.searchByTwo();
				if(temp.size() == 0)
					return adsArr; //null
				adsArr = new String[temp.size()];
				
				for(publishAdv val : temp)
					adsArr[i] = val.get_adId();
			}//End-else-condition
			
			return adsArr;
		}

		
		
		/**
		 * get Ad information
		 * @param id ad id
		 * @return array contains ad information
		 * [ "company id", "domain", "role", "desc", "area", "status"]
		 */
		public String[] getAd(String id) {
			
			String[] infoAd = null;
			for(company item : this.COMPANIES) {
				ArrayList<publishAdv> allAdvs = item.getAllAds();
				int size = allAdvs.size();
				if(size != 0)
					for(publishAdv val : allAdvs)
						if(val.get_adId() == id) {
							infoAd = new String[6];
							infoAd[0] = item.getIdCompany(); //company id
							infoAd[1] = val.get_domain(); //domain
							infoAd[2] = val.get_role(); //role
							infoAd[3] = val.get_desc(); //desc
							infoAd[4] = val.get_area(); //area
							infoAd[5] = String.valueOf( val.get_status() ); //status
						}
			}//End-company-loop
			return infoAd; //return null
			
		}
		
		
		
		/**
		 * Close ad
		 * @param user company's username
		 * @param pass company's password
		 * @param id - ad's id
		 * @return TRUE if succeed. Otherwise FALSE
		 */
		public boolean closeAd(String user, String pass, String id) {
			
			for(company item : this.COMPANIES)
				if(item.getUser() == user && item.getPass() == pass) {
					return item.getIsPublishById(id);
				}
			return false;
			
		}
		
		
		
		//Assistant methods
		private int set_domain(String domain){
			for(String val : this.listDomain)
				if(val == domain)
					return 1;
			return 0;
		}
		
		private int set_role(String role){
			for(String val : this.listRole)
				if(val == role)
					return 1;
			return 0;
		}
		
		private int set_area(String area){
			for(String val : this.listArea)
				if(val == area)
					return 1;
			return 0;
		}
}
