package utils;

public class Split {
	public static String[] splitByCommaOrColon(String value) {
		return value.split("[,:]");
	}
}
