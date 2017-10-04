package org.dlearn.helsinki.skeleton.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dlearn.helsinki.skeleton.model.Group;
import org.dlearn.helsinki.skeleton.model.Student;
import org.dlearn.helsinki.skeleton.service.GroupService;
import org.dlearn.helsinki.skeleton.service.StudentService;

@Path("/students")
public class StudentAccessResource {
	static final GroupService groupService = new GroupService();
	static final StudentService studentService = new StudentService(); 	
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String checkLogin() {
        return "logged in";
    }

    
    @Path("/{student_id}/classes")
    public StudentClassResource getGroups() {
        return new StudentClassResource();
    }
    
    /*
    @Path("/{studentID}/groups")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Group> getAllGroupsTheStudentIsIn(@PathParam("studentID") int studentID) {
        return groupService.getAllGroupsTheStudentIsIn(studentID);
    } 
    */
    
	@GET
	@Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
	public Student getStudentInfo(@PathParam("studentId") int student_id) {
		return studentService.getStudentNoPassword(student_id);
    }
}
