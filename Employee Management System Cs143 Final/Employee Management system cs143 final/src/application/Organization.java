package application;

public class Organization {
	
	private String orgName;
	
	public Organization(String org) {
		this.orgName = org;
	}
	
	public String getEmpOrg(){
		return orgName;
	}
	public void setEmpOrg(String empOrg){
		this.orgName = empOrg;
	}
}
