package br.edu.daione.pavan.Floricultura.Floricultura.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author daione.pavan
 */
@RestController
@RequestMapping("/")
public class MainController {
    
    @RequestMapping(value="/teste/")
    public String teste(){
        return "testei"; 
    }
    
}
