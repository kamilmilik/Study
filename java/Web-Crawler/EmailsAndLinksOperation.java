import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailsAndLinksOperation {
	static String emailRegex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
	static public boolean deleteWrongLink(String link) {
		int lengthOfCurrentLink = link.length();
		if (link.charAt(lengthOfCurrentLink - 2) == '.' || link.charAt(lengthOfCurrentLink - 3) == '.'
				|| link.charAt(lengthOfCurrentLink - 4) == '.') {
			return true;
		}
		else
			return false;
	}
	static public boolean deletePNGFromEmail(String currentEmail) {
		int currentEmailLength = currentEmail.length();
		if (!currentEmail.substring(currentEmailLength - 4, currentEmailLength).contains("png")) {
			return true;
		}
		else
			return false;
	}
	static int numberSearchedEmails = 1 ;
	public static void searchEmailAndAddToSet(String stringAddress,HashSet<String> emailsSet){
		Pattern emailPattern = Pattern.compile(emailRegex);
		Matcher emailMatcher = emailPattern.matcher(stringAddress);

		while (emailMatcher.find()) {
			String currentEmail = emailMatcher.group();
			if (!emailsSet.contains(currentEmail)) {
				if(EmailsAndLinksOperation.deletePNGFromEmail(currentEmail)){
					System.out.println("Email: " + currentEmail);
					numberSearchedEmails++;
				}
			}
			emailsSet.add(currentEmail);
		}
	}
	public static String readSourceCodePage(int currentVertex, StringIntConverter converter, BufferedReader br) throws IOException{
		StringBuilder sb = new StringBuilder();
		String stringAddress = converter.getOriginText(currentVertex);
		while ((stringAddress = br.readLine()) != null) {// pobieramy kod strony
			sb.append(stringAddress);
		}
		stringAddress = sb.toString();
		return stringAddress;
	}
}
