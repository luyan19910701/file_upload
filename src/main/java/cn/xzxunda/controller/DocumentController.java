package cn.xzxunda.controller;

import cn.xzxunda.Util.DocumentUtil;
import cn.xzxunda.Util.HttpClientUtil;
import cn.xzxunda.domain.Sys_File;
import cn.xzxunda.service.DocumentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ThinkPad on 2017-10-27.
 */
@Controller
@RequestMapping(value = "/document")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    Logger logger = Logger.getLogger(DocumentController.class);

    @RequestMapping(value = "/upload.do")
    @ResponseBody
    public List<Sys_File> upload(HttpServletRequest request, HttpServletResponse response){

        try {
            request.setCharacterEncoding("utf-8");
            response.setCharacterEncoding("utf-8");
        }catch (IOException l){

        }
        List<MultipartFile> files =  DocumentUtil.getMultipartFileList(request);
//        Map<String,Object> map = new HashMap<String, Object>();
        List<Sys_File> sys_files = new ArrayList<Sys_File>();
        Map<String,Sys_File> requestMap = new HashMap<String, Sys_File>();

        for (MultipartFile file : files){
            String filePath = "";
            UUID uuid = UUID.randomUUID();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
            Date date = new Date();
            try {

                byte[] data = file.getBytes();
                filePath = ((CommonsMultipartFile) file).getFileItem().getName();
                String[] fileType = filePath.split("\\.");
                logger.info("接收到的文件名为***************"+fileType[0]);

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = new Date();
//        String folder = format.format(date1);
                File folder = new File("/upfiles/"+format.format(date1));
                //如果文件夹不存在  则创建文件夹
                if (!folder.exists()&&!folder.isDirectory()){
                    folder.mkdirs();
                }

//                File finalFile = new File("/home/xunda/apache-tomcat-8.5.12/bin/"+uuid.toString()+"."+fileType[fileType.length-1]);
                File finalFile = new File("/upfiles/"+format.format(date1)+"/"+uuid.toString()+"."+fileType[fileType.length-1]);
//                Runtime.getRuntime().exec(" chmod 777 "+"/home/xunda/aaa/"+uuid.toString()+"."+fileType[fileType.length-1]);
//                boolean a = finalFile.setWritable(true,false);
//                finalFile.setReadable(true,false);
//                finalFile.setExecutable(true,false);
                file.transferTo(finalFile);
//                OutputStream out = new FileOutputStream("/upfiles/"+uuid.toString()+"."+fileType[fileType.length-1]);
//                OutputStream out = new FileOutputStream("d:\\img\\"+filePath);
//                OutputStream out = new FileOutputStream("/home/xunda/"+((CommonsMultipartFile) file).getFileItem().getName());
//                out.write(data);
//                out.flush();
//                out.close();
                System.out.println("11111");

                Sys_File sys_file = new Sys_File();
                sys_file.setId(uuid.toString());
                sys_file.setFileName(filePath);
                sys_file.setFileType(fileType[fileType.length-1]);
                sys_file.setCreateDate(simpleDateFormat.format(date));

                logger.info("中文文件名为============="+sys_file.getFileName());

//                requestMap.put("id",uuid.toString());
//                requestMap.put("fileName",filePath);
//                requestMap.put("fileType",fileType[fileType.length-1]);
//                requestMap.put("createDate",simpleDateFormat.format(date));
//
//                String result = HttpClientUtil.sendPost("http://10.21.2.46:8080/fileUpload/clepUpload.web",requestMap);
//                map.put(uuid.toString(),sys_file);
                sys_files.add(sys_file);

            }catch (IOException e){

            }catch (Exception r){

            }
        }
        return sys_files;
    }

}
