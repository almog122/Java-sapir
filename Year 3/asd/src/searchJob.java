import java.util.ArrayList;

public class searchJob {
	//Attributes
	private publishAdv[] jobs;
	private String domain;
	private String role; 
	private String area;
	
	
	//CONSTRUCTOR
	searchJob(String domain, String role, String area){
		jobs = new publishAdv[0];
		
		set_domain(domain);
		set_role(role);
		set_area(area);
	}
	
	
	//SETs
	private void set_domain(String str) {
		if(str == "")
			this.domain = str;
		else
			this.domain = str;
	}
	
	
	private void set_role(String str) {
		if(str == "")
			this.role = str;
		else
			this.role = str;
	}
	
	
	private void set_area(String str) {
		if(str == "")
			this.area = str;
		else
			this.area = str;
	}
	
	
	
	//gets
	public publishAdv[] getJobs() {
		return jobs;
	}
	
	
	
	//methods
	public void addJob(publishAdv ad) {

		String domain = ad.get_domain();
		String role = ad.get_role();
		String desc = ad.get_desc();
		String area = ad.get_area();
	
		publishAdv newAd = new publishAdv(domain, role, desc, area); 
		
		publishAdv[] temp = new publishAdv[jobs.length + 1];
		
		for(int i = 0; i < jobs.length; i++) 
			temp[i] = jobs[i];
			
		temp[temp.length - 1] = newAd;
		
		jobs = temp;
	}
	
	//Search for ad with the the same id , and if he found it it return true
	public boolean containId (String id) {
		
		for(int i = 0; i < jobs.length; i++)
			if(jobs[i].get_adId() == id)
				return true;
		
		return false;
	}
	
	
	
	//Search for ads with the the same role
	public publishAdv[] searchByRole(String role){
		
		
		int hit = 0;//
		
		for(int i = 0; i < jobs.length; i++)
			if(jobs[i].get_role() == role)
				hit++;
		
		publishAdv[] roleArrHit = new publishAdv[hit];
		
		for(int i = 0; i < jobs.length; i++)
			if(jobs[i].get_role() == role)
				roleArrHit[i] = jobs[i];
		
		return roleArrHit;
		
	
		
	}
	
	//Search for ads with the the same domain
	public publishAdv[] searchByDomain(String domain){
		
		int[] hit = new int[0];//
		
		for(int i = 0; i < jobs.length; i++)
			if(jobs[i].get_domain() == domain)
				hit++;
		
		publishAdv[] domainArrHit = new publishAdv[hit];
		
		for(int i = 0; i < jobs.length; i++)
			if(jobs[i].get_domain() == domain)
				domainArrHit[i] = jobs[i];
		
		return domainArrHit;
			
	}
	
	//Search for ads with the the same area
	public publishAdv[] searchByArea(String area){
			
		int hit = 0;//
			
		for(int i = 0; i < jobs.length; i++)
			if(jobs[i].get_area() == area)
				hit++;
			
		publishAdv[] areaArrHit = new publishAdv[hit];
			
		for(int i = 0; i < jobs.length; i++)
			if(jobs[i].get_area() == area)
				areaArrHit[i] = jobs[i];
			
		return areaArrHit;
			
	}
	
	//Search for ads that are available 
	public publishAdv[] searchOpenOnly(){
		int hit = 0;//
		
		for(int i = 0; i < jobs.length; i++)
			if(jobs[i].get_status() == true)
				hit++;
		
		publishAdv[] availableArrHit = new publishAdv[hit];
		
		for(int i = 0; i < jobs.length; i++)
			if(jobs[i].get_status() == true)
				availableArrHit[i] = jobs[i];
		
		return availableArrHit;
		
		
	}
	
	//Search for an ad with the fields given
	public publishAdv[] searchAd(String domain , String area , String role){
		
		publishAdv[] temp = null;
		
		publishAdv[] found = null;
		
		int hit = 0;//

		//domain And role
		if( (domain != null) && (role != null) && ( area == null) ){
			
			temp = searchByDomain(domain);
			
			for(int i = 0; i < temp.length; i++)
				if(temp[i].get_role() == role)
					if(temp[i].get_status() == true)
						hit++;
			
			found = new publishAdv[hit];
			
			for(int i = 0; i < temp.length; i++)
				if(temp[i].get_role() == role)
					if(temp[i].get_status() == true)
						found[i] = temp[i];
			
			
			
		}
		//role And area
		else if( (domain == null) && (role != null) && ( area != null) ){		
			for(int i = 0; i < jobs.length; i++)
				if(jobs[i].get_domain() == area && jobs[i].get_role() == role)
					if(jobs[i].get_status() == true)
						hit++;		
		}
		
		
		//domain And area
		else if( (domain != null) && (role == null) && ( area != null) ){	
			for(int i = 0; i < jobs.length; i++)
				if(jobs[i].get_domain() == domain && jobs[i].get_role() == area)
					if(jobs[i].get_status() == true)
						hit++;		
		}
		
		
		
		
		return found;
		
	}
	
	
}
