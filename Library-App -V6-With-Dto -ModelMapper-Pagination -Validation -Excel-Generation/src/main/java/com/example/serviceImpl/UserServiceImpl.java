package com.example.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.attoparser.dom.Document;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dto.UsersDto;
import com.example.entity.Users;
import com.example.repository.UserRepo;
import com.example.service.UserService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService{


	@Autowired
	private UserRepo repo;
	
	@Autowired
	private ModelMapper mapper;

  
	@Override
	public UsersDto saveUser(UsersDto userdto) {
		
		// dto obj to entity obj conversion using helper class
		
		
		Users user = mapper.map(userdto, Users.class);
		
		
		Users savedEntity = repo.save(user);
		
		//convert saved entity to again dto
		UsersDto dto = mapper.map(savedEntity, UsersDto.class);

		return dto;
		
	}

	
	
	@Override
	public UsersDto updateUser(UsersDto userdto) {
		// TODO Auto-generated method stub
		
		Users userEntity = repo.findById(userdto.getId()).orElse(null);
		
		if(userEntity !=null) {
			
			userEntity.setName(userdto.getName());
			userEntity.setEmail(userdto.getEmail());
			userEntity.setAddress(userdto.getAddress());
			
			Users savedEntity = repo.save(userEntity);
			
			return mapper.map(savedEntity, UsersDto.class);
			
		} 
		
		return null;
	}
	
	
	@Override
	public List<UsersDto> getAllUsers() {

		List<Users> userslist = repo.findAll();		
		
		List<UsersDto> dtoList = userslist.stream().map(entity->mapper.map(entity, UsersDto.class)).collect(Collectors.toList());
		
		return dtoList;
	}


	@Override
	public void deleteUsers(Long id) {
		
		repo.deleteById(id);
		
	}


	@Override
	public UsersDto getUserById(Long id) {
	
	Users user = repo.findById(id).orElse(null);
		
	// convert entity to dto
		return mapper.map(user, UsersDto.class);
	}



	@Override
	public Page<UsersDto> getAllPaginationData(Pageable pageable) {
	Page<Users> pages = repo.findAll(pageable);
	
	Page<UsersDto> dtopages = pages.map(u->mapper.map(u, UsersDto.class));
	
	return dtopages;
	}



	@Override
	public void generateExce(HttpServletResponse resp) throws IOException {
		
		List<Users> usersList = repo.findAll();
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue("SrNo");
		headerRow.createCell(1).setCellValue("Name");
		headerRow.createCell(2).setCellValue("Email");
		headerRow.createCell(3).setCellValue("Address");
		headerRow.createCell(4).setCellValue("Aadhar");
		headerRow.createCell(5).setCellValue("Pan");
		
		int rowCount =1;
		
		for(Users u:usersList) {
			HSSFRow dataRow = sheet.createRow(rowCount);
			dataRow.createCell(0).setCellValue(rowCount);
			dataRow.createCell(1).setCellValue(u.getName());
			dataRow.createCell(2).setCellValue(u.getEmail());
			dataRow.createCell(3).setCellValue(u.getAddress());
			dataRow.createCell(4).setCellValue(u.getAadhar());
			dataRow.createCell(5).setCellValue(u.getPan());
			
			rowCount++;
			
		}
		
		ServletOutputStream os = resp.getOutputStream();
		
		workbook.write(os);
		workbook.close();
		os.close();
		
		
	}

	
	// for PDF generation 
	
	@Override
	public void generatePdf(HttpServletResponse resp) throws Exception {
		
		List<Users> userList = repo.findAll();
		
//		Document doc = new Document(PageSize.A4);
//		
//		PdfWriter.getInstance(doc, resp.getOutputStream());
		
		
		
	}

	
	
	
	

}
