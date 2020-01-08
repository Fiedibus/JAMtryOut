package article;

public enum Genre {

	ACTION ("Action"), 
	ADVENTURE ("Adventure"), 
	ACTION_ADVENTURE ("Action Adventure"), 
	STRATEGY ("Strategie"), 
	OTHER ("Anderes");
	
	String value;
	
	Genre (String value) {
		this.value = value;
	}
}
