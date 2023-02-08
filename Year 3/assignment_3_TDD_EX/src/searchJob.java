import java.util.ArrayList;
//Almog Fadida 315544437
//Yair Nisa-El 206005373

public class searchJob {
	//attributes
	private ArrayList<publishAdv> jobs;
	private String domain;
	private String role; 
	private String area;
	
	
	//constructor
	searchJob(String domain, String role, String area){
		jobs = new ArrayList<publishAdv>();
		
		set_domain(domain);
		set_role(role);
		set_area(area);
	}
	
	
	//sets
	private void set_domain(String str) {
		if(str == "")
			this.domain = null;
		else
			this.domain = str;
	}
	
	
	private void set_role(String str) {
		if(str == "")
			this.role = null;
		else
			this.role = str;
	}
	
	
	private void set_area(String str) {
		if(str == "")
			this.area = null;
		else
			this.area = str;
	}
	
	
	
	//gets
	public ArrayList<publishAdv> getAllJobs() {
		return jobs;
	}
	
	
	//methods
	
	public void addJob(publishAdv ad) {
		jobs.add(ad);
	}
	
	public boolean containId (String id) {
		
		for(publishAdv ad : jobs)
			if(ad.get_adId() == id)
				return true;
		
		return false;
	}
	
	
	//filter ad with area
	public ArrayList<publishAdv> filterByArea(String area){
		
		ArrayList<publishAdv> areaArr = new ArrayList<publishAdv>();
		
		for(publishAdv ad : jobs)
			if(ad.get_area() == area)
				areaArr.add(ad);
		
		return areaArr;
		
	}
	
	
	//filter ad with role
	public ArrayList<publishAdv> filterByRole(String role){
		
		ArrayList<publishAdv> roleArr = new ArrayList<publishAdv>();
		
		for(publishAdv ad : jobs)
			if(ad.get_role() == role)
				roleArr.add(ad);
		
		return roleArr;
		
	}
	
	//filter ad with domain
	public ArrayList<publishAdv> filterByDomain(String domain){
		
		ArrayList<publishAdv> domainArr = new ArrayList<publishAdv>();
		
		for(publishAdv ad : jobs)
			if(ad.get_domain() == domain)
				domainArr.add(ad);
		
		return domainArr;
		
	}
	
	//filter ad with available
	public ArrayList<publishAdv> filterOpenOnly(){
		
		ArrayList<publishAdv> openArr = new ArrayList<publishAdv>();
		
		for(publishAdv ad : jobs)
			if(ad.get_status() == true)
				openArr.add(ad);
		
		return openArr;
		
	}
	
	public ArrayList<publishAdv> searchAd(){
		
		ArrayList<publishAdv> arr = new ArrayList<publishAdv>();
		
		//domain And role
		if( (domain != null) && (role != null) && ( area == null) ){	
			for(publishAdv item : jobs)
				if(item.get_domain() == domain || item.get_role() == role)
					if(item.get_status() == true)
						arr.add(item);	
		}
		
		//domain And area
		else if( (domain != null) && (role == null) && ( area != null) ){	
			for(publishAdv item : jobs)
				if(item.get_domain() == domain || item.get_area() == area)
					if(item.get_status() == true)
						arr.add(item);	
		}
	
		//role And area
		else if( (domain == null) && (role != null) && ( area != null) ){		
			for(publishAdv item : jobs)
				if(item.get_role() == role || item.get_area() == area)
					if(item.get_status() == true)
						arr.add(item);	
		}
		
		return arr;
	}
	
	
}
