package track.pro.user.entites;
 
import org.springframework.web.multipart.MultipartFile;
 

/*`user_id`, `full_name`, `user_name`, `gender`, `mobile`, `email`, 
`profile_image`, `profile`, `pwd_salt`, `pwd_hash`, `role_id`, `is_authorized`*/

public class User {
	private int userId;
	private String fullName;
	private String userName;
	private String gender;
	private String mobile;
	private String email;
	private MultipartFile profileImage;
	private MultipartFile profile;
	private String password;
	private String pwdSalt;
	private String pwdHash;
	private int roleId;
	private boolean isAuthorized;
	
	
	public User(int userId, String fullName) {
		super();
		this.userId = userId;
		this.fullName = fullName;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String fullName, String userName, String gender, String mobile, String email,
			MultipartFile profileImage, MultipartFile profile, String password, String pwdSalt, String pwdHash,
			int roleId, boolean isAuthorized) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.userName = userName;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.profileImage = profileImage;
		this.profile = profile;
		this.password = password;
		this.pwdSalt = pwdSalt;
		this.pwdHash = pwdHash;
		this.roleId = roleId;
		this.isAuthorized = isAuthorized;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public MultipartFile getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(MultipartFile profileImage) {
		this.profileImage = profileImage;
	}
	public MultipartFile getProfile() {
		return profile;
	}
	public void setProfile(MultipartFile profile) {
		this.profile = profile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPwdSalt() {
		return pwdSalt;
	}
	public void setPwdSalt(String pwdSalt) {
		this.pwdSalt = pwdSalt;
	}
	public String getPwdHash() {
		return pwdHash;
	}
	public void setPwdHash(String pwdHash) {
		this.pwdHash = pwdHash;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public boolean isAuthorized() {
		return isAuthorized;
	}
	public void setAuthorized(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", userName=" + userName + ", gender=" + gender
				+ ", mobile=" + mobile + ", email=" + email + ", profileImage=" + profileImage + ", profile=" + profile
				+ ", password=" + password + ", pwdSalt=" + pwdSalt + ", pwdHash=" + pwdHash + ", roleId=" + roleId
				+ ", isAuthorized=" + isAuthorized + "]";
	}
	
	
	
			}