package org.doit.ik;

import java.util.ArrayList;
import java.util.Locale;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.domain.EmpDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.doit.ik.mapper.scott.EmpMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;


@Controller
public class ScottController {
   
   private static final Logger logger = LoggerFactory.getLogger(ScottController.class);
   
   // @Autowired
   @Setter(onMethod =@__({@Autowired}))
   private DeptMapper deptMapper;
   
   @Autowired
   private EmpMapper empMapper;
   
   //@RequestMapping(value = "/scott/dept", method = RequestMethod.GET)
   @GetMapping("/scott/dept")
   public String dept(Locale locale, Model model) {
      logger.info(">ScottController.dept()...");
      
      ArrayList<DeptDTO> list = deptMapper.selectDept();
      
      model.addAttribute("list",list);
   
      return "/scott/dept"; //WEB-INF /views/homs.jsp
   } 
   
   
   
   // void를 리턴으로 주면 요청 url과 똑같은곳으로 이동한다.
   @PostMapping("/scott/emp")
   public void emp(@RequestParam( value = "deptno") int[] deptnos, Model model) {
	   logger.info(">ScottController.emp()...");
	   
	   ArrayList<EmpDTO> list = empMapper.selectEmpArray(deptnos);
	   model.addAttribute("list",list);
	   
   }
}