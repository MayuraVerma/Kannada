package com.kannada.kanuaconv.maps;

public interface CharacterMap {

	public static class CHARMAP {
		public String textProp;
		public String textStd;
		public int textPropLength;
		public int textStdLength; 
		
		
		public CHARMAP(String textProp, String textStd) {
			this.textProp = textProp;
			this.textStd = textStd;
			this.textPropLength = textProp.length();
			this.textStdLength = textStd.length();
		}

		@Override
		public String toString() {
			return "CHARMAP [textStdLength=" + textStdLength + "]";
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object arg0) {
			// TODO Auto-generated method stub
			return super.equals(arg0);
		}
		
	}
	public void initializeMap();
	
	public String Convert(String inText);
}
