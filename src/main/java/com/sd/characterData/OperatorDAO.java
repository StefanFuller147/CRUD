package com.sd.characterData;

import java.util.List;

public interface OperatorDAO {
	public Operator getOpById(String id); 
	public Operator getOpByName(String firstName, String lastName);
	public Operator getOpByCodeName(String codeName);
	public Operator getOpByNationality(String nationality);
	public Operator getOpBySide(String side);
	public void addAnOperator(Operator operators);
	public void removeAnOperator(String id);
	public List<Operator> getOperators();
	Operator getNextOperator(String id);
	Operator getPreviousOperator(String id);
	public Operator editAndSaveOperator(Operator operator);
	List<String> getImages();
}
