package com.example.demo.Controllers;//src/main/java/com/example/demo/Controllers/HomeController.java


import java.util.List;
import org.springframework.ui.Model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.Entities.DTO;
import com.example.demo.Services.LoanService;





@Controller
public class HomeController {
	
	@Autowired
    private LoanService loanService;

    @GetMapping("/")
    public String mainPage() {
        return "index"; //Redirects to index.html (home page)
    }

    @GetMapping("/user")
    public String userPage() {
        return "user"; //Redirects to user.html
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin"; //Redirects to admin.html
    }
    
    @GetMapping("/add")
    public String addPage() {
        return "add";  //Redirects to add.html
    }
    
    
    @GetMapping("/edit")
    public String editPage() {
        return "edit"; //Redirects to edit.html
    }
    
    @GetMapping("/showBorrow") //Adds the DTO collection as an attribute to the model and redirects to borrow.html
    public String borrowPage(Model model) {
        List<DTO> borrowedBooks = loanService.getBorrowedBooks();
        model.addAttribute("borrowedBooks", borrowedBooks);
        return "borrow";
    }
    
    
    


    
 

    
  
}


