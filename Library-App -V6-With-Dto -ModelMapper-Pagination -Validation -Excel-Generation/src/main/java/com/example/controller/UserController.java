package com.example.controller;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.UsersDto;
import com.example.repository.UserRepo;
import com.example.service.UserService;
import com.example.utils.FileUploadUtils;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class UserController {

    private final UserRepo userRepo;


	@Autowired
	private UserService service;


    UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


   
	@GetMapping("/")
	public String showHomePage() {
		
		return "home";
		
	}
	
	
	
	@GetMapping("/register")
	public String showregisterPage(Model model) {
		
		model.addAttribute("userdto", new UsersDto());
		
		return "register";
	}
	
	
	
	@PostMapping("/save")
	public String saveUsers(@Valid @ModelAttribute("userdto") UsersDto userdto , BindingResult result , Model model,
			@RequestParam ("imgpart")MultipartFile imgpart ,@RequestParam("pdfpart")MultipartFile pdfpart) {
		
		
		if(result.hasErrors()) {
			model.addAttribute("userdto",userdto);
			return "register";
		}
		
		
		// extract the original img or pdf file name
		String imageName = null;
		String pdfName =null;
		
		// extract imageName 
		if(imgpart !=null && !imgpart.isEmpty())
		{
			imageName = StringUtils.cleanPath(Objects.requireNonNull(imgpart.getOriginalFilename()));
			
			// set image Name to user Dto
			userdto.setImageName(imageName);
		}
		
		
		// extract pdf name
		if(pdfpart !=null && !pdfpart.isEmpty()) {
			
			pdfName = StringUtils.cleanPath(Objects.requireNonNull(pdfpart.getOriginalFilename()));
			userdto.setPdfName(pdfName);
		
		}
		
		// save user to database with file Name
		UsersDto savedUser = service.saveUser(userdto);
		
		
		// save file in directory
		
		try {
			
			String uploadDirectory = "myfiles/"+ savedUser.getId();
			FileUploadUtils.saveFile(uploadDirectory, imageName, imgpart);
			
			FileUploadUtils.saveFile(uploadDirectory, pdfName, pdfpart);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/allusers";
	}
	
	
	
	
	
//	@GetMapping("/allusers")
//	public String viewAllUsers(Model model) {
//		
//		List<UsersDto> dtolist  = service.getAllUsers();
//		
//		model.addAttribute("userlist",dtolist);
//		
//		return "viewall";
//	}
	
	
	// view All records with pagination
	
	@GetMapping("/allusers")
	public String getAllUsersWithPage(Model model ,@RequestParam(defaultValue = "0") int pageNo) {
		
		int pageSize =3;
		
		if(pageNo <0) {
			pageNo=0;
		}
		
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		
		Page<UsersDto> pages = service.getAllPaginationData(pageable);
		
		model.addAttribute("userpages", pages);
		
		model.addAttribute("currentpage",pageNo);
		
		return "viewall";
	
	
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	// to show edit page
	@GetMapping("/editUser/{id}")
	public String editUser(@PathVariable Long id , Model model) {
		
		UsersDto dto = service.getUserById(id);
		
		model.addAttribute("userdto", dto);
		
		return "edit";
	}
	
	
	
	@PostMapping("/update")
	public String updateUser(@ModelAttribute UsersDto userdto) {
		
//		Users existingUser = service.getUserById(user.getId());
//		
//		if(existingUser !=null) {
//			existingUser.setName(user.getName());
//			existingUser.setEmail(user.getEmail());
//			existingUser.setAddress(user.getAddress());
//			existingUser.setAadhar(user.getAadhar());
//			existingUser.setPan(user.getPan());
//			
//			service.saveUser(existingUser);
//		
//		}
		service.saveUser(userdto);
		
		return "redirect:/allusers";
	}
	
	
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		
		service.deleteUsers(id);
		
		return "redirect:/allusers";
	}
	
	
	@GetMapping("/download/{userid}/{filename}")
	public void downloadDocs(@PathVariable String userid , @PathVariable String filename, HttpServletResponse resp) {
		
		try {
			
			Path filePath = Paths.get("myfiles",userid,filename).normalize();
			
			resp.setContentType("application/pdf");
			resp.setHeader("Content-Disposition","attachment;filename=\""+filename +"\"");
			
			Files.copy(filePath, resp.getOutputStream());
			
			resp.getOutputStream().flush();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@GetMapping("/excel-export")
	public void excelExport(HttpServletResponse resp) throws Exception{
		
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition","attachment;filename=userreport.xls");
		service.generateExce(resp);
		
	}
	
	
}
