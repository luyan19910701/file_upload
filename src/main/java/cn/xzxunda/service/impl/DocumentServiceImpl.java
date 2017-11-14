package cn.xzxunda.service.impl;

import cn.xzxunda.Repository.FileUploadRepository;
import cn.xzxunda.domain.Sys_File;
import cn.xzxunda.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by ThinkPad on 2017-10-27.
 */
@Service
public class DocumentServiceImpl implements DocumentService {

//    @Autowired
    FileUploadRepository fileUploadRepository;

    public String uploadFile(Sys_File sys_file) {

        fileUploadRepository.saveAndFlush(sys_file);

        return "";
    }
}
