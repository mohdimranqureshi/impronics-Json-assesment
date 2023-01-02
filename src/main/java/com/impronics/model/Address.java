package com.impronics.model;

public class Address {

	private String id;
	private Type type;
	private AddressLineDetail addressLineDetail;
	private ProvinceOrState provinceOrState;
	private String cityOrTown;
	private Country country;
	private String postalCode;
	private String lastUpdated;
	private String suburbOrDistrict;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public AddressLineDetail getAddressLineDetail() {
		return addressLineDetail;
	}

	public void setAddressLineDetail(AddressLineDetail addressLineDetail) {
		this.addressLineDetail = addressLineDetail;
	}

	public ProvinceOrState getProvinceOrState() {
		return provinceOrState;
	}

	public void setProvinceOrState(ProvinceOrState provinceOrState) {
		this.provinceOrState = provinceOrState;
	}

	public String getCityOrTown() {
		return cityOrTown;
	}

	public void setCityOrTown(String cityOrTown) {
		this.cityOrTown = cityOrTown;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public String getSuburbOrDistrict() {
		return suburbOrDistrict;
	}

	public void setSuburbOrDistrict(String suburbOrDistrict) {
		this.suburbOrDistrict = suburbOrDistrict;
	}

}
