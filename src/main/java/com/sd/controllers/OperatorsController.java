package com.sd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sd.characterData.Operator;
import com.sd.characterData.OperatorDAO;

@Controller
public class OperatorsController {
	@Autowired
	private OperatorDAO opDAO;
	
	@Autowired
	public void setOperatorDAO(OperatorDAO opDAO){
		this.opDAO=opDAO;
	}
	
	@RequestMapping(path = "GetOperatorData.do", params = "name", method = RequestMethod.GET)
	public ModelAndView getByName(@RequestParam("name") String fn, String ln) {
		System.out.println("I made it to the controller ");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("Operator", opDAO.getOpByName(fn, ln));
		return mv;
	}	
	@RequestMapping(path = "GetOperatorData.do", params = {"next", "id"}, method = RequestMethod.GET)
	public ModelAndView getNext(@RequestParam("id") String n) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("Operator", opDAO.getNextOperator(n));
		return mv;
	}	
	@RequestMapping(path = "GetOperatorData.do", params = {"back", "id"}, method = RequestMethod.GET)
	public ModelAndView getPrevious(@RequestParam("id") String n) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("Operator", opDAO.getPreviousOperator(n));
		return mv;
	}	
	@RequestMapping(path = "GetOperatorData.do", params = "codeName", method = RequestMethod.GET)
	public ModelAndView getByCodeName(@RequestParam("codeName") String n) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("Operator", opDAO.getOpByCodeName(n));
		return mv;
	}	
	@RequestMapping(path = "GetOperatorData.do", params = "id", method = RequestMethod.GET)
	public ModelAndView getById(@RequestParam("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		Operator o = opDAO.getOpById(id);
		mv.addObject("Operator", o);
		return mv;
	}	
	@RequestMapping(path = "GetOperatorData.do", params = "nationality", method = RequestMethod.GET)
	public ModelAndView getByNationality(@RequestParam("nationality") String n) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("Operator", opDAO.getOpByNationality(n));
		return mv;
	}	
	@RequestMapping(path = "GetOperatorData.do", method = RequestMethod.GET)
	public ModelAndView getAllOperators() {
		System.out.println("test");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("operatorList", opDAO.getOperators());
		return mv;
	}	
	
	@RequestMapping(path = "EditOperatorData.do", method = RequestMethod.POST) 
       public ModelAndView editAndSaveOperator(Operator operator){
        System.out.println(operator);  
			opDAO.editAndSaveOperator(operator);
           ModelAndView mv = new ModelAndView();
           mv.setViewName("home");
           mv.addObject("operatorList", opDAO.getOperators());
        return mv;
       }
	@RequestMapping(path = "goToEditForm.do", method = RequestMethod.POST) 
	public ModelAndView editOperator(@RequestParam("id")String id){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("EditOperator");
		mv.addObject("Operator", opDAO.getOpById(id));
		return mv;
	}
	@RequestMapping(path="AddAnOperatorForm.do", method = RequestMethod.POST)
	public ModelAndView goToAddForm(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("AddAnOperatorForm");
		return mv;
	}
	@RequestMapping(path="AddAnOperator.do", method = RequestMethod.POST)
	public ModelAndView addAnOperator(Operator operator){
		operator.setId(Integer.parseInt(opDAO.getOperators().get(opDAO.getOperators().size()-1).getId())+1+"");
		opDAO.addAnOperator(operator);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("operatorList", opDAO.getOperators());
		return mv;
	}
	@RequestMapping(path="RemoveAnOperator.do", method = RequestMethod.POST)
	public ModelAndView removeAnOperator(@RequestParam("id") String id){
		opDAO.removeAnOperator(id);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("operatorList", opDAO.getOperators());
		return mv;
	}
}
