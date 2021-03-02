package southwind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import southwind.entity.Student;
import southwind.repository.StudentRepository;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentHandler {
    @Autowired
    private StudentRepository studentRepository;

    @Value("${server.port}")
    private String port;
    @GetMapping("/findAll")
    public Collection<Student> findAll(){
        System.out.println(studentRepository.findAll());
        return studentRepository.findAll();
    }
    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") long id){
        System.out.println(studentRepository.findById(id));
        return studentRepository.findById(id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Student student){
        studentRepository.saveOrUpdate(student);
    }
    @PutMapping("/update")
    public void updata(@RequestBody Student student){
       studentRepository.saveOrUpdate(student);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")long id){
        studentRepository.deleteById(id);
    }
    @GetMapping("/index")
    public String index(){
        return "当前端口"+this.port;
    }
}
