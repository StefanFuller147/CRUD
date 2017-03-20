package com.sd.characterData;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;

public class OperatorDAOImpl implements OperatorDAO {
	private static final String FILE_NAME = "/WEB-INF/operators.csv";
	private List<Operator> operators = new ArrayList<>();

	@Autowired
	private WebApplicationContext wac;

	@PostConstruct
	public void init() {
		System.out.println("in init");
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			System.out.println("in try");
			while ((line = buf.readLine()) != null) {
				System.out.println("in while");
				String[] tokens = line.split("///");
				String id = tokens[0];
				String firstName = tokens[1];
				String lastName = tokens[2];
				String nationality = tokens[3];
				String side = tokens[4];
				String codeName = tokens[5];
				String picture = tokens[6];
				String icon = tokens[7];
				String bio = tokens[8];
				String operatorVideo = tokens[9];
				Operator o = new Operator(id, firstName, lastName, nationality, side, codeName, picture, icon, bio, operatorVideo);
				operators.add(o);
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	@Override
	public Operator getOpByName(String firstName, String lastName) {
		Operator o = null;
		for (Operator operator : operators) {
			if (operator.getFirstName().equalsIgnoreCase(firstName)
					&& operator.getLastName().equalsIgnoreCase(lastName)) {
				o = operator;
				break;
			}
		}
		return o;
	}

	@Override
	public Operator getOpByCodeName(String codeName) {
		Operator o = null;
		for (Operator operator : operators) {
			if (operator.getCodeName().equalsIgnoreCase(codeName)) {
				o = operator;
				break;
			}
		}
		return o;
	}

	@Override
	public Operator getOpByNationality(String nationality) {
		Operator o = null;
		for (Operator operator : operators) {
			if (operator.getNationality().equalsIgnoreCase(nationality))
				;
			o = operator;
		}
		return o;
	}

	@Override
	public Operator getOpById(String id) {
		Operator o = null;
		for (Operator operator : operators) {
			if (operator.getId().equals(id)) {
				o = operator;
			}
		}
		return o;
	}

	@Override
	public Operator getOpBySide(String side) {
		Operator o = null;
		for (Operator operator : operators) {
			if (operator.getSide().equalsIgnoreCase(side)) {
				o = operator;
			}
		}
		return o;
	}

	@Override
	public Operator getNextOperator(String id) {
		System.out.println(id);
		Operator o = null;
		for (Operator operator : operators) {
			System.out.println(operator);
			if (operator.getId().equals(id)) {
				int index = operators.indexOf(operator);
				index++;
				if (index == operators.size()) {
					index = 0;
				}
				o = operators.get(index);
				break;
			}
		}
		return o;
	}

	@Override
	public Operator getPreviousOperator(String id) {
		Operator o = null;
		for (Operator operator : operators) {
			if (operator.getId().equals(id)) {
				int index = operators.indexOf(operator);
				index--;
				if (index < 0) {
					index = operators.size() - 1;
				}
				o = operators.get(index);
				break;
			}
		}
		return o;
	}

	@Override
	public List<Operator> getOperators() {
		return operators;
	}

	@Override
	public Operator editAndSaveOperator(Operator operator) {
		int index = 0;
		for (Operator operator2 : operators) {
			if (operator2.getId().equalsIgnoreCase(operator.getId())) {
				System.out.println("*****" + operator2);
				index = operators.indexOf(operator2);
			}
		}
		System.out.println("index " + index);
		Operator o = operators.get(index);
		o.setFirstName(operator.getFirstName());
		o.setLastName(operator.getLastName());
		o.setCTU(operator.getCTU());
		o.setSide(operator.getSide());
		o.setCodeName(operator.getCodeName());
		operators.set(index, o);
		for (Operator operator2 : operators) {
			System.out.println(operator2);
		}
		return null;
	}

	@Override
	public void addAnOperator(Operator operator) {
		operators.add(operator);

	}

	@Override
	public void removeAnOperator(String id) {
		int index = 0;
		for (Operator operator : this.operators) {
			if (operator.getId().equals(id)) {
				index = operators.indexOf(operator);
				break;

			}
		}
		operators.remove(index);
	}
	
	@Override
	public List<String> getImages() {
		List<String> pics = new ArrayList<>();
		for (Operator operator : operators) {
			pics.add(operator.getIcon());
		}
		return pics;
	}
	
	

}