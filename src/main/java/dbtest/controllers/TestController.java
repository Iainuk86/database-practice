package dbtest.controllers;

import dbtest.*;
import dbtest.repos.AddressRepo;
import dbtest.repos.CourseRepo;
import dbtest.repos.InstructorRepo;
import dbtest.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    InstructorRepo instructorRepo;

    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/")
    public String testRun() {

        studentRepo.deleteAll();
        courseRepo.deleteAll();
        instructorRepo.deleteAll();

        Student iain = new Student("Iain", "McIntosh", new Address("yo", "yo"));
        Student morg = new Student("Morgan", "Brademann", new Address("46", "Cooma"));
        Instructor ins = new Instructor("Bugsy", "Malone");
        Course airGuitar = new Course("Air Guitar 101");
        Course rps = new Course("Advanced Rock paper scissors");
        airGuitar.setInstructor(ins);
        rps.setInstructor(ins);
        iain.addCourse(airGuitar);
        iain.addCourse(rps);
        morg.addCourse(airGuitar);
        morg.addCourse(rps);

        studentRepo.save(iain);
        studentRepo.save(morg);
        instructorRepo.save(ins);
        courseRepo.save(airGuitar);
        courseRepo.save(rps);

        return "home";
    }

}
