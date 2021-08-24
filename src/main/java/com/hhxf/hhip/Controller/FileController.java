package com.hhxf.hhip.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping("/upload")
    public String uploadFile(MultipartFile file, HttpServletRequest request)  {
        if (file.isEmpty()){
            return "上传的文件不能为空！请重新上传";
        }
        if (file.getSize()<=0){
            return "上传的文件大小需要大于0kb";
        }
        System.out.println(file.getContentType());//image/png
        Date date = new Date();
        Long time = date.getTime();
        String originFileName = file.getOriginalFilename();//获取文件原始的名称
        String newFileName = time+originFileName;
        //获取项目运行的绝对路径
        String filePath = System.getProperty("user.dir");

        //由于我是创建的多模块项目，所以获取到的项目运行路径为外层的项目路径，
        // 这时候我们就需要在项目相对路径这里加上项目的名称demo-upload
        String newFilePath = filePath+"\\HHIP\\src\\main\\resources\\static\\file\\";

        //当然你也可以自己设置一个绝对路径用于图片上传，文件上传。
        //比如说：D:\\images\\
        File file1 = new File(newFilePath);

        if (!file1.exists()){
            file1.mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(newFilePath+newFileName);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
            return "localhost:8012/file/"+newFileName;
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}
