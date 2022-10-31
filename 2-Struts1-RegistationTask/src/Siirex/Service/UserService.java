package Siirex.Service;

import java.util.List;

import Siirex.Model.UserDB;
import Siirex.Repository.UserRepository;

public class UserService {

	private UserRepository repository;

	public UserRepository getRepository() {
		return repository;
	}
	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}
	
	public UserService() {
		this.repository = new UserRepository();
	}
	
	public int registerUser(UserDB userDB) {
		try {
			return this.repository.registerUser(userDB);
			
		} catch (Exception e) {
			return -1;
		}
	}
	
	public int deleteUser(int id) {
		try {
			return this.repository.deleteUser(id);
			
		} catch (Exception e) {
			return -1;
		}
	}
	
	public int updateUser(UserDB userDB) {
		try {
			return this.repository.updateUser(userDB);
			
		} catch (Exception e) {
			return -1;
		}
	}
	
	public UserDB getUserById(int id) throws Exception {
		return this.repository.getUserById(id);
	}
	
	public List<UserDB> getAllUser() throws Exception {
		
		try {
			return this.repository.listAllUser();
		} catch (Exception e) {
			System.out.println("> Service getAllUser() error!");
			return null;
		}
	}
	
	public Long getMaxId() throws Exception {
		return this.repository.getMaxId();
	}
	
}
