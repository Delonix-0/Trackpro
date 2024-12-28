package track.pro.project.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import track.pro.project.entites.Project;
import track.pro.user.entites.User;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertProject(Project project) {
		final String INSERT_PROJECT = "INSERT INTO projects (`project_name`, `description`, "
				+ "`assigned_to`,"
				+ " `status`, `created_at`) VALUES (?,?,?,?,?)";
		return jdbcTemplate.update(INSERT_PROJECT, project.getProjectName(), project.getDescription(),
				project.getAssignedTo(), project.isStatus(), project.getCreatedAt());

	}

	/*
	 * @Override public List<Project> fetchAllProjects() { final String
	 * GET_ALL_PROJECTS = "SELECT * FROM projects";
	 * 
	 * return jdbcTemplate.query(GET_ALL_PROJECTS, (rs, rowNum) -> { int projectId =
	 * rs.getInt("project_id"); String projectName = rs.getString("project_name");
	 * return new Project(projectId, projectName); }); }
	 */

	@Override
	public List<User> fetchAllUsers() {

		final String GET_ALL_USERS = "SELECT * FROM trackpro.users where role_id=2";
		return jdbcTemplate.query(GET_ALL_USERS, (rs, rowNum) -> {
			int userId = rs.getInt("user_id");
			String fullName = rs.getString("full_name");
			return new User(userId, fullName);
		});

	}

}