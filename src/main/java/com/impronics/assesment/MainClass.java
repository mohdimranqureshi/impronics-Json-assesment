package com.impronics.assesment;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.impronics.model.Address;
import com.impronics.model.Addresses;

public class MainClass {

	public static void main(String[] args) {

		ObjectMapper objectMapper = new ObjectMapper();
		Addresses addresses = objectMapper.readValue(new File("src/main/resources/addresses.json"), Addresses.class);

		String prettyAddress = prettyPrintAddress(addresses.getAddresses().get(0));
		System.out.println(prettyAddress);

		printAllAddresses(addresses);
		printCertainAddress(addresses);
		boolean validateAddress = validateAddress(addresses.getAddresses().get(0));
		System.out.println("Address is: " + validateAddress);
		String validateMessage = validateAddressMessage(addresses.getAddresses().get(0));
		System.out.println(validateMessage);

	}

	public static String prettyPrintAddress(Address address) {

		StringBuilder result = new StringBuilder("");

		if (address != null) {
			if (address.getType() != null && !"".equals(address.getType().getName())) {
				result.append(address.getType().getName());
			}
			result.append(": ");

			if (address.getAddressLineDetail() != null) {
				if (address.getAddressLineDetail().getLine1() != null
						&& !"".equals(address.getAddressLineDetail().getLine1())) {
					result.append(address.getAddressLineDetail().getLine1() + " ");
				}
				if (address.getAddressLineDetail().getLine2() != null
						&& !"".equals(address.getAddressLineDetail().getLine2())) {
					result.append(address.getAddressLineDetail().getLine2());
				}
			}

			result.append(" - ");

			if (address.getCityOrTown() != null && !"".equals(address.getCityOrTown())) {
				result.append(address.getCityOrTown());
			}

			result.append(" - ");

			if (address.getProvinceOrState() != null && address.getProvinceOrState().getName() != null
					&& !"".equals(address.getProvinceOrState().getName())) {
				result.append(address.getProvinceOrState().getName());
			}

			result.append(" - ");

			if (address.getPostalCode() != null && !"".equals(address.getPostalCode())) {
				result.append(address.getPostalCode());
			}

			result.append(" - ");

			if (address.getCountry() != null && address.getCountry().getName() != null
					&& !"".equals(address.getCountry().getName())) {
				result.append(address.getCountry().getName());
			}

			return result.toString();
		}
		return "Address is blank";
	}

	public static void printAllAddresses(Addresses addresses) {
		addresses.getAddresses().stream()
				.forEach((address) -> System.out.println("Address Type: " + address.getType().getName() + ", "
						+ "Address Line 1: " + address.getAddressLineDetail().getLine1() + ", " + "Address Line 2: "
						+ address.getAddressLineDetail().getLine2() + ", " + "State: "
						+ address.getProvinceOrState().getName() + ", " + "City: " + address.getCityOrTown() + ", "
						+ "Country: " + address.getCountry().getName() + ", " + "Postal Code: "
						+ address.getPostalCode() + ", " + "Last Updated:" + address.getLastUpdated() + "\n"));
	}

	public static void printCertainAddress(Addresses addresses) {
		List<Address> physicalAddress = addresses.getAddresses().stream()
				.filter(address -> address.getType().getName().equals("Physical Address")).collect(Collectors.toList());
		physicalAddress.forEach((address) -> System.out.println("Address Type: " + address.getType().getName() + ", "
				+ "Address Line 1: " + address.getAddressLineDetail().getLine1() + ", " + "Address Line 2: "
				+ address.getAddressLineDetail().getLine2() + ", " + "State: " + address.getProvinceOrState().getName()
				+ ", " + "City: " + address.getCityOrTown() + ", " + "Country: " + address.getCountry().getName() + ", "
				+ "Postal Code: " + address.getPostalCode() + ", " + "Last Updated:" + address.getLastUpdated()));

		List<Address> postalAddress = addresses.getAddresses().stream()
				.filter(address -> address.getType().getName().equals("Postal Address")).collect(Collectors.toList());
		postalAddress.forEach((address) -> System.out.println("Address Type: " + address.getType().getName() + ", "
				+ "Address Line 1: " + address.getAddressLineDetail().getLine1() + ", " + "Address Line 2: "
				+ address.getAddressLineDetail().getLine2() + ", " + "State: " + address.getProvinceOrState().getName()
				+ ", " + "City: " + address.getCityOrTown() + ", " + "Country: " + address.getCountry().getName() + ", "
				+ "Postal Code: " + address.getPostalCode() + ", " + "Last Updated:" + address.getLastUpdated()));

		List<Address> businessAddress = addresses.getAddresses().stream()
				.filter(address -> address.getType().getName().equals("Business Address")).collect(Collectors.toList());
		businessAddress.forEach((address) -> System.out.println("Address Type: " + address.getType().getName() + ", "
				+ "Address Line 1: " + address.getAddressLineDetail().getLine1() + ", " + "Address Line 2: "
				+ address.getAddressLineDetail().getLine2() + ", " + "State: " + address.getProvinceOrState().getName()
				+ ", " + "City: " + address.getCityOrTown() + ", " + "Country: " + address.getCountry().getName() + ", "
				+ "Postal Code: " + address.getPostalCode() + ", " + "Last Updated:" + address.getLastUpdated()));
	}

	public static boolean validateAddress(Address address) {
		if (null != address) {
			if (null != address.getCountry() && !"".equals(address.getCountry().getName())
					&& null != address.getAddressLineDetail() && !"".equals(address.getAddressLineDetail().getLine1())
					&& !"".equals(address.getAddressLineDetail().getLine2())
					&& address.getPostalCode().chars().allMatch(Character::isDigit)) {
				return true;
			}
		}

		return false;

	}

	public static boolean provinanceCheckForCountry(Address address) {
		if (null != address) {
			if ("ZA".equals(address.getCountry().getName()) && null != address.getProvinceOrState()
					&& "".equals(address.getProvinceOrState().getName())) {
				return true;
			}
		}
		return false;

	}

	public static String validateAddressMessage(Address address) {
		if (address != null) {
			if (address.getCountry() == null && address.getCountry().getName() != null
					&& "".equals(address.getCountry().getName())) {
				return "Country name should not be blank";
			}
		}

		return "Valid Address";

	}
}
