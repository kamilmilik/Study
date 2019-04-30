import java.util.Map;
import java.util.HashMap;
public class StringIntConverter {
	private Map<String, Integer> elementsWithStringKey = new HashMap<>();
	private Map<Integer, String> elementsWithIntegerKey = new HashMap<>();
	private int valueForNewElement = 0;

	private boolean wasThisTextConvertedBefore(String text){
		return elementsWithStringKey.containsKey(text);
	}

	private void associateTextWithNumber(String text, int number){
		elementsWithStringKey.put(text, number);
		elementsWithIntegerKey.put(number, text);
	}

	private int createNewNumber(){
		return valueForNewElement++;
	}

	private int getAssiciatedNumber(String text){
		 return elementsWithStringKey.get(text);
	}

	int convertToNumber(String text){
		if(!wasThisTextConvertedBefore(text)){
			int newNumber = createNewNumber();
			associateTextWithNumber(text, newNumber);
			return newNumber;
		}
		return getAssiciatedNumber(text);
	}

	String getOriginText(int number){
		return elementsWithIntegerKey.get(number);
	}
	public Integer getNumberByText(String v){
		return elementsWithStringKey.get(v);
	}
}
