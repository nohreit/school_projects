package codingame;

public class ChuckNorris {
	public ChuckNorris() {};
	
	/**
	 * 
	 * @param message : get message form user.
	 * @return the message in binary of String type.
	 */
	public String toBin(String message) {
		String bin = "";
		
		for (int i = 0; i < message.length(); i++) {
			bin += Integer.toBinaryString((int) message.charAt(i));
		}
		
		return bin;
	}
	
	public String toUnary(String bin) {
		String unary = "";
		char c = 0;
		
		for (int i = 0; i < bin.length(); i++) {
			c = bin.charAt(i);

			switch(c) {
			case '1':
				if(bin.charAt(i+1) != '1')
					unary += "0 ";
				for(; i < bin.length(); i++) {
					unary+= "0";
					if(bin.charAt(i) == '0') break;
				}
				unary +=" ";
				break;
			
			case '0':
				if(bin.charAt(i+1) != '0')
					unary += "00 ";
				for(; i < bin.length(); i++) {
					unary+= "0";
					if(bin.charAt(i) == '1') break;
				}
				unary +=" ";
				break;
			}
		}
		
		return unary;
	}
}
