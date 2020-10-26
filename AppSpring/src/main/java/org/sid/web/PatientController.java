package org.sid.web;

import java.util.List;

import javax.validation.Valid;

import org.sid.dao.PatientRepository;
import org.sid.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PatientController {
  
	 @Autowired
	    private PatientRepository patientRepository;
	 
		@GetMapping(path="/index")
		public String index() {
			return "index";
		}
		
		@GetMapping(path="/patients")
		public String List(Model model,
				@RequestParam(name="page",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size
				,@RequestParam(name="motCle",defaultValue="")String motCle)
		{
			Page<Patient> pagePatients=patientRepository.findByNameContains(motCle,PageRequest.of(page, size));
			model.addAttribute("pagePatients",pagePatients.getContent());
			model.addAttribute("currentPage",page);
			model.addAttribute("size",size);
			model.addAttribute("motCle",motCle);

			model.addAttribute("pages",new int[pagePatients.getTotalPages()]);
			return "patients";
		}
		@GetMapping(path="/deletePatient")
		public String delete(Long id,String motCle,String page,String size) {
			patientRepository.deleteById(id);
			return "redirect:/patients?page="+page+"&motCle="+motCle+"&size="+size;
		}
		@GetMapping(path="/fromPatient")
		public String fromPatient(Model model)
		{
			model.addAttribute("patient",new Patient());
			model.addAttribute("mode","new");
			return "fromPatient";
		}
		@PostMapping(path="/savePatient")
		public String savePatient(@Valid Patient patient ,BindingResult bindingResult,Model model)
		{
			if(bindingResult.hasErrors()) return "fromPatient";
			patientRepository.save(patient);
			model.addAttribute("patient",patient);
			return "confirmation";
		}
		@GetMapping(path="editPatient")
		public String editPatient(Model model,Long id)
		{   
			Patient p= patientRepository.findById(id).get();
			model.addAttribute("patient",p);
			model.addAttribute("mode","edit");

			return "fromPatient";
		}
		
		
		
		
}
