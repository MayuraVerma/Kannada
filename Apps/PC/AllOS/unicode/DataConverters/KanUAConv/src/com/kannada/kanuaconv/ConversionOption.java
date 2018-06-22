package com.kannada.kanuaconv;

public class ConversionOption {

	public static String fileFormat;
	public static String dataFormat;
	
	public ConversionOption() {
		// TODO Auto-generated constructor stub
	}
	
	private void ConversionOption(String fileFormat,String dataFormat) {
		// TODO Auto-generated method stub
		this.dataFormat = dataFormat;
		this.fileFormat = fileFormat;
	}

	public String getFileFormat() {
		return fileFormat;
	}

	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}

	public String getDataFormat() {
		return dataFormat;
	}

	public void setDataFormat(String dataFormat) {
		this.dataFormat = dataFormat;
	}
	
	
}
