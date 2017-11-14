package cn.xzxunda.service;

import cn.xzxunda.domain.Sys_File;
import org.springframework.stereotype.Service;

/**
 * Created by ThinkPad on 2017-10-27.
 */
public interface DocumentService {

    String uploadFile(Sys_File sys_file);

}
