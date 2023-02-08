

public class RealBridge implements DrushimBridge {
	
	private drushimSite real;
	
	RealBridge(){
		real = new drushimSite();
	}
	
	@Override
	public void addArea(String str) {
		
		real.addArea(str);
	}

	@Override
	public String addCompany(String name, String user, String pass, int numOfAds) {

		return real.addCompany(name, user, pass, numOfAds);
	}

	@Override
	public void addDomain(String str) {

		real.addDomain(str);
	}

	@Override
	public String addNewAd(String user, String pass, String domain, String role, String desc, String area) {

		return real.addNewAd(user, pass, domain, role, desc, area);
	}

	@Override
	public void addRole(String str) {

		real.addRole(str);
	}

	@Override
	public boolean closeAd(String user, String pass, String id) {

		return real.closeAd(user, pass, id);
	}

	@Override
	public String[] getAd(String id) {

		return real.getAd(id);
	}

	@Override
	public String[] getAds(String role, String domain, String area) {

		return real.getAds(domain, role, area);
	}

	@Override
	public String getCompanyId(String name) {

		return real.getCompanyId(name);
	}

	@Override
	public String[] getMyAdsIds(String user, String pass) {

		return real.getMyAdsIds(user,pass);
	}

	@Override
	public int getMyCredit(String user, String pass) {
		return real.getMyCredit(user, pass);
	}

}
