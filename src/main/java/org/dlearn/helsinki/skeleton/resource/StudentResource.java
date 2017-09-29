package org.dlearn.helsinki.skeleton.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import jersey.repackaged.com.google.common.collect.Lists;

import org.dlearn.helsinki.skeleton.model.Group;
import org.dlearn.helsinki.skeleton.model.Student;
import org.dlearn.helsinki.skeleton.service.GroupService;

@Path("/students")
public class StudentResource {
		
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents(@PathParam("student_id") int student_id) {
        return Lists.newArrayList(
            new Student(student_id, "lastname", "firstname", "username", "password"),
            new Student(student_id + 1, "lastname2", "firstname2", "username2", "password2")
        );
    }
    
    /*
    @Path("/{student_id}/spidergraphs")
    public SpiderGraphResource getSpiderGraphResource(@PathParam("student_id") int student_id) {
        return new SpiderGraphResource();
    }
    */
}
