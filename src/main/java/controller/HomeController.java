package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.MyService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

@Controller
public class HomeController {
    @Autowired
    private MyService myService;

    @RequestMapping("")
    @ResponseBody
    public String index() {
        return "<center>" + myService.getName() + "</center>";
    }

    @RequestMapping("/file")
    @ResponseBody
    public String getFile() throws IOException {

        Scanner scanner = new Scanner(new File("D:\\file.txt"));
//        Scanner scanner = new Scanner(new ClassPathResource("file.txt").getFile());

        String res = "";
        while (scanner.hasNext()) {
            res += scanner.nextLine();
        }

        return res;
    }
}
